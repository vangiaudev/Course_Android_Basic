package vangiaurecca.example.jsonlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageButton btnVN, btnEN;
    TextView txtInfo;

    String noiDung = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ReadJSONLanguage().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");

        AnhXa();
        btnEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadJSONLanguage("en");
            }
        });

        btnVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadJSONLanguage("vn");
            }
        });
    }
    private void ReadJSONLanguage(String lang){
        try {
            JSONObject object = new JSONObject(noiDung);
            JSONObject language = object.getJSONObject("language");
            JSONObject vn = language.getJSONObject(lang);
            String ten = vn.getString("name");
            String diachi = vn.getString("address");
            String khoahoc1 = vn.getString("course1");
            String khoahoc2 = vn.getString("course2");
            String khoahoc3 = vn.getString("course3");

            txtInfo.setText(ten + "\n" + diachi + "\n" + khoahoc1 + "\n" + khoahoc2 + "\n" + khoahoc3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    
    private void AnhXa() {
        btnEN = findViewById(R.id.btnEN);
        btnVN = findViewById(R.id.btnVN);
        txtInfo = findViewById(R.id.txtInfo);
    }

    private class ReadJSONLanguage extends AsyncTask<String, Void, String>{
        StringBuilder content = new StringBuilder();
        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            try {
                url = new URL(strings[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            noiDung = s;
            ReadJSONLanguage("vn");
        }

    }
}