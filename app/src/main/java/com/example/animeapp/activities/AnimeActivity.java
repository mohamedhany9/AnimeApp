package com.example.animeapp.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.animeapp.R;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        getSupportActionBar().hide();

        String name= getIntent().getExtras().getString("anime_name");
        String description= getIntent().getExtras().getString("anime_description");
        String studio= getIntent().getExtras().getString("anime_studio");
        String category= getIntent().getExtras().getString("anime_category");
        String episode= getIntent().getExtras().getString("anime_nb_episode");
        String rating= getIntent().getExtras().getString("anime_rating");
        String img_url= getIntent().getExtras().getString("anime_img");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_anime_name);
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_studio = findViewById(R.id.aa_studio);
        TextView tv_category = findViewById(R.id.aa_categorie);
        TextView tv_rating = findViewById(R.id.aa_rating);
        ImageView img = findViewById(R.id.aa_thumbnail);


        tv_name.setText(name);
        tv_description.setText(description);
        tv_studio.setText(studio);
        tv_category.setText(category);
        tv_rating.setText(rating);

        Glide.with(this).load(img_url).into(img);

    }
}
