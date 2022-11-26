package vangiaurecca.example.karaoke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

import vangiaurecca.example.adapter.MusicAdapter;
import vangiaurecca.example.model.Music;

public class MainActivity extends AppCompatActivity {
    ListView lvBaiHatGoc;
    ArrayList<Music> dsBaiHatGoc;
    MusicAdapter adapterBaiHatGoc;

    ListView lvBaiHatYeuThich;
    ArrayList<Music> dsBaiHatYeuThich;
    MusicAdapter adapterBaiHatYeuThich;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if(s.equalsIgnoreCase("t1"))
                {
                    xuLyHienThiBaiHatGoc();
                }
                else if(s.equalsIgnoreCase("t2"))
                {
                    xuLyBaiHatYeuThich();
                }
            }
        });
    }

    private void xuLyBaiHatYeuThich() {
        dsBaiHatYeuThich.clear(); //xóa dữ liệu cũ để cập nhật cái mới
        for(Music music : dsBaiHatGoc){
            if(music.isThich()){
                dsBaiHatYeuThich.add(music);
            }
        }
        adapterBaiHatYeuThich.notifyDataSetChanged();
    }

    private void xuLyHienThiBaiHatGoc() {
    }

    private void addControls() {
        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("", getResources().getDrawable(R.drawable.list_music));
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("", getResources().getDrawable(R.drawable.music_favourite));
        tabHost.addTab(tab2);

        lvBaiHatGoc = this.<ListView>findViewById(R.id.lvBaiHatGoc);
        dsBaiHatGoc = new ArrayList<>();
        adapterBaiHatGoc = new MusicAdapter(
                MainActivity.this,
                R.layout.item,
                dsBaiHatGoc
        );
        lvBaiHatGoc.setAdapter(adapterBaiHatGoc);

        lvBaiHatYeuThich = this.<ListView>findViewById(R.id.lvBaiHatYeuThich);
        dsBaiHatYeuThich = new ArrayList<>();
        adapterBaiHatYeuThich = new MusicAdapter(
                MainActivity.this,
                R.layout.item,
                dsBaiHatYeuThich
        );
        lvBaiHatYeuThich.setAdapter(adapterBaiHatYeuThich);

        giaLapBaiHat();

    }

    private void giaLapBaiHat() {
        dsBaiHatGoc.add(new Music("13749", "Kết Thúc Lưng Chừng", "Văn Võ Ngọc Nhân", true));
        dsBaiHatGoc.add(new Music("13345", "Chúng Ta Của Hiện Tại", "Sơn Tùng M-TP", false));
        dsBaiHatGoc.add(new Music("12334", "Lỡ Yêu", "DC Tâm", true));
        dsBaiHatGoc.add(new Music("19888", "Níu Duyên", "Lê Bảo Bình", true));
        adapterBaiHatGoc.notifyDataSetChanged();
    }
}