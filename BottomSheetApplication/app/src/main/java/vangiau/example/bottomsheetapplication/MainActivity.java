package vangiau.example.bottomsheetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.flipboard.bottomsheet.BottomSheetLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomSheetLayout bottomSheet = (BottomSheetLayout) findViewById(R.id.bottomsheet);
        bottomSheet.showWithSheetView(LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_main, bottomSheet, false));
        

    }
}