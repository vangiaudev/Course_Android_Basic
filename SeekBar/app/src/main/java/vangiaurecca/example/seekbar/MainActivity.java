package vangiaurecca.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar skSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skSound = findViewById(R.id.seekBar);
        skSound.getProgress(); //lấy giá trị hiện tại
        skSound.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //i: giá trị của thanh Seekbar
                Log.d("AAA", "Giá trị: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("AAA", "Stop");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}