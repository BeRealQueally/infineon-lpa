package com.infineon.esim.lpa.core.worker.local;

import com.gsma.sgp.messages.rspdefinitions.GetRatResponse;
import com.gsma.sgp.messages.rspdefinitions.RulesAuthorisationTable;
import com.infineon.esim.lpa.core.es10.Es10Interface;
import com.infineon.esim.util.Log;

public class GetRatWorker {
    private static final String TAG = GetRatWorker.class.getName();


    private final Es10Interface es10Interface;

    public GetRatWorker(Es10Interface es10Interface) {
        this.es10Interface = es10Interface;
    }

    public RulesAuthorisationTable getRat() throws Exception {
        Log.debug(TAG, "Getting RAT...");


        GetRatResponse getRatResponse = es10Interface.es10c_getRat();

        return getRatResponse.getRat();
    }
}
