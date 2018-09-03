package com.andrewxa.rickandmorty.view.fragments.locations;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrewxa.rickandmorty.R;
import com.andrewxa.rickandmorty.datasource.model.locations.Result;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.ViewHolder> {

    private CompoundButton.OnCheckedChangeListener listener;
    private List<Result> resultList;
    Context context;

    LocationsAdapter(List<Result> resultList,Context context) {
        this.resultList = resultList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.locations_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result result = resultList.get(position);
        String name = result.getName();
        String type = result.getType();
        String dimension = result.getDimension();


        Glide.with(context)
                .load(R.drawable.ic_solar_system)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(holder.image);

        holder.planetName.setText(name);
        holder.planetType.setText(type);
        holder.dimension.setText(dimension);
    }


    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView planetName;
        TextView planetType;
        TextView dimension;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.planeImageView);
            planetName = (TextView) itemView.findViewById(R.id.planetNameView);
            planetType = (TextView) itemView.findViewById(R.id.planetTypeView);
            dimension = (TextView) itemView.findViewById(R.id.planetDimensionView);

        }
    }

}
