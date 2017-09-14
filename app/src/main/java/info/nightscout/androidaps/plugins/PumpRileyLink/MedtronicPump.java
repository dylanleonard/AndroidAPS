package info.nightscout.androidaps.plugins.PumpRileyLink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dylan on 9/14/2017.
 */

public class MedtronicPump {
    private static Logger log = LoggerFactory.getLogger(MedtronicPump.class);

    private static MedtronicPump instance = null;

    public static MedtronicPump getInstance() {
        if (instance == null) instance = new MedtronicPump();
        return instance;
    }
}
