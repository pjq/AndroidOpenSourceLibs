
package me.pjq.androidopensourcelib.bus;

import com.squareup.otto.Bus;

/**
 * Created by i329817 on 4/26/16.
 */
public class BusManager {
    private static BusManager ourInstance = new BusManager();

    Bus bus;

    public static BusManager getInstance() {
        return ourInstance;
    }

    private BusManager() {
        bus = new Bus();
    }

    public void sendBusAction(String s){
        bus.post(new BusAction(s));
    }

    public Bus getBus() {
       return bus;
    }
}
