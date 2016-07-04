package com.coemy.coemydevtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HerosListActivity extends AppCompatActivity {

    private static final String TAG = "HerosListActivity";

    @Override
    protected void onPause() {
        super.onPause();
        //this.finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_list);

        ArrayList<Hero> mHeros = JsonUtils.loadJSONFromAsset(this.getApplicationContext(), "test.json");

        ListView heroesList = (ListView) findViewById(R.id.list);
        HeroesAdapter adapter = new HeroesAdapter(this, R.layout.listview_item_layout, mHeros);

        heroesList.setAdapter(adapter);

        heroesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                TextView titleTextView = (TextView) view.findViewById(R.id.txtTitle);
                TextView introTextView = (TextView) view.findViewById(R.id.txtIntro);
                TextView txtTextView = (TextView) view.findViewById(R.id.txtText);

                Hero hero = new Hero(titleTextView.getText().toString(), introTextView.getText().toString(), txtTextView.getText().toString());

                Intent heroIntent = new Intent(HerosListActivity.this, HeroActivity.class);
                heroIntent.putExtra("hero", hero);
                startActivity(heroIntent);

            }
        });


    }


}
