package info.nightscout.androidaps.plugins.PumpRileyLink;

import android.support.annotation.Nullable;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import info.nightscout.androidaps.Config;
import info.nightscout.androidaps.Constants;
import info.nightscout.androidaps.data.DetailedBolusInfo;
import info.nightscout.androidaps.data.Profile;
import info.nightscout.androidaps.data.ProfileStore;
import info.nightscout.androidaps.data.PumpEnactResult;
import info.nightscout.androidaps.interfaces.ConstraintsInterface;
import info.nightscout.androidaps.interfaces.PluginBase;
import info.nightscout.androidaps.interfaces.ProfileInterface;
import info.nightscout.androidaps.interfaces.PumpDescription;
import info.nightscout.androidaps.interfaces.PumpInterface;
import info.nightscout.androidaps.plugins.PumpRileyLink.services.MedtronicExecutionService;

import static info.nightscout.androidaps.R.string.pump;

/**
 * Created by Dylan on 9/14/2017.
 */

public class MedtronicPlugin implements PluginBase, PumpInterface, ConstraintsInterface, ProfileInterface {

    private static Logger log = LoggerFactory.getLogger(MedtronicPlugin.class);

    @Override
    public String getFragmentClass() {
        return MedtronicFragment.class.getName();
    }

    static boolean fragmentPumpEnabled = false;
    static boolean fragmentProfileEnabled = false;
    static boolean fragmentPumpVisible = true;

    public static MedtronicExecutionService sExecutionService;


    private static MedtronicPump pump = MedtronicPump.getInstance();
    private static boolean useExtendedBoluses = false;

    private static MedtronicPlugin plugin = null;

    public static MedtronicPlugin getPlugin() {
        if (plugin == null)
            plugin = new MedtronicPlugin();
        return plugin;
    }

    public static PumpDescription pumpDescription = new PumpDescription();

    @Override
    public boolean isLoopEnabled() {
        return true;
    }

    @Override
    public boolean isClosedModeEnabled() {
        return true;
    }

    @Override
    public boolean isAutosensModeEnabled() {
        return true;
    }

    @Override
    public boolean isAMAModeEnabled() {
        return true;
    }

    @Override
    public Double applyBasalConstraints(Double absoluteRate) {
        double origAbsoluteRate = absoluteRate;
        if (pump != null) {
            if (absoluteRate > pump.maxBasal) {
                absoluteRate = pump.maxBasal;
                if (Config.logConstraintsChanges && origAbsoluteRate != Constants.basalAbsoluteOnlyForCheckLimit)
                    log.debug("Limiting rate " + origAbsoluteRate + "U/h by pump constraint to " + absoluteRate + "U/h");
            }
        }
        return absoluteRate;
    }

    @Override
    public Integer applyBasalConstraints(Integer percentRate) {
        return null;
    }

    @Override
    public Double applyBolusConstraints(Double insulin) {
        return null;
    }

    @Override
    public Integer applyCarbsConstraints(Integer carbs) {
        return null;
    }

    @Override
    public Double applyMaxIOBConstraints(Double maxIob) {
        return null;
    }

    @Nullable
    @Override
    public ProfileStore getProfile() {
        return null;
    }

    @Override
    public String getUnits() {
        return null;
    }

    @Override
    public String getProfileName() {
        return null;
    }

    @Override
    public boolean isInitialized() {
        return false;
    }

    @Override
    public boolean isSuspended() {
        return false;
    }

    @Override
    public boolean isBusy() {
        return false;
    }

    @Override
    public int setNewBasalProfile(Profile profile) {
        return 0;
    }

    @Override
    public boolean isThisProfileSet(Profile profile) {
        return false;
    }

    @Override
    public Date lastDataTime() {
        return null;
    }

    @Override
    public void refreshDataFromPump(String reason) {

    }

    @Override
    public double getBaseBasalRate() {
        return 0;
    }

    @Override
    public PumpEnactResult deliverTreatment(DetailedBolusInfo detailedBolusInfo) {
        return null;
    }

    @Override
    public void stopBolusDelivering() {

    }

    @Override
    public PumpEnactResult setTempBasalAbsolute(Double absoluteRate, Integer durationInMinutes, boolean force) {
        return null;
    }

    @Override
    public PumpEnactResult setTempBasalPercent(Integer percent, Integer durationInMinutes) {
        return null;
    }

    @Override
    public PumpEnactResult setExtendedBolus(Double insulin, Integer durationInMinutes) {
        return null;
    }

    @Override
    public PumpEnactResult cancelTempBasal(boolean force) {
        return null;
    }

    @Override
    public PumpEnactResult cancelExtendedBolus() {
        return null;
    }

    @Override
    public JSONObject getJSONStatus() {
        return null;
    }

    @Override
    public String deviceID() {
        return null;
    }

    @Override
    public PumpDescription getPumpDescription() {
        return null;
    }

    @Override
    public String shortStatus(boolean veryShort) {
        return null;
    }

    @Override
    public boolean isFakingTempsByExtendedBoluses() {
        return false;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getNameShort() {
        return null;
    }

    @Override
    public boolean isEnabled(int type) {
        return false;
    }

    @Override
    public boolean isVisibleInTabs(int type) {
        return false;
    }

    @Override
    public boolean canBeHidden(int type) {
        return false;
    }

    @Override
    public boolean hasFragment() {
        return false;
    }

    @Override
    public boolean showInList(int type) {
        return false;
    }

    @Override
    public void setFragmentEnabled(int type, boolean fragmentEnabled) {

    }

    @Override
    public void setFragmentVisible(int type, boolean fragmentVisible) {

    }
}
