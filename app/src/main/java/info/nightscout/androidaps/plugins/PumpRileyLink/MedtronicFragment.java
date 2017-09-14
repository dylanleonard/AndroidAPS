package info.nightscout.androidaps.plugins.PumpRileyLink;

import android.app.Activity;
import android.widget.TextView;

import info.nightscout.androidaps.MainApp;
import info.nightscout.androidaps.plugins.Common.SubscriberFragment;

/**
 * Created by Dylan on 9/14/2017.
 */

public class MedtronicFragment extends SubscriberFragment {

    TextView basaBasalRateView;
    TextView tempBasalView;
    TextView extendedBolusView;
    TextView batteryView;
    TextView reservoirView;

    @Override
    protected void updateGUI() {
        Activity activity = getActivity();
        if (activity != null && basaBasalRateView != null)
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    MedtronicPlugin virtualPump = MedtronicPlugin.getInstance();
                    basaBasalRateView.setText(virtualPump.getBaseBasalRate() + "U");
                    if (MainApp.getConfigBuilder().isTempBasalInProgress()) {
                        tempBasalView.setText(MainApp.getConfigBuilder().getTempBasalFromHistory(System.currentTimeMillis()).toStringFull());
                    } else {
                        tempBasalView.setText("");
                    }
                    if (MainApp.getConfigBuilder().isInHistoryExtendedBoluslInProgress()) {
                        extendedBolusView.setText(MainApp.getConfigBuilder().getExtendedBolusFromHistory(System.currentTimeMillis()).toString());
                    } else {
                        extendedBolusView.setText("");
                    }
                    batteryView.setText(virtualPump.batteryPercent + "%");
                    reservoirView.setText(virtualPump.reservoirInUnits + "U");
                }
            });
    }
}
