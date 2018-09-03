package com.andrewxa.rickandmorty.view.fragments.characters;

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
import com.andrewxa.rickandmorty.datasource.model.characters.Result;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private CompoundButton.OnCheckedChangeListener listener;
    private List<Result> resultList;
    Context context;

    CharacterAdapter(List<Result> resultList,Context context) {
        this.resultList = resultList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.characters_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Result result = resultList.get(position);
        String name = result.getName();
        String status = result.getStatus();
        String species = result.getSpecies();


        Glide.with(context)
                .load(result.getImage())
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(holder.image);

        holder.name.setText(name);
        holder.status.setText(status);
        holder.species.setText(species);

        holder.arrowExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.gender.setText(result.getGender());
                holder.placeOfBirth.setText(result.getOrigin().getName());
                holder.location.setText(result.getLocation().getName());

                holder.arrowExpand.setImageResource(R.drawable.ic_down_arrow);

                holder.layout.toggle();

                holder.arrowExpand.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.arrowExpand.setImageResource(R.drawable.ic_left_arrow);
                        holder.layout.toggle();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView status;
        TextView species;
        ImageView arrowExpand;

        ExpandableRelativeLayout layout;
        TextView gender;
        TextView placeOfBirth;
        TextView location;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageView);
            name = (TextView) itemView.findViewById(R.id.nameView);
            status = (TextView) itemView.findViewById(R.id.statusView);
            species = (TextView) itemView.findViewById(R.id.speciesView);
            arrowExpand = (ImageView) itemView.findViewById(R.id.arrow);

            layout = (ExpandableRelativeLayout) itemView.findViewById(R.id.expandableLayout1);
            gender = (TextView) itemView.findViewById(R.id.gender_extend);
            placeOfBirth = (TextView) itemView.findViewById(R.id.place_of_birth_extend);
            location = (TextView) itemView.findViewById(R.id.location_extend);

        }
    }

}
