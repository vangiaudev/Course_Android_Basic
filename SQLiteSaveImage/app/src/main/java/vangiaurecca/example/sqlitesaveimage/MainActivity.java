package vangiaurecca.example.sqlitesaveimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnThem;
    ListView lvDoVat;
    ArrayList<DoVat> arrDoVat;
    DoVatAdapter adapter;
    public static Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThem = findViewById(R.id.btnThem);
        lvDoVat = findViewById(R.id.lvDoVat);

        arrDoVat = new ArrayList<>();
        adapter = new DoVatAdapter(this, R.layout.dong_do_vat, arrDoVat);
        lvDoVat.setAdapter(adapter);

        database = new Database(this, "QuanLy.sqlite", null, 1);

        database.QueryData("CREATE TABLE IF NOT EXISTS DoVat(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(150), MoTa VARCHAR(200), HinhAnh BLOB)");


        //getdata
        Cursor cursor =  database.getData("SELECT * FROM DoVat");
        while (cursor.moveToNext()){
            arrDoVat.add(new DoVat(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getBlob(3)));

        }
        adapter.notifyDataSetChanged();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ThemDoVatActivity.class));

            }
        });
    }
}