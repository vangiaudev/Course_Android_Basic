package vangiaurecca.example.hocintentmomanhinhvatruyendulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import vangiaurecca.example.model.SinhVien;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyVaGuiDuLieu(View view) {
        Intent intent = new Intent(MainActivity.this, ManHinh2Activity.class);
        //Đối số 1: tên biến
        intent.putExtra("KIEU_BOOLEAN", true);
        intent.putExtra("KIEU_CHAR", 'x');
        intent.putExtra("KIEU_INT", 100);
        intent.putExtra("KIEU_DOUBLE", 9.99);
        intent.putExtra("KIEU_CHUOI", "Kevin De Bruyne");

        SinhVien teo = new SinhVien(1, "Nguyễn Văn Tèo");
        intent.putExtra("SINHVIEN", teo);
        startActivity(intent);
    }
}