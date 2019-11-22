package com.task.playersapp.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.task.playersapp.R;
import com.task.playersapp.network.apiservice.PlayersApiClient;
import com.task.playersapp.network.apiservice.PlayersApiService;
import com.task.playersapp.network.models.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SinglePlayerFragment extends Fragment {
    private SinglePlayerFragment() {

    }

    public static final String ID_KEY = "id";

    private int playerId = -1;
    private PlayersApiService apiService;
    private TextView playerName;
    private TextView surname;
    private TextView id;
    private TextView position;
    private TextView team;
    private TextView city;
    private TextView confer;
    private TextView division;

    public static SinglePlayerFragment newInstance(int playerId) {
        Bundle args = new Bundle();
        args.putInt(ID_KEY, playerId);
        SinglePlayerFragment fragment = new SinglePlayerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_single_player, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiService = PlayersApiClient.getClient().create(PlayersApiService.class);
        playerName = view.findViewById(R.id.player_name);
        surname = view.findViewById(R.id.player_surname);
        id = view.findViewById(R.id.players_id);
        position = view.findViewById(R.id.position);
        team = view.findViewById(R.id.team);
        city = view.findViewById(R.id.city);
        confer = view.findViewById(R.id.conference);
        division = view.findViewById(R.id.division);
        if (getArguments() != null) {
            playerId = getArguments().getInt(ID_KEY);
        }
        if (playerId != -1)
            apiService.getPlayer(playerId).enqueue(new Callback<Data>() {
                @Override
                public void onResponse(Call<Data> call, Response<Data> response) {
                    Data player = response.body();
                    if (player != null && player.getFirst_name() != null && !player.getFirst_name().isEmpty()) {
                        playerName.setText(player.getFirst_name());
                        surname.setText(player.getLast_name());
                        StringBuilder sb = new StringBuilder();
                        sb.append(player.getId());
                        String c = sb.toString();
                        id.setText(c);
                        position.setText(player.getPosition());
                        team.setText(player.getTeam().getAbbreviation());
                        city.setText(player.getTeam().getCity());
                        confer.setText(player.getTeam().getConference());
                        division.setText(player.getTeam().getDivision());
                    }else {
                        playerName.setText("Player not found");
                    }
                }

                @Override
                public void onFailure(Call<Data> call, Throwable t) {
                    playerName.setText("Something went wrong");
                }
            });
    }
}
