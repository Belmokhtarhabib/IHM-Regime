package edu.polytech.gotoslim.succes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.polytech.gotoslim.R;

public  class UnlockedSuccessFragment extends Fragment {


    public UnlockedSuccessFragment(){}
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_unlockedsuccess, container, false);
        return v;
    }



}