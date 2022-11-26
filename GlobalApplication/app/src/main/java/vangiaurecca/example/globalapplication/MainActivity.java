package vangiaurecca.example.globalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtThongTin;
    Button btnXacNhan;
    EditText txtTen, txtEmail, txtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = txtTen.getText().toString();
                String email = txtEmail.getText().toString();
                String phone = txtPhone.getText().toString();

                txtThongTin.setText( "Chào bạn: " + hoTen + "\nEmail: "+ email + "\nSố điện thoại: " + phone);
            }
        });
    }

    private void AnhXa() {
        txtThongTin = findViewById(R.id.txtThongTin);
        txtEmail    = findViewById(R.id.txtEmail);
        txtPhone    = findViewById(R.id.txtPhone);
        txtTen      = findViewById(R.id.txtTen);
        btnXacNhan  = findViewById(R.id.btnXacNhan);
    }
}