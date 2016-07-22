package cordova.tools.miladesign;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;

public class AndroidTools extends CordovaPlugin {
	private static final String TAG = "MilaDesign";
	private static CallbackContext callbackContextKeepCallback = null;
	private static Activity mActivity = null;
	public CordovaInterface cordova = null;
	private ProgressDialog progress;
	
	@Override
	public void initialize (CordovaInterface initCordova, CordovaWebView webView) {
		 Log.e (TAG, "initialize");
		  cordova = initCordova;
		  super.initialize (cordova, webView);
	}
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if ("progressShow".equals(action)) {
			progressShow(action, args, callbackContext);
			Log.i(TAG,"Show ProgressDialog");
	    	return true;
	    }

		if ("progressHide".equals(action)) {
			progressHide(action, args, callbackContext);
			Log.i(TAG,"Hide ProgressDialog");
	    	return true;
	    }
		return false;
	}
	
	private void progressShow(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String title = args.getString(0);
		final String text = args.getString(1);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_progressShow(title,text,callbackContextKeepCallback);
			}
		});
	}
	
	private void progressHide(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_progressHide(callbackContextKeepCallback);
			}
		});
	}
	
	public void _progressShow(String title,String text,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		progress = ProgressDialog.show(mActivity, title, text, true);
		callbackContextKeepCallback = callbackContext;
		callbackContextKeepCallback.success();
	}
	
	public void _progressHide(CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		progress.dismiss();
		callbackContextKeepCallback = callbackContext;
		callbackContextKeepCallback.success();
	}
}
