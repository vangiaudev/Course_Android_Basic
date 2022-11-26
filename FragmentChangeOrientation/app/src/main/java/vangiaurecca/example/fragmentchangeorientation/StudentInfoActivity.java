package vangiaurecca.example.fragmentchangeorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        Intent intent = getIntent();
        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("thongtinsv");

        FragmentStudentInfo studentInfo = (FragmentStudentInfo) getFragmentManager().findFragmentById(R.id.fmDetail);
        Configuration configuration = getResources().getConfiguration();
        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }
        else{
            studentInfo.SetInfo(sinhVien);
        }
    }
}