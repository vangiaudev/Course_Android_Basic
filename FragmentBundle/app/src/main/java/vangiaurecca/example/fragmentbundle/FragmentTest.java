package vangiaurecca.example.fragmentbundle;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FragmentTest  extends Fragment {

    TextView txtNoiDung;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        txtNoiDung = view.findViewById(R.id.txtTest);

        Bundle bundle = getArguments();
        if(bundle != null){
            txtNoiDung.setText(bundle.getString("hoten"));
        }

        return view;
    }
}
