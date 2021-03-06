package project.pb.fragments;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private SharedPreferences mySharedPref;

    public SharedPref(Context context) {
        mySharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    public void setNightModeState(Boolean state) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("NightMode", state);
        editor.commit();
    }

    public void setNotification(Boolean state) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("Notification", state);
        editor.commit();
    }

    public Boolean loadNightModeState() {
        Boolean state = mySharedPref.getBoolean("NightMode", false);
        return state;
    }

    public Boolean getNotificationState() {
        Boolean state = mySharedPref.getBoolean("Notification", false);
        return state;
    }
}
