package app.cave.recyclerview_filterring;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.myViewHolder> implements Filterable {
    Context c;
    ArrayList<Player> players, filterList;
    CustomFilter filter;
    ItemClickListener itemClickListener;
    RecyclerView recyclerView;
    Activity activity;

    public RecycleAdapter(Context c, ArrayList<Player> players, RecyclerView recyclerView, Activity activity) {
        this.c = c;
        this.players = players;
        this.filterList = players;
        itemClickListener = (ItemClickListener) activity;
        this.recyclerView = recyclerView;
        this.activity = activity;
    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model,null);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {
        myViewHolder.posTxt.setText(players.get(i).getPos());
        myViewHolder.nameTxt.setText(players.get(i).getName());
        myViewHolder.img.setImageResource(players.get(i).getImg());

    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter(filterList,this);
        }

        return filter;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView nameTxt,posTxt;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img= (ImageView) itemView.findViewById(R.id.playerImage);
            nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
            posTxt= (TextView) itemView.findViewById(R.id.posTxt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(v,getAdapterPosition());
                }
            });
        }
    }
}
