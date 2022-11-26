package vangiaurecca.example.intentimplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgBrowser, imgMessage, imgCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBrowser = findViewById(R.id.imgBrowser);
        imgMessage = findViewById(R.id.imgMessage);
        imgCall = findViewById(R.id.imgCall);

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0385642964")); //"tel:" là cú pháp mặc đinh
                startActivity(intent);
            }
        });

        imgMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "Chào bạn..."); //sms_body là tên mặc đinh bắt buộc phải viết giống
                intent.setData(Uri.parse("sms:0385642964")); //"sms:" cũng là cú pháp mặc định

                startActivity(intent);
            }
        });
        imgBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(); //tại đây ta ko cần truyền vào màn hình main, vì khi mở sẽ ra ứng dụng khác
                intent.setAction(Intent.ACTION_VIEW); //mở trình duyệt
                intent.setData(Uri.parse("https://vangiaurecca.github.io/PersonalBlog/index.html"));
                startActivity(intent);
            }
        });
    }
}