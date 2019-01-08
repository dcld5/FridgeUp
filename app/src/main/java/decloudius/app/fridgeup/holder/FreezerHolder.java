package decloudius.app.fridgeup.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import decloudius.app.fridgeup.R;

/**
 * Created by Umair on 1/5/2019.
 */


public class FreezerHolder extends RecyclerView.ViewHolder{
    public ImageView img_freezer;
    public TextView nama_freezer;
    public TextView waktu_freezer;
    public TextView jumlah_freezer;

    public FreezerHolder(View itemView){
        super (itemView);
        img_freezer = (ImageView) itemView.findViewById(R.id.img_freezer);
        nama_freezer = (TextView) itemView.findViewById(R.id.txt_namafreezer);
        waktu_freezer = (TextView) itemView.findViewById(R.id.txt_time_freezer);
        jumlah_freezer = (TextView) itemView.findViewById(R.id.txt_jumlah_freezer);
    }
}
