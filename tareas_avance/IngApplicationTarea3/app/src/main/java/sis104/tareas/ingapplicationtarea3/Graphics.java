package sis104.tareas.ingapplicationtarea3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Graphics extends View {
    public Graphics(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(50,50,30,paint);
    }
}
