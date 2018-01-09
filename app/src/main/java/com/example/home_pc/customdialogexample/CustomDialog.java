package com.example.home_pc.customdialogexample;

import android.app.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class CustomDialog extends DialogFragment implements View.OnClickListener {

    public Button btnYes, btnNo;
    LayoutInflater inflater;
    CustomToast toast;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        toast = new CustomToast(getActivity());
        inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_dialog, null);
        btnYes = customView.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(this);
        btnNo = customView.findViewById(R.id.btn_no);
        btnNo.setOnClickListener(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder
                .setIcon(R.drawable.ic_android_black_24dp)
                .setView(customView);

        return builder.create();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                toast.createCustomToast("Yes you are", 1);
                dismiss();
                break;
            case R.id.btn_no:
                toast.createCustomToast("No you are not", 2);
                dismiss();
                break;
        }
    }
}
































