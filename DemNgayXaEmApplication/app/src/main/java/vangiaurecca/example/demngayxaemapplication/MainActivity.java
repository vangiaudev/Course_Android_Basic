package vangiaurecca.example.demngayxaemapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnTinh;
    EditText edtNgay1, edtNgay2;
    TextView txtKetQua;
    Calendar calendarOne, calendarTwo;
    SimpleDateFormat simpleDateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        edtNgay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay1();
            }
        });
        edtNgay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay2();
            }
        });
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ngayXaNhau = (int) ((calendarTwo.getTimeInMillis() - calendarOne.getTimeInMillis()) / (1000 * 60 * 60 * 24));
                txtKetQua.setText("Số ngày xa nhau là: " + ngayXaNhau);
            }
        });
    }

    private  void ChonNgay1(){
        calendarOne = Calendar.getInstance();
        int ngay = calendarOne.get(Calendar.DATE);
        int thang = calendarOne.get(Calendar.MONTH);
        int nam = calendarOne.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendarOne.set(i, i1, i2);
                edtNgay1.setText(simpleDateFormat.format(calendarOne.getTime()));
            }
        }, nam,thang,ngay);
        datePickerDialog.show();
    }
    private  void ChonNgay2(){
        calendarTwo = Calendar.getInstance();
        int ngay = calendarTwo.get(Calendar.DATE);
        int thang = calendarTwo.get(Calendar.MONTH);
        int nam = calendarTwo.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendarTwo.set(i, i1, i2);
                edtNgay2.setText(simpleDateFormat.format(calendarTwo.getTime()));
            }
        }, nam,thang,ngay);
        datePickerDialog.show();
    }
    private void AnhXa() {
        edtNgay1 = findViewById(R.id.txtDateOne);
        edtNgay2 = findViewById(R.id.txtDateTwo);
        btnTinh = findViewById(R.id.btnTinh);
        txtKetQua = findViewById(R.id.txtResult);
    }
}