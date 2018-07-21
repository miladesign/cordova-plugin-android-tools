package cordova.tools.miladesign.toast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class SuccessToastView extends View {
    RectF rectF = new RectF();
    ValueAnimator valueAnimator;
    float mAnimatedValue = 0.0F;
    private Paint mPaint;
    private float mWidth = 0.0F;
    private float mEyeWidth = 0.0F;
    private float mPadding = 0.0F;
    private float endAngle = 0.0F;
    private boolean isSmileLeft = false;
    private boolean isSmileRight = false;

    public SuccessToastView(Context paramContext) {
        super(paramContext);
    }

    public SuccessToastView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public SuccessToastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        initPaint();
        initRect();
        this.mWidth = getMeasuredWidth();
        this.mPadding = dip2px(10.0F);
        this.mEyeWidth = dip2px(3.0F);
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(Color.parseColor("#5cb85c"));
        this.mPaint.setStrokeWidth(dip2px(2.0F));
    }

    private void initRect() {
        this.rectF = new RectF(this.mPadding, this.mPadding, this.mWidth - this.mPadding, this.mWidth - this.mPadding);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        this.mPaint.setStyle(Paint.Style.STROKE);
        paramCanvas.drawArc(this.rectF, 180.0F, this.endAngle, false, this.mPaint);

        this.mPaint.setStyle(Paint.Style.FILL);
        if (this.isSmileLeft) {
            paramCanvas.drawCircle(this.mPadding + this.mEyeWidth + this.mEyeWidth / 2.0F, this.mWidth / 3.0F, this.mEyeWidth, this.mPaint);
        }
        if (this.isSmileRight)
            paramCanvas.drawCircle(this.mWidth - this.mPadding - this.mEyeWidth - this.mEyeWidth / 2.0F, this.mWidth / 3.0F, this.mEyeWidth, this.mPaint);
    }

    public int dip2px(float paramFloat) {
        float f = getContext().getResources().getDisplayMetrics().density;
        return (int)(paramFloat * f + 0.5F);
    }

    public void startAnim() {
        stopAnim();
        startViewAnim(0.0F, 1.0F, 2000L);
    }

    public void stopAnim() {
        if (this.valueAnimator != null) {
            clearAnimation();
            this.isSmileLeft = false;
            this.isSmileRight = false;
            this.mAnimatedValue = 0.0F;
            this.valueAnimator.end();
        }
    }

    private ValueAnimator startViewAnim(float paramFloat1, float paramFloat2, long paramLong) {
        this.valueAnimator = ValueAnimator.ofFloat(new float[] {
            paramFloat1,
            paramFloat2
        });
        this.valueAnimator.setDuration(paramLong);
        this.valueAnimator.setInterpolator(new LinearInterpolator());
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator) {
                SuccessToastView.this.mAnimatedValue = ((Float) paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
                if (SuccessToastView.this.mAnimatedValue < 0.5D) {
                    SuccessToastView.this.isSmileLeft = false;
                    SuccessToastView.this.isSmileRight = false;
                    SuccessToastView.this.endAngle = (-360.0F * SuccessToastView.this.mAnimatedValue);
                } else if ((SuccessToastView.this.mAnimatedValue > 0.55D) && (SuccessToastView.this.mAnimatedValue < 0.7D)) {
                    SuccessToastView.this.endAngle = -180.0F;
                    SuccessToastView.this.isSmileLeft = true;
                    SuccessToastView.this.isSmileRight = false;
                } else {
                    SuccessToastView.this.endAngle = -180.0F;
                    SuccessToastView.this.isSmileLeft = true;
                    SuccessToastView.this.isSmileRight = true;
                }

                SuccessToastView.this.postInvalidate();
            }
        });
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }

        return this.valueAnimator;
    }
}