package com.example.mamba.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.mamba.service.testlibrary.MyServer;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private Button startServiceButton;
    private MyServer myLittleServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServiceButton = findViewById(R.id.start_service_button);
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.embarcadero.NotificationApp");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            myLittleServer = new MyServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(myLittleServer != null){
            myLittleServer.stop();
        }
    }
}
