package vangiaurecca.example.fragmentremove;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddA(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentA(), "fragA");
        fragmentTransaction.addToBackStack("aaa");
        fragmentTransaction.commit();
    }
    public void AddB(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentB(), "fragB");
        fragmentTransaction.addToBackStack("bbb");
        fragmentTransaction.commit();
    }
    public void AddC(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentC(), "fragC");
        fragmentTransaction.addToBackStack("ccc");
        fragmentTransaction.commit();
    }
    public void RemoveA(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentByTag("fragA");

        if(fragmentA != null){
            fragmentTransaction.remove(fragmentA);
            fragmentTransaction.commit();
        }
        else{
            Toast.makeText(this, "Fragment A không tồn tại", Toast.LENGTH_SHORT).show();
        }

    }
    public void RemoveB(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentByTag("fragB");

        if(fragmentB != null){
            fragmentTransaction.remove(fragmentB);
            fragmentTransaction.commit();
        }
        else{
            Toast.makeText(this, "Fragment B không tồn tại", Toast.LENGTH_SHORT).show();
        }

    }
    public void RemoveC(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentC fragmentC = (FragmentC) getFragmentManager().findFragmentByTag("fragC");

        if(fragmentC != null){
            fragmentTransaction.remove(fragmentC);
            fragmentTransaction.commit();
        }
        else{
            Toast.makeText(this, "Fragment C không tồn tại", Toast.LENGTH_SHORT).show();
        }

    }

    public void Back(View view){
        getFragmentManager().popBackStack();
    }
    public void Pop(View view){
        getFragmentManager().popBackStack("aaa", 0);
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 1){
            getFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }
    }
}