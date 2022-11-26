package vangiaurecca.example.hocquanlyketquatrave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManHinhXuLyActivity extends AppCompatActivity {
    TextView txtNhan;
    Button btnTinh;
    Intent intent;
    int a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_xu_ly);
        addControls();
        addEvent();
    }

    private void addEvent() {
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTinhUCLN();
            }
        });
    }

    private void xuLyTinhUCLN() {
        int min = Math.min(a, b);
        int ucln = 1;
        for(int i = min; i >= 1; i--){
            if(a%i == 0 && b%i == 0){
                ucln = i;
                break;
            }
        }
        //Bước 3: Thay đổi thông tin và gán vào cho intent
        //nên sử dụng lại intent và ko cần tạo mới
        intent.putExtra("UCLN", ucln);

        //Bước 4: đánh dấu kết qủa trả về

        setResult(33, intent);
        //Bước 5: phải đóng màn hình này lại để màn hình MainActivity trở thành Foreground Lifetime
        //vì nó chỉ tự động nhận được kết quả trả về ở trong Foreground Lifetime
        finish();
    }

    private void addControls() {
        txtNhan = this.<TextView>findViewById(R.id.txtNhan);
        btnTinh = this.<Button>findViewById(R.id.btnTinh);
        //Bước 2: lấy dữ liệu ra
        intent = getIntent();
        a = intent.getIntExtra("a", -1);
        b = intent.getIntExtra("b", -1);
        txtNhan.setText("a = " + a + "; b = " + b);

    }
}