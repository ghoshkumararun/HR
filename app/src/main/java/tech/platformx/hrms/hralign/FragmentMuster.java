package tech.platformx.hrms.hralign;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Carl_johnson on 11/22/2016.
 */
public class FragmentMuster extends Fragment{

    private Button MusterIntimer;
    private Button MusterOuttimer;
    private TextView timer;

    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragmentmuster, container, false);
        View view = inflater.inflate(R.layout.fragmentmuster, container, false);
        timer = (TextView) view.findViewById(R.id.Timer);
        MusterIntimer = (Button) view.findViewById(R.id.MusterIntimer);

        MusterIntimer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread, 0);

            }
        });

        MusterOuttimer = (Button) view.findViewById(R.id.MusterOuttimer);

        MusterOuttimer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);

            }
        });
        return view;
    }
/*  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }*/



    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuff + timeInMilliseconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timer.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);
        }

    };

}
