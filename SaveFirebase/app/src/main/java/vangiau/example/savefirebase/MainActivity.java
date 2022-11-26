package vangiau.example.savefirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        //trường hợp 1
        mDatabase.child("HoTen").setValue("Nguyễn Văn Giàu - CNTT");

        //trường hợp 2 (kiểu Object Class)
        SinhVien sv = new SinhVien("Hồ Văn Đồ", "Cà Mau", 1990);
        mDatabase.child("SinhVien").setValue(sv);

        //trường hợp 3 (Map)
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("XeMay", 2);
        mDatabase.child("PhuongTien").setValue(myMap);

        //trường hợp 4 - push là tạo thêm giá trị mới và ko ghi đè như TH2
        SinhVien hocVien = new SinhVien("Nguyễn Thị Hạnh Phúc", "Quận 12", 1999);
        mDatabase.child("HocVien").push().setValue(hocVien);

        //bắt sự kiện hoàn thành khi setValue
        mDatabase.child("Android").setValue("Java", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if(error == null){
                    Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Lưu thất bại: " + error, Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}