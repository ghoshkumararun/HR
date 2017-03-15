package tech.platformx.hrms.hralign;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.text.DateFormat;
import android.support.v7.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Carl_johnson on 11/24/2016.
 */
public class DatePickerUtility extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentleave);

        // Get the widgets reference from XML layout
        final LinearLayout rl = (LinearLayout) findViewById(R.id.FromDate);
        Button btn = (Button) findViewById(R.id.imageButton1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize a new date picker dialog fragment
                DialogFragment dFragment = new DatePickerFragment();
                // Show the date picker dialog fragment
                dFragment.show(getFragmentManager(), "Date Picker");
            }
        });

    }


    public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                    AlertDialog.THEME_HOLO_LIGHT,this,year,month,day);
            Intent intent = new Intent(DatePickerUtility.this, FragmentLeave.class);
            intent.putExtra("message", (Parcelable) dpd);
            startActivity(intent);
            return  dpd;
        }

        public void onDateSet(android.widget.DatePicker view, int year, int month, int day){
            // Do something with the chosen date
            EditText tv = (EditText) getActivity().findViewById(R.id.From_Date);
            int actualMonth = month+1; // Because month index start from zero


            // Create a Date variable/object with user chosen date
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(0);
            cal.set(year, month, day, 0, 0, 0);
            Date chosenDate = cal.getTime();

            // Format the date using style medium and US locale
            DateFormat df_medium_us = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
            String df_medium_us_str = df_medium_us.format(chosenDate);
            // Display the formatted date

        }
    }
}
