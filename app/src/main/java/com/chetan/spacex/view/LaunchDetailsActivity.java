package com.chetan.spacex.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.chetan.spacex.R;
import com.chetan.spacex.model.Launch;
import com.chetan.spacex.viewmodel.LaunchesViewModel;

public class LaunchDetailsActivity extends AppCompatActivity {
    private static final String TAG = LaunchDetailsActivity.class.getSimpleName();
    LaunchesViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_details);
        model = ViewModelProviders.of(LaunchDetailsActivity.this).get(LaunchesViewModel.class);
        TextView tv_mission_name = findViewById(R.id.tv_mission_name);
        TextView tv_launch_date = findViewById(R.id.tv_launch_date);
        TextView tv_rocket_name = findViewById(R.id.tv_rocket_name);
        TextView tv_rocket_type = findViewById(R.id.tv_rocket_type);
        TextView tv_launch_status = findViewById(R.id.tv_launch_status);
        TextView tv_launch_site_name = findViewById(R.id.tv_launch_site_name);
        TextView tv_launch_site_location = findViewById(R.id.tv_launch_site_location);
        ImageView iv_mission_patch = findViewById(R.id.iv_mission_patch);
        TextView tv_mission_description = findViewById(R.id.tv_mission_description);
        TextView tv_press_kit = findViewById(R.id.tv_press_kit);
        TextView tv_article_link = findViewById(R.id.tv_article_link);

        Intent intent = getIntent();
        if (intent != null) {
            try {
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String flight_number = extras.getString("flight_number");
                    Launch objLaunch = model.getRecordById(Integer.parseInt(flight_number));
                    tv_mission_name.setText(objLaunch.getMissionName());
                    tv_launch_date.setText(objLaunch.getLaunchDateUtc());
                    tv_rocket_name.setText(objLaunch.getRocket().getRocketName());
                    tv_rocket_type.setText(objLaunch.getRocket().getRocketType());
                    boolean launch_status = objLaunch.isLaunchSuccess();
                    String launchStatus;
                    if (launch_status) {
                        launchStatus = " Successful";
                    } else {
                        launchStatus = " Failed";
                    }
                    tv_launch_status.setText(launchStatus);
                    tv_launch_site_name.setText(objLaunch.getLaunchSite().getSiteName());
                    tv_launch_site_location.setText(objLaunch.getLaunchSite().getSiteNameLong());

                    Glide.with(LaunchDetailsActivity.this).load(objLaunch.getLinks().getMissionPatchSmall())
                            .placeholder(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher)
                            .transform(new RoundedCorners(2)).into(iv_mission_patch);

                    tv_mission_description.setText(objLaunch.getDetails());
                    tv_press_kit.setText(objLaunch.getLinks().getPresskit());
                    tv_article_link.setText(objLaunch.getLinks().getArticleLink());

                }
            } catch (Exception e) {
                Log.e(TAG, "onCreate: " + e.getMessage());
            }
        }
    }
}