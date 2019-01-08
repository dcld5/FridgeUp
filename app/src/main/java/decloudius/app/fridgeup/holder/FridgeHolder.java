package decloudius.app.fridgeup.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import decloudius.app.fridgeup.R;

/**
 * Created by Umair on 1/5/2019.
 */


public class FridgeHolder extends RecyclerView.ViewHolder {
    public ImageView img_fridge;
    public TextView nama_fridge;
    public TextView waktu_fridge;
    public TextView jumlah_fridge;

    public FridgeHolder(View itemView){
        super (itemView);
        img_fridge = (ImageView) itemView.findViewById(R.id.img_fridge);
        nama_fridge = (TextView) itemView.findViewById(R.id.txt_namafridge);
        waktu_fridge = (TextView) itemView.findViewById(R.id.txt_time_fridge);
        jumlah_fridge = (TextView) itemView.findViewById(R.id.txt_jumlah_fridge);
    }
}
