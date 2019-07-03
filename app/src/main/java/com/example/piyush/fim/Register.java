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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    Button button1;
    EditText e1,e2;
   ProgressDialog progressDialog;
   FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        button1=findViewById(R.id.buttonRegister);
        e1=findViewById(R.id.editTextEmail);
        e2=findViewById(R.id.editTextPassword);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == button1){
                    registerUser();

                }

                }
            public void registerUser(){
                String email=e1.getText().toString().trim();
                String password=e2.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this, "Please enter email", Toast.LENGTH_SHORT).show();

                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Registering user....");
                progressDialog.show();

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            startActivity(new Intent(Register.this,ngologin.class));
                        }
                        else{
                            Toast.makeText(Register.this, "Could not register", Toast.LENGTH_SHORT).show();

                        }



                    }
                });


            }


        });
    }
}
