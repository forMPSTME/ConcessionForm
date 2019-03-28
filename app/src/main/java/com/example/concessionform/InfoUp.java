package com.example.concessionform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InfoUp extends AppCompatActivity {
    public FirebaseDatabase firebaseDatabase;
    public Button b;
    public RadioGroup rg1,rg2,rg3;
    public DatabaseReference db;
    public String id;
    public FirebaseUser user;
    public EditText e1,e2,e3,e4,e5,e6,e7,e8;
    public Spinner spinner,spinner2;
    public FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db= FirebaseDatabase.getInstance().getReference();
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        id=user.getUid();

        setContentView(R.layout.activity_info_up);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        spinner = (Spinner) findViewById(R.id.year);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,

                R.array.years_arr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2 = (Spinner) findViewById(R.id.stream);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,

                R.array.course_arr, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);

    }

    public void Upd()
    {
        b=(Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.surname);
        e3=(EditText)findViewById(R.id.address);
        e4=(EditText)findViewById(R.id.address1);
        e5=(EditText)findViewById(R.id.address2);
        e6=(EditText)findViewById(R.id.address3);
        e7=(EditText)findViewById(R.id.Bday);
        e8=(EditText)findViewById(R.id.station);
        rg1=(RadioGroup)findViewById((R.id.Gender));
        rg2=(RadioGroup)findViewById(R.id.Cla);
        rg3=(RadioGroup)findViewById(R.id.Duration);
        String name;
        String surname;
        String apart;
        String street;
        String local;
        String pin;
        final String[] sex = new String[1];
        String station;
        final String[] cla = new String[1];
        String year;
        String course;
        final String[] duration = new String[1];
        String Dob;
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.male)
                {
                    sex[0] ="Male";
                }
                else if(checkedId==R.id.female)
                {
                    sex[0] ="Female";
                }
                else
                {
                    Toast.makeText(InfoUp.this, "Please Enter All Information", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.firstcl)
                {
                    cla[0] ="First Class";
                }
                else if(checkedId==R.id.secondcl)
                {
                    cla[0] ="Second Class";
                }
                else
                {
                    Toast.makeText(InfoUp.this, "Please Enter All Information", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.quart)
                {
                    duration[0] ="Quarterly";
                }
                else if(checkedId==R.id.month)
                {
                    duration[0] ="Monthly";
                }
                else
                {
                    Toast.makeText(InfoUp.this, "Please Enter All Information", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        name=e1.getText().toString().trim();
        surname=e2.getText().toString().trim();
        apart=e3.getText().toString().trim();
        street=e4.getText().toString().trim();
        local=e5.getText().toString().trim();
        pin=e6.getText().toString().trim();
        Dob=e7.getText().toString().trim();
        station=e8.getText().toString().trim();

        year=spinner.getSelectedItem().toString().trim();
        course=spinner2.getSelectedItem().toString().trim();
        db=firebaseDatabase.getInstance().getReference();
        Database DB=new Database(id,name,surname,apart,street,local,pin,Dob,station,year,course, duration[0], cla[0], sex[0]);
        db.child("Users").child(id).setValue(DB);





    }
    public void Update(View v) {
        Toast.makeText(this, "Update Successful", Toast.LENGTH_SHORT).show();
        Upd();
    }
}

