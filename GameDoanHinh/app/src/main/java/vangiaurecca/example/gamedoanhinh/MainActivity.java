package vangiaurecca.example.gamedoanhinh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> arrName;
    ImageView imgGoc, imgNhan;
    TextView txtDiem;
    int REQUEST_CODE_IMAGE = 123;
    String tenHinhGoc = "";

    int total = 100;
    SharedPreferences luuDiemSo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgGoc = findViewById(R.id.imgGoc);
        imgNhan = findViewById(R.id.imgNhan);
        txtDiem = findViewById(R.id.txtDiem);

        //khởi tạo
        luuDiemSo = getSharedPreferences("DiemSoGame", MODE_PRIVATE);
        //get điểm số
        total = luuDiemSo.getInt("diem", 100);

        txtDiem.setText(total + "");
        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrName = new ArrayList<>(Arrays.asList(mangTen));

        //trộn hình
        Collections.shuffle(arrName);
        tenHinhGoc = arrName.get(5);
        int idHinh = getResources().getIdentifier(arrName.get(5), "drawable", getPackageName());
        imgGoc.setImageResource(idHinh);

        imgNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, ImageActivity.class), REQUEST_CODE_IMAGE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null){
            String tenHinhNhan = data.getStringExtra("tenhinhchon");
            int idHinhNhan = getResources().getIdentifier(tenHinhNhan, "drawable", getPackageName());
            imgNhan.setImageResource(idHinhNhan);

            //so sánh theo tên hình
            if(tenHinhGoc.equals(tenHinhNhan)){
                Toast.makeText(this, "Chính xác, bạn được cộng 10 điểm", Toast.LENGTH_SHORT).show();
                //cộng điểm
                total += 10;
                LuuDiem();
                //đổi hình góc
                CountDownTimer countDownTimer = new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        Collections.shuffle(arrName);
                        tenHinhGoc = arrName.get(5);
                        int idHinh = getResources().getIdentifier(arrName.get(5), "drawable", getPackageName());
                        imgGoc.setImageResource(idHinh);
                    }
                }.start();
            }
            else{
                Toast.makeText(this, "Sai rồi, bạn bị trừ 5 điểm", Toast.LENGTH_SHORT).show();
                total -= 5;
                LuuDiem();
            }
            txtDiem.setText(total +"");
        }

        //kiểm tra màn hình thứ 2 không chọn hình
        if(requestCode == REQUEST_CODE_IMAGE && resultCode ==RESULT_CANCELED){
            Toast.makeText(this, "Bạn chưa chọn hình, muốn xem lại à ! Bạn đã bị trừ 15 điểm ^^", Toast.LENGTH_SHORT).show();
            total -= 15;
            LuuDiem();
            txtDiem.setText(total + "");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuReload){
            Collections.shuffle(arrName);
            tenHinhGoc = arrName.get(5);
            int idHinh = getResources().getIdentifier(arrName.get(5), "drawable", getPackageName());
            imgGoc.setImageResource(idHinh);
        }
        return super.onOptionsItemSelected(item);
    }

    private void LuuDiem(){
        SharedPreferences.Editor editor = luuDiemSo.edit();
        editor.putInt("diem", total);
        editor.apply();
    }
}