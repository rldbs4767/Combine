package com.example.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

// main
public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Home");
                    transaction.replace(R.id.content,new HomeFragment()).commit();
                    return true;
                case R.id.navigation_brand:
                   // mTextMessage.setText(R.string.title_dashboard);
                    setTitle("Brand");
                    transaction.replace(R.id.content,new MenuFragment()).commit();
                    return true;
                case R.id.page_function:
                    // mTextMessage.setText(R.string.title_notifications);
                    setTitle("Function");
                    transaction.replace(R.id.content,new FunctionFragment()).commit();
                    return true;
                case R.id.navigation__1_1:
                   // mTextMessage.setText(R.string.title_notifications);
                    setTitle("1:1");
                    transaction.replace(R.id.content,new MatchFragment()).commit();
                    return true;
            }
            return false;
        }

    };
//    List<DataItem> lstData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

   //     mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        setTitle("Home");
        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.content,new HomeFragment()).commit();

    }


}
