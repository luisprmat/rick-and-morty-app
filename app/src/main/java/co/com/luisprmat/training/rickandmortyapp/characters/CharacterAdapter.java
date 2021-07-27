package co.com.luisprmat.training.rickandmortyapp.characters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.R;
import co.com.luisprmat.training.rickandmortyapp.commons.Constants;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterViewHolder> {
    Context context;
    List<Character> characters;

    public CharacterAdapter(Context context, List<Character> characters) {
        this.context = context;
        this.characters = characters;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characters.get(position);

        holder.llCharacterContainer.setOnClickListener(v -> {
            Intent intent = new Intent(context, CharacterDetailActivity.class);
            intent.putExtra(Constants.EXTRA_NAME, character.getName());
            intent.putExtra(Constants.EXTRA_GENDER, character.getGender());
            intent.putExtra(Constants.EXTRA_STATUS, character.getStatus());
            intent.putExtra(Constants.EXTRA_SPECIES, character.getSpecies());
            intent.putExtra(Constants.EXTRA_AVATAR, character.getImage());
            context.startActivity(intent);
        });

        Glide.with(context)
                .load(character.getImage())
                .into(holder.ivAvatar);

        String name = context.getString(R.string.text_name, character.getName());
        String status = context.getString(R.string.text_status, character.getStatus());
        String species = context.getString(R.string.text_species, character.getSpecies());
        String gender = context.getString(R.string.text_gender, character.getGender());

        holder.tvName.setText(name);
        holder.tvStatus.setText(status);
        holder.tvSpecies.setText(species);
        holder.tvGender.setText(gender);

        if (character.getOrigin() != null) {
            String origin = context.getString(R.string.text_origin, character.getOrigin().getName());
            holder.tvOrigin.setText(origin);
        } else {
            holder.tvOrigin.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
