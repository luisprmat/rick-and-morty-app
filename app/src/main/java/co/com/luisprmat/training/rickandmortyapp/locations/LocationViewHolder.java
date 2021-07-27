package co.com.luisprmat.training.rickandmortyapp.locations;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import co.com.luisprmat.training.rickandmortyapp.R;

public class LocationViewHolder extends RecyclerView.ViewHolder {
    TextView tvName, tvType, tvDimension;

    public LocationViewHolder(@NonNull View v) {
        super(v);

        tvName = v.findViewById(R.id.tvName);
        tvType = v.findViewById(R.id.tvType);
        tvDimension = v.findViewById(R.id.tvDimension);
    }
}
