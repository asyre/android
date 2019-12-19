package ru.ifmo.timerapp_derbenyova;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private long seconds;
    private boolean isRunning;
    //    Handler - это механизм, который позволяет работать с очередью сообщений.
//    Он привязан к конкретному потоку (thread) и работает с его очередью.
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

    //    Bundle необходим для временного хранения данных в процессе выполнения.
//    Это отличный выбор при передаче данных между активностями.
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

    //    Runnable же – это кусок кода, который мы пошлем вместо атрибутов сообщения,
//    и он будет выполнен в потоке, с которым работает Handler.
    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            runTimer(textView);
            customHandler.postDelayed(this, 1000);
        }
    };

}