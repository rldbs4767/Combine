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

import static com.example.myapplication.HomeActivity.data_num;


//  품목들의 데이터들을 관리하는 액티비티

public class data_infActivity extends AppCompatActivity {

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

        i++;
        firebaseAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        currentUser = user.getEmail();

        User.email[i] = user.getEmail();

        //현재 접속자와 이전의 접속자를 구별하기 위해서 구현한 코드
        for (int j = 0; j <= i; j++) {

            if (currentUser.equals(User.email[j])) {
                i = j;
                break;
            }
        }


        if(data_num == 1) {

            setContentView(R.layout.activity_hong1);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);

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
                        writeUserlike("not natural", currentUser);

                        //좋아요 취소버튼의 text를 바꿔준다.
                        naturalButton.setText("Basket");

                        //natural[i]값이 0으로 저장이 된다.
                        User.naturallike[i] = 0;

                    }

                }
            });

        }
        else if(data_num == 2){

            setContentView(R.layout.activity_hong2);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


            if (User.diamond[i] == 1) {
                naturalButton.setText("nonlike");

            }
            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.diamond[i])++;

                    if (User.diamond[i] == 1) {
                        writeUserlike("diamond", currentUser);
                        naturalButton.setText("nonlike");
                        User.diamond[i] = 1;

                    }
                    else if (User.diamond[i] > 1) {
                        writeUserlike("not diamond", currentUser);
                        naturalButton.setText("Basket");
                        User.diamond[i] = 0;

                    }



                }
            });

        }
        else if(data_num == 3){

            setContentView(R.layout.activity_hong3);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


            if (User.nutrena[i] == 1) {
                naturalButton.setText("nonlike");

            }

            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.nutrena[i])++;

                    if (User.nutrena[i] == 1) {
                        writeUserlike("nutrena", currentUser);
                        naturalButton.setText("nonlike");
                        User.nutrena[i] = 1;

                    }
                    else if (User.nutrena[i] > 1) {
                        writeUserlike("not nutrena", currentUser);
                        naturalButton.setText("Basket");
                        User.nutrena[i] = 0;

                    }



                }
            });
        }
        else if(data_num == 4){

            setContentView(R.layout.activity_hong4);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


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
                        writeUserlike("not the_dog", currentUser);
                        naturalButton.setText("Basket");
                        User.the_dog[i] = 0;

                    }



                }
            });

        }
        else if(data_num == 5){

            setContentView(R.layout.activity_hong5);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);

            if (User.amio[i] == 1) {
                naturalButton.setText("nonlike");

            }

            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.amio[i])++;

                    if (User.amio[i] == 1) {
                        writeUserlike("amio", currentUser);
                        naturalButton.setText("nonlike");
                        User.amio[i] = 1;

                    }
                    else if (User.amio[i] > 1) {
                        writeUserlike("not amio", currentUser);
                        naturalButton.setText("Basket");
                        User.amio[i] = 0;

                    }



                }
            });
        }
        else if(data_num == 6){

            setContentView(R.layout.activity_hong6);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


            if (User.esbilac[i] == 1) {
                naturalButton.setText("nonlike");

            }

            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.esbilac[i])++;

                    if (User.esbilac[i] == 1) {
                        writeUserlike("esbilac", currentUser);
                        naturalButton.setText("nonlike");
                        User.esbilac[i] = 1;

                    }
                    else if (User.esbilac[i] > 1) {
                        writeUserlike("not esbilac", currentUser);
                        naturalButton.setText("Basket");
                        User.esbilac[i] = 0;

                    }



                }
            });
        }
        else if(data_num == 7){

            setContentView(R.layout.activity_hong7);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


            if (User.seoul[i] == 1) {
                naturalButton.setText("nonlike");

            }

            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.seoul[i])++;

                    if (User.seoul[i] == 1) {
                        writeUserlike("seoul", currentUser);
                        naturalButton.setText("nonlike");
                        User.seoul[i] = 1;

                    }
                    else if (User.seoul[i] > 1) {
                        writeUserlike("not seoul", currentUser);
                        naturalButton.setText("Basket");
                        User.seoul[i] = 0;

                    }



                }
            });
        }
        else if(data_num == 8){

            setContentView(R.layout.activity_hong8);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


            if (User.acana[i] == 1) {
                naturalButton.setText("nonlike");

            }

            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.acana[i])++;

                    if (User.acana[i] == 1) {
                        writeUserlike("acana", currentUser);
                        naturalButton.setText("nonlike");
                        User.acana[i] = 1;

                    }
                    else if (User.acana[i] > 1) {
                        writeUserlike("not acana", currentUser);
                        naturalButton.setText("Basket");
                        User.acana[i] = 0;

                    }



                }
            });
        }
        else if(data_num == 9){

            setContentView(R.layout.activity_hong9);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


            if (User.nutrena2[i] == 1) {
                naturalButton.setText("nonlike");

            }

            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.nutrena2[i])++;

                    if (User.nutrena2[i] == 1) {
                        writeUserlike("nutrena2", currentUser);
                        naturalButton.setText("nonlike");
                        User.nutrena2[i] = 1;

                    }
                    else if (User.nutrena2[i] > 1) {
                        writeUserlike("not nutrena2", currentUser);
                        naturalButton.setText("Basket");
                        User.nutrena2[i] = 0;

                    }



                }
            });

        }
        else if(data_num == 10){

            setContentView(R.layout.activity_hong10);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


            if (User.purina[i] == 1) {
                naturalButton.setText("nonlike");

            }

            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.purina[i])++;

                    if (User.purina[i] == 1) {
                        writeUserlike("purina", currentUser);
                        naturalButton.setText("nonlike");
                        User.purina[i] = 1;

                    }
                    else if (User.purina[i] > 1) {
                        writeUserlike("not purina", currentUser);
                        naturalButton.setText("Basket");
                        User.purina[i] = 0;

                    }



                }
            });

        }
        else if(data_num == 11){

            setContentView(R.layout.activity_hong11);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


            if (User.purina2[i] == 1) {
                naturalButton.setText("nonlike");

            }

            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.purina2[i])++;

                    if (User.purina2[i] == 1) {
                        writeUserlike("purina2", currentUser);
                        naturalButton.setText("nonlike");
                        User.purina2[i] = 1;

                    }
                    else if (User.purina2[i] > 1) {
                        writeUserlike("not purina2", currentUser);
                        naturalButton.setText("Basket");
                        User.purina2[i] = 0;

                    }



                }
            });


        }
        else if(data_num == 12){

            setContentView(R.layout.activity_hong12);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


            if (User.acana2[i] == 1) {
                naturalButton.setText("nonlike");

            }

            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.acana2[i])++;

                    if (User.acana2[i] == 1) {
                        writeUserlike("acana2", currentUser);
                        naturalButton.setText("nonlike");
                        User.acana2[i] = 1;

                    }
                    else if (User.acana2[i] > 1) {
                        writeUserlike("not acana2", currentUser);
                        naturalButton.setText("Basket");
                        User.acana2[i] = 0;

                    }



                }
            });

        }
        else if(data_num == 13){

            setContentView(R.layout.activity_hong13);

            explain = (TextView) findViewById(R.id.explain);

            explain.setText("무게 = 2kg\n 원산지 = 중국\n");

            naturalButton = (Button) findViewById(R.id.naturalButton);


            if (User.natural2like[i] == 1) {
                naturalButton.setText("nonlike");

            }

            naturalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    (User.natural2like[i])++;

                    if (User.natural2like[i] == 1) {
                        writeUserlike("natural2", currentUser);
                        naturalButton.setText("nonlike");
                        User.natural2like[i] = 1;

                    }
                    else if (User.natural2like[i] > 1) {
                        writeUserlike("not natural2", currentUser);
                        naturalButton.setText("Basket");
                        User.natural2like[i] = 0;

                    }

                }
            });

        }
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
/*
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
    */
}
