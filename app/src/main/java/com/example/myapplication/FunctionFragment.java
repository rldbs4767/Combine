package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;



//(function)기능별 화면 셋팅

public class FunctionFragment extends Fragment {


    public FunctionFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_function,container,false);
        //기능목록
        final String[] menuItems = {"Obesity","Pregnancy","Grain Free","Bone","Skin","Prescription"};

        ListView listView = view.findViewById(R.id.functionFragment);

        //리스트뷰에 들어가는 항목 셋팅
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.function_list,
                R.id.textViewLabel,
                menuItems
        );
        listView.setAdapter(listViewAdapter);

        //리스트뷰 클릭리스너
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view,int position,long l){
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(),Obesity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(),Pregnancy.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(),GrainFree.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(),Bone.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(),Skin.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getActivity(),Prescription.class);
                        startActivity(intent5);
                        break;

                    default:
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}