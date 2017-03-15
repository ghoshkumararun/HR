package tech.platformx.hrms.hralign;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Carl_johnson on 11/18/2016.
 */
public class LoginActivty extends AppCompatActivity {
    Spinner spinnerctrl;
    Locale myLocale;
    Button btnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        spinnerctrl = (Spinner) findViewById(R.id.spinner1);
        btnLogin =(Button) findViewById(R.id.btnLogin);
        spinnerctrl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                if (pos == 1) {

                    Toast.makeText(parent.getContext(),
                            "You have selected English", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("en");
                } else if (pos == 2)
                {

                    Toast.makeText(parent.getContext(),
                            "You have selected Hindi", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("hi");
                } else if (pos == 3)
                {

                    Toast.makeText(parent.getContext(),
                            "You have selected Marathi", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("ma");
                }

            }
            public void onNothingSelected(AdapterView<?> arg0)
            {
                // TODO Auto-generated method stub
            }

        });
    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, LoginActivty.class);
        startActivity(refresh);
    }


    public void NavigateToMainScreen(View v)
    {
        Intent LoginIntent = new Intent(getApplicationContext(),HomeScreen.class);
        LoginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(LoginIntent);
    }
}

