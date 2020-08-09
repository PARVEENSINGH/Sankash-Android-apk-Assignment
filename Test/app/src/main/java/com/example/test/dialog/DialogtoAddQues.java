package com.example.test.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;

import com.example.test.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class DialogtoAddQues {

    private Context context;
    public  List<String> queslist;

    public DialogtoAddQues(Context context,List<String> queslist) {
        this.context=context;
        this.queslist = queslist;
    }

    public void  Dialog_toAddQues()
    {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.add_more_ques);

        TextInputLayout textInputLayoutques = (TextInputLayout)dialog.findViewById(R.id.textInputLayoutAddQues);
        final TextInputEditText textInputEditTextques = (TextInputEditText)dialog.findViewById(R.id.textInputEditTextQues);

        Button savebutton=(AppCompatButton)dialog.findViewById(R.id.appCompatButtonSaveQues);
        dialog.show();
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queslist.add(textInputEditTextques.getText().toString());
                dialog.dismiss();


            }
        });
    }
}
