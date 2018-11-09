package top.golabe.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class ArcImageView extends AppCompatImageView {

    private final int IN = 0x0001;
    private final int OUT = 0x0002;
    private float mArcHeight;
    private int orientation;
    private Path mPath;


    public ArcImageView(Context context) {
        this(context, null);
    }

    public ArcImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ArcImageView);
            mArcHeight = a.getDimension(R.styleable.ArcImageView_arc_height, 0);
            orientation = a.getInt(R.styleable.ArcImageView_direction, OUT);
            a.recycle();
        }
        mPath = new Path();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        switch (orientation){
            case IN:
                mPath.moveTo(0, 0);
                mPath.lineTo(0, h);
                mPath.quadTo(w / 2f, h - dp2px(mArcHeight), w, h);
                mPath.lineTo(w, 0);
                mPath.close();
                break;
            case OUT:
                mPath.moveTo(0, 0);
                mPath.lineTo(0, h - dp2px(mArcHeight));
                mPath.quadTo(w / 2f, h + dp2px(mArcHeight), w, h - dp2px(mArcHeight));
                mPath.lineTo(w, 0);
                mPath.close();
                break;
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.clipPath(mPath);

        super.onDraw(canvas);

    }

    public float getmArcHeight() {
        return mArcHeight;
    }

    public void setmArcHeight(float mArcHeight) {
        this.mArcHeight = mArcHeight;
        invalidate();
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
        invalidate();
    }

    private int dp2px(float dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5F);
    }
}
