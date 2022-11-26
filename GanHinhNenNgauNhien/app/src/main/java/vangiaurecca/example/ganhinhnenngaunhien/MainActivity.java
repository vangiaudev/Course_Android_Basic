package vangiaurecca.example.ganhinhnenngaunhien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ArrayList<Integer> arrHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
    }

    private void AnhXa() {
        linearLayout = this.<LinearLayout>findViewById(R.id.linearLayout);
        arrHinh = new ArrayList<Integer>();
        arrHinh.add(R.drawable.image1);
        arrHinh.add(R.drawable.image2);
        arrHinh.add(R.drawable.image3);
        arrHinh.add(R.drawable.image4);

        Random rd = new Random();

        int vt = rd.nextInt(arrHinh.size());

        linearLayout.setBackgroundResource(arrHinh.get(vt));
    }
}