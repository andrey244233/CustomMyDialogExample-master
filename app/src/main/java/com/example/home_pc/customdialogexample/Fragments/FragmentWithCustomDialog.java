package com.example.home_pc.customdialogexample.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.home_pc.customdialogexample.CustomDialog;
import com.example.home_pc.customdialogexample.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentWithCustomDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentWithCustomDialog extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnShowNotif;
    CustomDialog customDialog;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentWithCustomDialog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentWithCustomDialog.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentWithCustomDialog newInstance(String param1, String param2) {
        FragmentWithCustomDialog fragment = new FragmentWithCustomDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_custom_dialog, container, false);
        btnShowNotif  = rootView.findViewById(R.id.btn_show_dialog);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnShowNotif.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CustomDialog customDialog = new CustomDialog();
        customDialog.show(getFragmentManager(), "tag");
    }

}
