package decloudius.app.fridgeup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import decloudius.app.fridgeup.adapter.ContainerAdapter;
import decloudius.app.fridgeup.adapter.FridgeAdapter;
import decloudius.app.fridgeup.fragment.FreezerFragment;
import decloudius.app.fridgeup.fragment.FridgeFragment;

/**
 * Created by Umair on 1/5/2019.
 */




public class MainActivity extends AppCompatActivity {

    private ViewPager vpMain;
    private Button btnFridge,btnFreezer;

    private ContainerAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting view

        vpMain = (ViewPager) findViewById(R.id.view_pager_main);
        btnFridge = (Button) findViewById(R.id.btn_fridge);
        btnFreezer = (Button) findViewById(R.id.btn_freezer);

        setContainerPrepared();
        onButtonClicked();
    }

    private void setContainerPrepared(){
        adapter = new ContainerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FreezerFragment(), getString(R.string.menu_freezer));
        adapter.addFragment(new FridgeFragment(), getString(R.string.menu_fridge));
        vpMain.setAdapter(adapter);
    }

    private void onButtonClicked(){
        btnFridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpMain.setCurrentItem(0);
            }
        });
        btnFreezer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpMain.setCurrentItem(1);
            }
        });
    }
}
