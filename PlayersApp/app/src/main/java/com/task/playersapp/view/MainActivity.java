package com.task.playersapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.task.playersapp.R;
import com.task.playersapp.network.models.Data;
import com.task.playersapp.network.apiservice.PlayersApiClient;
import com.task.playersapp.network.apiservice.PlayersApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private PlayersApiService apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = PlayersApiClient.getClient().create(PlayersApiService.class);
//        apiInterface.getAllPayers().enqueue(new Callback<AllPayersResponse>() {
//            @Override
//            public void onResponse(Call<AllPayersResponse> call, Response<AllPayersResponse> response) {
//                for (Data item : response.body().getData()) {
//                    Log.i("tag", item.getFirst_name());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AllPayersResponse> call, Throwable t) {
//
//            }
//        });
        apiInterface.getPlayer(36).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.i("tag", response.body().getFirst_name());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }
}
