package com.chetan.spacex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Payload {

    @SerializedName("payload_id")
    @Expose
    private String payloadId;
    @SerializedName("norad_id")
    @Expose
    private List<Integer> noradId;
    @SerializedName("reused")
    @Expose
    private Boolean reused;
    @SerializedName("customers")
    @Expose
    private List<String> customers;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("payload_type")
    @Expose
    private String payloadType;
    @SerializedName("payload_mass_kg")
    @Expose
    private Object payloadMassKg;
    @SerializedName("payload_mass_lbs")
    @Expose
    private Object payloadMassLbs;
    @SerializedName("orbit")
    @Expose
    private String orbit;
    @SerializedName("orbit_params")
    @Expose
    private OrbitParams orbitParams;
    @SerializedName("cap_serial")
    @Expose
    private String capSerial;
    @SerializedName("mass_returned_kg")
    @Expose
    private Object massReturnedKg;
    @SerializedName("mass_returned_lbs")
    @Expose
    private Object massReturnedLbs;
    @SerializedName("flight_time_sec")
    @Expose
    private Object flightTimeSec;
    @SerializedName("cargo_manifest")
    @Expose
    private Object cargoManifest;

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public List<Integer> getNoradId() {
        return noradId;
    }

    public void setNoradId(List<Integer> noradId) {
        this.noradId = noradId;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public Object getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(Object payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public Object getPayloadMassLbs() {
        return payloadMassLbs;
    }

    public void setPayloadMassLbs(Object payloadMassLbs) {
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParams getOrbitParams() {
        return orbitParams;
    }

    public void setOrbitParams(OrbitParams orbitParams) {
        this.orbitParams = orbitParams;
    }

    public String getCapSerial() {
        return capSerial;
    }

    public void setCapSerial(String capSerial) {
        this.capSerial = capSerial;
    }

    public Object getMassReturnedKg() {
        return massReturnedKg;
    }

    public void setMassReturnedKg(Object massReturnedKg) {
        this.massReturnedKg = massReturnedKg;
    }

    public Object getMassReturnedLbs() {
        return massReturnedLbs;
    }

    public void setMassReturnedLbs(Object massReturnedLbs) {
        this.massReturnedLbs = massReturnedLbs;
    }

    public Object getFlightTimeSec() {
        return flightTimeSec;
    }

    public void setFlightTimeSec(Object flightTimeSec) {
        this.flightTimeSec = flightTimeSec;
    }

    public Object getCargoManifest() {
        return cargoManifest;
    }

    public void setCargoManifest(Object cargoManifest) {
        this.cargoManifest = cargoManifest;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "payloadId='" + payloadId + '\'' +
                ", noradId=" + noradId +
                ", reused=" + reused +
                ", customers=" + customers +
                ", nationality='" + nationality + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", payloadType='" + payloadType + '\'' +
                ", payloadMassKg=" + payloadMassKg +
                ", payloadMassLbs=" + payloadMassLbs +
                ", orbit='" + orbit + '\'' +
                ", orbitParams=" + orbitParams +
                ", capSerial='" + capSerial + '\'' +
                ", massReturnedKg=" + massReturnedKg +
                ", massReturnedLbs=" + massReturnedLbs +
                ", flightTimeSec=" + flightTimeSec +
                ", cargoManifest=" + cargoManifest +
                '}';
    }
}
