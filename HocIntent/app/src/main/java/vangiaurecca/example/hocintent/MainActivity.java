package vangiaurecca.example.hocintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyMo1ManHinh(View view) {
        //Đối số 1: màn hình hiện tại gọi cái Intent này (tên Activity.this)
        //Đối số 2: màn hình bạn muốn mở (tên Activity.class)
        //Đối số 3:
        Intent i = new Intent(
                MainActivity.this,
                ManHinh2.class
        );
        startActivity(i);
    }
}