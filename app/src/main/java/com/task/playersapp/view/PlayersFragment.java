package com.task.playersapp.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.task.playersapp.R;


public class PlayersFragment extends Fragment implements View.OnClickListener {


    private RecyclerView playersList;
    Button btnSearch;
    TextInputEditText idValue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_players, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playersList = (RecyclerView) getView().findViewById(R.id.rv_players_list);
        btnSearch =(Button)getView().findViewById(R.id.btn_search);
        idValue = (TextInputEditText)getView().findViewById(R.id.text_input_edit_text_write_id);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        playersList.setLayoutManager(layoutManager);
        playersList.setHasFixedSize(true);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), SinglePlayerFragment.class);
        getActivity().startActivity(intent);


    }
    }
