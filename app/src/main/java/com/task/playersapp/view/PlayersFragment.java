package com.task.playersapp.view;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.task.playersapp.R;
import com.task.playersapp.network.apiservice.PlayersApiClient;
import com.task.playersapp.network.apiservice.PlayersApiService;
import com.task.playersapp.network.models.AllPayersResponse;

import com.task.playersapp.network.models.AllPayersResponse;
import com.task.playersapp.network.models.Data;
import com.task.playersapp.network.apiservice.PlayersApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayersFragment extends Fragment  {


    private RecyclerView playersList;
    private PlayersAdapter playersAdapter;
    private PlayersApiService apiInterface;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_players, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playersList = (RecyclerView) getView().findViewById(R.id.rv_players_list);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        playersList.setLayoutManager(layoutManager);
        playersList.setHasFixedSize(true);

        playersAdapter = new PlayersAdapter(200);
        playersList.setAdapter(playersAdapter);

       /* apiInterface = PlayersApiClient.getClient().create(PlayersApiService.class);
        apiInterface.getAllPayers(1).enqueue(new Callback<AllPayersResponse>() {
            @Override
            public void onResponse(Call<AllPayersResponse> call, Response<AllPayersResponse> response) {
                for (Data item : response.body().getData()) {
                    Log.i("tag", item.getFirst_name());
                }
            }

            @Override
            public void onFailure(Call<AllPayersResponse> call, Throwable t) {
            }
        });
        apiInterface.getPlayer(36).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.i("tag", response.body().getFirst_name());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });*/
    }



    }
