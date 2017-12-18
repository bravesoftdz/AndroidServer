package com.example.mamba.service.testlibrary;

import android.util.Log;
import java.io.IOException;


public class MyServer extends NanoHTTPD {
    private static final String TAG = "MyServer";
    private static final int PORT = 8080;

    public MyServer() throws IOException {
        super(PORT);
        start();
        Log.d(TAG, "server running!");
    }

    @Override
    public Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Android java server</h1>\n";
        msg += "uri endpoint: " + session.getUri();
        return newFixedLengthResponse(msg);
    }
}
