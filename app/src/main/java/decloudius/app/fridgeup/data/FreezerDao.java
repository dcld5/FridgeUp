package decloudius.app.fridgeup.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import decloudius.app.fridgeup.model.FreezerModel;

/**
 * Created by Umair on 1/8/2019.
 */

@Dao
public interface FreezerDao {

    @Insert
    void insert(FreezerModel freezerModel);

    @Query("Select * from freezer")
    List<FreezerModel> getFreezerModel();

    @Update
    void update(FreezerModel freezerModel);

    @Delete
    void delete(FreezerModel freezerModel);


}
