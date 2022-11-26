package vangiaurecca.example.gridviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvHinhAnh;
    ArrayList<HinhAnh> hinhAnhArrayList;
    HinhAnhAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        arrayAdapter = new HinhAnhAdapter(this, R.layout.dong_hinh_anh, hinhAnhArrayList);
        gvHinhAnh.setAdapter(arrayAdapter);
        gvHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, hinhAnhArrayList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AnhXa() {
        gvHinhAnh = findViewById(R.id.gvHinhAnh);
        hinhAnhArrayList = new ArrayList<>();
        hinhAnhArrayList.add(new HinhAnh("Hình số 1", R.drawable.h1));
        hinhAnhArrayList.add(new HinhAnh("Hình số 2", R.drawable.h2));
        hinhAnhArrayList.add(new HinhAnh("Hình số 3", R.drawable.h3));
        hinhAnhArrayList.add(new HinhAnh("Hình số 4", R.drawable.h4));
        hinhAnhArrayList.add(new HinhAnh("Hình số 5", R.drawable.h5));
        hinhAnhArrayList.add(new HinhAnh("Hình số 6", R.drawable.h6));
        hinhAnhArrayList.add(new HinhAnh("Hình số 7", R.drawable.h7));
        hinhAnhArrayList.add(new HinhAnh("Hình số 8", R.drawable.h8));
        hinhAnhArrayList.add(new HinhAnh("Hình số 9", R.drawable.h9));

    }
}