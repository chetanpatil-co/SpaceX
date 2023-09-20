package com.chetan.spacex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Core {

    @SerializedName("core_serial")
    @Expose
    private Object coreSerial;
    @SerializedName("flight")
    @Expose
    private Object flight;
    @SerializedName("block")
    @Expose
    private Integer block;
    @SerializedName("gridfins")
    @Expose
    private Object gridfins;
    @SerializedName("legs")
    @Expose
    private Object legs;
    @SerializedName("reused")
    @Expose
    private Object reused;
    @SerializedName("land_success")
    @Expose
    private Object landSuccess;
    @SerializedName("landing_intent")
    @Expose
    private Object landingIntent;
    @SerializedName("landing_type")
    @Expose
    private Object landingType;
    @SerializedName("landing_vehicle")
    @Expose
    private Object landingVehicle;

    public Object getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(Object coreSerial) {
        this.coreSerial = coreSerial;
    }

    public Object getFlight() {
        return flight;
    }

    public void setFlight(Object flight) {
        this.flight = flight;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Object getGridfins() {
        return gridfins;
    }

    public void setGridfins(Object gridfins) {
        this.gridfins = gridfins;
    }

    public Object getLegs() {
        return legs;
    }

    public void setLegs(Object legs) {
        this.legs = legs;
    }

    public Object getReused() {
        return reused;
    }

    public void setReused(Object reused) {
        this.reused = reused;
    }

    public Object getLandSuccess() {
        return landSuccess;
    }

    public void setLandSuccess(Object landSuccess) {
        this.landSuccess = landSuccess;
    }

    public Object getLandingIntent() {
        return landingIntent;
    }

    public void setLandingIntent(Object landingIntent) {
        this.landingIntent = landingIntent;
    }

    public Object getLandingType() {
        return landingType;
    }

    public void setLandingType(Object landingType) {
        this.landingType = landingType;
    }

    public Object getLandingVehicle() {
        return landingVehicle;
    }

    public void setLandingVehicle(Object landingVehicle) {
        this.landingVehicle = landingVehicle;
    }

    @Override
    public String toString() {
        return "Core{" +
                "coreSerial=" + coreSerial +
                ", flight=" + flight +
                ", block=" + block +
                ", gridfins=" + gridfins +
                ", legs=" + legs +
                ", reused=" + reused +
                ", landSuccess=" + landSuccess +
                ", landingIntent=" + landingIntent +
                ", landingType=" + landingType +
                ", landingVehicle=" + landingVehicle +
                '}';
    }
}
