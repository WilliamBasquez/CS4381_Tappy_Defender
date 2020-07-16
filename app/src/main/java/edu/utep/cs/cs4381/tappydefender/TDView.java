package edu.utep.cs.cs4381.tappydefender;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import edu.utep.cs.cs4381.tappydefender.model.PlayerShip;

public class TDView extends SurfaceView implements  Runnable {
    private PlayerShip player;
    private SurfaceHolder holder;
    private Canvas canvas;
    private Paint paint;

    private Thread gameThread;
    private boolean playing;

    public TDView(Context context){
        super(context);
        player = new PlayerShip(context);
        holder = getHolder();
        paint = new Paint();
    }

    @Override
    public void run(){
        while(playing){
            update();
            draw();
            control();
        }
    }

    public void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void pause(){
        playing = false;
        try{
            gameThread.join();
        } catch (InterruptedException e){

        }
    }

    private void update(){
        player.update();
    }
    private void draw(){
        if(holder.getSurface().isValid()){
            canvas = holder.lockCanvas();
            canvas.drawColor(Color.argb(255,0,0,0));
            canvas.drawBitmap(player.getBitmap(), player.getX(), player.getY(), paint);
            holder.unlockCanvasAndPost(canvas);
        }
    }
    private void control(){
        try{
            gameThread.sleep(10);
        } catch (InterruptedException e){}
    }
}
