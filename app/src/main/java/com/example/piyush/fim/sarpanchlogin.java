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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sarpanchlogin extends AppCompatActivity {
    TextView sb1;
    EditText es1,es2;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    Button bs1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarpanchlogin);
        sb1=findViewById(R.id.sarb1);
        firebaseAuth=FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()!=null)
        {

        }
        progressDialog=new ProgressDialog(this);
        es1=findViewById(R.id.tsaenail);
        es2=findViewById(R.id.tsapassword);
        bs1=findViewById(R.id.sarb);

        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==bs1){
                    userLogin();
                }

            }
            private void userLogin(){
                String email=es1.getText().toString().trim();
                String password=es2.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(sarpanchlogin.this, "Please enter email", Toast.LENGTH_SHORT).show();

                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(sarpanchlogin.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Registering user....");

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(sarpanchlogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), Farmer1.class));
                        }
                        else{
                            Toast.makeText(sarpanchlogin.this, "Registration error", Toast.LENGTH_SHORT).show();



                        }
                        progressDialog.dismiss();

                    }
                });




            }
        });

        sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sarpanchlogin.this,sarpanchregister.class);
                startActivity(intent);
            }
        });


    }
}
