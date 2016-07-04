package com.coemy.coemydevtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroActivity extends AppCompatActivity {

    private static final String TAG = "HeroActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);


        final Hero hero = (Hero) getIntent().getSerializableExtra("hero");
        Log.i(TAG, "HERO NAME : " + hero.getTitle());

        getSupportActionBar().setTitle(hero.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView heroImage = (ImageView) findViewById(R.id.heroImageView);
        TextView heroIntro = (TextView) findViewById(R.id.heroIntroTextView);
        TextView heroText = (TextView) findViewById(R.id.heroTxtTextView);

        heroImage.setImageResource(ImageUtils.HEROES_IMAGES.get(hero.getTitle()));
        heroIntro.setText(hero.getInto());
        heroText.setText(hero.getText());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
