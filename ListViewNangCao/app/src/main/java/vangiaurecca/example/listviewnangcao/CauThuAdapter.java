package vangiaurecca.example.listviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CauThuAdapter  extends BaseAdapter {

    private Context context;
    private int layout;
    private List<CauThu> cauThuList;

    public CauThuAdapter(Context context, int layout, List<CauThu> cauThuList) {
        this.context = context;
        this.layout = layout;
        this.cauThuList = cauThuList;
    }

    @Override
    public int getCount() {
        //trả về số lượng dòng muốn hiển thị
        return cauThuList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMoTa;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            //ánh xạ view
            holder.txtTen = view.findViewById(R.id.txtTen);
            holder.txtMoTa = view.findViewById(R.id.txtMota);
            holder.imgHinh = view.findViewById(R.id.imgHinh);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }



        //gán giá trị
        CauThu cauThu = cauThuList.get(i);

        holder.txtTen.setText(cauThu.getTen());
        holder.txtMoTa.setText(cauThu.getMoTa());
        holder.imgHinh.setImageResource(cauThu.getHinh());

        //gán animation
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.scale_list);
        view.startAnimation(animation);

        return view;
    }
}
