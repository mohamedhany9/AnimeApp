package com.example.animeapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.animeapp.R;
import com.example.animeapp.adapter.RvAdapter;
import com.example.animeapp.model.Anime;
import com.example.animeapp.network.ApiClient;
import com.example.animeapp.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;
    private RecyclerView.LayoutManager layoutManager;
    private RvAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        ApiInterface apiInterface = ApiClient.getRetrofitClient().create(ApiInterface.class);

        Call<List<Anime>> call =apiInterface.getAnime();
        call.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                List<Anime> anime = response.body();
                adapter =new RvAdapter(MainActivity.this,anime);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {

            }
        });

    }

}
