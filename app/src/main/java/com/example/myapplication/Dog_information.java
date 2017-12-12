package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.myapplication.HomeActivity.data_num;

//(1:1) dog information 선택별 맞춤화면 구성

public class Dog_information extends AppCompatActivity {
    private void DisplayToast(String msg)
    {
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_information);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setTextColor(Color.parseColor("#04B4AE"));
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setTextColor(Color.parseColor("#04B4AE"));
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setTextColor(Color.parseColor("#04B4AE"));
        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setTextColor(Color.parseColor("#04B4AE"));

        Button button = (Button)findViewById(R.id.button);

        //체크박스들 선언
        final CheckBox check1 = (CheckBox) findViewById(R.id.check1);
        final CheckBox check2 = (CheckBox) findViewById(R.id.check2);
        final CheckBox check3 = (CheckBox) findViewById(R.id.check3);

        final CheckBox check4 = (CheckBox) findViewById(R.id.checkS1);
        final CheckBox check5 = (CheckBox) findViewById(R.id.checkS2);
        final CheckBox check6 = (CheckBox) findViewById(R.id.checkS3);

        final CheckBox check7 = (CheckBox) findViewById(R.id.checkA1);
        final CheckBox check8 = (CheckBox) findViewById(R.id.checkA2);
        final CheckBox check9 = (CheckBox) findViewById(R.id.checkA3);
        final CheckBox check10 = (CheckBox) findViewById(R.id.checkA4);

        final CheckBox check11 = (CheckBox) findViewById(R.id.checkF1);
        final CheckBox check12 = (CheckBox) findViewById(R.id.checkF2);
        final CheckBox check13 = (CheckBox) findViewById(R.id.checkF3);


        //첫번째 줄 (나이) 연령대 중복클릭 방지
        check2.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()==true || check3.isChecked()==true){
                    DisplayToast("Just click one");
                    check2.setChecked(false);
                }
            }});

        //체크박스 클릭리스너
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (((check1.isChecked() == true && check4.isChecked()==true)&& check10.isChecked()==true) && check11.isChecked()==true ){
                    //main2->아카나1 성분창으로
                    data_num = 8;
                    Intent intent = new Intent(Dog_information.this, data_infActivity.class);
                    startActivity(intent);
                }
                else if (((check2.isChecked() == true && check5.isChecked()==true) && check9.isChecked()==true) && check11.isChecked()==true ) {
                    //main2->아카나2 성분창으로
                    data_num = 12;
                    Intent intent = new Intent(Dog_information.this, data_infActivity.class);
                    startActivity(intent);
                }
                else if (((check3.isChecked() == true && (check4.isChecked()==true || check5.isChecked()== true)) && check10.isChecked()==true) && check11.isChecked()==true  ) {
                    //main2->뉴트리나2 성분창으로
                    data_num = 9;
                    Intent intent = new Intent(Dog_information.this, data_infActivity.class);
                    startActivity(intent);
                }
                else if (((check3.isChecked() == true && check6.isChecked()==true) && check10.isChecked()==true) && check11.isChecked()==true ) {
                    //main2->뉴트리나1 성분창으로
                    data_num = 3;
                    Intent intent = new Intent(Dog_information.this, data_infActivity.class);
                    startActivity(intent);
                }
                else{
                    DisplayToast("None information");
                }

            }
        });
    }
}