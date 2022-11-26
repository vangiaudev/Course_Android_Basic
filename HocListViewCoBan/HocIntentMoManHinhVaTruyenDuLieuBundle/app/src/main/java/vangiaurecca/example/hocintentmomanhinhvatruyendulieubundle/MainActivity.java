package vangiaurecca.example.hocintentmomanhinhvatruyendulieubundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import vangiaurecca.example.model.SanPham;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyMoVaGuiDuLieuBundle(View view) {
        Intent intent = new Intent(MainActivity.this, ManHinh2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("X", 113);
        bundle.putDouble("D", 11.4);
        SanPham coca = new SanPham(1, "Coca co la la la", 16.000);
        bundle.putSerializable("SANPHAM", coca);

        intent.putExtra("BUNDLE_CUA_TUI", bundle);
        startActivity(intent);
    }
}