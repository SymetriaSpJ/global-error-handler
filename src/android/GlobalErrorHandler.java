package com.fitatu.phonegap.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import android.content.Context;
import android.app.Activity;
import android.widget.Toast;

public class GlobalErrorHandler extends CordovaPlugin {
    @Override
    public void initialize(CordovaInterface cordova, final CordovaWebView webView) {
        super.initialize(cordova, webView);

        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("error");
            }
        });
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        JSONObject options = args.optJSONObject(0);

        if ("initializeCapturingErrors".equals(action)) {
            initializeCapturingErrors(options, callbackContext);
            return true;
        }

        return false;
    }

    private void initializeCapturingErrors(JSONObject options, CallbackContext callbackContext) {
        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("HERE ERROR");
            }
        });

        callbackContext.success("Success!");
    }
}