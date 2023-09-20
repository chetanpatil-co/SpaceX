package com.chetan.spacex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FirstStage {

    @SerializedName("cores")
    @Expose
    private List<Core> cores;

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }

    @Override
    public String toString() {
        return "FirstStage{" +
                "cores=" + cores +
                '}';
    }
}
