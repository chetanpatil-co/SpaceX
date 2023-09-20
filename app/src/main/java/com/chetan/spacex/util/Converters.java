package com.chetan.spacex.util;

import androidx.room.TypeConverter;

import com.chetan.spacex.model.Core;
import com.chetan.spacex.model.LaunchFailureDetails;
import com.chetan.spacex.model.LaunchSite;
import com.chetan.spacex.model.Links;
import com.chetan.spacex.model.Payload;
import com.chetan.spacex.model.Rocket;
import com.chetan.spacex.model.Telemetry;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Converters {
    @TypeConverter
    public static List<String> fromString(String value) {
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    // Core
    @TypeConverter
    public static List<Core> fromCoreString(String value) {
        Type listType = new TypeToken<List<Core>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromCoreList(List<Core> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    // Payload
    @TypeConverter
    public static List<Payload> fromPayloadString(String value) {
        Type listType = new TypeToken<List<Payload>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromPayloadList(List<Payload> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    // Rocket
    @TypeConverter
    public static String jsonRocketToString(Rocket rocket) {
        Gson gson = new Gson();
        String json = gson.toJson(rocket);
        return json;
    }

    @TypeConverter
    public Rocket stringToRocketJson(String json) {
        Gson gson = new Gson();
        Rocket rocket = gson.fromJson(json, Rocket.class);
        return rocket;
    }

    // Telemetry
    @TypeConverter
    public static String jsonTelemetryToString(Telemetry telemetry) {
        Gson gson = new Gson();
        String json = gson.toJson(telemetry);
        return json;
    }

    @TypeConverter
    public Telemetry stringToTelemetryJson(String json) {
        Gson gson = new Gson();
        Telemetry telemetry = gson.fromJson(json, Telemetry.class);
        return telemetry;
    }

    // LaunchSite
    @TypeConverter
    public static String jsonLaunchSiteToString(LaunchSite launchSite) {
        Gson gson = new Gson();
        String json = gson.toJson(launchSite);
        return json;
    }

    @TypeConverter
    public LaunchSite stringToLaunchSiteJson(String json) {
        Gson gson = new Gson();
        LaunchSite launchSite = gson.fromJson(json, LaunchSite.class);
        return launchSite;
    }

    // LaunchFailureDetails
    @TypeConverter
    public static String jsonLaunchFailureDetailsToString(LaunchFailureDetails launchFailureDetails) {
        Gson gson = new Gson();
        String json = gson.toJson(launchFailureDetails);
        return json;
    }

    @TypeConverter
    public LaunchFailureDetails stringToLaunchFailureDetailsJson(String json) {
        Gson gson = new Gson();
        LaunchFailureDetails launchFailureDetails = gson.fromJson(json, LaunchFailureDetails.class);
        return launchFailureDetails;
    }

    // Links
    @TypeConverter
    public static String jsonLinksToString(Links links) {
        Gson gson = new Gson();
        String json = gson.toJson(links);
        return json;
    }

    @TypeConverter
    public Links stringToLinksJson(String json) {
        Gson gson = new Gson();
        Links links = gson.fromJson(json, Links.class);
        return links;
    }
}
