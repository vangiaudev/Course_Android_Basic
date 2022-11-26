package vangiaurecca.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDownload;
    ProgressBar pbXuLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDownload = findViewById(R.id.btnDownload);
        pbXuLy = findViewById(R.id.pbXuLy);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //10000: 10 giây -> tổng thời gian đếm ngược
                //1000: 1 giây -> thời gian lặp lại 1 hành động nào đó
                CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
                    @Override
                    public void onTick(long l) {
                        int current = pbXuLy.getProgress();
                        if(current >= pbXuLy.getMax()){
                            current = 0;
                        }
                        pbXuLy.setProgress(current+10);
                    }

                    @Override
                    public void onFinish() {
                        //chạy ko có điểm dừng thì gọi this.start()
                        this.start();
                        Toast.makeText(MainActivity.this, "Time Out", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();

            }
        });
    }
}