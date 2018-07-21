package cordova.tools.miladesign.toast;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rahul on 28/7/16.
 */
@SuppressLint("InflateParams")
public class TastyToast {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;


    public static final int SUCCESS = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    public static final int INFO = 4;
    public static final int DEFAULT = 5;

    static SuccessToastView successToastView;
    static WarningToastView warningToastView;
    static ErrorToastView errorToastView;
    static InfoToastView infoToastView;
    static DefaultToastView defaultToastView;

    public static void makeText(Context context, String msg, int length, int type) {

        Toast toast = new Toast(context);


        switch (type) {
            case 0:
                {
                    View layout = LayoutInflater.from(context).inflate(context.getResources().getIdentifier("default_toast_layout", "layout", context.getPackageName()), null, false);

                    TextView text = (TextView) layout.findViewById(context.getResources().getIdentifier("toastMessage", "id", context.getPackageName()));
                    text.setText(msg);
                    defaultToastView = (DefaultToastView) layout.findViewById(context.getResources().getIdentifier("defaultView", "id", context.getPackageName()));
                    defaultToastView.startAnim();
                    text.setBackgroundResource(context.getResources().getIdentifier("default_toast", "drawable", context.getPackageName()));
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    toast.setView(layout);
                    break;
                }
            case 1:
                {
                    View layout = LayoutInflater.from(context).inflate(context.getResources().getIdentifier("success_toast_layout", "layout", context.getPackageName()), null, false);
                    TextView text = (TextView) layout.findViewById(context.getResources().getIdentifier("toastMessage", "id", context.getPackageName()));
                    text.setText(msg);
                    successToastView = (SuccessToastView) layout.findViewById(context.getResources().getIdentifier("successView", "id", context.getPackageName()));
                    successToastView.startAnim();
                    text.setBackgroundResource(context.getResources().getIdentifier("success_toast", "drawable", context.getPackageName()));
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    toast.setView(layout);
                    break;
                }
            case 2:
                {
                    View layout = LayoutInflater.from(context).inflate(context.getResources().getIdentifier("error_toast_layout", "layout", context.getPackageName()), null, false);

                    TextView text = (TextView) layout.findViewById(context.getResources().getIdentifier("toastMessage", "id", context.getPackageName()));
                    text.setText(msg);
                    errorToastView = (ErrorToastView) layout.findViewById(context.getResources().getIdentifier("errorView", "id", context.getPackageName()));
                    errorToastView.startAnim();
                    text.setBackgroundResource(context.getResources().getIdentifier("error_toast", "drawable", context.getPackageName()));
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    toast.setView(layout);
                    break;
                }
            case 3:
                {
                    View layout = LayoutInflater.from(context).inflate(context.getResources().getIdentifier("info_toast_layout", "layout", context.getPackageName()), null, false);

                    TextView text = (TextView) layout.findViewById(context.getResources().getIdentifier("toastMessage", "id", context.getPackageName()));
                    text.setText(msg);
                    infoToastView = (InfoToastView) layout.findViewById(context.getResources().getIdentifier("infoView", "id", context.getPackageName()));
                    infoToastView.startAnim();
                    text.setBackgroundResource(context.getResources().getIdentifier("info_toast", "drawable", context.getPackageName()));
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    toast.setView(layout);
                    break;
                }
            case 4:
                {
                    View layout = LayoutInflater.from(context).inflate(context.getResources().getIdentifier("warning_toast_layout", "layout", context.getPackageName()), null, false);

                    TextView text = (TextView) layout.findViewById(context.getResources().getIdentifier("toastMessage", "id", context.getPackageName()));
                    text.setText(msg);

                    warningToastView = (WarningToastView) layout.findViewById(context.getResources().getIdentifier("warningView", "id", context.getPackageName()));
                    SpringSystem springSystem = SpringSystem.create();
                    final Spring spring = springSystem.createSpring();
                    spring.setCurrentValue(1.8);
                    SpringConfig config = new SpringConfig(40, 5);
                    spring.setSpringConfig(config);
                    spring.addListener(new SimpleSpringListener() {

                        @Override
                        public void onSpringUpdate(Spring spring) {
                            float value = (float) spring.getCurrentValue();
                            float scale = (float)(0.9f - (value * 0.5f));

                            warningToastView.setScaleX(scale);
                            warningToastView.setScaleY(scale);
                        }
                    });
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {}
                            spring.setEndValue(0.4f);
                        }
                    });

                    t.start();
                    text.setBackgroundResource(context.getResources().getIdentifier("warning_toast", "drawable", context.getPackageName()));
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    toast.setView(layout);
                    break;
                }
        }
        toast.setDuration(length);
        toast.show();
    }

}