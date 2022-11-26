package vangiaurecca.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgThoiGian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgThoiGian = findViewById(R.id.rgThoiGian);

        rgThoiGian.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbSang:
                        Toast.makeText(MainActivity.this, "Bạn chọn sáng", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbTrua:
                        Toast.makeText(MainActivity.this, "Bạn chọn trưa", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbChieu:
                        Toast.makeText(MainActivity.this, "Bạn chọn chiều", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}