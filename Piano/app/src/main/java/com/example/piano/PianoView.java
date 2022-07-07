package com.example.piano;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PianoView extends View {
    private  static  int NUMBER_KEY = 14;
    private Paint black, white, yellow;
    private ArrayList<Key> whites , blacks;
    private int keyWidth, keyHeight;

    public PianoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        black = new Paint();
        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.FILL);

        white = new Paint();
        white.setColor(Color.WHITE);
        white.setStyle(Paint.Style.FILL);

        yellow = new Paint();
        yellow.setColor(Color.YELLOW);
        yellow.setStyle(Paint.Style.FILL);

        whites = new ArrayList<Key>();
        blacks = new ArrayList<Key>();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        keyWidth = w / NUMBER_KEY;
        keyHeight = h ;

        int blackCount = 15;
        for (int i = 0 ; i < NUMBER_KEY; i++){
            int left = i*keyWidth;
            int right = left + keyWidth;

            RectF rect = new RectF(left , 0 , right, keyHeight);
            whites.add((new Key(i+1, rect)));
            if ( i != 0 && i != 3  && i != 7 && i != 10){
                rect = new RectF((float) (i-1)*keyWidth + 0.75f*keyWidth,
                        0,
                        (float) i*keyWidth+0.25f*keyWidth,
                        keyHeight*0.67f);
                blacks.add(new Key(blackCount++, rect));
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(Key k:whites){
            canvas.drawRect(k.rect, k.isDown?yellow:white);
        }
        for (int i = 1 ; i < NUMBER_KEY ; i++){
            canvas.drawLine(i*keyWidth, 0 , i*keyWidth, keyHeight , black);

        }

        for (Key k:blacks){
            canvas.drawRect(k.rect , k.isDown?yellow:black);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        boolean isDownAction = action == MotionEvent.ACTION_DOWN ||
                                action == MotionEvent.ACTION_MOVE;
        for ( int touchIndex = 0 ; touchIndex < event.getPointerCount() ; touchIndex++){
            float x = event.getX(touchIndex);
            float y = event.getY(touchIndex);

            for ( Key k:whites){
                if (k.rect.contains(x,y)) {
                    k.isDown = isDownAction;
                    break;
                }
            }
        }
        invalidate();
        return true;

    }
}
