package vangiaurecca.example.hoclistviewcoban_dulieuthaydoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrTen;
    ArrayAdapter<String> adapterTen;
    ListView lvTen;
    EditText txtTen;
    Button btnLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();

    }

    private void addEvent() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLuu();
            }
        });
    }

    private void xuLyLuu() {
        String ten = txtTen.getText().toString();
        arrTen.add(ten); //thêm dữ liệu mới
        adapterTen.notifyDataSetChanged(); //ra lệnh cho listview cập nhật lại dữ liệu
        txtTen.setText("");
        txtTen.requestFocus(); //để con trỏ văn bản đúng ô nhập
    }

    private void addControls() {
        arrTen = new ArrayList<String>();
        adapterTen = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrTen
        );
        lvTen = this.<ListView>findViewById(R.id.lvTen);
        lvTen.setAdapter(adapterTen);
        txtTen = this.<EditText>findViewById(R.id.txtTen);
        btnLuu = this.<Button>findViewById(R.id.btnLuu);
    }
}