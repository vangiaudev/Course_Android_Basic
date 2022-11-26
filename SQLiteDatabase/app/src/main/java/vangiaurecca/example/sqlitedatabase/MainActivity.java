package vangiaurecca.example.sqlitedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView lvCongViec;

    ArrayList<CongViec> arrCongViec;
    CongViecAdapter congViecAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongViec = findViewById(R.id.lvCongViec);
        arrCongViec = new ArrayList<>();

        congViecAdapter = new CongViecAdapter(this, R.layout.dong_cong_viec, arrCongViec);
        lvCongViec.setAdapter(congViecAdapter);

        //tạo database
        database = new Database(this, "ghichu.sqlite", null, 1);

        //tạo bảng công việc
        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(200))");

        //insert database
        //database.QueryData("INSERT INTO CongViec VALUES(null, 'Code Android')");

        getDataCongViec();

    }

    public void DialogXoaCV(String tenCV, int id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Ban co chac chan muon xoa "+tenCV+" khong?");
        dialogXoa.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.QueryData("DELETE FROM CongViec WHERE Id = '"+id+"'");
                Toast.makeText(MainActivity.this, "Da Xoa " + tenCV, Toast.LENGTH_SHORT).show();
                getDataCongViec();
            }
        });
        dialogXoa.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }

    public void DialogSuaCV(String ten, int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_edit);

        EditText txtSuaCV = dialog.findViewById(R.id.txtSuaTen);

        Button btnXacNhan = dialog.findViewById(R.id.btnXacNhan);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);

        txtSuaCV.setText(ten);

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenMoi = txtSuaCV.getText().toString().trim();
                database.QueryData("UPDATE CongViec SET TenCV = '"+tenMoi+"' WHERE Id = '"+id+"' ");
                Toast.makeText(MainActivity.this, "Da cap nhat", Toast.LENGTH_SHORT).show();
                dialog.cancel();
                getDataCongViec();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    private void getDataCongViec() {
        //select data
        Cursor dataCongViec  = database.GetData("Select * from CongViec");
        arrCongViec.clear();
        while (dataCongViec.moveToNext()){
            String ten = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            arrCongViec.add(new CongViec(id, ten));

        }
        congViecAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_cong_viec, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuAdd){
            DialogADD();
        }

        return super.onOptionsItemSelected(item);
    }
    private void DialogADD(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_cong_viec);

        TextView edtTen = dialog.findViewById(R.id.edtTenCV);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenCV = edtTen.getText().toString();
                if(tenCV.equals("")){
                    Toast.makeText(MainActivity.this, "Vui long nhap ten cong viec", Toast.LENGTH_SHORT).show();
                }
                else{
                    database.QueryData("INSERT INTO CongViec VALUES(null, '"+ tenCV +"')");
                    Toast.makeText(MainActivity.this, "Da Them", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getDataCongViec();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}