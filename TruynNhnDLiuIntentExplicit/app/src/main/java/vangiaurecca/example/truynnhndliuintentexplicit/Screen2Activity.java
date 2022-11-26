package vangiaurecca.example.truynnhndliuintentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Screen2Activity extends AppCompatActivity {
    TextView txtData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        txtData = findViewById(R.id.txtData);

        //nhận dữ liệu từ màn hình main
        Intent intent = getIntent();
//        String noiDung = intent.getStringExtra("dulieu");
//        String[] arrMonHoc = intent.getStringArrayExtra("dulieu");
//        int noiDung = intent.getIntExtra("dulieu", 2021);
//        SinhVien sv1 = (SinhVien) intent.getSerializableExtra("dulieu");

        Bundle bundle = intent.getBundleExtra("dulieu");
        if(bundle != null) {
            String ten = bundle.getString("chuoi");
            int so = bundle.getInt("conso", 123);
            String[] arr = bundle.getStringArray("mangTen");
            SinhVien sv1 = (SinhVien) bundle.getSerializable("doiTuong");
            txtData.setText(ten + so + arr[0] + sv1);
        }
    }
}