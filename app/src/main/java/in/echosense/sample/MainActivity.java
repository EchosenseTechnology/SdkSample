package in.echosense.sample;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent reqPerm = new Intent(this, AppPermissions.class);
            reqPerm.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(reqPerm);
        }
    }
}
