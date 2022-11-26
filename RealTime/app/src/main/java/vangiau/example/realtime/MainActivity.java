package vangiau.example.realtime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mData;
    TextView txtKhoaHoc, txtCourse;
    Button btnAndroid;
    Button btnIOS;

    Button btnListViewScreen, btnForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKhoaHoc = findViewById(R.id.txtKhoaHoc);
        txtCourse = findViewById(R.id.txtCourse);
        btnAndroid = findViewById(R.id.btnAndroid);
        btnIOS = findViewById(R.id.btnIOS);
        btnListViewScreen = findViewById(R.id.btnListViewScreen);
        btnForm = findViewById(R.id.btnForm);

        btnListViewScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });
        mData = FirebaseDatabase.getInstance().getReference();


        mData.child("KhoaHoc").setValue("Lập trình Android");

        mData.child("KhoaHoc").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                txtKhoaHoc.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.child("KhoaHoc").setValue("Học Android");
            }
        });

        btnIOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.child("KhoaHoc").setValue("Học IOS");
            }
        });

        //Nhận dữ liệu từ Firebase - sử dụng AddChild với Push String
        mData.child("Test").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //cơ chế chạy tương tự vòng lập for
                txtCourse.append(snapshot.getValue().toString() +"\n");
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //Nhận dữ liệu từ Firebase -  sử dụng AddChild với Push Object OOP
        //SinhVien obama = new SinhVien("Nguyễn Văn Giàu", "Hệ Thống Thông Tin", 61);
        //mData.child("Sinh Vien").push().setValue(obama);




    }
}