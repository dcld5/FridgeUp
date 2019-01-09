package decloudius.app.fridgeup;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import decloudius.app.fridgeup.data.FreezerRepository;
import decloudius.app.fridgeup.model.FreezerModel;

/**
 * Created by Umair on 1/7/2019.
 */


public class DetailActivityFreezer extends AppCompatActivity{

    private EditText edtNama, edtJumlah;
    private Button btnConfirmFreezer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_freezer);

        edtNama = (EditText) findViewById(R.id.edit_namaitem_freezer);
        edtJumlah = (EditText) findViewById(R.id.edit_jumlahitem_freezer);
        btnConfirmFreezer = (Button) findViewById(R.id.btn_acc_freezer);

        FreezerModel model = (FreezerModel) getIntent().getSerializableExtra("data");

        if (model != null) {
            edtJumlah.setText(model.getJumlah_freezer());
            edtNama.setText(model.getNama_freezer());
        }

        String action = getIntent().getStringExtra(Const.KEY_ACTION_DETAIL);
        switch (action){
            case Const.INTENT_ADD:
                btnConfirmFreezer.setText("Tambah Barang");
                btnConfirmFreezer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String namaFreezer = edtNama.getText().toString();
                        String jumlahFreezer = edtJumlah.getText().toString();
                        String time = "test";
                        addNewFreezer(namaFreezer, jumlahFreezer, time);
                        if (!namaFreezer.isEmpty() && !jumlahFreezer.isEmpty()){
                            addNewFreezer(namaFreezer, jumlahFreezer, time);
                            finish();
                        } else {
                            Toast.makeText(DetailActivityFreezer.this,
                                    "Maaf nama dan jumlah tidak boleh kosong",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
            case Const.INTENT_EDIT:
                final FreezerModel freezerModel = (FreezerModel)getIntent().getSerializableExtra("freezer");
                edtNama.setText(freezerModel.getNama_freezer());
                edtJumlah.setText(freezerModel.getJumlah_freezer());

                btnConfirmFreezer.setText("Confirm Change");
                btnConfirmFreezer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        freezerModel.setNama_freezer(edtNama.getText().toString());
                        freezerModel.setJumlah_freezer(edtJumlah.getText().toString());
                        updateFreezer(freezerModel);
                        finish();

                    }
                });
                break;
        }

    }

    void addNewFreezer(final String namaFreezer, final String jumlahFreezer, final String time){
        final FreezerRepository repository = new FreezerRepository(this);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                FreezerModel freezerModel = new FreezerModel(namaFreezer, time, jumlahFreezer);
                repository.insertFreezer(freezerModel);
                return null;
            }
        }.execute();
    }

    private void updateFreezer(FreezerModel freezerModel) {

        String freezerID = String.valueOf(freezerModel.getId());
        String namaFreezer = freezerModel.getNama_freezer();
        String jumlahFreezer = freezerModel.getJumlah_freezer();
    }
}
