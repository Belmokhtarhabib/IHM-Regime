package edu.polytech.gotoslim.succes;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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