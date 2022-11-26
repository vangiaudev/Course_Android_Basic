package vangiau.example.testrss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {

    WebView wvTinTuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        wvTinTuc = findViewById(R.id.wvTinTuc);
        Intent intent = getIntent();

        String link = intent.getStringExtra("linkTinTuc");
        wvTinTuc.loadUrl(link);
        wvTinTuc.setWebViewClient(new WebViewClient());
    }
}