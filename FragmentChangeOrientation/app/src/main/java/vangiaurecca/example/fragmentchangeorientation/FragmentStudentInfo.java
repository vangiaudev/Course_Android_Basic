package vangiaurecca.example.fragmentchangeorientation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FragmentStudentInfo extends Fragment {
    TextView txtName, txtBirth, txtAddress, txtEmail;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_student_info, container, false);

        AnhXa();
        return view;
    }

    public void SetInfo(SinhVien sv){
        txtName.setText(sv.getHoTen());
        txtBirth.setText("Năm sinh: " + sv.getNamSinh());
        txtAddress.setText("Địa chỉ: " + sv.getDiaChi());
        txtEmail.setText("Email: " + sv.getEmail());

    }
    private void AnhXa(){
        txtName = view.findViewById(R.id.txtName);
        txtAddress = view.findViewById(R.id.txtAddress);
        txtBirth = view.findViewById(R.id.txtBirth);
        txtEmail = view.findViewById(R.id.txtEmail);

    }
}
