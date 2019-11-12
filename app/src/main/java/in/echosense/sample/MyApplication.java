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
                .setApiKey("NncAsizFxqjHwc0zLs8=")
                .setApplication(this)
                .start();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent reqPerm = new Intent(this, AppPermissions.class);
            reqPerm.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(reqPerm);
        }
    }
}
