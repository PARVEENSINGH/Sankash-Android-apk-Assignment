package com.example.test.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class AddQuestionAdapter extends RecyclerView.Adapter<AddQuestionAdapter.QuestionViewholder> {

    private  String TAG="AddQuestionAdapter";
    public  List<String> queslist;

    public AddQuestionAdapter(List<String > queslist) {
      this.queslist = queslist;
    }

//    public void addItem(String subject, AddQuestionAdapter addQuestionAdapter) {
//        Log.d(TAG,"data="+subject);
//        queslist.add(subject);
//        //addQuestionAdapter.notifyItemInserted(queslist.size()-1);
//    }

    @NonNull
    @Override
    public AddQuestionAdapter.QuestionViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View questions_view = layoutInflater.inflate(R.layout.question_list,parent,false);

        AddQuestionAdapter.QuestionViewholder view = new AddQuestionAdapter.QuestionViewholder(questions_view);

        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull AddQuestionAdapter.QuestionViewholder holder, int position) {
        Log.d(TAG,"item="+queslist.get(position)+" size= "+queslist.size()+"position="+position);
                holder.appCompatTextViewques.setText(queslist.get(position));
                holder.appCompatTextViewyes.setText("yes");
                holder.appCompatRadioButtonyes.setChecked(false);
                holder.appCompatTextViewno.setText("no");
                holder.appCompatRadioButtonno.setChecked(false);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG,"size="+queslist.size());
        return queslist.size();
    }

    public class QuestionViewholder extends RecyclerView.ViewHolder {
        public AppCompatTextView appCompatTextViewques;
        public AppCompatTextView appCompatTextViewyes;
        public AppCompatTextView appCompatTextViewno;
        public AppCompatRadioButton appCompatRadioButtonyes;
        public AppCompatRadioButton appCompatRadioButtonno;
        public QuestionViewholder(@NonNull View itemView) {
            super(itemView);

            appCompatTextViewques = (AppCompatTextView)itemView.findViewById(R.id.AppcompatTextViewQuestion);
            appCompatTextViewyes = (AppCompatTextView)itemView.findViewById(R.id.AppcompatTextViewYes);
            appCompatTextViewno = (AppCompatTextView)itemView.findViewById(R.id.AppcompatTextViewNo);

            appCompatRadioButtonyes = (AppCompatRadioButton)itemView.findViewById(R.id.AppCompatRadioButtonyes);
            appCompatRadioButtonno =  (AppCompatRadioButton)itemView.findViewById(R.id.AppCompatRadioButtonno);
        }
    }
}
