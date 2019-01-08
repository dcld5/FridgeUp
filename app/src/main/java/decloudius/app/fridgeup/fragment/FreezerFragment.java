package decloudius.app.fridgeup.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import decloudius.app.fridgeup.Const;
import decloudius.app.fridgeup.DetailActivityFreezer;
import decloudius.app.fridgeup.R;
import decloudius.app.fridgeup.adapter.FreezerAdapter;
import decloudius.app.fridgeup.model.FreezerModel;

/**
 * Created by Umair on 1/5/2019.
 */


public class FreezerFragment extends Fragment {

    private List<FreezerModel> freezers = new ArrayList<>();
    FloatingActionButton btnfreezer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_freezer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.lst_freezer);

        freezerCollection();

        FreezerAdapter adapter = new FreezerAdapter(freezers);
        int numberOfColumns = 2;
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), numberOfColumns);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        onButtonFreezer();
    }

    private void freezerCollection(){

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
