package com.example.user.thepiggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openactivity2();
            }
        });
        button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openactivity3();
            }
        });
    }
    public void openactivity2(){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
    public void openactivity3(){
        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
}
