package ru.ifmo.timerapp_derbenyova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private long seconds;
    private boolean isRunning;
    private Handler customHandler;
    private TextView textView;


    public void onClickStart(View view) {
        isRunning = true;

    }

    public void onClickStop(View view) {
        isRunning = false;
    }

    public void onClickReset(View view) {
        isRunning = false;
        seconds = 0;
        textView.setText(R.string.start_value);
    }


    public void runTimer(TextView timerValue) {
        if (isRunning) seconds++;
        long mins = seconds / 60;
        long hours = mins / 60;
        timerValue.setText(String.format("%02d", hours % 60) + ":"
                + String.format("%02d", mins % 60) + ":"
                + String.format("%02d", seconds % 60));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("seconds", seconds);
        savedInstanceState.putBoolean("isRunning", isRunning);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        customHandler = new Handler();
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            seconds = savedInstanceState.getLong("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
        } else {
            seconds = 0;
            isRunning = false;
        }
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.timerValue);
        customHandler.post(updateTimerThread);
    }

    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            runTimer(textView);
            customHandler.postDelayed(this, 1000);
        }
    };

}
