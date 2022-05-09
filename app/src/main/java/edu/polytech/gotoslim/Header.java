package edu.polytech.gotoslim;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Header extends Fragment{

    public Header() { }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_header, container, false);

        result.findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(result.getContext(), ParametresActivity.class)));
        result.findViewById(R.id.home).setOnClickListener(v1-> startActivity(new Intent(result.getContext(), MainActivity.class)));

        return result;
    }

    public static void setHeader(FragmentManager fm){
        Header header = (Header) fm.findFragmentById(R.id.header);

        if (header == null) {
            header = new Header();
            fm.beginTransaction().add(R.id.header, header).commit();
        }
    }
}