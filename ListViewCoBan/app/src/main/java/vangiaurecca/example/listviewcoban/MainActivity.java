package vangiaurecca.example.listviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvCauThu;
    EditText txtTen;
    Button btnThem, btnSua;
    ArrayList<String> dsCauThu;

    int index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCauThu = findViewById(R.id.lvCauThu);
        txtTen = findViewById(R.id.txtTen);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);


        dsCauThu = new ArrayList<>();
        dsCauThu.add("Ederson Moraes");
        dsCauThu.add("Kyle Walker");
        dsCauThu.add("John Stones");
        dsCauThu.add("Ruben Dias");
        dsCauThu.add("Joao Cancelo");
        dsCauThu.add("Rodri");
        dsCauThu.add("Ilkay Gundogan");
        dsCauThu.add("Kevin De Bruyne");
        dsCauThu.add("Ferran Torres");
        dsCauThu.add("Gabriel Jesus");
        dsCauThu.add("Raheem Sterling");

        final ArrayAdapter arrayAdapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsCauThu
                );
        lvCauThu.setAdapter(arrayAdapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cauThu = txtTen.getText().toString();
                dsCauThu.add(cauThu);
                arrayAdapter.notifyDataSetChanged();
            }
        });



        lvCauThu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Click " + arrayAdapter.getItem(i), Toast.LENGTH_SHORT).show();
            }
        });

        lvCauThu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtTen.setText(dsCauThu.get(i));
                index = i;
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsCauThu.set(index, txtTen.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        lvCauThu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                dsCauThu.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });



    }
}