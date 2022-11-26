package vangiaurecca.example.hocintentmomanhinhvatruyendulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import vangiaurecca.example.model.SinhVien;

public class ManHinh2Activity extends AppCompatActivity {
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);
        addControls();
    }

    private void addControls() {
        txtKetQua = this.<TextView>findViewById(R.id.txtKetQua);
        Intent intent = getIntent();
        //đối số 1: tên biến bên màn hình main
        //đối số 2: kiểu dữ liệu mặc định, nếu tìm ko thấy thì trả về kiểu dữ liệu mặc định
        boolean kieuBoolean = intent.getBooleanExtra("KIEU_BOOLEAN", false);
        char kieuChar = intent.getCharExtra("KIEU_CHAR", 'a');
        int kieuInt = intent.getIntExtra("KIEU_INT", 0);
        double kieuDouble = intent.getDoubleExtra("KIEU_DOUBLE", 0.0);
        String kieuChuoi = intent.getStringExtra("KIEU_CHUOI");

        //Kiểu đối tượng ta cần getSerializeble
        SinhVien sv = (SinhVien) intent.getSerializableExtra("SINHVIEN");

        txtKetQua.setText("Kiểu boolean = " + kieuBoolean +
                "\n" + "Kiểu char = " + kieuChar +
                "\n" + "Kiểu int = " + kieuInt +
                "\n" + "Kiểu double = " + kieuDouble +
                "\n" + "Kiểu chuỗi = " + kieuChuoi +
                "\n" + "Kiểu hướng đối tượng = " + sv +
                "\n");
    }
}