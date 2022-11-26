package vangiaurecca.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtTen;

    AutoCompleteTextView autoTinhThanh;
    String []arrTinhThanh;
    ArrayAdapter<String> adapterTinhThanh;

    Button btnXacNhan;
    TextView txtThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXacNhanThongTin();
            }
        });
    }

    private void xuLyXacNhanThongTin() {
        String s = txtTen.getText().toString() + "\n" +autoTinhThanh.getText().toString();
        txtThongTin.setText(s);
    }

    private void addControls() {
        txtTen = this.<EditText>findViewById(R.id.txtTen);
        btnXacNhan = this.<Button>findViewById(R.id.btnXacNhan);
        txtThongTin = this.<TextView>findViewById(R.id.txtThongTin);
        autoTinhThanh = this.<AutoCompleteTextView>findViewById(R.id.autoTinhThanh);
        arrTinhThanh = getResources().getStringArray(R.array.arrTinhThanh);
        adapterTinhThanh = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrTinhThanh
                );
        autoTinhThanh.setAdapter(adapterTinhThanh);
    }
}