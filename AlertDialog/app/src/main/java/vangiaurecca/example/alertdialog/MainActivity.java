package vangiaurecca.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    ArrayAdapter arrayAdapter;
    ArrayList<String> dsMonHoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonHoc = findViewById(R.id.lvMonHoc);
        dsMonHoc = new ArrayList<>();

        AddArrayMonHoc();

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dsMonHoc);
        lvMonHoc.setAdapter(arrayAdapter);
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);
                return false;
            }
        });
    }

    private void XacNhanXoa(int vitri){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo !");
        alertDialog.setIcon(R.mipmap.ic_launcher_round);
        alertDialog.setMessage("Bạn có chắc chắn muốn xóa hay không ?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dsMonHoc.remove(vitri);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
    private void AddArrayMonHoc()
    {
        dsMonHoc.add("Android");
        dsMonHoc.add("PHP");
        dsMonHoc.add("Web");
        dsMonHoc.add("React Native");
        dsMonHoc.add("IOS");
    }
}