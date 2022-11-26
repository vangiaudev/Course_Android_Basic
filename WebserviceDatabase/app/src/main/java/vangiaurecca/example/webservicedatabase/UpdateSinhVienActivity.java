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

public class UpdateSinhVienActivity extends AppCompatActivity {

    EditText edtHoTen, edtDiaChi, edtNamSinh;
    Button btnCapNhat, btnHuy;

    int id = 0;
    String urlUpdate = "http://192.168.1.13:8080/androidwebservice/update.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sinh_vien);

        Intent intent = getIntent();
        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("dataSinhVien");
        Toast.makeText(UpdateSinhVienActivity.this, sinhVien.getHoTen(), Toast.LENGTH_SHORT).show();

        AnhXa();

        id = sinhVien.getId();
        edtHoTen.setText(sinhVien.getHoTen());
        edtNamSinh.setText(sinhVien.getNamSinh() + "");
        edtDiaChi.setText(sinhVien.getDiaChi());
//
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ht = edtHoTen.getText().toString().trim();
                String ns = edtNamSinh.getText().toString().trim();
                String dc = edtDiaChi.getText().toString().trim();

                if(ht.isEmpty() || ns.isEmpty() || dc.matches("")){
                    Toast.makeText(UpdateSinhVienActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    CapNhatSinhVien(urlUpdate);
                }
            }
        });
    }

    private void CapNhatSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.trim().equals("success")){
                    Toast.makeText(UpdateSinhVienActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateSinhVienActivity.this, MainActivity.class));
                }
                else{
                    Toast.makeText(UpdateSinhVienActivity.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(UpdateSinhVienActivity.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("idSV", String.valueOf(id));
                params.put("hotenSV", edtHoTen.getText().toString().trim());
                params.put("namsinhSV", edtNamSinh.getText().toString().trim());
                params.put("diachiSV", edtDiaChi.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void AnhXa() {
        btnCapNhat = this.<Button>findViewById(R.id.btnCapNhat);
        btnHuy = this.<Button>findViewById(R.id.btnHuy);
        edtDiaChi = this.<EditText>findViewById(R.id.edtDiaChiUpdate);
        edtHoTen = this.<EditText>findViewById(R.id.edtHoTenUpdate);
        edtNamSinh = this.<EditText>findViewById(R.id.edtNamSinhUpdate);
    }
}