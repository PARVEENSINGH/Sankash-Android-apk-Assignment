package com.example.test.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.test.DoinBackGround;
import com.allyants.chipview.ChipView;
import com.allyants.chipview.SimpleChipAdapter;
import com.example.test.R;
import com.example.test.adapter.AddQuestionAdapter;
import com.example.test.doalog.DialogtoAddQues;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AddProfile2 extends AppCompatActivity implements View.OnClickListener {

    private String TAG="AddProfile1";

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutNickName;
    private TextInputEditText textInputEditTextNickName;

    private TextInputLayout textInputLayoutAbout;
    private TextInputEditText textInputEditTextAbout;

    private TextInputLayout textInputLayoutDOB;
    private TextInputEditText textInputEditTextDOB;

    private TextInputLayout textInputLayoutHobbies;
    private TextInputEditText textInputEditTextHobbies;

    private AppCompatSpinner spinner;

    private TextInputLayout textInputLayoutInterest;
    private TextInputEditText textInputEditTextInterest;

    private RecyclerView recyclerView;
    private AppCompatTextView textViewAddmoreques;

    private AddQuestionAdapter addQuestionAdapter;

    private AppCompatButton appCompatButtonSave;
    private AppCompatImageView appCompatCalendar;

    private LinearLayoutManager linearLayoutManager;
    private ChipView mChipView;
    private ChipGroup chipGroup;
    private AppCompatSpinner hobbies_list;
    private AppCompatSpinner interests_list;

    ArrayList tags = new ArrayList();
    public List<String> queslist = new ArrayList<>();
    private  List<String> chipgplist = new ArrayList<>();
    private  Chip lChip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_profile1);

        queslist.add("have a pet");
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
        textInputLayoutDOB = (TextInputLayout) findViewById(R.id.textInputLayoutDOB);
        textInputLayoutHobbies=(TextInputLayout) findViewById(R.id.textInputLayoutHobbies);
        textInputLayoutInterest=(TextInputLayout) findViewById(R.id.textInputLayoutInterest);

        textInputEditTextNickName = (TextInputEditText) findViewById(R.id.textInputEditTextNickName);
        textInputEditTextAbout = (TextInputEditText) findViewById(R.id.textInputEditTextAbout);
        textInputEditTextDOB = (TextInputEditText) findViewById(R.id.textInputEditTextDOB);
        textInputEditTextHobbies = (TextInputEditText) findViewById(R.id.textInputEditTextHobies);
        textInputEditTextInterest = (TextInputEditText) findViewById(R.id.textInputEditTextInterest);

        spinner= (AppCompatSpinner) findViewById(R.id.spinner_relationship_status);
        appCompatButtonSave = (AppCompatButton) findViewById(R.id.appCompatButtonSave);
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        textViewAddmoreques = (AppCompatTextView) findViewById(R.id.textViewAddmoreques);
        appCompatCalendar = (AppCompatImageView)findViewById(R.id.AppCompatCalendar);
        mChipView = (ChipView)findViewById(R.id.cvTag);
        chipGroup = (ChipGroup)findViewById(R.id.chipGroup);
        hobbies_list = (AppCompatSpinner) findViewById(R.id.hobbies_list);
        interests_list = (AppCompatSpinner)findViewById(R.id.interests_list);
    }

    private void initListeners() {

        appCompatButtonSave.setOnClickListener(this);
        textViewAddmoreques.setOnClickListener(this);
        appCompatCalendar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.appCompatButtonSave:
                emptyInputEditText();
                break;
            case R.id.textViewAddmoreques:
                generateList();
                break;
            case R.id.AppCompatCalendar:
                DisplayCalendar();
                break;
        }
    }

    private void DisplayCalendar() {

        final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                textInputEditTextDOB.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }

    private void generateList() {

        DialogtoAddQues dialogtoAddQues=new DialogtoAddQues(this,queslist);
        dialogtoAddQues.Dialog_toAddQues();
        addQuestionAdapter.notifyDataSetChanged();
    }

    public void implementRecyclerView() {

        recyclerView.setHasFixedSize(true);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        addQuestionAdapter = new AddQuestionAdapter(queslist);
        recyclerView.setAdapter(addQuestionAdapter);
    }

    private void emptyInputEditText() {
        textInputEditTextNickName.setText(null);
        textInputEditTextAbout.setText(null);
        textInputEditTextDOB.setText(null);
        textInputEditTextHobbies.setText(null);
        textInputEditTextInterest.setText(null);
    }

    private void implementSpinner() {

        implementRelationSpinner();
        implementhobbieslist();
        implementinterestslist();
    }

    private void implementRelationSpinner() {

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, createRelationList());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    private void implementhobbieslist() {

        final StringBuilder stringBuilder= new StringBuilder();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, createHobbiesList());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hobbies_list.setAdapter(arrayAdapter);

        hobbies_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                    stringBuilder.append(parent.getItemAtPosition(position).toString());
                else
                    stringBuilder.append(parent.getItemAtPosition(position).toString() +", ");
                textInputEditTextHobbies.setText(stringBuilder);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<String> createHobbiesList() {

        List<String> Hobbies=new ArrayList<>();
        Hobbies.add("");
        Hobbies.add("Writing");
        Hobbies.add("Photography");
        Hobbies.add("Gardening");
        Hobbies.add("Knitting");
        Hobbies.add("Cooking");
        Hobbies.add("Sewing");
        Hobbies.add("Drawing");
        Hobbies.add("Painting");
        Hobbies.add("Chess");
        Hobbies.add("Camping");

        return Hobbies;
    }

    private void implementinterestslist() {

        final StringBuilder stringBuilder= new StringBuilder();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, createInterestList());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interests_list.setAdapter(arrayAdapter);

        interests_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    private List<String> createRelationList() {

        List<String> relationship_status=new ArrayList<>();
        relationship_status.add("Relationship Status");
        relationship_status.add("Married");
        relationship_status.add("Single");
        relationship_status.add("UnMarried");
        relationship_status.add("Divorced");
        relationship_status.add("Widowed");

        return relationship_status;
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
