package com.example.tomcat.timeralarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class MainActivity extends AppCompatActivity
{
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




    private void initView()
    {
        textView = (TextView) findViewById(R.id.tvMesg);
    }

    private void initControl()
    {
        handler = new Handler();
        }

        runnable  = new Runnable() {
            @Override
            public void run() {
                showTime();
            }
        };


    }


    public void showTime()
    {
            Date nowDt = Calendar.getInstance().getTime();
            SimpleDateFormat sft = new SimpleDateFormat("yyyy/MM/DD hh:mm:ss");
            String msg = sft.format(nowDt);
            textView.setText(msg);
    }

}
