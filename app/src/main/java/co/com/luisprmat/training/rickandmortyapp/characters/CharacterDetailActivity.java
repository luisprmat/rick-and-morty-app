package co.com.luisprmat.training.rickandmortyapp.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import co.com.luisprmat.training.rickandmortyapp.BaseActivity;
import co.com.luisprmat.training.rickandmortyapp.R;
import co.com.luisprmat.training.rickandmortyapp.commons.Constants;

public class CharacterDetailActivity extends BaseActivity {
    String name, gender, status, species, avatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        loadExtras();
        loadViews();
    }

    private void loadExtras() {
        name = getIntent().getStringExtra(Constants.EXTRA_NAME);
        gender = getIntent().getStringExtra(Constants.EXTRA_GENDER);
        status = getIntent().getStringExtra(Constants.EXTRA_STATUS);
        species = getIntent().getStringExtra(Constants.EXTRA_SPECIES);
        avatar = getIntent().getStringExtra(Constants.EXTRA_AVATAR);
    }

    public void loadViews() {
        loadAvatarImage();

        TextView tvName = findViewById(R.id.tvName);
        tvName.setText(name);

        TextView tvSpecies = findViewById(R.id.tvSpecies);
        tvSpecies.setText(species);

        Button btSave = findViewById(R.id.btSave);
        btSave.setOnClickListener(v -> addToFavs());

        ImageView ivGender = findViewById(R.id.ivGender);
        if (gender.toLowerCase().equals("Male"))
            ivGender.setImageResource(R.drawable.ic_male);
        else
            ivGender.setImageResource(R.drawable.ic_female);

        ImageView ivStatus = findViewById(R.id.ivStatus);
        if (status.toLowerCase().equals("dead"))
            ivStatus.setVisibility(View.VISIBLE);
        else
            ivStatus.setVisibility(View.GONE);

        getSupportActionBar().setTitle("Personaje: " + name);
    }

    private void addToFavs() {

    }

    private void loadAvatarImage() {
        ImageView ivAvatar = findViewById(R.id.ivAvatar);

        Glide.with(this)
                .load(avatar)
                .into(ivAvatar);
    }
}
