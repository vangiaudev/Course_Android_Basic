package vangiaurecca.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnXuLy;
    TextView txtThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtThongTin = findViewById(R.id.txtThongTin);
        btnXuLy = findViewById(R.id.btnXuLy);

    }

    private class CongViec extends AsyncTask<Void, String, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtThongTin.setText("Bắt đầu" + "\n");
            btnXuLy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new CongViec().execute();
                }
            });
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(int i = 1; i<5; i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("Xong viêc " + i + "\n");
            }
            return "Xong roi \n" ;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtThongTin.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtThongTin.append(values[0]);
        }
    }
}