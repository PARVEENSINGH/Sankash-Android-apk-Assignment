package com.example.test.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.allyants.chipview.ChipView;
import com.allyants.chipview.SimpleChipAdapter;
import com.example.test.R;
import com.example.test.adapter.AddExperienceAdapter;
import com.example.test.data.Experience;
import com.example.test.dialog.DialogtoAddExperience;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AddProfile2 extends AppCompatActivity implements View.OnClickListener {

    private String TAG="AddProfile1";

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutNickName;
    private TextInputEditText textInputEditTextNickName;

    private TextInputLayout textInputLayoutAbout;
    private TextInputEditText textInputEditTextAbout;

    private AppCompatSpinner spinner_skills;

    private TextInputLayout textInputLayoutInterest;
    private TextInputEditText textInputEditTextInterest;

    private RecyclerView exprecycler_view;
    private AppCompatTextView textViewAddExperience;

    private TextInputLayout textInputLayoutSkills;
    private TextInputEditText textInputEditTextSkills;

    private  TextInputLayout textInputLayoutContact;
    private TextInputEditText textInputEditTextContact;

    private AppCompatSpinner spinner_education;
    private  AppCompatSpinner spinner_interest;

    private AddExperienceAdapter addExperienceAdapter;

    private AppCompatButton appCompatButtonSave;

    private LinearLayoutManager linearLayoutManager;
    private ChipView mChipView;
    private ChipGroup chipGroup;
    private AppCompatSpinner interests_list;

    ArrayList tags = new ArrayList();
    public List<Experience> explist = new ArrayList<>();
    private  List<String> chipgplist = new ArrayList<>();
    private  Chip lChip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_profile2);

        initViews();
        implementRecyclerView();
        implementSpinner();
        initListeners();
        createChipgroup();
        populateTags();
    }



    private void createChipgroup() {

        addChip("Database",chipGroup);
        addChip("Data Binding",chipGroup);
        addChip("Widgets",chipGroup);
        addChip("RecyclerView",chipGroup);
        addChip("Activity",chipGroup);
        addChip("Services",chipGroup);
        addChip("Networking",chipGroup);
        addChip("Android",chipGroup);
        addChip("Flutter",chipGroup);
        addChip("PWA",chipGroup);
        addChip("LinearLayout",chipGroup);
        addChip("ListView",chipGroup);
        addChip("ConstraintLayout",chipGroup);
        addChip("NestedScrollView",chipGroup);
        addChip("ConstraintLayout",chipGroup);
        addChip("Linux",chipGroup);
        addChip("RelativeLayout",chipGroup);
        addChip("Chip",chipGroup);
        addChip("ChipView",chipGroup);
        addChip("ChipGroup",chipGroup);
        addChip("Hybrid Application",chipGroup);
        addChip("Native Application",chipGroup);
        addChip("Java",chipGroup);
        addChip("Kotlin",chipGroup);
        addChip("C++",chipGroup);
        addChip("Python",chipGroup);
        addChip("C",chipGroup);
        addChip("Unit Test Cases",chipGroup);
        addChip("Instrumented Test Cases",chipGroup);
    }

    private void initViews() {

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutNickName = (TextInputLayout) findViewById(R.id.textInputLayoutNickName);
        textInputLayoutAbout = (TextInputLayout) findViewById(R.id.textInputLayoutAbout);
        textInputLayoutInterest=(TextInputLayout) findViewById(R.id.textInputLayoutInterest);
        textInputLayoutSkills=(TextInputLayout) findViewById(R.id.textInputLayoutSkills);
        textInputLayoutContact=(TextInputLayout)findViewById(R.id.textInputLayoutContact);

        textInputEditTextNickName = (TextInputEditText) findViewById(R.id.textInputEditTextNickName);
        textInputEditTextAbout = (TextInputEditText) findViewById(R.id.textInputEditTextAbout);
        textInputEditTextInterest = (TextInputEditText) findViewById(R.id.textInputEditTextinterest);
        textInputEditTextContact= (TextInputEditText) findViewById(R.id.textInputEditTextContact);
        textInputEditTextSkills = (TextInputEditText) findViewById(R.id.textInputEditTextSkills);

        spinner_skills= (AppCompatSpinner) findViewById(R.id.spinner_skills);
        spinner_education=(AppCompatSpinner) findViewById(R.id.spinner_education);
        spinner_interest=(AppCompatSpinner) findViewById(R.id.spinner_interest);

        exprecycler_view = (RecyclerView)findViewById(R.id.exp_recycler_view);
        textViewAddExperience = (AppCompatTextView) findViewById(R.id.textViewExperience);

        mChipView = (ChipView)findViewById(R.id.cvTag);
        chipGroup = (ChipGroup)findViewById(R.id.chipGroup);

        appCompatButtonSave = (AppCompatButton) findViewById(R.id.appCompatButtonSave);
    }

    private void initListeners() {

        appCompatButtonSave.setOnClickListener(this);
        textViewAddExperience.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.appCompatButtonSave:
                emptyInputEditText();
                createGson();
                break;
            case R.id.textViewExperience:
                generateList();
                break;
        }
    }

    private void createGson() {

        String source = "{\"almonoid\":\"android\", \"deve\": 393232}";

        Gson gson = new Gson();
        String json = gson.toJson(source);
        Toast.makeText(getApplicationContext(),json,Toast.LENGTH_SHORT).show();
    }

    private void generateList() {

        DialogtoAddExperience dialogtoAddExperience=new DialogtoAddExperience(this,explist);
        dialogtoAddExperience.Dialog_toAddQues();
        addExperienceAdapter.notifyDataSetChanged();
        implementRecyclerView();
    }

    public void implementRecyclerView() {

        exprecycler_view.setHasFixedSize(true);
        linearLayoutManager=new LinearLayoutManager(this);
        exprecycler_view.setLayoutManager(linearLayoutManager);
        addExperienceAdapter = new AddExperienceAdapter(explist);
        exprecycler_view.setAdapter(addExperienceAdapter);
    }

    private void emptyInputEditText() {

        textInputEditTextNickName.setText(null);
        textInputEditTextAbout.setText(null);
        textInputEditTextSkills.setText(null);
        textInputEditTextContact.setText(null);
        textInputEditTextInterest.setText(null);
    }

    private void implementSpinner() {

        implementRelationSpinner();
        implementhobbieslist();
        implementinterestslist();
    }

    private void implementRelationSpinner() {

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, createEducationList());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_education.setAdapter(arrayAdapter);
    }

    private void implementhobbieslist() {

        final StringBuilder stringBuilder= new StringBuilder();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, createSkillList());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_skills.setAdapter(arrayAdapter);

        spinner_skills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                    stringBuilder.append(parent.getItemAtPosition(position).toString());
                else
                    stringBuilder.append(parent.getItemAtPosition(position).toString() +", ");
                textInputEditTextSkills.setText(stringBuilder);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<String> createSkillList() {

        List<String> Skills=new ArrayList<>();
        Skills.add("");
        Skills.add("Java");
        Skills.add("Android");
        Skills.add("C++");
        Skills.add("Kotlin");
        Skills.add("PWA");
        Skills.add("Flutter");
        Skills.add("Native app");
        Skills.add("retrofit");
        Skills.add("Linux");
        Skills.add("VAPT");

        return Skills;
    }

    private void implementinterestslist() {

        final StringBuilder stringBuilder= new StringBuilder();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, createInterestList());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_interest.setAdapter(arrayAdapter);

        spinner_interest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                    stringBuilder.append(parent.getItemAtPosition(position).toString());
                else
                    stringBuilder.append(parent.getItemAtPosition(position).toString() +", ");

                textInputEditTextInterest.setText(stringBuilder);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<String> createInterestList() {

        List<String> Interest=new ArrayList<>();
        Interest.add("");
        Interest.add("Volunteering");
        Interest.add("Traveling");
        Interest.add("Music");
        Interest.add("Art & Design");
        Interest.add("Reading");
        Interest.add("Video Gaming");
        Interest.add("Sports");
        Interest.add("Blogging");
        Interest.add("Yoga");
        Interest.add("Dancing");

        return Interest;
    }

    private List<String> createEducationList() {

        List<String> education_list=new ArrayList<>();
        education_list.add("Education");
        education_list.add("10th");
        education_list.add("12th");
        education_list.add("BA");
        education_list.add("B.Tech (CSE)");
        education_list.add("B.Com");
        education_list.add("B.Tech (ECE)");
        education_list.add("Bsc");
        education_list.add("M.Com");
        education_list.add("M.Tech (ECE)");
        education_list.add("Phd");

        return education_list;
    }

    private void populateTags(){

        tags= (ArrayList) getCheckedChipIds();
        SimpleChipAdapter adapter = new SimpleChipAdapter(tags);
        mChipView.setAdapter(adapter);
    }

    @NonNull
    public List<String> getCheckedChipIds() {
        ArrayList<String> checkedIds = new ArrayList<>();
        for (int i = 0; i < chipGroup.getChildCount(); i++) {
            View child = chipGroup.getChildAt(i);
            if (child instanceof Chip) {

                checkedIds.add(((Chip) child).getText().toString());
            }
        }

        return checkedIds;
    }

    private void addChip(String pItem, ChipGroup pChipGroup) {

        lChip = new Chip(this);
        lChip.setText(pItem);

        lChip.setTextColor(getResources().getColor(R.color.colorPrimary));
        lChip.setChipBackgroundColor(getResources().getColorStateList(R.color.colorAccent));
        pChipGroup.addView(lChip, pChipGroup.getChildCount() - 1);

    }
}
