package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//natural
public class hong1Activity extends AppCompatActivity {

    information User = new information();

    String currentUser;
    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;

    TextView explain;
    //관심상품에 담을 상품목록
    Button naturalButton;


    public static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hong1);

        i++;
        firebaseAuth = FirebaseAuth.getInstance();

        explain = (TextView)findViewById(R.id.explain);

        explain.setText("무게 = 2kg\n 원산지 = 중국\n");
        naturalButton = (Button)findViewById(R.id.naturalButton);

        database = FirebaseDatabase.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        currentUser = user.getEmail();

        User.email[i] = user.getEmail();

        //현재 접속자와 이전의 접속자를 구별하기 위해서 구현한 코드
        for(int j = 0; j<=i; j++) {

            if (currentUser.equals(User.email[j])) {
                i = j;
                break;
            }
        }

        //만약, 이미 저장된 natural[i]값을 통해 사용자가 품목의 선호여부를 보여주기 위한 코드
        if (User.naturallike[i] == 1) {
            naturalButton.setText("nonlike");

        }

        naturalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                (User.naturallike[i])++;

                //만약, natural품목을 좋아요 버튼을 누른다면,,,
                if (User.naturallike[i] == 1) {

                    //품목을 좋아하는 함수를 호출
                    writeUserlike("natural", currentUser);

                    //좋아요 버튼의 text를 바꿔준다.
                    naturalButton.setText("nonlike");

                    //natural[i]값이 1로 저장이 된다.
                    User.naturallike[i] = 1;


                }
                //만약, natural품목을 좋아요 버튼을 누른다면,,,
                else if (User.naturallike[i] > 1) {

                    //품목을 싫어하는 함수를 호출
                    writeUserunlike("not natural", currentUser);

                    //좋아요 취소버튼의 text를 바꿔준다.
                    naturalButton.setText("Basket");

                    //natural[i]값이 0으로 저장이 된다.
                    User.naturallike[i] = 0;

                }



            }
        });

    }
    //좋아하는 품목을 데이터베이스에 입력하기 위한 함수
    private void writeUserlike(String item, String email)
    {
        User user = new User(email,item);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //날짜
        String formattedDate = df.format(c.getTime());
        //데이터를 데이터베이스에 입력함.
        FirebaseDatabase.getInstance().getReference("like?").child(formattedDate).setValue(user);
    }
    //품목을 취소하는 데이터베이스에 입력하기 위한 함수
    private void writeUserunlike(String item, String email)
    {
        User user = new User(email,item);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //날짜
        String formattedDate = df.format(c.getTime());
        //데이터를 데이터베이스에 입력함.
        FirebaseDatabase.getInstance().getReference("like?").child(formattedDate).setValue(user);
    }
}
