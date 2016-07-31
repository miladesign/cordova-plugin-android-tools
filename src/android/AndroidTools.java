package cordova.tools.miladesign;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.util.Log;
import android.widget.Toast;
import android.telephony.TelephonyManager;

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
		callbackContextKeepCallback = callbackContext;
		if ("progressShow".equals(action)) {
			progressShow(action, args, callbackContext);
	    	return true;
	    }

		if ("progressHide".equals(action)) {
			progressHide(action, args, callbackContext);
	    	return true;
	    }
		
		if ("dialogShow".equals(action)) {
			dialogShow(action, args, callbackContext);
	    	return true;
	    }
		
		if ("exitDialog".equals(action)) {
			exitDialog(action, args, callbackContext);
	    	return true;
	    }
		
		if ("showToast".equals(action)) {
			showToast(action, args, callbackContext);
	    	return true;
	    }
		
		if ("getDeviceId".equals(action)) {
			getDeviceId();
		}

		if ("shareText".equals(action)) {
			shareText(action, args, callbackContext);
	    	return true;
	    }

		if ("shareApp".equals(action)) {
			shareApp(action, args, callbackContext);
	    	return true;
	    }

		if ("allMarketsApp".equals(action)) {
			allMarketsApp(action, args, callbackContext);
	    	return true;
	    }

		if ("avvalMarketRate".equals(action)) {
			avvalMarketRate(action, args, callbackContext);
	    	return true;
	    }
		
		if ("bazaarRate".equals(action)) {
			bazaarRate(action, args, callbackContext);
	    	return true;
	    }
		
		if ("bazaarApp".equals(action)) {
			bazaarApp(action, args, callbackContext);
	    	return true;
	    }
		
		if ("bazaarDeveloper".equals(action)) {
			bazaarDeveloper(action, args, callbackContext);
	    	return true;
	    }
		
		if ("myketRate".equals(action)) {
			myketRate(action, args, callbackContext);
	    	return true;
	    }
		
		if ("myketApp".equals(action)) {
			myketApp(action, args, callbackContext);
	    	return true;
	    }
		
		if ("myketDeveloper".equals(action)) {
			myketDeveloper(action, args, callbackContext);
	    	return true;
	    }
		
		if ("iranappsRate".equals(action)) {
			iranappsRate(action, args, callbackContext);
	    	return true;
	    }
		
		if ("iranappsApp".equals(action)) {
			iranappsApp(action, args, callbackContext);
	    	return true;
	    }
		
		if ("iranappsDeveloper".equals(action)) {
			iranappsDeveloper(action, args, callbackContext);
	    	return true;
	    }
		
		if ("candoRate".equals(action)) {
			candoRate(action, args, callbackContext);
	    	return true;
	    }
		
		if ("candoApp".equals(action)) {
			candoApp(action, args, callbackContext);
	    	return true;
	    }
		
		if ("candoDeveloper".equals(action)) {
			candoDeveloper(action, args, callbackContext);
	    	return true;
	    }
		
		if ("parshubRate".equals(action)) {
			parshubRate(action, args, callbackContext);
	    	return true;
	    }
		
		if ("parshubApp".equals(action)) {
			parshubApp(action, args, callbackContext);
	    	return true;
	    }
		
		if ("parshubDeveloper".equals(action)) {
			parshubDeveloper(action, args, callbackContext);
	    	return true;
	    }
		
		if ("instagramProfile".equals(action)) {
			instagramProfile(action, args, callbackContext);
	    	return true;
	    }
		
		if ("telegramProfile".equals(action)) {
			telegramProfile(action, args, callbackContext);
	    	return true;
	    }
		
		return false;
	}

	
	/****** Device Tools *******/
	
	private void getDeviceId() {
		mActivity = cordova.getActivity();
		try {
			String deviceId = Secure.getString(mActivity.getContentResolver(),Secure.ANDROID_ID);
			if ("9774d56d682e549c".equals(deviceId) || deviceId == null) {
				deviceId = ((TelephonyManager) mActivity.getSystemService( Context.TELEPHONY_SERVICE )).getDeviceId();
			}
			if (deviceId==null){
				WifiManager m_wm = (WifiManager) mActivity.getSystemService(Context.WIFI_SERVICE);
				String mac_addr = m_wm.getConnectionInfo().getMacAddress();
				deviceId = mac_addr;
			}
			callbackContextKeepCallback.success((deviceId!=null)?deviceId:"DEVICE_ID_ERROR");
		} catch (Exception e) {
			Toast.makeText(mActivity, "شناسه دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
    }
	
	
	/****** Dialog Tools *******/
	
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
	
	public void _progressShow(String title,String text,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		progress = ProgressDialog.show(mActivity, title, text, true);
		callbackContextKeepCallback = callbackContext;
		callbackContextKeepCallback.success();
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
	
	public void _progressHide(CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		progress.dismiss();
		callbackContextKeepCallback = callbackContext;
		callbackContextKeepCallback.success();
	}
	
	private void dialogShow(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String title = args.getString(0);
		final String text = args.getString(1);
		final String button = args.getString(2);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_dialogShow(title,text,button,callbackContextKeepCallback);
			}
		});
	}
	
	public void _dialogShow(String title,String text, String button, CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		builder.setTitle(title);
		builder.setMessage(text);
		builder.setCancelable(true);
		builder.setPositiveButton(button, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
		callbackContextKeepCallback = callbackContext;
		callbackContextKeepCallback.success();
	}
	
	private void exitDialog(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String title = args.getString(0);
		final String text = args.getString(1);
		final String btnYes = args.getString(2);
		final String btnNo = args.getString(3);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_exitDialog(title,text,btnYes,btnNo,callbackContextKeepCallback);
			}
		});
	}
	
	public void _exitDialog(String title,String text, String btnYes, String btnNo, CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		builder.setTitle(title);
		builder.setMessage(text);
		builder.setCancelable(true);
		builder.setNegativeButton(btnNo, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		builder.setPositiveButton(btnYes, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				mActivity.finish();
				System.exit(0);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
		callbackContextKeepCallback = callbackContext;
		callbackContextKeepCallback.success();
	}
	
	private void showToast(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String text = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_showToast(text,callbackContextKeepCallback);
			}
		});
	}
	
	public void _showToast(String text, CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		Toast.makeText(mActivity, text, Toast.LENGTH_LONG).show();
		callbackContextKeepCallback = callbackContext;
		callbackContextKeepCallback.success();
	}
	
	
	
	/******* Bazaar Tools *******/
	
	private void bazaarRate(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_bazaarRate(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	private void bazaarApp(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_bazaarApp(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	private void bazaarDeveloper(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String userName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_bazaarDeveloper(userName,callbackContextKeepCallback);
			}
		});
	}
	
	public void _bazaarRate(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.EDIT");
			intent.setData(Uri.parse("bazaar://details?id=" + packageName));
			intent.setPackage("com.farsitel.bazaar");
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "بازار  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	public void _bazaarApp(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("bazaar://details?id=" + packageName));
			intent.setPackage("com.farsitel.bazaar");
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "بازار  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	public void _bazaarDeveloper(String userName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + userName));
			intent.setPackage("com.farsitel.bazaar");
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "بازار  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	/******* Myket Tools *******/
	
	private void myketRate(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_myketRate(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	private void myketApp(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_myketApp(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	private void myketDeveloper(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_myketDeveloper(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	public void _myketRate(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("myket://comment/#Intent;scheme=comment;package=" + packageName+ ";end"));
			intent.setPackage("ir.mservices.market");
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "مایکت  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	public void _myketApp(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("myket://application/#Intent;scheme=myket;package=" + packageName+ ";end"));
			intent.setPackage("ir.mservices.market");
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "مایکت  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	public void _myketDeveloper(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("http://myket.ir/DeveloperApps.aspx?Packagename=" + packageName));
			intent.setPackage("ir.mservices.market");
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "مایکت  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	/******* IranApps Tools *******/
	
	private void iranappsRate(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_iranappsRate(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	private void iranappsApp(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_iranappsApp(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	private void iranappsDeveloper(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String UserName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_iranappsDeveloper(UserName,callbackContextKeepCallback);
			}
		});
	}
	
	public void _iranappsRate(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("iranapps://app/" + packageName+ "?a=comment&r=5"));
			intent.setPackage("ir.tgbs.android.iranapp");
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "ایران اپس  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	public void _iranappsApp(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("iranapps://app/" + packageName+ ";end"));
			intent.setPackage("ir.tgbs.android.iranapp");
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "ایران اپس  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	public void _iranappsDeveloper(String UserName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("iranapps://user/" + UserName));
			intent.setPackage("ir.tgbs.android.iranapp");
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "ایران اپس  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	/******* Cando Tools *******/
	
	private void candoRate(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_candoRate(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	private void candoApp(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_candoApp(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	private void candoDeveloper(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String UserName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_candoDeveloper(UserName,callbackContextKeepCallback);
			}
		});
	}
	
	public void _candoRate(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("cando://leave-review?id=" + packageName));
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "کندو  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	public void _candoApp(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("cando://details?id=" + packageName));
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "کندو  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	public void _candoDeveloper(String UserName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("cando://publisher?id=" + UserName));
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "کندو  بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	/******* Parshub Tools *******/
	
	private void parshubRate(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_parshubRate(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	private void parshubApp(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_parshubApp(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	private void parshubDeveloper(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String UserName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_parshubDeveloper(UserName,callbackContextKeepCallback);
			}
		});
	}
	
	public void _parshubRate(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("parshub://comment?q=" + packageName));
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "پارس هاب بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	public void _parshubApp(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("parshub://search?q=" + packageName));
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "پارس هاب بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	
	public void _parshubDeveloper(String UserName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("parshub://collection?type=APP&id=" + UserName));
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "پارس هاب بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	

	/******* All Markets Tools *******/
	
	private void allMarketsApp(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_allMarketsApp(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	public void _allMarketsApp(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("market://details?id=" + packageName));
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "مارکتی بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	

	/******* Avval Market Tools *******/
	
	private void avvalMarketRate(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_avvalMarketRate(packageName,callbackContextKeepCallback);
			}
		});
	}
	
	public void _avvalMarketRate(String packageName,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setComponent(new ComponentName("com.hrm.android.market", "com.hrm.android.market.main.view.RateActivity"));
			intent.setData(Uri.parse("market://rate?id=" + packageName));
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "اول مارکت بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	

	/******* Instagram Profile *******/
	
	private void instagramProfile(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String username = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_instagramProfile(username,callbackContextKeepCallback);
			}
		});
	}
	
	public void _instagramProfile(String username,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = mActivity.getPackageManager().getLaunchIntentForPackage("com.instagram.android");
			intent.setComponent(new ComponentName("com.instagram.android", "com.instagram.android.activity.UrlHandlerActivity"));
		    intent.setData(Uri.parse("http://instagram.com/_u/" + username));
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "اینستاگرام بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	

	/******* Telegram Profile *******/
	
	private void telegramProfile(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String username = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_telegramProfile(username,callbackContextKeepCallback);
			}
		});
	}
	
	public void _telegramProfile(String username,CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent("android.intent.action.VIEW");
			intent.setData(Uri.parse("tg://resolve?domain=" + username));
		    ((CordovaActivity) mActivity).startActivity(intent);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "تلگرام بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	

	/******* Share Tools *******/
	
	private void shareText(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String title = args.getString(0);
		final String text = args.getString(1);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_shareText(title,text,callbackContextKeepCallback);
			}
		});
	}
	
	public void _shareText(String title,String text, CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			Intent intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(android.content.Intent.EXTRA_TEXT, text);
			this.cordova.startActivityForResult(this, Intent.createChooser(intent, title), 0);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "برنامه ای برای ارسال بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
	private void shareApp(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		final String title = args.getString(0);
		final String packageName = args.getString(1);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_shareApp(title,packageName,callbackContextKeepCallback);
			}
		});
	}
	
	public void _shareApp(String title,String packageName, CallbackContext callbackContext) {
		mActivity = cordova.getActivity();
		try {
			PackageManager localPackageManager = mActivity.getPackageManager();
		    ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(packageName, 0);
		    java.io.File localFile = new java.io.File(localApplicationInfo.publicSourceDir);
		    Intent intent = new Intent();
		    intent.setAction("android.intent.action.SEND");
		    intent.setType("application/*");
		    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(localFile));
			this.cordova.startActivityForResult(this, Intent.createChooser(intent, title), 0);
			callbackContextKeepCallback = callbackContext;
			callbackContextKeepCallback.success();
		} catch(Exception e) {
			Toast.makeText(mActivity, "برنامه ای برای ارسال بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
		}
	}
}