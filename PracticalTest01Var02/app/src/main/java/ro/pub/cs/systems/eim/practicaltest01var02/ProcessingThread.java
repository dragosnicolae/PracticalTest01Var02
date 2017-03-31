package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;

import java.util.Date;
import java.util.Random;

/**
 * Created by dragosn on 31.03.2017.
 */

public class ProcessingThread extends Thread {

    private Context context = null;

    private int sum;
    private int dif;

    public ProcessingThread(Context context, int firstNumber, int secondNumber) {
        this.context = context;

        sum = firstNumber + secondNumber;
        dif = firstNumber - secondNumber;
    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
            sendMessage(sum, 0);
            sleep();
            sendMessage(dif, 1);
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage(int val, int ind) {
        Intent intent = new Intent();
        intent.setAction(Constants.actionTypes[ind]);
        intent.putExtra("message", val);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

}