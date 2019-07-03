package com.example.piyush.fim;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button but,brtu1;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.tool);
        but=findViewById(R.id.bt);
        brtu1=findViewById(R.id.quer);
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId())
                {

                    case R.id.set2:
                        Intent intent1=new Intent(MainActivity.this,Main3Activity.class);
                        startActivity(intent1);
                        return true;
                    case R.id.set3:
                        Intent intent2=new Intent(MainActivity.this,about.class);
                        startActivity(intent2);
                        return true;
                }
                return false;
            }
        });
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
        brtu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,query.class);
                startActivity(intent1);
            }
        });
        ViewPager viewPager=findViewById(R.id.viewme);
        ImageAdapter adapter= new ImageAdapter(this);
        viewPager.setAdapter(adapter);


    }
}
