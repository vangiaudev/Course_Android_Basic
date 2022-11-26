package vangiaurecca.example.fragmentchangeorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TruyenSinhVien {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void DataStudent(SinhVien sinhVien) {

        FragmentStudentInfo fragmentStudentInfo = (FragmentStudentInfo) getFragmentManager().findFragmentById(R.id.fmInfo);

        Configuration configuration = getResources().getConfiguration();

        if(fragmentStudentInfo != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){ //cách 2: có thể thêm điều kiện này vào if: && fragmentStudentInfo.isInLayout()
             fragmentStudentInfo.SetInfo(sinhVien);
        }
        else {
            Intent intent = new Intent(MainActivity.this, StudentInfoActivity.class);
            intent.putExtra("thongtinsv", sinhVien);
            startActivity(intent);
        }


    }
}