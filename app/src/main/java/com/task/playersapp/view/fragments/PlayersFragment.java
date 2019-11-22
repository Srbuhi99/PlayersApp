package com.task.playersapp.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.task.playersapp.R;
import com.task.playersapp.network.apiservice.PlayersApiClient;
import com.task.playersapp.network.apiservice.PlayersApiService;
import com.task.playersapp.network.models.AllPayersResponse;
import com.task.playersapp.view.adapter.PlayersAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayersFragment extends Fragment {

    private RecyclerView playersRv;
    private PlayersAdapter adapter;
    private PlayersApiService apiService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_players, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playersRv = view.findViewById(R.id.rv_players_list);
        apiService = PlayersApiClient.getClient().create(PlayersApiService.class);
        setupRv();
        apiService.getAllPayers().enqueue(new Callback<AllPayersResponse>() {
            @Override
            public void onResponse(Call<AllPayersResponse> call, Response<AllPayersResponse> response) {
                if (response.body().getData() != null) {
                    adapter.setPlayers(response.body().getData());
                    playersRv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<AllPayersResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupRv() {
        playersRv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PlayersAdapter();
    }

}
