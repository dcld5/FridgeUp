package decloudius.app.fridgeup.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.media.Image;

import java.io.Serializable;

/**
 * Created by Umair on 1/5/2019.
 */

@Entity(tableName = "freezer")
public class FreezerModel implements Serializable{

    @PrimaryKey(autoGenerate = true)
    private int id;

    //private Image img_freezer;
    private String nama_freezer;
    private String time_added_freezer;
    private String jumlah_freezer;

    public FreezerModel(String nama_freezer, String time_added_freezer, String jumlah_freezer){
        //this.img_freezer = img_freezer;
        this.nama_freezer = nama_freezer;
        this.time_added_freezer = time_added_freezer;
        this.jumlah_freezer = jumlah_freezer;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setNama_freezer(String nama_freezer) {
        this.nama_freezer = nama_freezer;
    }

    public void setJumlah_freezer(String jumlah_freezer) {
        this.jumlah_freezer = jumlah_freezer;
    }

    public int getId() {
        return id;
    }

//    public Image getImg_freezer() {
//        return img_freezer;
//    }

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
