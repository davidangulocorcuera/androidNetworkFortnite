package viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.biolizard.networkrequestandroid.R;


public class MainCellViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_cellFirstText;
    public TextView tv_cellSecondText;
    public TextView tv_cellThirdText;

    public MainCellViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_cellFirstText = itemView.findViewById(R.id.textView_cell_first_text);
        tv_cellSecondText = itemView.findViewById(R.id.textView_cell_second_text);
        tv_cellThirdText = itemView.findViewById(R.id.textView_cell_third_text);




    }


}
