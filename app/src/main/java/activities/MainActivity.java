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
    private ArrayList<Parameters> parameters;
    private FloatingActionButton btnSearch;
    private EditText etUserForSearch;
    private Spinner sp_platform;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView_main);
        parameters = new ArrayList<>();
        etUserForSearch = findViewById(R.id.editText_search);
        btnSearch = findViewById(R.id.btn_search);
        sp_platform = findViewById(R.id.spinner_platform);


        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getParametersDataMutableLiveData().observe(this, arr_params -> {
            if (arr_params != null) {

                parameters = arr_params;
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                recyclerView.setAdapter(new MainListAdapter(parameters));

            }


        });
        mainViewModel.getData("psn","ninja");

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // limpiamos la lista para que la nueva búsqueda se superponga.
                parameters.clear();
                // Método para obtener los datos y le mandamos los parametros necesarios
                mainViewModel.getData(sp_platform.getSelectedItem().toString().trim(), etUserForSearch.getText().toString());
                // Quitamos el texto de la busqueda para no tener que borrarlo cada vez que buscamos un usuario.
                etUserForSearch.setText("");
            }
        });


    }
}
