package decloudius.app.fridgeup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

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

        String action = getIntent().getStringExtra(Const.KEY_ACTION_DETAIL);

    }
}
