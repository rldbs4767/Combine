package com.example.myapplication;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.R.id.*;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
//(brand)

public class MenuFragment extends Fragment {

    ListViewAdapter adapter ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu,container,false);
        // Adapter 생성 및 Adapter 지정.
        ListView listView = view.findViewById(R.id.menuFragment);

        adapter = new ListViewAdapter() ;
        listView.setAdapter(adapter) ;

        // 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.natural_balance),
                "Natural balance","all age,dry matter") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.diamond_petfoods),
                "Diamond PetFoods","all age, dry matter") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.nutrena),
                "Nutrena","old dog, dry matter") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.the_dog),
                "B.W korea The Dog","adult dog, wet dip") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.amio),
                "Amio","adult dog, dry matter") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.esbilac),
                "Esbilac","puppy,can") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.seoul_milk),
                "Seoul milk","puppy,can") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.acana),
                "Acana","puppy, dry matter") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.purina),
                "Purina","adult dog, dry matter") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.mom_daddy),
                "Mom&Daddy","adult dog, dry matter") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.one_meal),
                "One meal","wet dip") ;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view,int position,long l){
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(),Natural.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(),Diamond.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(),Nutrena.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(),TheDog.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(),Amio.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getActivity(),Esbilac.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(),Seoul.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(getActivity(),Acana.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(getActivity(),Purina.class);
                        startActivity(intent8);
                        break;
                    /*
                    case 9:
                        Intent intent9 = new Intent(getActivity(),Main3Activ.class);
                        startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10 = new Intent(getActivity(),Main3Activity.class);
                        startActivity(intent10);
                        break;
*/
                    default:
                }
            }
        });

        return view;
    }

}