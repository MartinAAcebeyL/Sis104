package sis104.tareas.tarea3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;


class Graphics extends View {

    private static final String TAG = "DATA";

    public Graphics(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        Paint paint = new Paint();

//canvas.drawCircle(50,50,30,paint);

        int width = getWidth();
        int height = getHeight();
        Log.i(TAG,"Screen: "+width+", "+height);
        paint.setColor(Color.YELLOW);
        canvas.drawLine(0,height/2,width,height/2,paint);
        canvas.drawLine(width/2,0,width/2,height,paint);

        float infX = -40;
        float supX = 40;
        float infY = -40;
        float supY = 40;
        paint.setColor(Color.WHITE);
        for(float x=infX; x<=supX; x+=0.01){
            double y = fx(x);
            double xt = ((x-infX)/(supX-infX))*width;
            double yt = height - ((y-infY)/(supY-infY))*height;
            Log.i(TAG,"x = "+x+" f(x)="+y+" xt="+xt+" yt="+yt);
            canvas.drawCircle((float)xt,(float)yt,3,paint);
        }
    }
    private double fx(float x){
        return x*Math.sin(x);
    }
    }