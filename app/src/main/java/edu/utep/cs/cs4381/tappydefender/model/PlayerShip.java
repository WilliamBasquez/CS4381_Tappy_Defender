package edu.utep.cs.cs4381.tappydefender.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import edu.utep.cs.cs4381.tappydefender.R;

public class PlayerShip {
    private int x;
    private int y;
    private final int speed;
    private final Bitmap bitmap;

    public PlayerShip(Context context){
        x = 50;
        y = 50;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ship);
    }

    public void update(){
        x++;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }
}
