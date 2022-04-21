package edu.polytech.gotoslim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Header extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(Header.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> startActivity(new Intent(Header.this,MainActivity.class)));
    }

}