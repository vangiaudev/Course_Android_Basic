package vangiaurecca.example.mediaappmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtTitle, txtStartTime, txtEndTime;
    SeekBar skSong;
    ImageButton btnPre, btnPlay, btnStop, btnSkip;
    ImageView imgDisc;
    ArrayList<Song> arrSong;
    int position = 0;
    MediaPlayer mediaPlayer;

    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        animation = AnimationUtils.loadAnimation(this, R.anim.disc_rotate);

        addControls();
        addSong();
        addEvent();
        initMediaPlayer();
        setTimeTotal();
        updateTimeSong();

    }

    private void updateTimeSong() {
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                txtStartTime.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()));
                //cập nhật progress skSong
                skSong.setProgress(mediaPlayer.getCurrentPosition());

                //kiểm tra thời gian kết thúc bài hát -> next
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        btnSkip.callOnClick();
                    }
                });

                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    private void setTimeTotal() {
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        txtEndTime.setText(dinhDangGio.format(mediaPlayer.getDuration()));

        //gán max của skSong = mediaPlayer.getDuration()
        skSong.setMax(mediaPlayer.getDuration());


    }

    private void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(MainActivity.this, arrSong.get(position).getFile());
        txtTitle.setText(arrSong.get(position).getTitle());
    }

    private void addEvent() {
        initMediaPlayer();

        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress());
            }
        });

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position--;
                if(position < 0){
                    position = arrSong.size() - 1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                initMediaPlayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.ic_pause);
                setTimeTotal();
                updateTimeSong();
                imgDisc.startAnimation(animation);
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position++;
                if(position > arrSong.size() - 1){
                    position = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                initMediaPlayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.ic_pause);
                setTimeTotal();
                updateTimeSong();
                imgDisc.startAnimation(animation);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlay.setImageResource(R.drawable.ic_play);
                initMediaPlayer();
                imgDisc.clearAnimation();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    //nếu đang phát thì -> pause -> đổi hình play
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.ic_play);
                    imgDisc.clearAnimation();
                }
                else{
                    //đang ngừng -> phát -> đổi hình pause
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.ic_pause);
                    imgDisc.startAnimation(animation);
                }
                setTimeTotal();
                updateTimeSong();

            }
        });
    }

    private void addSong() {
        arrSong = new ArrayList<>();
        arrSong.add(new Song("Uống Cạn Chén Tình", R.raw.uong_can_chen_tinh));
        arrSong.add(new Song("Chỉ Muốn Bên Em Lúc Này", R.raw.chi_muon_ben_em_luc_nay));
        arrSong.add(new Song("Níu Duyên Remix", R.raw.niu_duyen_remix));
        arrSong.add(new Song("Em Muốn Là Nữ Hoàng", R.raw.em_muon_la_nu_hoang));
        arrSong.add(new Song("Tết Đã Về Rồi", R.raw.tet_da_ve_roi));

    }

    private void addControls() {
        txtTitle     = findViewById(R.id.txtTitle);
        txtStartTime = findViewById(R.id.txtStartTime);
        txtEndTime   = findViewById(R.id.txtEndTime);
        skSong       = findViewById(R.id.skSong);
        btnPlay      = findViewById(R.id.btnPlay);
        btnPre       = findViewById(R.id.btnPre);
        btnSkip      = findViewById(R.id.btnSkip);
        btnStop      = findViewById(R.id.btnStop);
        imgDisc      = findViewById(R.id.imgDisc);
    }
}