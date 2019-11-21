package com.task.playersapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.material.textfield.TextInputEditText;
import com.task.playersapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentManager fragmentManager;
    FragmentTransaction fts;
    Button btnSearch;
    TextInputEditText idValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch =(Button)findViewById(R.id.btn_search);
        idValue = (TextInputEditText)findViewById(R.id.text_input_edit_text_write_id);
        btnSearch.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        toStartFragment();

    }
    public void toStartFragment(){
        PlayersFragment playersFragment = new PlayersFragment();
        fts = fragmentManager.beginTransaction();
        fts.addToBackStack(null);
        fts.add(R.id.containerFragment,playersFragment);
        fts.commit();
     }


    @Override
    public void onClick(View v) {
        SinglePlayerFragment singlePlayerFragment = new SinglePlayerFragment();
        fts = fragmentManager.beginTransaction();
        fts.addToBackStack(null);
        fts.replace(R.id.containerFragment,singlePlayerFragment);
        fts.commit();



    }
}
