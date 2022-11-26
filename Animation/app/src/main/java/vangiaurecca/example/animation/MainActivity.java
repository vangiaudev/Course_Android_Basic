package vangiaurecca.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgAlpha;
    ImageView imgRotate;
    ImageView imgScale;
    ImageView imgTranslate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgAlpha = findViewById(R.id.imgAlpha);
        imgRotate = findViewById(R.id.imgRotate);
        imgScale = findViewById(R.id.imgScale);
        imgTranslate = findViewById(R.id.imgTranslate);

        Animation animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);

        imgTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animTranslate);
            }
        });
        imgScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animScale);
            }
        });
        imgRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animRotate);
            }
        });
        imgAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha);
            }
        });
    }
}