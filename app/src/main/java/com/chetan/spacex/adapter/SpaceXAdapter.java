package com.chetan.spacex.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.chetan.spacex.R;
import com.chetan.spacex.model.Launch;
import com.chetan.spacex.view.LaunchDetailsActivity;
import com.chetan.spacex.view.MainActivity;
import com.chetan.spacex.viewmodel.LaunchesViewModel;

import java.util.List;

public class SpaceXAdapter extends RecyclerView.Adapter<SpaceXAdapter.MyViewHolder> {

    Context context;
    public List<Launch> launchList;
    LaunchesViewModel viewModel;

    public SpaceXAdapter(Context mCtx, List<Launch> launchList) {
        this.context = mCtx;
        this.launchList = launchList;
        viewModel = ViewModelProviders.of((MainActivity) mCtx).get(LaunchesViewModel.class);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.launches_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Launch launchObj = launchList.get(position);

        Glide.with(context).load(launchObj.getLinks().getMissionPatchSmall()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).transform(new RoundedCorners(2)).into(holder.iv_mission_patch);

        holder.txtMissionName.setText(launchObj.getMissionName());
        holder.txtLaunchDate.setText(launchObj.getLaunchDateUtc());
        holder.txtRocketName.setText(launchObj.getRocket().getRocketName());
        String launchStatus;
        boolean launch_status = launchObj.isLaunchSuccess();
        if (launch_status) {
            launchStatus = "Launch Status: " + " Successful";
        } else {
            launchStatus = "Launch Status: " + " Failed";
        }
        holder.txtLaunchStatus.setText(launchStatus);

        int favStatus = launchObj.getFavStatus();
        if (favStatus == 1) {
            Drawable added = ContextCompat.getDrawable(context, R.drawable.baseline_star_24);
            holder.iv_favorite.setImageDrawable(added);
        } else {
            Drawable removed = ContextCompat.getDrawable(context, R.drawable.outline_star_outline_24);
            holder.iv_favorite.setImageDrawable(removed);
        }

        holder.iv_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int flight_number = launchObj.getFlightNumber();
                    int fav_status = launchObj.getFavStatus();
                    if (fav_status == 0) {
                        Toast.makeText(context, "Added to Favorite", Toast.LENGTH_SHORT).show();
                        Launch launchObjUpdate = new Launch();
                        launchObjUpdate.setFlightNumber(flight_number);
                        launchObjUpdate.setFavStatus(1);
                        viewModel.updateFavoriteStatus(launchObjUpdate);
                        Drawable added = ContextCompat.getDrawable(context, R.drawable.baseline_star_24);
                        holder.iv_favorite.setImageDrawable(added);
                    } else if (fav_status == 1) {
                        Toast.makeText(context, "Removed from Favorite", Toast.LENGTH_SHORT).show();
                        Launch launchObjUpdate = new Launch();
                        launchObjUpdate.setFlightNumber(flight_number);
                        launchObjUpdate.setFavStatus(0);
                        viewModel.updateFavoriteStatus(launchObjUpdate);
                        Drawable removed = ContextCompat.getDrawable(context, R.drawable.outline_star_outline_24);
                        holder.iv_favorite.setImageDrawable(removed);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flight_number = launchObj.getFlightNumber();
                Intent intent = new Intent(context, LaunchDetailsActivity.class);
                intent.putExtra("flight_number", "" + flight_number);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return launchList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout parent_layout;
        ImageView iv_mission_patch, iv_favorite;
        TextView txtMissionName, txtLaunchDate, txtRocketName, txtLaunchStatus;

        public MyViewHolder(View itemView) {
            super(itemView);

            parent_layout = itemView.findViewById(R.id.parent_layout);
            iv_mission_patch = itemView.findViewById(R.id.iv_mission_patch);
            iv_favorite = itemView.findViewById(R.id.iv_favorite);
            txtMissionName = itemView.findViewById(R.id.txtMissionName);
            txtLaunchDate = itemView.findViewById(R.id.txtLaunchDate);
            txtRocketName = itemView.findViewById(R.id.txtRocketName);
            txtLaunchStatus = itemView.findViewById(R.id.txtLaunchStatus);

        }
    }
}