package vangiaurecca.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDangNhap;
    EditText txtTaiKhoan, txtMatKhau;
    CheckBox cbLuuThongTin;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sharedPreferences = getSharedPreferences("DuLieuDangNhap", MODE_PRIVATE);

        //lấy giá trị sharePreferences
        txtTaiKhoan.setText(sharedPreferences.getString("user", ""));
        txtMatKhau.setText(sharedPreferences.getString("pass", ""));
        cbLuuThongTin.setChecked(sharedPreferences.getBoolean("checked", false));


        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taiKhoan = txtTaiKhoan.getText().toString().trim();
                String matKhau = txtMatKhau.getText().toString().trim();

                if(taiKhoan.equals("vangiaurecca") && matKhau.equals("2001")){
                    Toast.makeText(MainActivity.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                    //NẾU CÓ CHECK
                    if(cbLuuThongTin.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("user", taiKhoan);
                        editor.putString("pass", matKhau);
                        editor.putBoolean("checked", true);
                        editor.apply();
                    }
                    else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("user");
                        editor.remove("pass");
                        editor.remove("checked");
                        editor.apply();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void AnhXa() {
        btnDangNhap = findViewById(R.id.btnDangNhap);
        txtMatKhau = findViewById(R.id.txtMatKhau);
        txtTaiKhoan = findViewById(R.id.txtTaiKhoan);
        cbLuuThongTin = findViewById(R.id.cbLuuMatKhau);

    }
}