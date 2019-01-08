package decloudius.app.fridgeup.model;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by Umair on 1/5/2019.
 */


public class FridgeModel implements Serializable {

    public Image img_fridge;
    public String nama_fridge;
    public String time_added_fridge;
    public String jumlah_fridge;

    public FridgeModel(Image img_fridge, String nama_fridge, String time_added_fridge, String jumlah_fridge){
        this.img_fridge = img_fridge;
        this.nama_fridge = nama_fridge;
        this.time_added_fridge = time_added_fridge;
        this.jumlah_fridge = jumlah_fridge;
    }

    public Image getImg_fridge() {
        return img_fridge;
    }

    public String getNama_fridge() {
        return nama_fridge;
    }

    public String getTime_added_fridge() {
        return time_added_fridge;
    }

    public String getJumlah_fridge() {
        return jumlah_fridge;
    }
}
