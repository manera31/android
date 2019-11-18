package com.joanmanera.examen;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentList extends Fragment {
    private Star[] stars;
    private RecyclerView rvList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        StarParser parser = new StarParser(getActivity());
        if(parser.parse()){
            this.stars = parser.getStars();
        }
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvList = getView().findViewById(R.id.rvList);
        AdapterStars adapterStars = new AdapterStars(getActivity(), stars);

        adapterStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "ra: "+stars[v.getId()].getRa()+",  dec: "+stars[v.getId()].getDec(), Toast.LENGTH_LONG).show();
                Log.i("FragmentList", stars[v.getId()].toString());
            }
        });
        rvList.setAdapter(adapterStars);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }
}
