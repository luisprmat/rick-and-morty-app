package co.com.luisprmat.training.rickandmortyapp.episodes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import co.com.luisprmat.training.rickandmortyapp.R;

public class EpisodeViewHolder extends RecyclerView.ViewHolder {
    TextView tvName, tvAirDate, tvEpisode;

    public EpisodeViewHolder(@NonNull View v) {
        super(v);

        tvName = v.findViewById(R.id.tvName);
        tvAirDate = v.findViewById(R.id.tvAirDate);
        tvEpisode = v.findViewById(R.id.tvEpisode);
    }
}
