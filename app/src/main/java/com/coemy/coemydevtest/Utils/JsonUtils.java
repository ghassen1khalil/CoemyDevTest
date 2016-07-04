package com.coemy.coemydevtest.Utils;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.coemy.coemydevtest.Model.Hero;
import com.coemy.coemydevtest.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ASUS on 02/07/2016.
 */

public class JsonUtils {
    private static final String TAG = "JsonUtils";

    public static ArrayList<Hero> loadJSONFromAsset(Activity activity, String fileName){

        HashMap<String, Integer> HEROES_IMAGES = new HashMap<String, Integer>(){{
            put("Black Panther", R.drawable.black_panther);
            put("Captain America", R.drawable.captain_america);
            put("Hulk", R.drawable.hulk);
            put("Spiderman", R.drawable.spiderman);
            put("Thor", R.drawable.thor);
            put("Wolverine", R.drawable.wolverine);
        }};

        //int resId = HEROES_IMAGES.get("Hulk");

        //Reading Json file from assets folder
        String json = null;
        try {
            InputStream is = activity.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            //Creating an ArrayList of Heros read from JSON
            JSONObject obj = new JSONObject(json);
            JSONArray m_jArry = obj.getJSONArray("elements");
            ArrayList<Hero> herosList = new ArrayList<>();

            for (int i = 0; i < m_jArry.length(); i++) {
                Hero mHero = new Hero();
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String title = jo_inside.getString("title");
                String intro = jo_inside.getString("intro");
                String year = jo_inside.getString("year");
                String text = jo_inside.getString("text");
                String color = jo_inside.getString("color");

                mHero.setTitle(title);
                mHero.setInto(intro);
                mHero.setText(text);
                mHero.setYear(year);
                mHero.setColor(color);
                mHero.setImage(HEROES_IMAGES.get(title));

                herosList.add(mHero);
            }

            return herosList;

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;

    }
}
