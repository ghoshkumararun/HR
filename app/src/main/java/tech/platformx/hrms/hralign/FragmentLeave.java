package tech.platformx.hrms.hralign;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.app.Dialog;
import android.app.DatePickerDialog;
import android.widget.LinearLayout;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class FragmentLeave extends Fragment {
    EditText mEdit;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragmentleave, container, false);
        view = inflater.inflate(R.layout.fragmentleave, container, false);
        return view;
    }

}


