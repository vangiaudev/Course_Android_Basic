package vangiaurecca.example.listfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FragmentDanhSach extends ListFragment {

    String[] arrayCity = {"Hồ Chí Minh", "Mỹ Tho", "Cần Thơ"};
    ArrayAdapter arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayCity);
        setListAdapter(arrayAdapter);

        return inflater.inflate(R.layout.fragment_danh_sach, container, false);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), arrayCity[position], Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);
    }
}
