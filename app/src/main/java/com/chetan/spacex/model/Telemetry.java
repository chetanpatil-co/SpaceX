package com.chetan.spacex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Telemetry {

    @SerializedName("flight_club")
    @Expose
    private String flightClub;

    public String getFlightClub() {
        return flightClub;
    }

    public void setFlightClub(String flightClub) {
        this.flightClub = flightClub;
    }

    @Override
    public String toString() {
        return "Telemetry{" +
                "flightClub=" + flightClub +
                '}';
    }
}
