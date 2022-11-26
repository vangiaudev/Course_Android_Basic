package vangiaurecca.example.webservicedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    ListView lvSinhVien;
    ArrayList<SinhVien> sinhVienArrayList;
    SinhVienAdapter sinhVienAdapter;
    String urlDelete = "http://192.168.1.13:8080/androidwebservice/delete.php";


    String urlGetdata = "http://192.168.1.13:8080/androidwebservice/getdata.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSinhVien = findViewById(R.id.lvSinhVien);
        sinhVienArrayList = new ArrayList<>();

        sinhVienAdapter = new SinhVienAdapter(this, R.layout.dong_sinh_vien, sinhVienArrayList);
        lvSinhVien.setAdapter(sinhVienAdapter);
        GetData(urlGetdata);

    }

    public void DeleteStudent(int idsv){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlDelete, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.trim().equals("success")){
                    Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    GetData(urlGetdata);
                }
                else {
                    Toast.makeText(MainActivity.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> pa = new HashMap<>();
                pa.put("idCuaSinhVien", String.valueOf(idsv));

                return pa;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                sinhVienArrayList.clear();
                for (int i = 0; i<response.length(); i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        sinhVienArrayList.add(new SinhVien(object.getInt("Id"), object.getString("HoTen"), object.getInt("NamSinh"), object.getString("DiaChi")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                sinhVienAdapter.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_student, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menuAddStudent){
            startActivity(new Intent(MainActivity.this, AddSinhVienActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}