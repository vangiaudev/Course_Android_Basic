package vangiaurecca.example.randomapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText txtMin, txtMax;
    Button btnRandom;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        try {
            btnRandom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    xuLyRandom();
                }
            });
        }
        catch (Exception ex){
            Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void xuLyRandom() {
        String str1 = txtMin.getText().toString().trim();
        String str2 = txtMax.getText().toString().trim();
        if(str1.length() == 0 || str2.length() == 0 ){
            Toast.makeText(MainActivity.this, "Vui lòng nhập đủ số !", Toast.LENGTH_SHORT).show();
        }
        else {
            //ép kiểu từ String -> Int
            int min = Integer.parseInt(str1);
            int max = Integer.parseInt(str2);

            if(min > max){
                Toast.makeText(MainActivity.this, "[Min] không vượt quá [Max] !", Toast.LENGTH_SHORT).show();
            }
            else {
                Random rd = new Random();
                int n = rd.nextInt(max - min + 1) + min;
                //Int -> String
                txtKetQua.setText(String.valueOf(n));
            }
        }
    }

    private void AnhXa() {
        txtMin = findViewById(R.id.txtMin);
        txtMax = findViewById(R.id.txtMax);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnRandom = findViewById(R.id.btnRandom);
    }


}