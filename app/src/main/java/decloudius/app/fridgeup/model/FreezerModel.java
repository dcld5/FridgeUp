package decloudius.app.fridgeup.model;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by Umair on 1/5/2019.
 */


public class FreezerModel implements Serializable{
    public Image img_freezer;
    public String nama_freezer;
    public String time_added_freezer;
    public String jumlah_freezer;

    public FreezerModel(Image img_freezer, String nama_freezer, String time_added_freezer, String jumlah_freezer){
        this.img_freezer = img_freezer;
        this.nama_freezer = nama_freezer;
        this.time_added_freezer = time_added_freezer;
        this.jumlah_freezer = jumlah_freezer;
    }

    public Image getImg_freezer() {
        return img_freezer;
    }

    public String getNama_freezer() {
        return nama_freezer;
    }

    public String getTime_added_freezer() {
        return time_added_freezer;
    }

    public String getJumlah_freezer() {
        return jumlah_freezer;
    }
}
