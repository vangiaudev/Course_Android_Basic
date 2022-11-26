package vangiaurecca.example.hoccheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox chkAndroid, chkFrontEnd, chkBackEnd, chkKHMT;
    Button btnChon;
    TextView txtLuaChon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvent();
    }

    private void addEvent() {
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyChonMonHoc();
            }
        });
    }

    private void xuLyChonMonHoc() {
        String s = "";
        if(chkAndroid.isChecked()){
            s += chkAndroid.getText().toString();
        }
        if(chkFrontEnd.isChecked()){
            s += "\n" + chkFrontEnd.getText().toString();
        }
        if(chkBackEnd.isChecked()){
            s += "\n" + chkBackEnd.getText().toString();
        }
        if(chkKHMT.isChecked()) {
            s += "\n" + chkKHMT.getText().toString();
        }
        txtLuaChon.setText(s);
    }

    private void addControls() {
        chkAndroid = this.<CheckBox>findViewById(R.id.chkAndroid);
        chkFrontEnd = this.<CheckBox>findViewById(R.id.chkFrontEnd);
        chkBackEnd = this.<CheckBox>findViewById(R.id.chkBackEnd);
        chkKHMT = this.<CheckBox>findViewById(R.id.chkKHMT);
        btnChon = this.<Button>findViewById(R.id.btnChon);
        txtLuaChon = this.<TextView>findViewById(R.id.txtLuaChon);
    }
}