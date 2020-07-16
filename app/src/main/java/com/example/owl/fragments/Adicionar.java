package com.example.owl.fragments;

import android.content.ContentValues;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.owl.R;
import com.example.owl.controller.DataBaseHelper;
import com.example.owl.controller.LivroDAO;
import com.example.owl.controller.UsuarioDAO;


public class Adicionar extends Fragment {

    private static DataBaseHelper id;

    public Adicionar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adicionar, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Button btn = getView().findViewById(R.id.btnSalvar);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            EditText edt1 = getView().findViewById(R.id.edtTitulo);
                            EditText edt2 = getView().findViewById(R.id.edtAutor);
                            EditText edt3 = getView().findViewById(R.id.edtEditora);
                            ContentValues obj = new ContentValues();
                            obj.put("titulo", edt1.getText().toString());
                            obj.put("autor", edt2.getText().toString());
                            obj.put("editora", edt3.getText().toString());
                            id = new DataBaseHelper(getContext().getApplicationContext());
                            long idd = new LivroDAO(id).inserir(obj);
                            if (idd > 0) {
                                Toast.makeText(getContext().getApplicationContext(),
                                        "O livro foi adicionado com sucesso!",
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
