package info.nightscout.androidaps.plugins.PumpRileyLink.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Dylan on 9/14/2017.
 */

public class MedtronicExecutionService extends Service {
    private IBinder mBinder = new Localbinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private class Localbinder extends Binder {
        public MedtronicExecutionService getServiceInstance() {
            return MedtronicExecutionService.this;
        }
    }
}
