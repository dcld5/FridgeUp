package decloudius.app.fridgeup.adapter;

import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import decloudius.app.fridgeup.R;
import decloudius.app.fridgeup.holder.FreezerHolder;
import decloudius.app.fridgeup.model.FreezerModel;

/**
 * Created by Umair on 1/5/2019.
 */


public class FreezerAdapter extends RecyclerView.Adapter<FreezerHolder> {

    private List<FreezerModel> freezers = new ArrayList<>();
    public FreezerAdapter(List<FreezerModel> freezers){
        this.freezers = freezers;
    }

    @Override
    public FreezerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_freezer, parent, false);
        final FreezerHolder freezerHolder = new FreezerHolder(itemView);

        return freezerHolder;
    }

    @Override
    public void onBindViewHolder(FreezerHolder holder, int position) {
        final FreezerModel freezer = freezers.get(position);
        //holder.img_freezer.;
        holder.nama_freezer.setText(freezer.getNama_freezer());
        holder.waktu_freezer.setText(freezer.getTime_added_freezer());
        holder.jumlah_freezer.setText(freezer.getJumlah_freezer());
    }

    @Override
    public int getItemCount() {
        return freezers.size();
    }
}
