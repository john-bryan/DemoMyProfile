package sg.edu.rp.c346.demomyprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    RadioButton rbMale;
    RadioButton rbFemale;
    Button btnSave;

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        Integer intGender = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("name",strName);
        prefEdit.putString("gpa",strGPA);
        prefEdit.putInt("gender", intGender);


        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String name = prefs.getString("name", "");

        String gpa = prefs.getString("gpa", "");

        int gender = prefs.getInt("gender", 0);



        etName.setText(name);
        etGPA.setText(gpa);
        rgGender.check(gender);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);
        rbMale = findViewById(R.id.radioButtonGenderMale);
        rbFemale = findViewById(R.id.radioButtonGenderFemale);
        btnSave = findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = etName.getText().toString();
                String strGPA = etGPA.getText().toString();
                Integer intGender = rgGender.getCheckedRadioButtonId();

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                SharedPreferences.Editor prefEdit = prefs.edit();

                prefEdit.putString("name",strName);
                prefEdit.putString("gpa",strGPA);
                prefEdit.putInt("gender", intGender);


                prefEdit.commit();
            }
        });

    }
}
