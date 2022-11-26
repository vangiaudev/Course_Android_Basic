package vangiaurecca.example.swtich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch swWifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swWifi = findViewById(R.id.switch1);
        swWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "You turn on WIFI", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "You turn off WIFI", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}