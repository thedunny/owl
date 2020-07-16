package com.example.owl.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.owl.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment implements View.OnClickListener  {

    public Perfil() {
        // Required empty public constructor
    }
    private Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

       /*Button btn = container.findViewById(R.id.edtbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aa();
            }
        });*/

        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.edtbtn) {
                Intent it = new Intent(
                        getActivity().getApplicationContext(),
                        Sobre.class
                );
                startActivity(it);
            }

    }

}

