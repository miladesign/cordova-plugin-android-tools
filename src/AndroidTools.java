package cordova.tools.miladesign;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import cordova.tools.miladesign.toast.TastyToast;

@SuppressWarnings("unused")
public class AndroidTools extends CordovaPlugin {
	private static final String TAG = "AndroidTools";
	private static CallbackContext callbackContextKeepCallback = null;
	private static Activity mActivity = null;
	public static CordovaInterface cordova = null;
	private ProgressDialog progress;
	private TastyToast cv;
	
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
			progressShow(args, callbackContext);
	    	return true;
	    }

		if ("progressHide".equals(action)) {
			progressHide(args, callbackContext);
	    	return true;
	    }
		
		if ("dialogShow".equals(action)) {
			dialogShow(args, callbackContext);
	    	return true;
	    }
		
		if ("exitDialog".equals(action)) {
			exitDialog(args, callbackContext);
	    	return true;
	    }
		
		if ("showToast".equals(action)) {
			showToast(args, callbackContext);
	    	return true;
	    }
		
		if ("getDeviceId".equals(action)) {
			getDeviceId();
		}
		
		if ("vibrate_supported".equals(action)) {
			vibrate_supported();
		}
		
		if ("vibrateDevice".equals(action)) {
			vibrateDevice(args, callbackContext);
		}

		if ("shareText".equals(action)) {
			shareText(args, callbackContext);
	    	return true;
	    }

		if ("shareApp".equals(action)) {
			shareApp(args, callbackContext);
	    	return true;
	    }
		
		if ("allMarketsApp".equals(action)) {
			allMarketsApp(args, callbackContext);
	    	return true;
	    }

		if ("avvalMarketRate".equals(action)) {
			avvalMarketRate(args, callbackContext);
	    	return true;
	    }
		
		if ("bazaarRate".equals(action)) {
			bazaarRate(args, callbackContext);
	    	return true;
	    }
		
		if ("bazaarApp".equals(action)) {
			bazaarApp(args, callbackContext);
	    	return true;
	    }
		
		if ("bazaarDeveloper".equals(action)) {
			bazaarDeveloper(args, callbackContext);
	    	return true;
	    }
		
		if ("myketRate".equals(action)) {
			myketRate(args, callbackContext);
	    	return true;
	    }
		
		if ("myketApp".equals(action)) {
			myketApp(args, callbackContext);
	    	return true;
	    }
		
		if ("myketDeveloper".equals(action)) {
			myketDeveloper(args, callbackContext);
	    	return true;
	    }
		
		if ("iranappsRate".equals(action)) {
			iranappsRate(args, callbackContext);
	    	return true;
	    }
		
		if ("iranappsApp".equals(action)) {
			iranappsApp(args, callbackContext);
	    	return true;
	    }
		
		if ("iranappsDeveloper".equals(action)) {
			iranappsDeveloper(args, callbackContext);
	    	return true;
	    }
		
		if ("candoRate".equals(action)) {
			candoRate(args, callbackContext);
	    	return true;
	    }
		
		if ("candoApp".equals(action)) {
			candoApp(args, callbackContext);
	    	return true;
	    }
		
		if ("candoDeveloper".equals(action)) {
			candoDeveloper(args, callbackContext);
	    	return true;
	    }
		
		if ("parshubRate".equals(action)) {
			parshubRate(args, callbackContext);
	    	return true;
	    }
		
		if ("parshubApp".equals(action)) {
			parshubApp(args, callbackContext);
	    	return true;
	    }
		
		if ("parshubDeveloper".equals(action)) {
			parshubDeveloper(args, callbackContext);
	    	return true;
	    }
		
		if ("instagramProfile".equals(action)) {
			instagramProfile(args, callbackContext);
	    	return true;
	    }
		
		if ("telegramProfile".equals(action)) {
			telegramProfile(args, callbackContext);
	    	return true;
	    }
		
		if ("customToast".equals(action)) {
			customToast(args, callbackContext);
	    	return true;
	    }
		if ("openApp".equals(action)) {
			openApp(args, callbackContext);
	    	return true;
	    }
		if ("openUrl".equals(action)) {
			openUrl(args, callbackContext);
	    	return true;
	    }
		if ("setBrightness".equals(action)) {
			setScreenBrightness(args, callbackContext);
	    	return true;
	    }
		if ("setOrientation".equals(action)) {
	    	return setScreenOrientation(args, callbackContext);
	    }
		if ("openWhatsapp".equals(action)) {
	    	openWhatsapp(args, callbackContext);
	    	return true;
	    }
		if ("setVolume".equals(action)) {
			return setVolume(args, callbackContext);
	    }
		if ("getMaxVolume".equals(action)) {
			return getMaxVolume(args, callbackContext);
	    }
		if ("setRingerMode".equals(action)) {
			return setRingerMode(args, callbackContext);
	    }
		if ("threeDialog".equals(action)) {
			return threeDialog(args, callbackContext);
	    }
		if ("inputDialog".equals(action)) {
			return inputDialog(args, callbackContext);
	    }
		if ("copyToClipboard".equals(action)) {
			copyToClipboard(args, callbackContext);
			return true;
	    }
		return false;
	}
	

	/****** Input Dialog  *******/
	private boolean inputDialog(final JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		final EditText input = new EditText(mActivity);
		input.setHint(args.getString(4));
		int type = args.getInt(5);
		final String format = args.getString(6);
		switch(type) {
			default: input.setInputType(InputType.TYPE_CLASS_TEXT); break;
			case 0: input.setInputType(InputType.TYPE_CLASS_TEXT); break;
			case 1: input.setInputType(InputType.TYPE_CLASS_NUMBER); break;
			case 2: input.setInputType(InputType.TYPE_CLASS_PHONE); break;
			case 3: input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); break;
			case 4: input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE); break;
			case 5: break;
		}
		final Calendar myCalendar = Calendar.getInstance();
		final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
		    @Override
		    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		        myCalendar.set(Calendar.YEAR, year);
		        myCalendar.set(Calendar.MONTH, monthOfYear);
		        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		        updateLabel(myCalendar,input,format);
		    }

		};
		new AlertDialog.Builder(mActivity)
			.setTitle(args.getString(0))
			.setMessage(args.getString(1))
			.setView(input)
			.setPositiveButton(args.getString(2), new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					dialog.dismiss();
					callbackContext.success(input.getText().toString());
				}
			})
			.setNegativeButton(args.getString(3), new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					dialog.dismiss();
					callbackContext.error(0);
				}
			})
			.show();
		if (type==5) {
			input.setOnClickListener(new OnClickListener() {
		        @Override
		        public void onClick(View v) {
		            new DatePickerDialog(mActivity, date, myCalendar
		            		.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
		                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
		        }
		    });
		}
		return true;
	}
	
	private void updateLabel(Calendar myCalendar, EditText edittext, String format) {
	    SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);

	    edittext.setText(sdf.format(myCalendar.getTime()));
	}
	
	/****** Three Button Dialog  *******/
	private boolean threeDialog(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		mActivity = cordova.getActivity();
		final String title = args.getString(0);
		final String text = args.getString(1);
		final String btn1 = args.getString(2);
		final String btn2 = args.getString(3);
		final String btn3 = args.getString(4);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
				builder.setTitle(title);
				builder.setMessage(text);
				builder.setCancelable(false);
				if (btn1.length() > 0) {
					builder.setNegativeButton(btn1, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
							callbackContextKeepCallback.success(1);
						}
					});
				}
				if (btn3.length() > 0) {
					builder.setPositiveButton(btn3, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
							callbackContextKeepCallback.success(3);
						}
					});
				}
				if (btn2.length() > 0) {
					builder.setNeutralButton(btn2, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
							callbackContextKeepCallback.success(2);
						}
					});
				}
				AlertDialog alert = builder.create();
				alert.show();
			}
		});
		return true;
	}
	
	
	/****** Volume  *******/
	public boolean setVolume(JSONArray args, CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		int Channel = args.getInt(0);
		int VolumeIndex = args.getInt(1);
		boolean ShowUI = args.getBoolean(2);
		AudioManager audioManager = (AudioManager) mActivity.getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		audioManager.setStreamVolume(Channel, VolumeIndex, ShowUI ? 1 : 0);
		callbackContext.success(audioManager.getStreamMaxVolume(Channel) + "|" + audioManager.getStreamVolume(Channel));
		return true;
	}
	
	public boolean getMaxVolume(JSONArray args, CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		int Channel = args.getInt(0);
		AudioManager audioManager = (AudioManager) mActivity.getSystemService(Context.AUDIO_SERVICE);
		callbackContext.success(audioManager.getStreamMaxVolume(Channel));
		return true;
	}
	
	public boolean setRingerMode(JSONArray args, CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		int Mode = args.getInt(0);
		AudioManager audioManager = (AudioManager) mActivity.getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(Mode);
	    return true;
	}

	
	/****** Whatsapp  *******/
	public void openWhatsapp(JSONArray args, CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		String number = args.getString(0);
	    try {
	      Uri localUri = Uri.parse("smsto:" + number);
	      Intent localIntent = new Intent("android.intent.action.SENDTO", localUri);
	      localIntent.addFlags(268435456);
	      localIntent.setPackage("com.whatsapp");
	      mActivity.startActivity(localIntent);
	    }
	    catch (Exception localException) {
	      Toast.makeText(mActivity, localException.toString(), Toast.LENGTH_LONG).show();
	    }
	}
	
	
	/****** Brightness *******/
	private class SetTask implements Runnable {
		private Activity target = null;
		private LayoutParams lp = null;
		@Override
		public void run() {
			target.getWindow().setAttributes(lp);
		}
		public void setParams(Activity act, LayoutParams params){
			this.target = act;
			this.lp = params;
		}
	}
	
	public void setScreenBrightness(JSONArray args, CallbackContext callbackContext) {
		callbackContextKeepCallback = callbackContext;
		try {
			Activity activity = cordova.getActivity();
			WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
			double brightness = args.getDouble(0);
			layoutParams.screenBrightness = (float)brightness;
			SetTask task = new SetTask();
			task.setParams(activity, layoutParams);
			activity.runOnUiThread(task);
			callbackContextKeepCallback.success("OK");
		} catch (NullPointerException e) {
			callbackContextKeepCallback.error(e.getMessage());
		} catch (JSONException e) {
			callbackContextKeepCallback.error(e.getMessage());
		}
	}

	
	/****** Orientation *******/
	public boolean setScreenOrientation(JSONArray args, CallbackContext callbackContext) throws JSONException {
		int orientation = args.getInt(0);
        Activity activity = cordova.getActivity();
        activity.setRequestedOrientation(orientation);
        callbackContext.success();
        return true;
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
	
	public void vibrate_supported() {
		mActivity = cordova.getActivity();
		Vibrator v = (Vibrator) mActivity.getSystemService(Context.VIBRATOR_SERVICE);
		if (v.hasVibrator()) {
			PluginResult pr = new PluginResult(PluginResult.Status.OK, "onVibrateSupported");
			pr.setKeepCallback(true);
			callbackContextKeepCallback.sendPluginResult(pr);
        } else {
        	PluginResult pr = new PluginResult(PluginResult.Status.ERROR, "onVibrateNotSupported");
			pr.setKeepCallback(true);
			callbackContextKeepCallback.sendPluginResult(pr);
        }
    }
	
	public void vibrateDevice(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		mActivity = cordova.getActivity();
		final int duration = args.getInt(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Vibrator vib = (Vibrator) mActivity.getSystemService(Context.VIBRATOR_SERVICE);
				vib.vibrate(duration);
				callbackContextKeepCallback = callbackContext;
				callbackContextKeepCallback.success();
			}
		});
		
    }
	
	/****** Dialog Tools *******/
	
	private void progressShow(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		mActivity = cordova.getActivity();
		final String title = args.getString(0);
		final String text = args.getString(1);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				progress = ProgressDialog.show(mActivity, title, text, true);
				callbackContextKeepCallback = callbackContext;
				callbackContextKeepCallback.success();
			}
		});
	}
	
	private void progressHide(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		mActivity = cordova.getActivity();
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				progress.dismiss();
				callbackContextKeepCallback = callbackContext;
				callbackContextKeepCallback.success();
			}
		});
	}
	
	private void dialogShow(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		mActivity = cordova.getActivity();
		final String title = args.getString(0);
		final String text = args.getString(1);
		final String button = args.getString(2);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	private void exitDialog(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		mActivity = cordova.getActivity();
		final String title = args.getString(0);
		final String text = args.getString(1);
		final String btnYes = args.getString(2);
		final String btnNo = args.getString(3);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					Log.e(TAG, "ITS OK!");
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
				} catch(Exception e) {
					Log.e(TAG, "HERE");
					Log.e(TAG, e.getMessage());
				}
			}
		});
	}
	
	private void showToast(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		mActivity = cordova.getActivity();
		final String text = args.getString(0);
		final Integer length = args.getInt(1);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(mActivity, text, length).show();
				callbackContextKeepCallback = callbackContext;
				callbackContextKeepCallback.success();
			}
		});
	}

	private void customToast(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		mActivity = cordova.getActivity();
		final String text = args.getString(0);
		final Integer length = args.getInt(1);
		final Integer type = args.getInt(2);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				cv = new TastyToast();
				TastyToast.makeText(mActivity, text, length, type);
				callbackContextKeepCallback = callbackContext;
				callbackContextKeepCallback.success();
			}
		});
	}
	
	/******* Bazaar Tools *******/
	
	private void bazaarRate(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	private void bazaarApp(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	private void bazaarDeveloper(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String userName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	/******* Myket Tools *******/
	
	private void myketRate(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	private void myketApp(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	private void myketDeveloper(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	/******* IranApps Tools *******/
	
	private void iranappsRate(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	private void iranappsApp(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	private void iranappsDeveloper(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String UserName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	/******* Cando Tools *******/
	
	private void candoRate(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	private void candoApp(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	private void candoDeveloper(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String UserName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	
	/******* Parshub Tools *******/
	
	private void parshubRate(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					Intent intent = new Intent("android.intent.action.VIEW");
					intent.setData(Uri.parse("jhoobin://comment?q=" + packageName));
				    ((CordovaActivity) mActivity).startActivity(intent);
					callbackContextKeepCallback = callbackContext;
					callbackContextKeepCallback.success();
				} catch(Exception e) {
					Toast.makeText(mActivity, "پارس هاب بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	private void parshubApp(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					Intent intent = new Intent("android.intent.action.VIEW");
					intent.setData(Uri.parse("jhoobin://search?q=" + packageName));
				    ((CordovaActivity) mActivity).startActivity(intent);
					callbackContextKeepCallback = callbackContext;
					callbackContextKeepCallback.success();
				} catch(Exception e) {
					Toast.makeText(mActivity, "پارس هاب بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	private void parshubDeveloper(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String UserName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					Intent intent = new Intent("android.intent.action.VIEW");
					intent.setData(Uri.parse("jhoobin://collection?type=APP&id=" + UserName));
				    ((CordovaActivity) mActivity).startActivity(intent);
					callbackContextKeepCallback = callbackContext;
					callbackContextKeepCallback.success();
				} catch(Exception e) {
					Toast.makeText(mActivity, "پارس هاب بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	

	/******* All Markets Tools *******/
	
	private void allMarketsApp(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	

	/******* Avval Market Tools *******/
	
	private void avvalMarketRate(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	

	/******* Instagram Profile *******/
	
	private void instagramProfile(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String username = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	

	/******* Telegram Profile *******/
	
	private void telegramProfile(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String username = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
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
		});
	}
	

	/******* Share Tools *******/
	
	private void shareText(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		callbackContextKeepCallback = callbackContext;
		mActivity = cordova.getActivity();
		final String title = args.getString(0);
		final String text = args.getString(1);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					Intent intent = new Intent(android.content.Intent.ACTION_SEND);
					intent.setType("text/plain");
					intent.putExtra(android.content.Intent.EXTRA_TEXT, text);
					mActivity.startActivityForResult(Intent.createChooser(intent, title), 0);
					callbackContextKeepCallback = callbackContext;
					callbackContextKeepCallback.success();
				} catch(Exception e) {
					Toast.makeText(mActivity, "برنامه ای برای ارسال بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	private void shareApp(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String title = args.getString(0);
		final String packageName = args.getString(1);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					PackageManager localPackageManager = mActivity.getPackageManager();
				    ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(packageName, 0);
				    java.io.File localFile = new java.io.File(localApplicationInfo.publicSourceDir);
				    Intent intent = new Intent();
				    intent.setAction("android.intent.action.SEND");
				    intent.setType("application/*");
				    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(localFile));
					mActivity.startActivityForResult(Intent.createChooser(intent, title), 0);
					callbackContextKeepCallback = callbackContext;
					callbackContextKeepCallback.success();
				} catch(Exception e) {
					Toast.makeText(mActivity, "برنامه ای برای ارسال بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	/******* Open App *******/

	private void openApp(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String packageName = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					Intent launchIntent = ((CordovaActivity) mActivity).getPackageManager().getLaunchIntentForPackage(packageName);
					((CordovaActivity) mActivity).startActivity(launchIntent);
					callbackContextKeepCallback = callbackContext;
					callbackContextKeepCallback.success();
				} catch(Exception e) {
					Toast.makeText(mActivity, "برنامه موردنظر یافت نشد", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	/******* Open URL *******/
	
	private void openUrl(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String url = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				String address = url;
				if (!url.startsWith("http://") && !url.startsWith("https://")) {
					address = "http://" + url;
				}
				try {
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
					((CordovaActivity) mActivity).startActivity(browserIntent);
					callbackContextKeepCallback = callbackContext;
					callbackContextKeepCallback.success();
				} catch(Exception e) {
					Toast.makeText(mActivity, "مرورگر بر روی دستگاه یافت نشد", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	/******* Copy to clipboard *******/
	@SuppressWarnings("deprecation")
	private void copyToClipboard(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		mActivity = cordova.getActivity();
		callbackContextKeepCallback = callbackContext;
		final String text = args.getString(0);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
					android.text.ClipboardManager clipboard = (android.text.ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
				    clipboard.setText(text);
				} else {
				    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
				    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
				    clipboard.setPrimaryClip(clip);
				}
				callbackContextKeepCallback.success();
			}
		});
	}
}