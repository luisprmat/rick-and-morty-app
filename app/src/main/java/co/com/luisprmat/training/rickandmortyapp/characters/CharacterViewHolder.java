package co.com.luisprmat.training.rickandmortyapp.characters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import co.com.luisprmat.training.rickandmortyapp.R;

public class CharacterViewHolder extends RecyclerView.ViewHolder {
    ImageView ivAvatar;
    LinearLayout llCharacterContainer;
    TextView tvName, tvStatus, tvSpecies, tvGender, tvOrigin;

    public CharacterViewHolder(@NonNull View v) {
        super(v);

        ivAvatar = v.findViewById(R.id.ivAvatar);
        llCharacterContainer = v.findViewById(R.id.llCharacterContainer);
        tvName = v.findViewById(R.id.tvName);
        tvStatus = v.findViewById(R.id.tvStatus);
        tvSpecies = v.findViewById(R.id.tvSpecies);
        tvGender = v.findViewById(R.id.tvGender);
        tvOrigin = v.findViewById(R.id.tvOrigin);
    }
}
