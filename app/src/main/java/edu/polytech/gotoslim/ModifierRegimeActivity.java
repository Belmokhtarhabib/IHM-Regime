package edu.polytech.gotoslim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import edu.polytech.gotoslim.ajoutplat.AjoutPlat;

public class ModifierRegimeActivity extends AppCompatActivity {

    EditText name;
    EditText description;
    EditText date;
    Button addEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.modifierregime);

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(ModifierRegimeActivity.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> startActivity(new Intent(ModifierRegimeActivity.this, MainActivity.class)));

        name=findViewById(R.id.EvenementName);
        description=findViewById(R.id.EvenementDescription);
        addEvent=findViewById(R.id.addEvent);
        date=findViewById(R.id.EvenementDate);


        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date currentTime = Calendar.getInstance().getTime();
                System.out.println("la date "+currentTime.toString());
                    if(!name.getText().toString().isEmpty() && !description.getText().toString().isEmpty() && !date.getText().toString().isEmpty() ){
                        System.out.println("la date a string"+date.getText().toString());
                        Intent intent=new Intent(Intent.ACTION_INSERT);
                        intent.setData(CalendarContract.Events.CONTENT_URI);
                        intent.putExtra(CalendarContract.Events.TITLE,name.getText().toString());
                        intent.putExtra(CalendarContract.Events.DESCRIPTION,description.getText().toString());
                        //intent.putExtra(CalendarContract.Events.,"1713625537000");
                        System.out.println("oulalala "+CalendarContract.EXTRA_EVENT_BEGIN_TIME);
                        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,"1713625537000");
                        intent.putExtra(CalendarContract.Events.ALL_DAY,"true");
                        intent.putExtra(Intent.EXTRA_EMAIL,"test@gmail.com");

                        if(intent.resolveActivity(getPackageManager()) !=null){
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(ModifierRegimeActivity.this,"Pas d'application suportant cet action",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(ModifierRegimeActivity.this,"remplir tout les champs",Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}