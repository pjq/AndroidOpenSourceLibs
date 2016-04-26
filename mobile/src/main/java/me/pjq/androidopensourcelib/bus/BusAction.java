package me.pjq.androidopensourcelib.bus;

/**
 * Created by i329817 on 4/26/16.
 */
public class BusAction {
    private String message;
    public BusAction(String s) {
        this.message = s;
    }

    @Override
    public String toString() {
        return "BusAction{" +
                "message='" + message + '\'' +
                '}';
    }
}
