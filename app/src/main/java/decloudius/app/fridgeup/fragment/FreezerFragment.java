package decloudius.app.fridgeup.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import decloudius.app.fridgeup.Const;
import decloudius.app.fridgeup.DetailActivityFreezer;
import decloudius.app.fridgeup.MainActivity;
import decloudius.app.fridgeup.R;
import decloudius.app.fridgeup.adapter.FreezerAdapter;
import decloudius.app.fridgeup.data.FreezerRepository;
import decloudius.app.fridgeup.model.FreezerModel;

/**
 * Created by Umair on 1/5/2019.
 */


public class FreezerFragment extends Fragment {

    private List<FreezerModel> freezers = new ArrayList<>();
    Button btnEdtFreezer;
    FloatingActionButton btnfreezer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_freezer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnEdtFreezer = (Button) view.findViewById(R.id.btn_edit_freezer);
        btnfreezer = (FloatingActionButton) view.findViewById(R.id.btn_to_add_Freezer);
        final RecyclerView recyclerView = view.findViewById(R.id.lst_freezer);

        int numberOfColumns = 2;
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), numberOfColumns);
        recyclerView.setLayoutManager(mLayoutManager);

        final FreezerRepository repository = new FreezerRepository(getContext());

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                FreezerAdapter adapter = new FreezerAdapter(repository.getFreezerModels());
                recyclerView.setAdapter(adapter);
                adapter.setListener(new FreezerAdapter.FreezerListener(){
                    @Override
                    public void onGrab(FreezerModel freezerModel) {
                        FreezerRepository freezerRepository = new FreezerRepository(getContext());
                        freezerRepository.insertFreezer(freezerModel);
                    }
                });
                return null;
            }
        }.execute();

        onButtonFreezer();


    }

    private void onButtonFreezer(){
        btnfreezer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addFreezer = new Intent(getContext(), DetailActivityFreezer.class);
                addFreezer.putExtra(Const.KEY_ACTION_DETAIL, Const.INTENT_ADD);
                startActivity(addFreezer);
            }
        });
    }

}
