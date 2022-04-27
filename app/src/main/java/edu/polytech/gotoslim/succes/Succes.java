package edu.polytech.gotoslim.succes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
import edu.polytech.gotoslim.R;

public class Succes extends AppCompatActivity {

    Button buttonAll;
    Button buttonUnlocked;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_succes);

        buttonAll=findViewById(R.id.AllSuccess);
        buttonUnlocked=findViewById(R.id.UnlockedSucces);
        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(Succes.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> {
            startActivity(new Intent(Succes.this, MainActivity.class));
            finish();
        });

        buttonAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new AllSuccessFragment());
            }
        });

        buttonUnlocked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new UnlockedSuccessFragment());
            }
        });
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}