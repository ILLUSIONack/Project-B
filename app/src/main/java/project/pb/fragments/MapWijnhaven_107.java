package project.pb.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;

import project.pb.R;

public class MapWijnhaven_107 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floor_plan_107);

        //TODO THIS CAUSES THE SCROLLVIEW TO NOT SCROLL!!!!!!!!!!!!!!!!!!!!!!!!!!
        //scrollViewMaps.setOnTouchListener(new MultiTouchListener());
    }
}