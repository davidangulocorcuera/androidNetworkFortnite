package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.bumptech.glide.Glide;
import com.example.biolizard.networkrequestandroid.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.Parameters;
import model.Player;
import viewholders.MainCellViewHolder;

public class MainListAdapter extends RecyclerView.Adapter<MainCellViewHolder>  {
    private ArrayList<Parameters> parameters;

    public MainListAdapter( ArrayList<Parameters> parameters){
        this.parameters = parameters;


    }

    public void setData(ArrayList<Parameters> parameters) {
        this.parameters = parameters  ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainCellViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout,null);
        MainCellViewHolder mainCellViewHolder = new MainCellViewHolder(view);
        return mainCellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainCellViewHolder mainCellViewHolder, int position) {
        // Como hay usuarios que no tienen rankin, en el caso de que falte alguna característica esa la ponemos como 404
        // que es el error de not found.

        Parameters item = parameters.get(position);
        if(item.getLabel() != null){
            mainCellViewHolder.tv_cellFirstText.setText(item.getLabel());
        }
        else{
            mainCellViewHolder.tv_cellFirstText.setText("error 404");

        }
        if(item.getRank()!= null){
            mainCellViewHolder.tv_cellSecondText.setText("Rank: " + item.getRank());
        }
        else{
            mainCellViewHolder.tv_cellSecondText.setText("error 404");

        }
        if(item.getValue() != null){
            mainCellViewHolder.tv_cellThirdText.setText("accuracy: " + item.getValue());
        }
        else{
            mainCellViewHolder.tv_cellThirdText.setText("error 404");

        }



    }

    @Override
    public int getItemCount() {
        return parameters.size();

    }


}
