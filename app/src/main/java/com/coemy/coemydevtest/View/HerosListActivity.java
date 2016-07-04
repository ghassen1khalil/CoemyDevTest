package com.coemy.coemydevtest.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import com.coemy.coemydevtest.Model.Hero;
import com.coemy.coemydevtest.R;
import com.coemy.coemydevtest.Utils.HeroesAdapter;
import com.coemy.coemydevtest.Utils.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class HerosListActivity extends AppCompatActivity {

    private static final String TAG = "HerosListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_list);

        ArrayList<Hero> mHeros = JsonUtils.loadJSONFromAsset(this, "test.json");

        ListView heroesList = (ListView) findViewById(R.id.listView);
        HeroesAdapter adapter = new HeroesAdapter(this,R.layout.listview_item_layout,mHeros);

        //View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        //heroesList.addHeaderView(header);

        heroesList.setAdapter(adapter);


    }






}
