package com.example.owl.fragments;


import android.content.ContentValues;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.owl.R;
import com.example.owl.controller.CitacaoDAO;
import com.example.owl.controller.DataBaseHelper;
import com.example.owl.controller.LivroDAO;

/**
 * A simple {@link Fragment} subclass.
 */
public class Citacao extends Fragment {


    public Citacao() {
        // Required empty public constructor
    }
    private static DataBaseHelper id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_citacao, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Button btn = getView().findViewById(R.id.btnSalvar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edt1 = getView().findViewById(R.id.edtTitulo);
                EditText edt2 = getView().findViewById(R.id.edtcitacao);
                ContentValues obj = new ContentValues();
                obj.put("titulo", edt1.getText().toString());
                obj.put("citacao", edt2.getText().toString());
                id = new DataBaseHelper(getContext().getApplicationContext());
                long idd = new CitacaoDAO(id).inserir(obj);
                if (idd > 0) {
                    Toast.makeText(getContext().getApplicationContext(),
                            "A citação foi adicionada com sucesso!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext().getApplicationContext(),
                            "Ocorreu um erro!",
                            Toast.LENGTH_LONG).show();
                }
            }


        });
    }
}
