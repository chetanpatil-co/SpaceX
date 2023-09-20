package com.chetan.spacex.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CommonMethods {

    public static boolean isInternetAvailable(Context context) {
        // Check Internet connection is ON or OFF
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        int flag = 1;
        if (networkInfo != null) {
            if (!networkInfo.isAvailable()) {
                flag = 0;
            }
            if (!networkInfo.isConnected()) {
                flag = 0;
            }
        } else {
            flag = 0;
        }
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }

}
