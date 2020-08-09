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
import com.example.test.data.Experience;

import java.util.ArrayList;
import java.util.List;

public class AddExperienceAdapter extends RecyclerView.Adapter<AddExperienceAdapter.QuestionViewholder> {

    private  String TAG="AddQuestionAdapter";
    public  List<Experience> experienceList;

    public AddExperienceAdapter(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }


    @NonNull
    @Override
    public AddExperienceAdapter.QuestionViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View questions_view = layoutInflater.inflate(R.layout.experience_list,parent,false);

        AddExperienceAdapter.QuestionViewholder view = new AddExperienceAdapter.QuestionViewholder(questions_view);

        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull AddExperienceAdapter.QuestionViewholder holder, int position) {

        holder.appCompatTextViewjob.setText(experienceList.get(position).getjob());
        holder.appCompatTextViewtitle.setText(experienceList.get(position).getTitle());
        holder.appCompatTextViewestartdate.setText(experienceList.get(position).getStart_date());
        holder.appCompatTextViewenddate.setText(experienceList.get(position).getEnd_date());
        holder.appCompatTextViewcity.setText(experienceList.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG,"size="+experienceList.size());
        return experienceList.size();
    }

    public class QuestionViewholder extends RecyclerView.ViewHolder {
        public AppCompatTextView appCompatTextViewjob;
        public AppCompatTextView appCompatTextViewtitle;
        public AppCompatTextView appCompatTextViewestartdate;
        public AppCompatTextView appCompatTextViewenddate;
        public AppCompatTextView appCompatTextViewcity;

        public QuestionViewholder(@NonNull View itemView) {
            super(itemView);

            appCompatTextViewjob = (AppCompatTextView)itemView.findViewById(R.id.job);
            appCompatTextViewtitle = (AppCompatTextView)itemView.findViewById(R.id.title);
            appCompatTextViewestartdate = (AppCompatTextView)itemView.findViewById(R.id.startdate);

            appCompatTextViewenddate = (AppCompatTextView) itemView.findViewById(R.id.enddate);
            appCompatTextViewcity =  (AppCompatTextView) itemView.findViewById(R.id.city);
        }
    }
}
