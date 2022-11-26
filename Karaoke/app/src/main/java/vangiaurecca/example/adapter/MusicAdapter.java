package vangiaurecca.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import vangiaurecca.example.karaoke.R;
import vangiaurecca.example.model.Music;

public class MusicAdapter extends ArrayAdapter<Music> {
    Activity context;
    int resource;
    List<Music> objects;
    public MusicAdapter(@NonNull Activity context, int resource, @NonNull List<Music> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);
        TextView txtMa = row.findViewById(R.id.txtMa);
        TextView txtTen = row.findViewById(R.id.txtTen);
        TextView txtCaSi = row.findViewById(R.id.txtCaSi);
        ImageButton btnLike = row.findViewById(R.id.btnLike);
        ImageButton btnDislike = row.findViewById(R.id.btnDislike);

        Music music = this.objects.get(position);
        txtTen.setText(music.getTen());
        txtMa.setText(music.getMa());
        txtCaSi.setText(music.getCaSi());
        if(music.isThich())
        {
            btnLike.setVisibility(View.INVISIBLE);
            btnDislike.setVisibility(View.VISIBLE);
        }
        else {
            btnLike.setVisibility(View.VISIBLE);
            btnDislike.setVisibility(View.INVISIBLE);
        }
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThich(music);
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyKhongThich(music);
            }
        });
        return row;
    }

    private void xuLyKhongThich(Music music) {
        music.setThich(false);
    }

    private void xuLyThich(Music music) {
        music.setThich(true);
    }
}
