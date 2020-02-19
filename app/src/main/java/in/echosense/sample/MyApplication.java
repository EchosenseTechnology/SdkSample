package in.echosense.sample;

import android.app.Application;
import android.content.Intent;
import android.os.Build;

import in.echosense.echosdk.EchoSdk;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        EchoSdk.Initialize()
                .with(getApplicationContext())
                .setApiKey("ECHOSENSE PROVIDED KEY")
                .setApplication(this)
                .start();

    }
}
