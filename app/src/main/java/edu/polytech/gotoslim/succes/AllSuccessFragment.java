package edu.polytech.gotoslim.succes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import edu.polytech.gotoslim.R;

public class AllSuccessFragment extends Fragment {

    public AllSuccessFragment(){}

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_allsuccess, container, false);
        return v;
    }
}