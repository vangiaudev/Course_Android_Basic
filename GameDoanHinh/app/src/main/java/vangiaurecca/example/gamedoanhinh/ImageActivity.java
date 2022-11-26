package vangiaurecca.example.gamedoanhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class ImageActivity extends Activity {
    TableLayout myTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        myTable = findViewById(R.id.tablelayoutImage);

        int soDong = 4;
        int soCot = 2;

        //trộn mảng
        Collections.shuffle(MainActivity.arrName);
        //tạo dòng - cột
        for(int i = 1; i<= soDong; i++){
            TableRow tableRow = new TableRow(this);

            //tạo ImageView
            for(int j = 1; j<= soCot; j++){
                ImageView imageView = new ImageView(this);

                Resources r = getResources();
                int px = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        100,
                        r.getDisplayMetrics()
                );

                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px);
                imageView.setLayoutParams(layoutParams);

                int pos = soCot * (i - 1) + j - 1;

                int idHinh = getResources().getIdentifier(MainActivity.arrName.get(pos), "drawable", getPackageName());
                imageView.setImageResource(idHinh);

                //add ImageView vào Table Row
                tableRow.addView(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhchon", MainActivity.arrName.get(pos));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
            //add Table Row vào table
            myTable.addView(tableRow);
        }
    }
}