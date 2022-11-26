package vangiaurecca.example.hockythuatxulysukien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    EditText txtSoA, txtSoB;
    Button btnAnomous;
    Button btnNhan, btnChia;
    Button btnAn;
    Button btnThoat;
    View.OnClickListener suKienChiaSe = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvent();
    }

    private void addEvent() {
        btnAnomous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyPhepTru();
            }
        });
        suKienChiaSe = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.btnNhan){
                    xuLyPhepNhan();
                }
                else if(view.getId() == R.id.btnChia){
                    xuLyPhepChia();
                }
            }
        };
        btnNhan.setOnClickListener(suKienChiaSe);
        btnChia.setOnClickListener(suKienChiaSe);
        btnAn.setOnLongClickListener(this);
        btnThoat.setOnClickListener(new MyEvent());
    }

    private void xuLyPhepChia() {
        int a = Integer.parseInt(txtSoA.getText().toString());
        int b = Integer.parseInt(txtSoB.getText().toString());
        int kq = a / b;
        Toast.makeText(MainActivity.this, "Kết quả " + a + " / " + b + " = " + kq, Toast.LENGTH_SHORT).show();
    }

    private void xuLyPhepNhan() {
        int a = Integer.parseInt(txtSoA.getText().toString());
        int b = Integer.parseInt(txtSoB.getText().toString());
        int kq = a * b;
        Toast.makeText(MainActivity.this, "Kết quả " + a + " * " + b + " = " + kq, Toast.LENGTH_SHORT).show();

    }

    private void xyLyPhepTru() {
        int a =  Integer.parseInt(txtSoA.getText().toString());
        int b =  Integer.parseInt(txtSoB.getText().toString());
        int c = a - b;
        Toast.makeText(MainActivity.this, "Trừ = " + c, Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        txtSoA= this.<EditText>findViewById(R.id.txtSoA);
        txtSoB= this.<EditText>findViewById(R.id.txtSoB);
        btnAnomous = this.<Button>findViewById(R.id.btnAnomous);
        btnNhan = this.<Button>findViewById(R.id.btnNhan);
        btnChia = this.<Button>findViewById(R.id.btnChia);
        btnAn = this.<Button>findViewById(R.id.btnAn);
        btnThoat = this.<Button>findViewById(R.id.btnThoat);
    }

    public void xuLyPhepCong(View v)
    {
        int a = Integer.parseInt((txtSoA.getText().toString()));
        int b = Integer.parseInt((txtSoB.getText().toString()));
        int c = a+b;
        Toast.makeText(MainActivity.this,"Tổng =" +c, Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId() == R.id.btnAn){
            btnAn.setVisibility(view.INVISIBLE);
        }
        return false;
    }
    public class MyEvent implements View.OnClickListener, View.OnLongClickListener
    {

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btnThoat)
                finish();
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
    public void xyLyDoiManHinhKhac(View v){
        Button btnMoi = new Button(MainActivity.this)
        {
            @Override
            public boolean performClick() {
                setContentView(R.layout.activity_main);

                addControls();
                addEvent();
                return super.performClick();
            }
        };
        btnMoi.setText("Quay Về");
        btnMoi.setWidth(50);
        btnMoi.setHeight(50);

        setContentView(btnMoi);

    }
}