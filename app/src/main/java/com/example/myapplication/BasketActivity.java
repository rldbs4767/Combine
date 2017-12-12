package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/*
            장바구니 기능을 구현하기 위한 화면이며 장바구니 화면에서는 RecyclerView를 통해서 디자인을 하였다.

 */
public class BasketActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Basket>[] mBasket = new ArrayList[100];
    public static int i = 0;

    TextView basket;

    String currentUser;
    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        i++;
        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        basket = (TextView)findViewById(R.id.basket);

        //장바구니를 여러 개 만든다.
        for(int j = 0; j<100; j++){

            mBasket[j] = new ArrayList<>();
        }

        mAdapter = new MyAdapter(mBasket[i]);
        mRecyclerView.setAdapter(mAdapter);

        firebaseAuth = FirebaseAuth.getInstance(); //파이어베이스로 사용자연결

        FirebaseUser user = firebaseAuth.getCurrentUser();

        currentUser = user.getEmail();  //사용자의 아이디를 저장.


        //데이터베이스에 저장되어 있는 데이터 값에서 "like"의 하위 목록을 reference로 지정.
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("like?");



        // 데이터베이스 읽기 #3. ChildEventListener
        myRef.addChildEventListener(new ChildEventListener(){
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                Basket basket = dataSnapshot.getValue(Basket.class);

                //장바구니를 이용하는 사용자와 현재 접속해 있는 사용자가 같을 때
                if( ((basket.getEmail()).equals(currentUser)) ){

                    //장바구니에 품목을 담는다.
                    mBasket[i].add(basket);
                    mAdapter.notifyItemInserted(mBasket[i].size() - 1);
                }
                //장바구니를 이용하는 사용자와 현재 접속해 있는 사용자가 다르면,,,
                else{
                    //다른 장바구니에 품목을 담는다.
                    mBasket[i+1].add(basket);
                    mAdapter.notifyItemInserted(mBasket[i+1].size() - 1);
                }

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
