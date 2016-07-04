package com.coemy.coemydevtest.Utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.coemy.coemydevtest.Model.Hero;
import com.coemy.coemydevtest.R;
import java.util.ArrayList;

/**
 * Created by ASUS on 03/07/2016.
 */

public class HeroesAdapter extends ArrayAdapter<Hero> {

    private Context context;
    int layoutResourceId;
    private ArrayList<Hero> lHero;
    private static LayoutInflater inflater = null ;

    public HeroesAdapter (Context context, int layoutResourceId, ArrayList<Hero> lHero) {
        super(context, layoutResourceId, lHero);

        try {
            this.layoutResourceId = layoutResourceId;
            this.lHero = lHero;
            this.context = context;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public int getCount() {
        return lHero.size();
    }

    public Hero getItem(Hero position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        HeroHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new HeroHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            holder.txtIntro = (TextView) row.findViewById(R.id.txtIntro);
            holder.txtYear = (TextView) row.findViewById(R.id.txtYear);

            row.setTag(holder);
        }
        else
        {
            holder = (HeroHolder)row.getTag();
        }

        Hero hero = lHero.get(position);
        holder.txtTitle.setText(hero.getTitle());
        holder.txtIntro.setText(hero.getInto());
        holder.txtYear.setText(hero.getYear());
        holder.imgIcon.setImageResource(hero.getImage());

        return row;
    }

    static class HeroHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
        TextView txtIntro;
        TextView txtYear;
    }
}


