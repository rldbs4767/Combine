package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static com.example.myapplication.HomeActivity.data_num;

public class Nutrena extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrena);

        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setTextColor(Color.parseColor("#0B614B"));

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_num = 3;
                Intent intent = new Intent(Nutrena.this, data_infActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_num = 9;
                Intent intent = new Intent(Nutrena.this, data_infActivity.class);
                startActivity(intent);
            }
        });
    }
}
