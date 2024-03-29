package com.chetan.spacex.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.chetan.spacex.util.Converters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "table_launch")
public class Launch {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("sr_no")
    @Expose
    private Integer srNo;
    @SerializedName("flight_number")
    @Expose
    private Integer flightNumber;
    @SerializedName("mission_name")
    @Expose
    private String missionName;

    @SerializedName("mission_id")
    @Expose
    @TypeConverters(Converters.class)
    private List<String> missionId;
    @SerializedName("upcoming")
    @Expose
    private Boolean upcoming;
    @SerializedName("launch_year")
    @Expose
    private String launchYear;
    @SerializedName("launch_date_unix")
    @Expose
    private Integer launchDateUnix;
    @SerializedName("launch_date_utc")
    @Expose
    private String launchDateUtc;
    @SerializedName("launch_date_local")
    @Expose
    private String launchDateLocal;
    @SerializedName("is_tentative")
    @Expose
    private Boolean isTentative;
    @SerializedName("tentative_max_precision")
    @Expose
    private String tentativeMaxPrecision;
    @SerializedName("tbd")
    @Expose
    private Boolean tbd;
    @SerializedName("launch_window")
    @Expose
    private Integer launchWindow;
    @SerializedName("rocket")
    @Expose
    @TypeConverters(Converters.class)
    private Rocket rocket;
    @SerializedName("ships")
    @Expose
    private List<String> ships;
    @SerializedName("telemetry")
    @Expose
    @TypeConverters(Converters.class)
    private Telemetry telemetry;
    @SerializedName("launch_site")
    @Expose
    @TypeConverters(Converters.class)
    private LaunchSite launchSite;
    @SerializedName("launch_success")
    @Expose
    private boolean launchSuccess;
    @SerializedName("launch_failure_details")
    @Expose
    @TypeConverters(Converters.class)
    private LaunchFailureDetails launchFailureDetails;
    @SerializedName("links")
    @Expose
    @TypeConverters(Converters.class)
    private Links links;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("static_fire_date_utc")
    @Expose
    private String staticFireDateUtc;
    @SerializedName("static_fire_date_unix")
    @Expose
    private String staticFireDateUnix;
    /*@SerializedName("timeline")
    @Expose
    private Object timeline;
    @SerializedName("crew")
    @Expose
    private Object crew;*/
    @SerializedName("last_date_update")
    @Expose
    private String lastDateUpdate;
    @SerializedName("last_ll_launch_date")
    @Expose
    private String lastLlLaunchDate;
    @SerializedName("last_ll_update")
    @Expose
    private String lastLlUpdate;
    @SerializedName("last_wiki_launch_date")
    @Expose
    private String lastWikiLaunchDate;
    @SerializedName("last_wiki_revision")
    @Expose
    private String lastWikiRevision;
    @SerializedName("last_wiki_update")
    @Expose
    private String lastWikiUpdate;
    @SerializedName("launch_date_source")
    @Expose
    private String launchDateSource;
    @SerializedName("fav_status")
    @Expose
    private Integer favStatus;

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public List<String> getMissionId() {
        return missionId;
    }

