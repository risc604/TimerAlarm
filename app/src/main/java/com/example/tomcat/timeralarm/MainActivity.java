package com.example.tomcat.timeralarm;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class MainActivity extends AppCompatActivity
{
    private final static String TAG = MainActivity.class.getSimpleName();

    Handler     handler;
    //Timer       notifyTimer;
    TextView    textView;
    Runnable    runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initControl();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onDestroy()
    {
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }

    private void initView()
    {
        textView = (TextView) findViewById(R.id.tvMesg);
        textView.setTextSize(20);
        //textView.set
    }

    private void initControl()
    {
        handler = new Handler();
        runnable  = new Runnable()
        {
            @Override
            public void run() {
                showTime();
            }
        };

        //showTime();
        //handler.postDelayed(runnable, 1000);
        handler.post(runnable);
        //runnable.run();

    }


    public void showTime()
    {
        Date nowDt = Calendar.getInstance().getTime();
        SimpleDateFormat sft = new SimpleDateFormat("yyyy/MM/dd   HH:mm:ss");
        String msg = sft.format(nowDt);
        textView.setText(msg);
        handler.postDelayed(runnable, 1000*10);
        Log.d(TAG, msg);
    }
}
