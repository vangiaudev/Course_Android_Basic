package vangiaurecca.example.jsonarrayobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvKhoaHoc;
    ArrayList<String> arrCourse;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvKhoaHoc = findViewById(R.id.lvKhoaHoc);
        arrCourse = new ArrayList<>();

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrCourse);
        lvKhoaHoc.setAdapter(arrayAdapter);
        new ReadJSON().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json");
    }

    private class ReadJSON extends AsyncTask<String, Void, String>{
        StringBuilder stringBuilder = new StringBuilder();
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStreamReader   inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONArray array = new JSONArray(s);

                for(int i = 0; i<array.length(); i++){
                    JSONObject object = array.getJSONObject(i);
                    String khoahoc = object.getString("khoahoc");
                    String hocphi = object.getString("hocphi");
                    arrCourse.add(khoahoc + "-" + hocphi);
                    //Toast.makeText(MainActivity.this, khoahoc + "\n" + hocphi, Toast.LENGTH_SHORT).show();

                }
                arrayAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}