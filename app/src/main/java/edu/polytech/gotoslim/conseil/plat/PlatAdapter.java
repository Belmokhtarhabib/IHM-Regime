package edu.polytech.gotoslim.conseil.plat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.polytech.gotoslim.R;

public class PlatAdapter extends BaseAdapter {

    private Ilistener listener;
    private ListPlat plats;
    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;

    private Context context;


    public PlatAdapter(Context context, ListPlat plats) {
        this.plats = plats;
        mInflater = LayoutInflater.from(context);
        this.context=context;
    }

    public int getCount() {
        return plats.size();
    }
    public Object getItem(int position) {
        return plats.get(position);
    }
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        //(1) : Réutilisation des layouts
        layoutItem = (LinearLayout) (convertView == null ? mInflater.inflate(R.layout.plat_layout, parent, false) : convertView);

        //(2) : Récupération des TextView de notre layout
        TextView tvName = layoutItem.findViewById(R.id.platName);
        ImageView Picture = layoutItem.findViewById(R.id.platPicture);

        //(3) : Renseignement des valeurs
        tvName.setText(plats.get(position).getName());
        Picture.setImageResource(plats.get(position).getPicture());
        //On retourne l'item créé.
        System.out.println("get low"+plats.get(position));

        layoutItem.setOnClickListener( click -> {
            System.out.println(click.getX()+"  oulalala    "+plats.get(position).getName());

            listener.onClickPlat(plats.get(position));
        });
        return layoutItem;
    }

    public void addListener(Ilistener listener) {
        this.listener = listener;
    }
}




