package vangiaurecca.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cbAndroid, cbIOS;
    Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbIOS = findViewById(R.id.cbIOS);
        btnOK = findViewById(R.id.btnXacNhan);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monHoc = "";
                if(cbAndroid.isChecked()){
                    monHoc += cbAndroid.getText();
                }
                if(cbIOS.isChecked()){
                    monHoc += cbIOS.getText();
                }
                Toast.makeText(MainActivity.this, monHoc, Toast.LENGTH_SHORT).show();
            }
        });



        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "You choise APK", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "You remove APK", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}