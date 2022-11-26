package vangiaurecca.example.fragmentchangeorientation;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentStudentList extends ListFragment {

    ArrayList<SinhVien> arraySinhVien;
    StudentAdapter adapter;

    TruyenSinhVien truyenSinhVien;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        truyenSinhVien = (TruyenSinhVien) getActivity();
        arraySinhVien = new ArrayList<>();
        AddArraySV();
        adapter = new StudentAdapter(getActivity(), R.layout.row_student, arraySinhVien);
        setListAdapter(adapter);

        return inflater.inflate(R.layout.fragment_student_list, container, false);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        truyenSinhVien.DataStudent(arraySinhVien.get(position));

    }

    private void AddArraySV(){
        arraySinhVien.add(new SinhVien("Hồ Văn Đồ", 1999, "Tiền Giang", "dohv@gmail.com"));
        arraySinhVien.add(new SinhVien("Hồ Văn Tý", 1992, "Kiên Giang", "tyhv@gmail.com"));
        arraySinhVien.add(new SinhVien("Hồ Văn Tèo", 1997, "Long An", "teohv@gmail.com"));
        arraySinhVien.add(new SinhVien("Hồ Văn Hồng", 1991, "Cà Mau", "honghv@gmail.com"));

    }
}