    public void setMissionId(List<String> missionId) {
        this.missionId = missionId;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    /*public Boolean getIsTentative() {
        return isTentative;
    }

    public void setIsTentative(Boolean isTentative) {
        this.isTentative = isTentative;
    }*/

    public String getTentativeMaxPrecision() {
        return tentativeMaxPrecision;
    }

    public void setTentativeMaxPrecision(String tentativeMaxPrecision) {
        this.tentativeMaxPrecision = tentativeMaxPrecision;
    }

    public Boolean getTbd() {
        return tbd;
    }

    public void setTbd(Boolean tbd) {
        this.tbd = tbd;
    }

    public Integer getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(Integer launchWindow) {
        this.launchWindow = launchWindow;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public List<String> getShips() {
        return ships;
    }

    public void setShips(List<String> ships) {
        this.ships = ships;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public boolean isLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public LaunchFailureDetails getLaunchFailureDetails() {
        return launchFailureDetails;
    }

    public void setLaunchFailureDetails(LaunchFailureDetails launchFailureDetails) {
        this.launchFailureDetails = launchFailureDetails;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStaticFireDateUtc() {
        return staticFireDateUtc;
    }

    public void setStaticFireDateUtc(String staticFireDateUtc) {
        this.staticFireDateUtc = staticFireDateUtc;
    }

    public String getStaticFireDateUnix() {
        return staticFireDateUnix;
    }

    public void setStaticFireDateUnix(String staticFireDateUnix) {
        this.staticFireDateUnix = staticFireDateUnix;
    }

    /*public Object getTimeline() {
        return timeline;
    }

    public void setTimeline(Object timeline) {
        this.timeline = timeline;
    }

    public Object getCrew() {
        return crew;
    }

    public void setCrew(Object crew) {
        this.crew = crew;
    }*/

    public String getLastDateUpdate() {
        return lastDateUpdate;
    }

    public void setLastDateUpdate(String lastDateUpdate) {
        this.lastDateUpdate = lastDateUpdate;
    }

    public String getLastLlLaunchDate() {
        return lastLlLaunchDate;
    }

    public void setLastLlLaunchDate(String lastLlLaunchDate) {
        this.lastLlLaunchDate = lastLlLaunchDate;
    }

    public String getLastLlUpdate() {
        return lastLlUpdate;
    }

    public void setLastLlUpdate(String lastLlUpdate) {
        this.lastLlUpdate = lastLlUpdate;
    }

    public String getLastWikiLaunchDate() {
        return lastWikiLaunchDate;
    }

    public void setLastWikiLaunchDate(String lastWikiLaunchDate) {
        this.lastWikiLaunchDate = lastWikiLaunchDate;
    }

    public String getLastWikiRevision() {
        return lastWikiRevision;
    }

    public void setLastWikiRevision(String lastWikiRevision) {
        this.lastWikiRevision = lastWikiRevision;
    }

    public String getLastWikiUpdate() {
        return lastWikiUpdate;
    }

    public void setLastWikiUpdate(String lastWikiUpdate) {
        this.lastWikiUpdate = lastWikiUpdate;
    }

    public String getLaunchDateSource() {
        return launchDateSource;
    }

    public void setLaunchDateSource(String launchDateSource) {
        this.launchDateSource = launchDateSource;
    }

    public Boolean getTentative() {
        return isTentative;
    }

    public void setTentative(Boolean tentative) {
        isTentative = tentative;
    }

    public Integer getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(Integer favStatus) {
        this.favStatus = favStatus;
    }

    @Override
    public String toString() {
        return "Launch{" +
                "srNo=" + srNo +
                ", flightNumber=" + flightNumber +
                ", missionName='" + missionName + '\'' +
                ", missionId=" + missionId +
                ", upcoming=" + upcoming +
                ", launchYear='" + launchYear + '\'' +
                ", launchDateUnix=" + launchDateUnix +
                ", launchDateUtc='" + launchDateUtc + '\'' +
                ", launchDateLocal='" + launchDateLocal + '\'' +
                ", isTentative=" + isTentative +
                ", tentativeMaxPrecision='" + tentativeMaxPrecision + '\'' +
                ", tbd=" + tbd +
                ", launchWindow=" + launchWindow +
                ", rocket=" + rocket +
                ", ships=" + ships +
                ", telemetry=" + telemetry +
                ", launchSite=" + launchSite +
                ", launchSuccess=" + launchSuccess +
                ", launchFailureDetails=" + launchFailureDetails +
                ", links=" + links +
                ", details='" + details + '\'' +
                ", staticFireDateUtc='" + staticFireDateUtc + '\'' +
                ", staticFireDateUnix='" + staticFireDateUnix + '\'' +
                ", lastDateUpdate='" + lastDateUpdate + '\'' +
                ", lastLlLaunchDate='" + lastLlLaunchDate + '\'' +
                ", lastLlUpdate='" + lastLlUpdate + '\'' +
                ", lastWikiLaunchDate='" + lastWikiLaunchDate + '\'' +
                ", lastWikiRevision='" + lastWikiRevision + '\'' +
                ", lastWikiUpdate='" + lastWikiUpdate + '\'' +
                ", launchDateSource='" + launchDateSource + '\'' +
                ", favStatus=" + favStatus +
                '}';
    }
}
