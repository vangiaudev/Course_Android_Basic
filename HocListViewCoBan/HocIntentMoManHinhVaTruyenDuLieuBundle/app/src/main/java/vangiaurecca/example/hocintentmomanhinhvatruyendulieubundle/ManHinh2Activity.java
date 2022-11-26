package vangiaurecca.example.hocintentmomanhinhvatruyendulieubundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import vangiaurecca.example.model.SanPham;

public class ManHinh2Activity extends AppCompatActivity {
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);
        addControls();
    }

    private void addControls() {
        txtKetQua = this.<TextView>findViewById(R.id.txtKetQua);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BUNDLE_CUA_TUI");
        SanPham sp = (SanPham) bundle.getSerializable("SANPHAM");
        txtKetQua.setText("X = " + bundle.getInt("X") +
                "\n" + "C = " + bundle.getDouble("D") +
                "\n" + "SP = " + sp);
    }
}