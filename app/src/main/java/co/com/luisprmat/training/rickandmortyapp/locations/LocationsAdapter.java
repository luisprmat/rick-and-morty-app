package co.com.luisprmat.training.rickandmortyapp.locations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.com.luisprmat.training.rickandmortyapp.R;

public class LocationsAdapter extends RecyclerView.Adapter<LocationViewHolder> {
    Context context;
    List<Location> locations;

    public LocationsAdapter(Context context, List<Location> locations) {
        this.context = context;
        this.locations = locations;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location, parent, false);
        return new LocationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        Location location = locations.get(position);

        String name = context.getString(R.string.text_name, location.getName());
        holder.tvName.setText(name);

        String type = context.getString(R.string.text_type, location.getType());
        holder.tvType.setText(type);

        String dimension = location.getDimension();

        if (dimension.equals("unknown")) {
            holder.tvDimension.setVisibility(View.GONE);
        } else {
            String textDimension = context.getString(R.string.text_dimension, dimension);
            holder.tvDimension.setText(textDimension);
        }
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }
}
