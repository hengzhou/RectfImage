package com.android.rectfimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;


import static com.android.rectfimage.Xfermodes.sModes;


public class SingleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);


//        setContentView(new XfermodeView(this));
//        setContentView(new XFdrawMethod(this));
//        setContentView(new PaintView(this));
    }

    private class PaintView extends View {
        int w, h;

        public PaintView(Context context) {
            super(context);
            WindowManager windowManager = (WindowManager) context.getApplicationContext()
                    .getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics metrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(metrics);
            w = metrics.widthPixels;
            h = metrics.heightPixels;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int width = 200, height = 200;

            int sc = canvas.saveLayer(0, 0, w, h, null, Canvas.MATRIX_SAVE_FLAG |
                    Canvas.CLIP_SAVE_FLAG |
                    Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                    Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                    Canvas.CLIP_TO_LAYER_SAVE_FLAG);
            int x = 600, y = 600;

            Bitmap bm1 = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
            Canvas c1 = new Canvas(bm1);
            Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
            p1.setColor(Color.BLUE);
            c1.drawRect(new RectF(0, 0, width, height), p1);
            c1.drawRect(new RectF(0, 0, width, height), p1);
            canvas.drawBitmap(bm1, x, y, p1);
            p1.setXfermode(sModes[7]);

            Bitmap bm = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(bm);
            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setColor(0xFFFFCC44);
            c.drawOval(new RectF(0, 0, width, height), p);

            canvas.drawBitmap(bm, x + 80, x + 80, p);
            Log.i("PaintView", x + "   " + y);

            p.setXfermode(null);


//创建一个图层，在图层上演示图形混合后的效果
//            paint.setXfermode(sModes[6]);
//            paint.setColor(Color.YELLOW);
//            canvas.drawOval(outerRect, paint);
//            paint.setXfermode(null);

//            imgDrawble.setBounds(200, 200, x, y);
//            canvas.saveLayer(outerRect, paint, Canvas.ALL_SAVE_FLAG);
//            imgDrawble.draw(canvas);
        }
    }

}
