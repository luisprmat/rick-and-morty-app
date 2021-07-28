package co.com.luisprmat.training.rickandmortyapp.episodes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.R;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {
    Context context;
    List<Episode> episodes;

    public EpisodeAdapter(Context context, List<Episode> episodes) {
        this.context = context;
        this.episodes = episodes;
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_episode, parent, false);
        return new EpisodeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        Episode episode = episodes.get(position);

        String sName = context.getString(R.string.text_name, episode.getName());
        holder.tvName.setText(sName);

        String sAirDate = context.getString(R.string.text_air_date, episode.getAirDate());
        holder.tvAirDate.setText(sAirDate);

        String sEpisode = context.getString(R.string.text_episode, episode.getEpisode());
        holder.tvEpisode.setText(sEpisode);
    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }
}
