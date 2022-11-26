package vangiaurecca.example.fragmentcommunicator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FragmentB extends Fragment {

    TextView txtB;
    EditText edtB;
    Button btnB;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_b, container, false);


        txtB = view.findViewById(R.id.txtFragB);
        btnB = view.findViewById(R.id.btnClickB);
        edtB = view.findViewById(R.id.edtFragB);


        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtA = getActivity().findViewById(R.id.txtFragA);
                txtA.setText(edtB.getText().toString());
                //Toast.makeText(getActivity(), edtB.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
