package co.com.luisprmat.training.rickandmortyapp.episodes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.BaseActivity;
import co.com.luisprmat.training.rickandmortyapp.R;

public class EpisodesActivity extends BaseActivity {
    private List<Episode> episodes;
    private EpisodeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);

        RecyclerView rvEpisodes = findViewById(R.id.rvEpisodes);
        rvEpisodes.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvEpisodes.setLayoutManager(linearLayoutManager);

        adapter = new EpisodeAdapter(this, episodes);
        rvEpisodes.setAdapter(adapter);

        loadEpisodes();
    }

    private void loadEpisodes() {

    }
}
