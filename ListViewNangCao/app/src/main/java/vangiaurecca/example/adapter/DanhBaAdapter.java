package vangiaurecca.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import vangiaurecca.example.listviewnangcao.R;
import vangiaurecca.example.model.DanhBa;

public class DanhBaAdapter extends ArrayAdapter<DanhBa> {
    //màn hình sử dụng layout này
    Activity context;
    //làm theo khách hàng(làm cho từng dòng muốn hiển thị)
    int resource;
    //danh sách nguồn dữ liệu muốn hiển thị lên giao diện
    List<DanhBa> objects;
    public DanhBaAdapter(@NonNull Activity context, int resource, @NonNull List<DanhBa> objects) {
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
        TextView txtTen = row.<TextView>findViewById(R.id.txtTen);
        TextView txtPhone = row.<TextView>findViewById(R.id.txtPhone);
        ImageButton btnCall = row.<ImageButton>findViewById(R.id.btnCall);
        ImageButton btnSMS = row.<ImageButton>findViewById(R.id.btnSMS);
        ImageButton btnDetail = row.<ImageButton>findViewById(R.id.btnDetail);
        final DanhBa danhBa = this.objects.get(position);
        txtTen.setText(danhBa.getTen());
        txtPhone.setText(danhBa.getPhone());
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXemChiTiet(danhBa);
                        
            }
        });
        return row;


    }

    private void xuLyXemChiTiet(DanhBa danhBa) {
        Toast.makeText(this.context, "Bạn chọn: " + danhBa.getTen(), Toast.LENGTH_SHORT).show();
    }
}
