package vangiaurecca.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtClick = findViewById(R.id.txtClick);

        txtClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogLogin();
            }
        });
    }

    private void dialogLogin() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);

        //ánh xạ
        EditText edtUsername = dialog.findViewById(R.id.txtUsername);
        EditText edtPassword = dialog.findViewById(R.id.txtPassword);

        Button btnLogin = dialog.findViewById(R.id.btnLogin);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);


        //bắt sự kiên Button Đăng nhập
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtUsername.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();
                if(id.equals("vangiaurecca") && pass.equals("2001")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //bắt sự kiên Button Hủy
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                //dialog.dismiss();
            }
        });
    }
}