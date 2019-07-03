package com.example.piyush.fim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class query extends AppCompatActivity {
    EditText eq1,eq2;
    Button btq1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        eq1=findViewById(R.id.qu2);
        eq2=findViewById(R.id.qu1);
        btq1=findViewById(R.id.qb1);
        btq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  databaseReference= FirebaseDatabase.getInstance().getReference();
                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
                String name = eq2.getText().toString().trim();
                String query = eq1.getText().toString().trim();
                // String genre=spinner.getSelectedItem().toString();
                if (!TextUtils.isEmpty(name)){
                    String id=databaseReference.push().getKey();
                    Artist artist=new Artist(id,query);
                    Artist artist1=new Artist(id,query);
                    databaseReference.child(id).setValue(artist);
                    databaseReference.child(id).setValue(artist1);
                    Toast.makeText(getApplicationContext(), "query submitted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "You should enter details", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    }

