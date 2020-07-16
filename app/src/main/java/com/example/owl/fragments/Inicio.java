package com.example.owl.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.owl.API;
import com.example.owl.Cadastrar;
import com.example.owl.Maps;
import com.example.owl.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Inicio extends Fragment {


    public Inicio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_main, container, false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final FragmentTransaction fragmentTransaction = this.getActivity().getSupportFragmentManager().beginTransaction();

        Button btn = getView().findViewById(R.id.ad);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.frameContainer, new Adicionar());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        Button btn2 = getView().findViewById(R.id.ler);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.frameContainer, new Ler());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        Button btn3 = getView().findViewById(R.id.cit);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.frameContainer, new Citacao());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });
        TextView txt = getView().findViewById(R.id.textView22);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity().getApplicationContext(), Maps.class);
                startActivity(it);
            }
        });
        TextView txt2 = getView().findViewById(R.id.textView23);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity().getApplicationContext(), API.class);
                startActivity(it);
            }
        });
    }



}
