package vangiaurecca.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Screen2Activity extends Activity {
    Button btnSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        btnSecond = findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Screen2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Log.d("AAA", "onCreate Second");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "onStart Second");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "onRestart Second");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "onResume Second");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "onPause Second");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "onStop Second");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA", "onDestroy Second");
    }
}