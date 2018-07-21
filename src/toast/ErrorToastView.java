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

public class ErrorToastView extends View {
    RectF rectF = new RectF();
    RectF leftEyeRectF = new RectF();
    RectF rightEyeRectF = new RectF();
    ValueAnimator valueAnimator;
    float mAnimatedValue = 0.0F;
    private Paint mPaint;
    private float mWidth = 0.0F;
    private float mEyeWidth = 0.0F;
    private float mPadding = 0.0F;
    private float endAngle = 0.0F;
    private boolean isJustVisible = false;
    private boolean isSad = false;

    public ErrorToastView(Context paramContext) {
        super(paramContext);
    }

    public ErrorToastView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public ErrorToastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
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
        this.mPaint.setColor(Color.parseColor("#d9534f"));
        this.mPaint.setStrokeWidth(dip2px(2.0F));
    }

    private void initRect() {
        this.rectF = new RectF(this.mPadding / 2.0F, this.mWidth / 2.0F, this.mWidth - this.mPadding / 2.0F, 3.0F * this.mWidth / 2.0F);
        this.leftEyeRectF = new RectF(this.mPadding + this.mEyeWidth - this.mEyeWidth, this.mWidth / 3.0F - this.mEyeWidth, this.mPadding + this.mEyeWidth + this.mEyeWidth, this.mWidth / 3.0F + this.mEyeWidth);

        this.rightEyeRectF = new RectF(this.mWidth - this.mPadding - 5.0F * this.mEyeWidth / 2.0F, this.mWidth / 3.0F - this.mEyeWidth, this.mWidth - this.mPadding - this.mEyeWidth / 2.0F, this.mWidth / 3.0F + this.mEyeWidth);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        this.mPaint.setStyle(Paint.Style.STROKE);
        paramCanvas.drawArc(this.rectF, 210.0F, this.endAngle, false, this.mPaint);

        this.mPaint.setStyle(Paint.Style.FILL);
        if (this.isJustVisible) {
            paramCanvas.drawCircle(this.mPadding + this.mEyeWidth + this.mEyeWidth / 2.0F, this.mWidth / 3.0F, this.mEyeWidth, this.mPaint);
            paramCanvas.drawCircle(this.mWidth - this.mPadding - this.mEyeWidth - this.mEyeWidth / 2.0F, this.mWidth / 3.0F, this.mEyeWidth, this.mPaint);
        }
        if (this.isSad) {
            paramCanvas.drawArc(this.leftEyeRectF, 160.0F, -220.0F, false, this.mPaint);
            paramCanvas.drawArc(this.rightEyeRectF, 20.0F, 220.0F, false, this.mPaint);
        }
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
            this.isSad = false;
            this.endAngle = 0.0F;
            this.isJustVisible = false;
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
                ErrorToastView.this.mAnimatedValue = ((Float) paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
                if (ErrorToastView.this.mAnimatedValue < 0.5D) {
                    ErrorToastView.this.isSad = false;
                    ErrorToastView.this.isJustVisible = false;
                    ErrorToastView.this.endAngle = (240.0F * ErrorToastView.this.mAnimatedValue);
                    ErrorToastView.this.isJustVisible = true;
                } else if ((ErrorToastView.this.mAnimatedValue > 0.55D) && (ErrorToastView.this.mAnimatedValue < 0.7D)) {
                    ErrorToastView.this.endAngle = 120.0F;
                    ErrorToastView.this.isSad = false;
                    ErrorToastView.this.isJustVisible = true;
                } else {
                    ErrorToastView.this.endAngle = 120.0F;
                    ErrorToastView.this.isSad = true;
                    ErrorToastView.this.isJustVisible = false;
                }

                ErrorToastView.this.postInvalidate();
            }
        });
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }

        return this.valueAnimator;
    }
}