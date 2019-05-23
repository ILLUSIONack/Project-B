package project.pb.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import project.pb.R;

public class SettlementFragment extends Fragment {

    private Button link;
    public ScrollView scrollSettlement;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.settlement_fragment, container, false);
        getActivity().setTitle("About HR");
        scrollSettlement = view.findViewById(R.id.scrollSettlement);
        scrollSettlement.setScrollbarFadingEnabled(false);
        link = view.findViewById(R.id.mapButton);
        link.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MapActivityFragment.class));
            }
        });
        return view;
    }

}
