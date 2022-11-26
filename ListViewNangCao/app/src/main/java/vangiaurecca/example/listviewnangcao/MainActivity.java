package vangiaurecca.example.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import vangiaurecca.example.adapter.DanhBaAdapter;
import vangiaurecca.example.model.DanhBa;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhBa;
    ArrayList<DanhBa>dsDanhBa;
    DanhBaAdapter danhBaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
    }

    private void addControls() {
        lvDanhBa = this.<ListView>findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        dsDanhBa.add(new DanhBa(1, "Nguyễn Văn Giàu", "0385642964"));
        dsDanhBa.add(new DanhBa(2, "Hồ Văn Đồ", "0776569413"));
        dsDanhBa.add(new DanhBa(3, "Lê Văn Đạt", "0909262839"));
        dsDanhBa.add(new DanhBa(4, "Trần Văn Tý", "0927363284"));
        danhBaAdapter = new DanhBaAdapter(
                MainActivity.this,
                R.layout.item,
                dsDanhBa
        );
        lvDanhBa.setAdapter(danhBaAdapter);
    }
}