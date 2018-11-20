package com.example.alamerate.ejemplo10_navigationyfragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alamerate.ejemplo10_navigationyfragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManageFragment extends Fragment {

private TextView tvmanage;
private ImageView ivimage;
private Button btnmanage;
private  Context context;
    public ManageFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_manage, container, false);
        //todo el codigo necesario para que el fragment funcione
        tvmanage = rootView.findViewById(R.id.Tvmanage);
        ivimage = rootView.findViewById(R.id.Ivimagen);
        btnmanage = rootView.findViewById(R.id.btnmanage);

        btnmanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // si necesito el contexto me creo un constructor que tenga el contexto
                Toast.makeText(context,"Hola mundo",Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

}
