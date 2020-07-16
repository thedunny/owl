package com.example.owl.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.owl.R;
import com.example.owl.controller.DataBaseHelper;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ler extends Fragment {

    private List<Object> dados;
    public Ler() {
        // Required empty public constructor
    }
    private static DataBaseHelper dh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ler, container, false);
    }
   /* private void preencherRecyclerView() {
        dados = new LivroDAO(dh).listar();
        adapter = new MyRecyclerAdapter(dados);
        adapter.setOnItemClickListener(onItemClick);
        adapter.setOnItemLongClickListener(onItemLongClick);

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext().getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }
    private View.OnClickListener onItemClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            ContentValues obj = (ContentValues)dados.get(viewHolder.getAdapterPosition());
            exibirTela(1);
            edtId.setText(obj.getAsString("id"));
            edtNome.setText(obj.getAsString("nome"));
            edtPreco.setText(obj.getAsString("preco"));


        }
    };*/

}
