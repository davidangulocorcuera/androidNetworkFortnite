package activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.arch.lifecycle.ViewModelProviders;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;


import com.example.biolizard.networkrequestandroid.R;

import java.util.ArrayList;

import adapters.MainListAdapter;
import model.Parameters;
import model.Player;
import request.Repository;
import viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Player> players;
    private ArrayList<Parameters> parameters;
    private FloatingActionButton btnSearch;
    private EditText etUserForSearch;
    private Spinner sp_platform;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView_main);
        players = new ArrayList<>();
        parameters = new ArrayList<>();
        etUserForSearch = findViewById(R.id.editText_search);
        btnSearch = findViewById(R.id.btn_search);
        sp_platform = findViewById(R.id.spinner_platform);


        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getServiceDataMutableLiveData().observe(this, player -> {
            if (player != null) {
                players.add(player);
                //  Log.v("LISTA", player.getStats().getP2().getKills().getRank());

                parameters.add(player.getStats().getP2().getKills());
                parameters.add(player.getStats().getP2().getKpg());
                parameters.add(player.getStats().getP2().getScore());
                parameters.add(player.getStats().getP2().getWinRatio());

                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                recyclerView.setAdapter(new MainListAdapter(parameters));

            }


        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parameters = new ArrayList<>();
                mainViewModel.getData(sp_platform.getSelectedItem().toString().trim(), etUserForSearch.getText().toString());
            }
        });


    }
}
