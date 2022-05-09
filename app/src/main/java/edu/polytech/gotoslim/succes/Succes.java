package edu.polytech.gotoslim.succes;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.R;

public class Succes extends AppCompatActivity {

    Button buttonAll;
    Button buttonUnlocked;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_succes);

        buttonAll=findViewById(R.id.AllSuccess);
        buttonUnlocked=findViewById(R.id.UnlockedSucces);

        Header.setHeader(getSupportFragmentManager());

        buttonAll.setOnClickListener(view -> replaceFragment(new AllSuccessFragment()));

        buttonUnlocked.setOnClickListener(view -> replaceFragment(new UnlockedSuccessFragment()));
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}