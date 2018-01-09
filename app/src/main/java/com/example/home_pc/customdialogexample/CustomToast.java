package com.example.home_pc.customdialogexample;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast {

    Context context;
    private static final int CLICK_YES = 1;

    public CustomToast(Context context){
        this.context = context;
    }

    public void createCustomToast(String text, int image){

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        LayoutInflater inflater = LayoutInflater.from(context);
        View customToast = inflater.inflate(R.layout.custom_toast, linearLayout, false);
        TextView tvText = customToast.findViewById(R.id.toast_text_view);
        tvText.setText(text);
        ImageView imageView = customToast.findViewById(R.id.toast_image_view);

        if(image == CLICK_YES) {
            imageView.setImageResource(R.drawable.ctyes);
        }else {
            imageView.setImageResource(R.drawable.cn);
        }

        Toast toast = new Toast(context);
        toast.setView(customToast);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

}
