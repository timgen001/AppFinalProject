package com.example.musicplayerexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class frag2 extends Fragment {

    private View view2;

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view2 = inflater.inflate(R.layout.frag2_layout, null);
        return view2;
    }
}
