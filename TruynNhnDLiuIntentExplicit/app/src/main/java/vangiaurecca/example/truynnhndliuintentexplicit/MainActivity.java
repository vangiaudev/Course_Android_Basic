package vangiaurecca.example.truynnhndliuintentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Screen2Activity.class);
//                String[] arrCourse = {"Android", "iOS", "PHP", "JAVA"};
//                SinhVien sv = new SinhVien("Ho Van Do", 2017);
//                intent.putExtra("dulieu", sv);
                SinhVien sv = new SinhVien("Nguyễn Văn Tèo", 1991);
                String[] arrName = {"Hồ Chí Minh", "Tiền Giang", "Long An"};

                Bundle bundle = new Bundle();
                bundle.putString("chuoi", "Van Giau Recca");
                bundle.putInt("conso", 2001);
                bundle.putStringArray("mangTen", arrName);
                bundle.putSerializable("doiTuong", sv);

                intent.putExtra("dulieu", bundle);
                startActivity(intent);
            }
        });
    }
}