package vangiau.example.realtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HinhAnhAdapter  extends BaseAdapter {

    Context context;
    int myLayout;
    List<HinhAnh> arrHinh;

    public HinhAnhAdapter(Context context, int myLayout, List<HinhAnh> arrHinh) {
        this.context = context;
        this.myLayout = myLayout;
        this.arrHinh = arrHinh;
    }

    @Override
    public int getCount() {
        return arrHinh.size();
    }

    @Override
    public Object getItem(int i) {
        return arrHinh.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        ImageView imgHinhLV;
        TextView txtHinhLV;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = view;
        ViewHolder holder = new ViewHolder();

        if(v == null){
            v = inflater.inflate(myLayout, null);
            holder.txtHinhLV = v.findViewById(R.id.txtHinhLV);
            holder.imgHinhLV = v.findViewById(R.id.imgHinhLV);
            v.setTag(holder);
        }
        else {
            holder = (ViewHolder) v.getTag();
        }

        //gán giá trị
        holder.txtHinhLV.setText(arrHinh.get(i).tenHinh);
        Picasso.with(context).load(arrHinh.get(i).linkHinh).into(holder.imgHinhLV);
        return v;
    }
}
