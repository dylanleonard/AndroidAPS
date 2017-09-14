package info.nightscout.androidaps.plugins.PumpRileyLink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import info.nightscout.androidaps.Constants;

/**
 * Created by Dylan on 9/14/2017.
 */

//ToDo adapt createConvertedProfile from DanaRPump?

public class MedtronicPump {
    private static Logger log = LoggerFactory.getLogger(MedtronicPump.class);

    private static MedtronicPump instance = null;

    public static MedtronicPump getInstance() {
        if (instance == null) instance = new MedtronicPump();
        return instance;
    }

    public static final int UNITS_MGDL = 0;
    public static final int UNITS_MMOL = 1;

    public static final int DELIVERY_PRIME = 0x01;
    public static final int DELIVERY_STEP_BOLUS = 0x02;
    public static final int DELIVERY_BASAL = 0x04;
    public static final int DELIVERY_EXT_BOLUS = 0x08;

    public static final String PROFILE_PREFIX = "Medtronic-";

    public Date lastConnection = new Date(0);
    public Date lastSettingsRead = new Date(0);

    // Info
    public String serialNumber = "";
//    public Date shippingDate = new Date(0);
//    public String shippingCountry = "";
    public boolean isNewPump = true;
    public int password = -1;
    public Date pumpTime = new Date(0);

//    public static final int DOMESTIC_MODEL = 0x01;
//    public static final int EXPORT_MODEL = 0x03;
    public int model;
    public int protocol;
    public int productCode;

    public boolean isConfigUD;
    public boolean isExtendedBolusEnabled;
    public boolean isEasyModeEnabled;

    // Status
    public boolean pumpSuspended;
    public boolean calculatorEnabled;
    public double dailyTotalUnits;
    public int maxDailyTotalUnits;

    public double bolusStep;
    public double basalStep;

    public double iob;

    public double reservoirRemainingUnits;
    public int batteryRemaining;

    public boolean bolusBlocked;
    public Date lastBolusTime = new Date(0);
    public double lastBolusAmount;

    public double currentBasal;

    public boolean isTempBasalInProgress;
    public int tempBasalPercent;
    public int tempBasalRemainingMin;
    public int tempBasalTotalSec;
    public Date tempBasalStart;

    public boolean isDualBolusInProgress;
    public boolean isExtendedInProgress;
    public int extendedBolusMinutes;
    public double extendedBolusAmount;
    public double extendedBolusAbsoluteRate;
    public int extendedBolusSoFarInMinutes;
    public Date extendedBolusStart;
    public int extendedBolusRemainingMinutes;

    // Profile
    public int units;
    public int easyBasalMode;
    public boolean basal48Enable = false;
    public int currentCIR;
    public double currentCF;
    public double currentAI;
    public double currentTarget;
    public int currentAIDR;

    public int morningCIR;
    public double morningCF;
    public int afternoonCIR;
    public double afternoonCF;
    public int eveningCIR;
    public double eveningCF;
    public int nightCIR;
    public double nightCF;


    public int activeProfile = 0;
    public double[][] pumpProfiles = null;

    //Limits
    public double maxBolus;
    public double maxBasal;

    public String getUnits() {
        return units == UNITS_MGDL ? Constants.MGDL : Constants.MMOL;
    }
}
