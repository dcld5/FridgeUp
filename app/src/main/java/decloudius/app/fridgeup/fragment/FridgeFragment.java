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
import decloudius.app.fridgeup.adapter.FridgeAdapter;
import decloudius.app.fridgeup.model.FridgeModel;

/**
 * Created by Umair on 1/5/2019.
 */


public class FridgeFragment extends Fragment {

    private List<FridgeModel> fridges = new ArrayList<>();
    FloatingActionButton btnfridge;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fridge, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.lst_fridge);

        fridgeCollection();

        FridgeAdapter adapter = new FridgeAdapter(fridges);
        int numberOfColumns = 2;
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), numberOfColumns);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        onButtonFridge();
    }

    private void fridgeCollection(){

    }

    private void onButtonFridge(){
        btnfridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addFridge = new Intent(getContext(), DetailActivityFreezer.class);
                addFridge.putExtra(Const.KEY_ACTION_DETAIL, Const.INTENT_ADD);
                startActivity(addFridge);
            }
        });
    }
}
