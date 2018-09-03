package com.andrewxa.rickandmorty.view.fragments.episodes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewxa.rickandmorty.R;
import com.andrewxa.rickandmorty.datasource.model.episodes.Result;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.ViewHolder> {

    private List<Result> resultsEpisodes;
    Context context;

    EpisodesAdapter(List<Result> resultEpisodes,Context context) {
        this.resultsEpisodes = resultEpisodes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.episodes_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result result = resultsEpisodes.get(position);
        String name = result.getName();
        String number = result.getEpisode();
        String date = result.getAirDate();


        holder.episodeName.setText(name);
        holder.episodeNumber.setText(number);
        holder.episodeDate.setText(date);
    }


    @Override
    public int getItemCount() {
        return resultsEpisodes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView episodeName;
        TextView episodeNumber;
        TextView episodeDate;

        public ViewHolder(View itemView) {
            super(itemView);

            episodeName = (TextView) itemView.findViewById(R.id.episodeNameView);
            episodeNumber = (TextView) itemView.findViewById(R.id.episodeNumberView);
            episodeDate = (TextView) itemView.findViewById(R.id.episodeDataView);

        }
    }

}
