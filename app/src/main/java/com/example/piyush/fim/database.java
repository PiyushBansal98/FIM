package com.example.piyush.fim;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class database extends AppCompatActivity {
    EditText et1,et2,et3,et4;
    Button bc1,bc2,e8,e9;
    myDatabase myDatabse;
    private static String PREF_NAME = "prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        e8=findViewById(R.id.updata);
        e9=findViewById(R.id.delt);


        myDatabse=new myDatabase(this);
        et1=findViewById(R.id.roll);
        et2=findViewById(R.id.nem);
        et3=findViewById(R.id.ser);
        et4=findViewById(R.id.id);

        bc1=findViewById(R.id.sav);
        bc2=findViewById(R.id.rd);
        e8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isupdate=myDatabse.isUpate(et4.getText().toString(),et1.getText().toString(),et2.getText().toString(), et3.getText().toString());
                if (isupdate==true)
                {
                    Toast.makeText(database.this, "Successfully update", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(database.this, "Error in updating", Toast.LENGTH_SHORT).show();
                }
            }
        });
        e9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletrows =myDatabse.deleteData(et4.getText().toString());
                if (deletrows>0)
                {
                    Toast.makeText(database.this, "successfully delte", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(database.this, "Error ion deleting", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isData=myDatabse.insertData(et1.getText().toString(),et2.getText().toString(), et3.getText().toString());
                if (isData==true )
                {
                    Toast.makeText(database.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(database.this, "some problem in inserting", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor myresult =myDatabse.getAllData();
                if (myresult.getCount()==0)
                {
                    showMessage("Error","No Data");
                }
                StringBuffer buffer= new StringBuffer();
                while (myresult.moveToNext())// provide value of 1 row
                {
                    buffer.append(myresult.getString(0)+",");
                    buffer.append(myresult.getString(1)+",");
                    buffer.append(myresult.getString(2)+",");
                    buffer.append(myresult.getString(3)+",");
                }
                String buffer1=buffer.toString();
                System.out.println("Data_"+buffer1);
                showMessage("Data",buffer.toString());

//                SharedPreferences sharedPref = getApplicationContext().getPreferences(PREF_NAME,Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putString("buffer",buffer1);
//                editor.commit();
                SharedPreferences sharedPreferences=getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("buffer",buffer1);
                editor.commit();
            }
        });




    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }

    }

