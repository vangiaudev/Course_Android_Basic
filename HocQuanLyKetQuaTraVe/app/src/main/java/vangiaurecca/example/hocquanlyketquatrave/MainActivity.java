package vangiaurecca.example.hocquanlyketquatrave;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtA, txtB;
    Button btnXuLy;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLayUCLN();
            }
        });
    }

    private void xuLyLayUCLN() {
        Intent intent = new Intent(MainActivity.this, ManHinhXuLyActivity.class);
        intent.putExtra("a", Integer.parseInt(txtA.getText().toString()));
        intent.putExtra("b", Integer.parseInt(txtB.getText().toString()));
        //Bước 1: bạn phải gọi startActivity for Result
        //requestCode là tự đặt nhưng ko đc trùng
        startActivityForResult(intent, 99);
    }


    //Bước 6: nhận kết quả trong onActivityResult
    //(Chỉ nhận trong vòng đời foreground liètime)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode==33)
        {
            int ucln =  data.getIntExtra("UCLN", 1);
            txtKetQua.setText("UCLN = " + ucln);
        }
    }

    private void addControls() {
        txtA = this.<EditText>findViewById(R.id.txtA);
        txtB = this.<EditText>findViewById(R.id.txtB);
        txtKetQua = this.<TextView>findViewById(R.id.txtKetQua);
        btnXuLy = this.<Button>findViewById(R.id.btnXuLy);
    }
}