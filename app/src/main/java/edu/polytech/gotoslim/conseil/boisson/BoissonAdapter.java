package edu.polytech.gotoslim.conseil.boisson;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.polytech.gotoslim.R;

public class BoissonAdapter extends BaseAdapter {


    private ListBoisson boissons;
    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;


    public BoissonAdapter(Context context, ListBoisson boissons) {
        this.boissons = boissons;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return boissons.size();
    }
    public Object getItem(int position) {
        return boissons.get(position);
    }
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        //(1) : Réutilisation des layouts
        layoutItem = (LinearLayout) (convertView == null ? mInflater.inflate(R.layout.boisson_layout, parent, false) : convertView);

        //(2) : Récupération des TextView de notre layout
        TextView tvName = layoutItem.findViewById(R.id.boissonName);
        ImageView pizzaPicture = layoutItem.findViewById(R.id.boissonPicture);

        //(3) : Renseignement des valeurs
        tvName.setText(boissons.get(position).getName());
        pizzaPicture.setImageResource(boissons.get(position).getPicture());
        //On retourne l'item créé.
        return layoutItem;
    }
}




