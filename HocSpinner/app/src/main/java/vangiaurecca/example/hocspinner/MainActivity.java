package vangiaurecca.example.hocspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import vangiaurecca.example.model.NhanVien;

public class MainActivity extends AppCompatActivity {
    EditText txtTen, txtSoNgay;
    Button btnXacNhan;

    Spinner spThu;
    ArrayList<String> dsThu;
    ArrayAdapter<String> adapterThu;
    int lastedSelected = -1;
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
                xuLyXacNhanCongTac();
            }
        });
        spThu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Bạn chọn " + dsThu.get(i), Toast.LENGTH_SHORT).show();
                lastedSelected = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void xuLyXacNhanCongTac() {
        if(lastedSelected==-1){
            Toast.makeText(MainActivity.this, "Thím chưa chọn thứ mà xác nhận cái gì ?", Toast.LENGTH_SHORT).show();
            return;
        }
        NhanVien nv = new NhanVien();
        nv.setTen(txtTen.getText().toString());
        nv.setThuBatDauCongTac(dsThu.get(lastedSelected));
        nv.setSoNgayCongTacDuKien(Integer.parseInt(txtSoNgay.getText().toString()));

        Toast.makeText(MainActivity.this, nv.toString(), Toast.LENGTH_SHORT).show();
    }

    private void addControls() {
        txtTen = this.<EditText>findViewById(R.id.txtTen);
        txtSoNgay = this.<EditText>findViewById(R.id.txtSoNgay);
        btnXacNhan = this.<Button>findViewById(R.id.btnXacNhan);

        spThu = this.<Spinner>findViewById(R.id.spThu);
        dsThu = new ArrayList<>();
        dsThu.add("Thứ 2");
        dsThu.add("Thứ 3");
        dsThu.add("Thứ 4");
        dsThu.add("Thứ 5");
        dsThu.add("Thứ 6");
        dsThu.add("Thứ 7");
        dsThu.add("Chủ Nhật");

        adapterThu = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                dsThu);
        adapterThu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spThu.setAdapter(adapterThu);
    }

}