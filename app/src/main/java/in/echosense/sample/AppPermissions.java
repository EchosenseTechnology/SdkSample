/*
 *
 *   ******************************************************
 *   * Copyright (C) Echosense Technologies <contact@echosense.in> - All Rights Reserved
 *   * Unauthorized copying of this file, via any medium is strictly prohibited
 *   * Proprietary and confidential
 *   * Contact Echosense Technologies <contact@echosense.in> for any queries.
 *   ******************************************************
 *   * Purpose:  Receiver for boot complete event
 *   *
 *   * Overview:
 *   *      This class will start the SDK services at boot completion
 *   *
 *   * Usage:   {If any}
 *   *
 *   *******************************************************
 *
 */

package in.echosense.sample;


import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/* Class for requesting permissions. It is a transparent UI class. UI class is required to get the
 * callback for user's action for the permissions */

public class AppPermissions extends AppCompatActivity {
    private static String TAG = AppPermissions.class.getSimpleName();

    protected String[] permissions;

    protected int pCode = 0x01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "Starting RequestPermission activity");

        super.onCreate(savedInstanceState);

        checkPermissions();
    }

    /* Call to native method for dangerous permissions:
     * 1. Storage
     * 2. Location
     * 4. Read Phone State*/
    @TargetApi(Build.VERSION_CODES.M)
    protected void checkPermissions() {

        permissions = new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        boolean flag = false;

        for (String s : permissions) {
            if (checkSelfPermission(s) != PackageManager.PERMISSION_GRANTED) {
                flag = true;
                Log.v(TAG, "Permission not available for " + s);
            }
        }

        if (flag) {
            requestPermissions(permissions, pCode);
        } else {
            finish();
        }
    }

    /* Call back for knowing user's actions */

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.v(TAG, "Permission result received for " + requestCode);

        if (requestCode == pCode) {

            boolean flag = true;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                for (int i = 0, len = permissions.length; i < len; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        Log.v(TAG, "Permission not granted for " + permissions[i]);
                        flag = false;
                    }
                }
            }
            finish();
        }
    }
}
