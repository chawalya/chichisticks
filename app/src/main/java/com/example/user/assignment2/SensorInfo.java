package com.example.user.assignment2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class SensorInfo {
    private float x = 0;
    private float y = 0;
    private float z = 0;
    private int shake_threshold = 10;
    private int index;
    private boolean showDialog;
    Stricks stick = new Stricks();
    public void setSensor(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void showDialog(Context context) {
        if((Math.abs(x) > shake_threshold) || (Math.abs(y) > shake_threshold) || (Math.abs(z) > shake_threshold)) {
            if(!showDialog) {
                showDialog = true;
                index=stick.getIndex();
                int checkSentiment = index + 1;
                final AlertDialog.Builder viewDialog = new AlertDialog.Builder(context);
                    viewDialog.setTitle("Prophecy " + String.valueOf(checkSentiment));
                viewDialog.setMessage(stick.getStick(index));
                viewDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        showDialog = false;
                        }
                        });
                viewDialog.show();
            }
        }
    }
}
