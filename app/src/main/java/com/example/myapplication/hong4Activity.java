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
public class hong4Activity extends AppCompatActivity {

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
        setContentView(R.layout.activity_hong4);

        i++;
        firebaseAuth = FirebaseAuth.getInstance();
        explain = (TextView)findViewById(R.id.explain);

        explain.setText("무게 = 2kg\n 원산지 = 중국\n");
        naturalButton = (Button)findViewById(R.id.naturalButton);

        database = FirebaseDatabase.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        currentUser = user.getEmail();

        User.email[i] = user.getEmail();

        for(int j = 0; j<=i; j++) {

            if (currentUser.equals(User.email[j])) {
                i = j;
                break;
            }
        }

        if (User.the_dog[i] == 1) {
            naturalButton.setText("nonlike");

        }

        naturalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                (User.the_dog[i])++;

                if (User.the_dog[i] == 1) {
                    writeUserlike("the_dog", currentUser);
                    naturalButton.setText("nonlike");
                    User.the_dog[i] = 1;

                }
                else if (User.the_dog[i] > 1) {
                    writeUserunlike("not the_dog", currentUser);
                    naturalButton.setText("Basket");
                    User.the_dog[i] = 0;

                }



            }
        });

    }
    //좋아하는 품목 or 품목을 취소하는 함수(사용자가 누군지 알기위해)
    private void writeUserlike(String item, String email)
    {
        User user = new User(email,item);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        FirebaseDatabase.getInstance().getReference("like?").child(formattedDate).setValue(user);
    }
    private void writeUserunlike(String item, String email)
    {
        User user = new User(email,item);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        FirebaseDatabase.getInstance().getReference("like?").child(formattedDate).setValue(user);
    }
}
