package com.task.playersapp.network.apiservice;

import com.task.playersapp.network.models.AllPayersResponse;
import com.task.playersapp.network.models.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlayersApiService {
    @GET("players")
    Call<AllPayersResponse> getAllPayers();

    @GET("players/{ID}")
    Call<Data> getPlayer(@Path("ID") int id);
}
