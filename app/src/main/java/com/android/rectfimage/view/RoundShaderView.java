package com.android.rectfimage.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.android.rectfimage.R;

/**
 * Created by Administrator on 2016/12/19.
 */

/**
 * 使用BitmapShader绘制圆角矩形
 */
public class RoundShaderView extends ImageView {

    public RoundShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.mipmap.beaty2);

        BitmapShader mBitmapShader = new BitmapShader(bm, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Bitmap targetBm = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), bm.getConfig());
        RectF rectF = new RectF(0, 0, targetBm.getWidth(), targetBm.getHeight());
        Paint paint = new Paint();
        paint.setShader(mBitmapShader);
        canvas.drawRoundRect(rectF, 40, 40, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }
}
