package decloudius.app.fridgeup.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import decloudius.app.fridgeup.model.FreezerModel;

/**
 * Created by Umair on 1/8/2019.
 */


public class FreezerRepository {

    private final static String DB_NAME = "datalokal";
    private FreezerDatabase freezerDatabase;

    public FreezerRepository(Context context){
        freezerDatabase = Room.databaseBuilder(
                context,
                FreezerDatabase.class,
                DB_NAME
        ).build();
    }

    public void insertFreezer(final FreezerModel freezerModel){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                freezerDatabase.freezerDao().insert(freezerModel);
                return null;
            }
        }.execute();
    }

    public List<FreezerModel> getFreezerModels(){
        return freezerDatabase.freezerDao().getFreezerModel();
    }

}
