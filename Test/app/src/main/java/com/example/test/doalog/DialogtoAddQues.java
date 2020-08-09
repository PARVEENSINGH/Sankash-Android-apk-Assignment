package com.example.test.doalog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;

import com.example.test.R;
import com.example.test.activities.AddProfile1;
//import com.example.test.adapter.AddQuestionAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class DialogtoAddQues {

    private Context context;
    public  List<String> queslist;
    private String TAG="Dialog";
    private AddProfile1 addProfile1;
    //private AddQuestionAdapter addQuestionAdapter;

    public DialogtoAddQues(Context context,List<String> queslist) {
        this.context=context;
        this.queslist = queslist;
       // addProfile1 = new AddProfile1();
      //  this.addQuestionAdapter = addQuestionAdapter;
        Log.d(TAG,"check");
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

                Log.d(TAG,"content= "+textInputEditTextques.getText().toString());
//                addQuestionAdapter.addItem(textInputEditTextques.getText().toString(),addQuestionAdapter);
//                addQuestionAdapter.notifyDataSetChanged();
                queslist.add(textInputEditTextques.getText().toString());
                dialog.dismiss();


            }
        });
//

       // return textInputEditTextques.getText().toString();
    }
}
