package com.example.mamba.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.example.mamba.service.testlibrary.ServerHostingService;


public class MainActivity extends AppCompatActivity {
    private Button startServiceButton;
    private Button stopServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServiceButton = findViewById(R.id.start_service_button);
        stopServiceButton = findViewById(R.id.stop_service_button);
        startServiceButton.setOnClickListener(view -> {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.embarcadero.NotificationApp");
            if (launchIntent != null) {
                startActivity(launchIntent);
            }
            Intent launchAndroidServer = new Intent(MainActivity.this, ServerHostingService.class);
            startService(launchAndroidServer);
        });
        stopServiceButton.setOnClickListener(view -> {
            Intent stopAndroidService = new Intent(MainActivity.this, ServerHostingService.class);
            stopService(stopAndroidService);
        });
    }
}
