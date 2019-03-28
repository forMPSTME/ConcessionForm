package com.example.concessionform;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Regis extends AppCompatActivity implements View.OnClickListener {
    EditText ed1;
    EditText ed2;
    TextView tv1;
    Button Sgup;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_regis);
        tv1=(TextView)findViewById(R.id.tv2);
        ed1=(EditText)findViewById(R.id.email_id);
        ed2=(EditText)findViewById(R.id.password);
        Sgup=(Button)findViewById(R.id.b1);
        Sgup.setOnClickListener(this);
        tv1.setOnClickListener(this);
    }
    private void registerUser() {

        //getting email and password from edit texts
        String email = ed1.getText().toString().trim();
        String password = ed2.getText().toString().trim();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            finish();
                            Intent i=new Intent(Regis.this,ProfileActivity.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(i);
                        } else {
                            //display some message here
                            Toast.makeText(Regis.this, "Registration Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v == Sgup){
            registerUser();
        }
        if(v == tv1){
            //open login activity when user taps on the already registered textview
            startActivity(new Intent(this, MainActivity.class));
        }


    }
}
