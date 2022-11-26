package vangiaurecca.example.webservicedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddSinhVienActivity extends AppCompatActivity {

    EditText edtHoten, edtNamSinh, edtDiaChi;

    Button btnThem, btnHuy;
    String urlInsert = "http://192.168.1.13:8080/androidwebservice/insert.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);

        AnhXa();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ht = edtHoten.getText().toString().trim();
                String ns = edtNamSinh.getText().toString().trim();
                String dc = edtDiaChi.getText().toString().trim();
                if(ht.isEmpty() || ns.isEmpty() || dc.isEmpty()){
                    Toast.makeText(AddSinhVienActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    ThemSinhVien(urlInsert);
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void ThemSinhVien(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(AddSinhVienActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddSinhVienActivity.this, MainActivity.class));

                }
                else{
                    Toast.makeText(AddSinhVienActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddSinhVienActivity.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("hotenSV", edtHoten.getText().toString().trim());
                params.put("namsinhSV", edtNamSinh.getText().toString().trim());
                params.put("diachiSV", edtDiaChi.getText().toString().trim());


                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void AnhXa() {
        btnThem = findViewById(R.id.btnThem);
        btnHuy = findViewById(R.id.btnHuy);
        edtHoten = findViewById(R.id.edtHoTen);
        edtNamSinh = findViewById(R.id.edtNamSinh);
        edtDiaChi = findViewById(R.id.edtDiaChi);

    }
}