package vangiaurecca.example.hocgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import vangiaurecca.example.adapter.HinhAdapter;

public class MainActivity extends AppCompatActivity {
    GridView gvHinh;
    ArrayList<Integer> dsHinh;
    HinhAdapter adapter;

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
        gvHinh = findViewById(R.id.gvHinh);
        dsHinh = new ArrayList<>();
        dsHinh.add(R.drawable.mci);
        dsHinh.add(R.drawable.bar);
        dsHinh.add(R.drawable.atl);
        dsHinh.add(R.drawable.bvb);
        dsHinh.add(R.drawable.imi);
        dsHinh.add(R.drawable.juv);
        dsHinh.add(R.drawable.laz);
        dsHinh.add(R.drawable.mun);
        dsHinh.add(R.drawable.nap);
        dsHinh.add(R.drawable.psg);
        dsHinh.add(R.drawable.rom);
        dsHinh.add(R.drawable.zip);
        adapter = new HinhAdapter(
                MainActivity.this,
                R.layout.item,
                dsHinh
        );
        gvHinh.setAdapter(adapter);
    }
}