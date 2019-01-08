package decloudius.app.fridgeup.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import decloudius.app.fridgeup.R;
import decloudius.app.fridgeup.holder.FridgeHolder;
import decloudius.app.fridgeup.model.FridgeModel;

/**
 * Created by Umair on 1/5/2019.
 */


public class FridgeAdapter extends RecyclerView.Adapter<FridgeHolder> {

    private List<FridgeModel> fridges = new ArrayList<>();
    public FridgeAdapter(List<FridgeModel> fridges){
        this.fridges = fridges;
    }

    @Override
    public FridgeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fridge, parent, false);
        final FridgeHolder fridgeHolder = new FridgeHolder(itemView);

        return fridgeHolder;
    }

    @Override
    public void onBindViewHolder(FridgeHolder holder, int position) {
        final FridgeModel fridge = fridges.get(position);
        //holder.img_fridge.;
        holder.nama_fridge.setText(fridge.getNama_fridge());
        holder.waktu_fridge.setText(fridge.getTime_added_fridge());
        holder.jumlah_fridge.setText(fridge.getJumlah_fridge());
    }

    @Override
    public int getItemCount() {
        return fridges.size();
    }
}
