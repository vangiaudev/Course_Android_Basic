package vangiaurecca.example.fragmentbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd =findViewById(R.id.btnAdd);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTest fragmentTest = new FragmentTest();

                Bundle bundle = new Bundle();

                bundle.putString("hoten", "Nguyễn Văn Tèo");

                fragmentTest.setArguments(bundle);
                fragmentTransaction.add(R.id.myLayout, fragmentTest);
                fragmentTransaction.commit();
            }
        });
    }
}