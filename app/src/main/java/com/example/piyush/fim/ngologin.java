package com.example.piyush.fim;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ngologin extends AppCompatActivity {
    TextView t1;
    EditText e6,e7;
    Button b7;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    RadioButton radioButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngologin);
        radioButton4=findViewById(R.id.rad);

        firebaseAuth=FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()!=null)
        {

        }
        progressDialog=new ProgressDialog(this);
        e6=findViewById(R.id.tvemail);
        e7=findViewById(R.id.tvpassword);
        b7=findViewById(R.id.tvbutton);
        t1=findViewById(R.id.txt);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==b7){
                    userLogin();
                }

            }
            private void userLogin(){
                String email=e6.getText().toString().trim();
                String password=e7.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(ngologin.this, "Please enter email", Toast.LENGTH_SHORT).show();

                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(ngologin.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Registering user....");

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(ngologin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                        }
                        else{
                            Toast.makeText(ngologin.this, "Registration error", Toast.LENGTH_SHORT).show();



                        }
                        progressDialog.dismiss();

                    }
                });




            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ngologin.this,Register.class);
                startActivity(intent);
            }
        });
        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(ngologin.this,firedataaadd.class);
                startActivity(i1);
            }
        });
    }
}
