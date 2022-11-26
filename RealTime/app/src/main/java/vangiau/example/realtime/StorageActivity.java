package vangiau.example.realtime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class StorageActivity extends AppCompatActivity {
    Button btnSaveImage;
    ImageView imgHinh;
    EditText edtTenHinh;
    ListView lvHinhAnh;
    ArrayList<HinhAnh> arrHinhAnh;
    HinhAnhAdapter hinhAnhAdapter;

    int REQUEST_CODE_IMAGE = 1;
    DatabaseReference mData;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        mData = FirebaseDatabase.getInstance().getReference();

        StorageReference storageReference = storage.getReferenceFromUrl("gs://real-time-e5b5c.appspot.com");

        btnSaveImage = findViewById(R.id.btnSaveImage);
        imgHinh = findViewById(R.id.imgHinh);
        edtTenHinh = findViewById(R.id.edtTenHinh);
        lvHinhAnh = findViewById(R.id.lvHinh);
        arrHinhAnh = new ArrayList<HinhAnh>();
        hinhAnhAdapter = new HinhAnhAdapter(this, R.layout.dong_hinh_anh, arrHinhAnh);
        lvHinhAnh.setAdapter(hinhAnhAdapter);
        LoadData();


        imgHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_IMAGE);
            }
        });

        btnSaveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance(); //đặt tên hình theo thời gian hệ thống để ko bị trùng
                StorageReference mountainsRef = storageReference.child("image" + calendar.getTimeInMillis() + ".png");

                // Get the data from an ImageView as bytes
                imgHinh.setDrawingCacheEnabled(true);
                imgHinh.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) imgHinh.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(getApplicationContext(), "Lỗi Up Ảnh", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        //lấy link hình ảnh vừa upload
                        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                            @Override
                            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                if (!task.isSuccessful()) {
                                    throw task.getException();
                                }

                                // Continue with the task to get the download URL
                                return mountainsRef.getDownloadUrl();
                            }
                        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                if (task.isSuccessful()) {
                                    Uri downloadUri = task.getResult(); //link hình
                                    Log.d("BBB", downloadUri + "");
                                    Toast.makeText(getApplicationContext(), "Lưu hình thành công", Toast.LENGTH_SHORT).show();
                                    HinhAnh hinhAnh = new HinhAnh(edtTenHinh.getText().toString(), String.valueOf(downloadUri));
                                    mData.child("HinhAnh").push().setValue(hinhAnh, new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if(error == null){
                                                Toast.makeText(getApplicationContext(), "Lưu database thành công", Toast.LENGTH_SHORT).show();
                                            }
                                            else {
                                                Toast.makeText(getApplicationContext(), "Lỗi lưu database", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                } else {
                                    // Handle failures
                                    // ...
                                }
                            }
                        });

                    }
                });
            }
        });
    }

    private void LoadData(){
        mData.child("HinhAnh").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                HinhAnh hinhAnh = snapshot.getValue(HinhAnh.class);
                arrHinhAnh.add(new HinhAnh(hinhAnh.tenHinh, hinhAnh.linkHinh));
                hinhAnhAdapter.notifyDataSetChanged();
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //tải hình chụp đc lên ImageView
        if(requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgHinh.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}