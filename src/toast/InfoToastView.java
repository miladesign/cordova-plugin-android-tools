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

public class InfoToastView extends View {
    RectF rectF = new RectF();
    ValueAnimator valueAnimator;
    float mAnimatedValue = 0.0F;
    private Paint mPaint;
    private float mWidth = 0.0F;
    private float mEyeWidth = 0.0F;
    private float mPadding = 0.0F;
    private float endPoint = 0.0F;
    private boolean isEyeLeft = false;
    private boolean isEyeRight = false;
    private boolean isEyeMiddle = false;

    public InfoToastView(Context paramContext) {
        super(paramContext);
    }

    public InfoToastView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public InfoToastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        initPaint();
        initRect();
        this.mWidth = getMeasuredWidth();
        this.mPadding = dip2px(10.0F);
        this.mEyeWidth = dip2px(3.0F);
        this.endPoint = this.mPadding;
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(Color.parseColor("#337ab7"));
        this.mPaint.setStrokeWidth(dip2px(2.0F));
    }

    private void initRect() {
        this.rectF = new RectF(this.mPadding, this.mPadding, this.mWidth - this.mPadding, this.mWidth - this.mPadding);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        this.mPaint.setStyle(Paint.Style.STROKE);
        paramCanvas.drawLine(this.mPadding, this.mWidth - 3.0F * this.mPadding / 2.0F, this.endPoint, this.mWidth - 3.0F * this.mPadding / 2.0F, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);

        if (this.isEyeLeft) {
            paramCanvas.drawCircle(this.mPadding + this.mEyeWidth, this.mWidth / 3.0F, this.mEyeWidth, this.mPaint);
            paramCanvas.drawCircle(this.mWidth - this.mPadding - 2.0F * this.mEyeWidth, this.mWidth / 3.0F, this.mEyeWidth, this.mPaint);
        }
        if (this.isEyeMiddle) {
            paramCanvas.drawCircle(this.mPadding + 3.0F * this.mEyeWidth / 2.0F, this.mWidth / 3.0F, this.mEyeWidth, this.mPaint);
            paramCanvas.drawCircle(this.mWidth - this.mPadding - 5.0F * this.mEyeWidth / 2.0F, this.mWidth / 3.0F, this.mEyeWidth, this.mPaint);
        }
        if (this.isEyeRight) {
            paramCanvas.drawCircle(this.mPadding + 2.0F * this.mEyeWidth, this.mWidth / 3.0F, this.mEyeWidth, this.mPaint);
            paramCanvas.drawCircle(this.mWidth - this.mPadding - this.mEyeWidth, this.mWidth / 3.0F, this.mEyeWidth, this.mPaint);
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
            this.isEyeLeft = false;
            this.isEyeMiddle = false;
            this.isEyeRight = false;
            this.endPoint = this.mPadding;
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
                InfoToastView.this.mAnimatedValue = ((Float) paramAnonymousValueAnimator.getAnimatedValue()).floatValue();

                if (InfoToastView.this.mAnimatedValue < 0.9D)
                    InfoToastView.this.endPoint = ((2.0F * InfoToastView.this.mWidth - 4.0F * InfoToastView.this.mPadding) * (InfoToastView.this.mAnimatedValue / 2.0F) + InfoToastView.this.mPadding);
                else {
                    InfoToastView.this.endPoint = (InfoToastView.this.mWidth - 5.0F * InfoToastView.this.mPadding / 4.0F);
                }

                if (InfoToastView.this.mAnimatedValue < 0.16D) {
                    InfoToastView.this.isEyeRight = true;
                    InfoToastView.this.isEyeLeft = false;
                } else if (InfoToastView.this.mAnimatedValue < 0.32D) {
                    InfoToastView.this.isEyeRight = false;
                    InfoToastView.this.isEyeLeft = true;
                } else if (InfoToastView.this.mAnimatedValue < 0.48D) {
                    InfoToastView.this.isEyeRight = true;
                    InfoToastView.this.isEyeLeft = false;
                } else if (InfoToastView.this.mAnimatedValue < 0.64D) {
                    InfoToastView.this.isEyeRight = false;
                    InfoToastView.this.isEyeLeft = true;
                } else if (InfoToastView.this.mAnimatedValue < 0.8D) {
                    InfoToastView.this.isEyeRight = true;
                    InfoToastView.this.isEyeLeft = false;
                } else if (InfoToastView.this.mAnimatedValue < 0.96D) {
                    InfoToastView.this.isEyeRight = false;
                    InfoToastView.this.isEyeLeft = true;
                } else {
                    InfoToastView.this.isEyeLeft = false;
                    InfoToastView.this.isEyeMiddle = true;
                    InfoToastView.this.isEyeRight = false;
                }

                InfoToastView.this.postInvalidate();
            }
        });
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }

        return this.valueAnimator;
    }
}