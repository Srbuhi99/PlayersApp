package com.task.playersapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.task.playersapp.R;
import com.task.playersapp.network.models.Data;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder> {


    private List<Data> players;

    public void setPlayers(List<Data> players) {
        this.players = players;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View playerCell = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_player, parent, false);
        return new PlayerViewHolder(playerCell);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Data player = players.get(position);
        holder.name.setText(player.getFirst_name());
        holder.surname.setText(player.getLast_name());
        StringBuilder sb = new StringBuilder();
        sb.append(player.getId());
        String c = sb.toString();
        holder.id.setText(c);
        holder.position.setText(player.getPosition());
        holder.team.setText(player.getTeam().getAbbreviation());
        holder.city.setText(player.getTeam().getCity());
        holder.confer.setText(player.getTeam().getConference());
        holder.division.setText(player.getTeam().getDivision());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView surname;
        TextView id;
        TextView position;
        TextView team;
        TextView city;
        TextView confer;
        TextView division;



        PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.player_name);
            surname = itemView.findViewById(R.id.player_surname);
            id = itemView.findViewById(R.id.players_id);
            position = itemView.findViewById(R.id.position);
            team = itemView.findViewById(R.id.team);
            city = itemView.findViewById(R.id.city);
            confer = itemView.findViewById(R.id.conference);
            division = itemView.findViewById(R.id.division);

        }
    }

}
