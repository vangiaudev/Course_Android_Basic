package vangiaurecca.example.webservicedatabase;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {

    private MainActivity context;
    private int layout;

    private List<SinhVien> sinhVienList;

    public SinhVienAdapter(MainActivity context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
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
        TextView txtHoTen, txtNamSinh, txtDiaChi;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null );
            holder.txtHoTen   = view.findViewById(R.id.txtHoTenCustom);
            holder.txtDiaChi  = view.findViewById(R.id.txtDiaChiCustom);
            holder.txtNamSinh = view.findViewById(R.id.txtNamSinhCustom);
            holder.imgDelete  = view.findViewById(R.id.imgDelete);
            holder.imgEdit    = view.findViewById(R.id.imgEdit);
            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();
        }

        SinhVien sinhVien = sinhVienList.get(i);

        holder.txtHoTen.setText(sinhVien.getHoTen());
        holder.txtNamSinh.setText("N??m sinh: "+sinhVien.getNamSinh());
        holder.txtDiaChi.setText(sinhVien.getDiaChi());

        //b???t sk x??a, s???a
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateSinhVienActivity.class);
                intent.putExtra("dataSinhVien", sinhVien);
                context.startActivity(intent);

            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XacNhanXoa(sinhVien.getHoTen(), sinhVien.getId());
            }
        });
        return view;
    }

    private void XacNhanXoa(String ten, final int id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context);
        dialogXoa.setMessage("B???n c?? mu???n x??a sinh vi??n " + ten + " kh??ng?");
        dialogXoa.setPositiveButton("C??", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.DeleteStudent(id);
            }
        });
        dialogXoa.setNegativeButton("Kh??ng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }
}
