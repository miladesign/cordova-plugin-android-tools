package cordova.tools.miladesign.toast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class WarningToastView extends View {
    RectF rectFOne = new RectF();
    RectF rectFTwo = new RectF();
    RectF rectFThree = new RectF();
    private Paint mPaint;
    private float mWidth = 0.0F;
    private float mHeight = 0.0F;
    private float mStrokeWidth = 0.0F;
    private float mPadding = 0.0F;
    private float mPaddingBottom = 0.0F;

    public WarningToastView(Context paramContext) {
        super(paramContext);
    }

    public WarningToastView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public WarningToastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        initPaint();
        initRect();
        this.mHeight = getMeasuredHeight();
        this.mWidth = getMeasuredWidth();
        this.mPadding = convertDpToPixel(2.0F);
        this.mPaddingBottom = (this.mPadding * 2.0F);
        this.mStrokeWidth = convertDpToPixel(2.0F);
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(Color.parseColor("#f0ad4e"));
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
    }

    private void initRect() {
        this.rectFOne = new RectF(this.mPadding, 0.0F, this.mWidth - this.mPadding, this.mWidth - this.mPaddingBottom);
        this.rectFTwo = new RectF((float)(1.5D * this.mPadding), convertDpToPixel(6.0F) + this.mPadding + this.mHeight / 3.0F, this.mPadding +
            convertDpToPixel(9.0F),
            convertDpToPixel(6.0F) + this.mPadding + this.mHeight / 2.0F);
        this.rectFThree = new RectF(this.mPadding + convertDpToPixel(9.0F), convertDpToPixel(3.0F) + this.mPadding + this.mHeight / 3.0F, this.mPadding +
            convertDpToPixel(18.0F),
            convertDpToPixel(3.0F) + this.mPadding + this.mHeight / 2.0F);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        this.mPaint.setStyle(Paint.Style.STROKE);
        paramCanvas.drawArc(this.rectFOne, 170.0F, -144.0F, false, this.mPaint);
        paramCanvas.drawLine(this.mWidth - convertDpToPixel(3.0F) - this.mStrokeWidth, this.mPadding + this.mHeight / 6.0F, this.mWidth -
            convertDpToPixel(3.0F) -
            this.mStrokeWidth, this.mHeight -
            convertDpToPixel(2.0F) -
            this.mHeight / 4.0F, this.mPaint);

        paramCanvas.drawLine(this.mWidth - convertDpToPixel(3.0F) - this.mStrokeWidth - convertDpToPixel(8.0F), (float)(this.mPadding + this.mHeight / 8.5D), this.mWidth -
            convertDpToPixel(3.0F) -
            this.mStrokeWidth - convertDpToPixel(8.0F),
            (float)(this.mHeight -
                convertDpToPixel(3.0F) -
                this.mHeight / 2.5D), this.mPaint);

        paramCanvas.drawLine(this.mWidth - convertDpToPixel(3.0F) - this.mStrokeWidth - convertDpToPixel(17.0F), this.mPadding + this.mHeight / 10.0F, this.mWidth -
            convertDpToPixel(3.0F) -
            this.mStrokeWidth - convertDpToPixel(17.0F),
            (float)(this.mHeight -
                convertDpToPixel(3.0F) -
                this.mHeight / 2.5D), this.mPaint);

        paramCanvas.drawLine(this.mWidth - convertDpToPixel(3.0F) - this.mStrokeWidth - convertDpToPixel(26.0F), this.mPadding + this.mHeight / 10.0F, this.mWidth -
            convertDpToPixel(3.0F) -
            this.mStrokeWidth - convertDpToPixel(26.0F),
            (float)(this.mHeight -
                convertDpToPixel(2.0F) -
                this.mHeight / 2.5D), this.mPaint);

        paramCanvas.drawArc(this.rectFTwo, 170.0F, 180.0F, false, this.mPaint);
        paramCanvas.drawArc(this.rectFThree, 175.0F, -150.0F, false, this.mPaint);
    }

    public float convertDpToPixel(float paramFloat) {
        DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
        float f = paramFloat * (localDisplayMetrics.densityDpi / 160.0F);
        return f;
    }
}