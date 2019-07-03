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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sarpanchregister extends AppCompatActivity {
    EditText tsr1,tsr2;
    Button btsr1;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarpanchregister);
        btsr1=findViewById(R.id.srab12);
        tsr1=findViewById(R.id.tsremail);
        tsr2=findViewById(R.id.tsrpassword);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        btsr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btsr1){
                    registerUser();

                }

            }
            public void registerUser(){
                String email=tsr1.getText().toString().trim();
                String password=tsr2.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(sarpanchregister.this, "Please enter email", Toast.LENGTH_SHORT).show();

                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(sarpanchregister.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Registering user....");
                progressDialog.show();

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(sarpanchregister.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(sarpanchregister.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            startActivity(new Intent(sarpanchregister.this,sarpanchlogin.class));
                        }
                        else{
                            Toast.makeText(sarpanchregister.this, "Could not register", Toast.LENGTH_SHORT).show();

                        }



                    }
                });


            }


        });
    }
}
