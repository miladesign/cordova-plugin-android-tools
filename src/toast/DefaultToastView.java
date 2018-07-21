package cordova.tools.miladesign.toast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

@SuppressWarnings("unused")
public class DefaultToastView extends View {
    ValueAnimator valueAnimator;
    float mAnimatedValue = 0.0F;
    private Paint mPaint;
    private Paint mSpikePaint;
    private float mWidth = 0.0F;
    private float mPadding = 0.0F;
    private float mSpikeLength;

    public DefaultToastView(Context paramContext) {
        super(paramContext);
    }

    public DefaultToastView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public DefaultToastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        initPaint();
        this.mWidth = getMeasuredWidth();
        this.mPadding = dip2px(5.0F);
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(Color.parseColor("#222222"));
        this.mPaint.setStrokeWidth(dip2px(2.0F));

        this.mSpikePaint = new Paint();
        this.mSpikePaint.setAntiAlias(true);
        this.mSpikePaint.setStyle(Paint.Style.STROKE);
        this.mSpikePaint.setColor(Color.parseColor("#222222"));
        this.mSpikePaint.setStrokeWidth(dip2px(4.0F));

        this.mSpikeLength = dip2px(4.0F);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        paramCanvas.save();
        paramCanvas.drawCircle(this.mWidth / 2.0F, this.mWidth / 2.0F, this.mWidth / 4.0F, this.mPaint);

        for (int i = 0; i < 360; i += 40) {
            int j = (int)(this.mAnimatedValue * 40.0F + i);
            float f1 = (float)(this.mWidth / 4.0F * Math.cos(j * 3.141592653589793D / 180.0D));
            float f2 = (float)(this.mWidth / 4.0F * Math.sin(j * 3.141592653589793D / 180.0D));
            float f3 = (float)((this.mWidth / 4.0F + this.mSpikeLength) * Math.cos(j * 3.141592653589793D / 180.0D));
            float f4 = (float)((this.mWidth / 4.0F + this.mSpikeLength) * Math.sin(j * 3.141592653589793D / 180.0D));
            paramCanvas.drawLine(this.mWidth / 2.0F - f1, this.mWidth / 2.0F - f2, this.mWidth / 2.0F - f3, this.mWidth / 2.0F - f4, this.mSpikePaint);
        }

        paramCanvas.restore();
    }

    public void startAnim() {
        stopAnim();
        startViewAnim(0.0F, 1.0F, 2000L);
    }

    public void stopAnim() {
        if (this.valueAnimator != null) {
            clearAnimation();

            this.valueAnimator.end();
            postInvalidate();
        }
    }

    private ValueAnimator startViewAnim(float paramFloat1, float paramFloat2, long paramLong) {
        this.valueAnimator = ValueAnimator.ofFloat(new float[] {
            paramFloat1,
            paramFloat2
        });
        this.valueAnimator.setDuration(paramLong);
        this.valueAnimator.setInterpolator(new LinearInterpolator());
        this.valueAnimator.setRepeatCount(-1);
        this.valueAnimator.setRepeatMode(1);
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator) {
                DefaultToastView.this.mAnimatedValue = ((Float) paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
                DefaultToastView.this.postInvalidate();
            }
        });
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }

        return this.valueAnimator;
    }

    public int dip2px(float paramFloat) {
        float f = getContext().getResources().getDisplayMetrics().density;
        return (int)(paramFloat * f);
    }
}