package vangiaurecca.example.hocimagebuttonimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton radAuthor, radLogo;
    ImageView imgHienThi;
    ImageButton btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        radAuthor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    imgHienThi.setImageResource(R.drawable.vangiau);
                }
            }
        });
        radLogo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    imgHienThi.setImageResource(R.drawable.logodhsp);
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControls() {
        radLogo = this.<RadioButton>findViewById(R.id.radLogo);
        radAuthor = this.<RadioButton>findViewById(R.id.radAuthor);
        imgHienThi = this.<ImageView>findViewById(R.id.imgHienThi);
        btnThoat = findViewById(R.id.btnThoat);
    }
}