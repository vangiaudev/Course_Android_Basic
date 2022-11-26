package vangiaurecca.example.intenttruyenvanhandulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    Button btnSave;
    EditText txtInputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        btnSave = findViewById(R.id.btnSave);
        txtInputName = findViewById(R.id.txtInputName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noiDungMoi = txtInputName.getText().toString();
                Intent intent = new Intent();

                intent.putExtra("dulieu", noiDungMoi);
                setResult(RESULT_OK, intent);

                //đóng màn hình hiện tại
                finish();
            }
        });
    }
}