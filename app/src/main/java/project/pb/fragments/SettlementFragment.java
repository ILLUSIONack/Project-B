package project.pb.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.ScrollView;

import project.pb.R;

public class SettlementFragment extends Fragment implements View.OnClickListener {

    private ScrollView scrollSettlement;
    private Button mapRouteButton, mapButton_99, mapButton_103, mapButton_107;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.settlement_fragment, container, false);
        initialise(view);
        return view;

    }

    public void initialise(View view) {
        getActivity().setTitle("About HR");
        scrollSettlement = view.findViewById(R.id.scrollSettlement);
        scrollSettlement.setScrollbarFadingEnabled(false);
        mapRouteButton = view.findViewById(R.id.mapRouteButton);
        mapButton_99 = view.findViewById(R.id.mapButton99);
        mapButton_103 = view.findViewById(R.id.mapButton103);
        mapButton_107 = view.findViewById(R.id.mapButton107);
        mapRouteButton.setOnClickListener(this);
        mapButton_99.setOnClickListener(this);
        mapButton_103.setOnClickListener(this);
        mapButton_107.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mapRouteButton:
                PopupMenu popup = new PopupMenu(getContext(), v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.equalizer, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.wijnhaven99:
                                openMaps("geo:0,0?q=Wijnhaven 99, 3011 WN Rotterdam");
                                break;
                            case R.id.wijnhaven103:
                                openMaps("geo:0,0?q=Wijnhaven 103, 3011 WN Rotterdam");
                                break;
                            case R.id.wijnhaven107:
                                openMaps("geo:0,0?q=Wijnhaven 107, 3011 WN Rotterdam");
                                break;
                        }
                        System.out.println("Item Id: " + item.getTitle());
                        return true;
                    }
                });
                break;
            case R.id.mapButton99:
                startActivity(new Intent(v.getContext(), MapWijnhaven99.class));
                break;
            case R.id.mapButton103:
                startActivity(new Intent(v.getContext(), MapWijnhaven103.class));
                break;
            case R.id.mapButton107:
                startActivity(new Intent(v.getContext(), MapWijnhaven107.class));
                break;
        }
    }

    private void openMaps(String location) {
        Uri gmmIntentUri = Uri.parse(location);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
