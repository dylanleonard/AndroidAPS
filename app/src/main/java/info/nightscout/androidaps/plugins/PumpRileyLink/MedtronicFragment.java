package info.nightscout.androidaps.plugins.PumpRileyLink;

import android.app.Activity;
import android.widget.TextView;

import info.nightscout.androidaps.MainApp;
import info.nightscout.androidaps.plugins.Common.SubscriberFragment;

/**
 * Created by Dylan on 9/14/2017.
 */

//ToDo adapt updateGUI from DanaRFragment?

public class MedtronicFragment extends SubscriberFragment {

    TextView basaBasalRateView;
    TextView tempBasalView;
    TextView extendedBolusView;
    TextView batteryView;
    TextView reservoirView;

    @Override
    protected void updateGUI() {

    }
}
