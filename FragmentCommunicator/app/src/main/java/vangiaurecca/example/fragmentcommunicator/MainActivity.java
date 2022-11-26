package vangiaurecca.example.fragmentcommunicator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMain;
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMain = findViewById(R.id.txtMain);
        btnMain = findViewById(R.id.btnMain);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentById(R.id.fragmentA);

                fragmentA.GanNoiDung("Văn Giàu");

            }
        });
    }
}