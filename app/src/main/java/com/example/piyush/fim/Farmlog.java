package com.example.piyush.fim;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Farmlog extends AppCompatActivity {
RadioButton radioButton;
Button bn1;
myDatabase database;
EditText edi1,edi2;
ProgressDialog progressDialog;
FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmlog);
        radioButton=findViewById(R.id.save);
        SharedPreferences sharedPreferences=getSharedPreferences("PREF_NAME",MODE_PRIVATE);
        boolean logged= sharedPreferences.getBoolean("islogin",false);


        bn1=findViewById(R.id.btsub);
        edi1=findViewById(R.id.intttex);
        edi2=findViewById(R.id.instext);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Farmlog.this,database.class);
                startActivity(intent);
            }
        });

        firebaseAuth=FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()!=null)
        {

        }
        progressDialog=new ProgressDialog(this);


        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==bn1){
                    userLogin();
                }

            }
            private void userLogin(){
                String email=edi1.getText().toString().trim();
                String password=edi2.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Farmlog.this, "Please enter email", Toast.LENGTH_SHORT).show();

                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Farmlog.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Registering user....");

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Farmlog.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), Farmer1.class));
                        }
                        else{
                            Toast.makeText(Farmlog.this, "Registration error", Toast.LENGTH_SHORT).show();



                        }
                        progressDialog.dismiss();

                    }
                });




            }
        });





//        bn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // Cursor result=database.getAllData();
//                StringBuffer buffer=new StringBuffer();
//                String nem= edi1.getText().toString().trim();
//                String id = edi2.getText().toString().trim();
//
//                if (TextUtils.isEmpty(nem))
//                {
//                    edi1.setError("Name field is empty");
//                }
//                else if (TextUtils.isEmpty(id))
//                {
//                    edi2.setError("Insurance ID field is empty");
//                }
//                SharedPreferences sharedPreferences=getSharedPreferences("PREF_NAME",MODE_PRIVATE);
//                SharedPreferences.Editor editor= sharedPreferences.edit();
//                String buffer_=sharedPreferences.getString("buffer","");
//                editor.putString("name",nem);
//                editor.putString("id",id);
//                String[] namelist=buffer_.split(",");
//                if (edi2.equals(namelist[0])&& edi1.equals(namelist[2])) {
//
//
//                }
//
//                Intent intent = new Intent(Farmlog.this, Farmer1.class);
//                startActivity(intent);
//
//
//            }
//        });
//        bn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Cursor myresult =database.getAllData();
//                if (myresult.getCount()==0)
//                {
//                   // Toast.makeText(Farmlog.this, "can update", Toast.LENGTH_SHORT).show();
//               }
//                StringBuffer buffer= new StringBuffer();
//                while (myresult.moveToNext())// provide value of 1 row
//                {
//                    buffer.append("Roll is "+myresult.getString(1)+"\n");
//                    buffer.append("Name is " + myresult.getString(2) + "\n");
//
//
//                }
//                Intent intent = new Intent(Farmlog.this,Farmer1.class);
//                 startActivity(intent);
////                String  str=buffer.toString();
////                String str2=str.substring(0,8);
////                String str1=str.substring(9,str.length());
//
////                if (edi1.equals(str2)&& edi2.equals(str1))
////
////                {
////                 Intent intent = new Intent(Farmlog.this,Farmer1.class);
////                 startActivity(intent);
////                }
//
//            }
//        });


    }
}
