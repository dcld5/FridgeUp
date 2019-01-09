package decloudius.app.fridgeup.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import decloudius.app.fridgeup.model.FreezerModel;

/**
 * Created by Umair on 1/8/2019.
 */

@Database(entities = {FreezerModel.class}, version = 1, exportSchema = false)
public abstract class FreezerDatabase extends RoomDatabase{
    public abstract FreezerDao freezerDao();
}
