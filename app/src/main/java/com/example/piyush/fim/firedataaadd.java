package com.example.piyush.fim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class firedataaadd extends AppCompatActivity {
    Spinner spinner;
    EditText ep2;
    TextView tvadd;
    Button bup;
  //  DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firedataaadd);
        ep2=findViewById(R.id.edity);
        tvadd=findViewById(R.id.text23);
        bup=findViewById(R.id.btnfire);
        spinner=findViewById(R.id.spin);

        bup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  databaseReference= FirebaseDatabase.getInstance().getReference();
                DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
                String name = ep2.getText().toString().trim();
               // String genre=spinner.getSelectedItem().toString();
                if (!TextUtils.isEmpty(name)){
                    String id=databaseReference.push().getKey();
                    Artist artist=new Artist(id,name);
                    databaseReference.child(id).setValue(artist);
                    Toast.makeText(getApplicationContext(), "NGO Added", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "You should enter details", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public void addArtist(){

    }
}
