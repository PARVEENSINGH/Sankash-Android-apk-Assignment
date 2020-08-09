package com.example.test.dialog;

        import android.app.DatePickerDialog;
        import android.app.Dialog;
        import android.content.Context;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;

        import androidx.appcompat.widget.AppCompatButton;
        import androidx.appcompat.widget.AppCompatImageView;

        import com.example.test.R;

        import com.example.test.data.Experience;
        import com.google.android.material.textfield.TextInputEditText;
        import com.google.android.material.textfield.TextInputLayout;

        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.List;
        import java.util.Locale;

public class DialogtoAddExperience implements View.OnClickListener{

    private Context context;
    public List<Experience> experienceList;
    private Dialog dialog;

    private AppCompatImageView appCompatImageViewCalendarsatrt;
    private AppCompatImageView appCompatImageViewCalendarend;

    private TextInputLayout textInputLayoutjob;
    private TextInputEditText textInputEditTextjob;

    private TextInputLayout textInputLayouttitle;
    private TextInputEditText textInputEditTexttitle;

    private TextInputLayout textInputLayoutstartdate;
    private TextInputEditText textInputEditTextstartdate;

    private TextInputLayout textInputLayoutenddate;
    private TextInputEditText textInputEditTextenddate;

    private TextInputLayout textInputLayoutcity;
    private TextInputEditText textInputEditTextcity;

    private Button savebutton;

    public DialogtoAddExperience(Context context, List<Experience> experienceList) {
        this.context=context;
        this.experienceList = experienceList;
    }

    public void  Dialog_toAddQues()
    {

        initViews();
        initListeners();

        dialog.show();
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                experienceList.add(new Experience(textInputEditTextjob.getText().toString(),textInputEditTexttitle.getText().toString(),
                        textInputEditTextstartdate.getText().toString(),textInputEditTextenddate.getText().toString(),
                        textInputEditTextcity.getText().toString()));

                dialog.dismiss();
            }

        });

    }

    private void initViews() {

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.add_experience);

        textInputLayoutjob = (TextInputLayout)dialog.findViewById(R.id.textInputLayoutJob);
        textInputLayouttitle =  (TextInputLayout)dialog.findViewById(R.id.textInputLayoutTitle);
        textInputLayoutstartdate = (TextInputLayout)dialog.findViewById(R.id.textInputLayoutstartDate);
        textInputLayoutenddate =  (TextInputLayout)dialog.findViewById(R.id.textInputLayoutendDate);
        textInputLayoutcity = (TextInputLayout)dialog.findViewById(R.id.textInputLayoutCity);

        textInputEditTextjob = (TextInputEditText)dialog.findViewById(R.id.textInputEditTextJob);
        textInputEditTexttitle = (TextInputEditText)dialog.findViewById(R.id.textInputEditTextTitle);
        textInputEditTextstartdate = (TextInputEditText)dialog.findViewById(R.id.textInputEditTextstartDate);
        textInputEditTextenddate = (TextInputEditText)dialog.findViewById(R.id.textInputEditTextendDate);
        textInputEditTextcity = (TextInputEditText)dialog.findViewById(R.id.textInputEditTextCity);

        appCompatImageViewCalendarsatrt=(AppCompatImageView)dialog.findViewById(R.id.AppCompatCalendar);
        appCompatImageViewCalendarend=(AppCompatImageView)dialog.findViewById(R.id.AppCompatCalendarend);

        savebutton=(AppCompatButton)dialog.findViewById(R.id.appCompatButtonSave);
    }

    private void initListeners() {

        appCompatImageViewCalendarsatrt.setOnClickListener(this);
        appCompatImageViewCalendarend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.AppCompatCalendar:
                getStartDate();
                break;
            case R.id.AppCompatCalendarend:
                getEndDate();
                break;
        }
    }

    private void getStartDate() {

        final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                textInputEditTextstartdate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


    private void getEndDate() {

        final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                textInputEditTextenddate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }

}
