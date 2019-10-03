package com.fitatu.errorHandler;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import android.content.Context;
import android.app.Activity;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

public class GlobalErrorHandler extends CordovaPlugin {
    @Override
    public void initialize(CordovaInterface cordova, final CordovaWebView webView) {
        super.initialize(cordova, webView);
        System.out.println("#debug GEH initialize error handler 1");

        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("#debug thread error");
            }
        });

        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("#debug uithread error");
                    }
                });
            }
        });

        System.out.println("#debug GEH initialize error handler 2");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        JSONObject options = args.optJSONObject(0);

        if ("initializeCapturingErrors".equals(action)) {
            initializeCapturingErrors(options, callbackContext);
            return true;
        } else if ("startError".equals(action)) {
            startError(options, callbackContext);
            return true;
        } else if ("startSecondError".equals(action)) {
                     startError(options, callbackContext);
                     return true;
                 }

        return false;
    }

    private void initializeCapturingErrors(JSONObject options, CallbackContext callbackContext) {
        System.out.println("#debug GEH initializeCapturingErrors 1");
        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("HERE ERROR");
            }
        });


        System.out.println("#debug GEH initializeCapturingErrors 1");

        callbackContext.success("Success!");
    }


    private void startError(JSONObject options, CallbackContext callbackContext) {
        System.out.println("#debug GEH startError 1");
        throw new RuntimeException("This is a crash");
    }

    private void startSecondError(JSONObject options, CallbackContext callbackContext) {
        System.out.println("#debug GEH startError 2");
        Integer i = null;
        i.byteValue();
    }
}