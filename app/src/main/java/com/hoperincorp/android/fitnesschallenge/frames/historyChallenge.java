package com.hoperincorp.android.fitnesschallenge.frames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hoperincorp.android.fitnesschallenge.R;

import static com.hoperincorp.android.fitnesschallenge.libraries.historyLibrary.removeFromHistory;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.APP_PREFERENCES;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.debug;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentColor;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentType;

/**
 * Created by laker on 27.02.2017.
 */

public class historyChallenge extends AppCompatActivity {
    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_currentchallenge);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        ImageButton panel_back = (ImageButton) findViewById(R.id.panel_backward);
        ImageButton panel_accept = (ImageButton) findViewById(R.id.panel_accept);
        ImageButton panel_delete = (ImageButton) findViewById(R.id.panel_delete);

        final TextView dateNow = (TextView) findViewById(R.id.dateNow);
        final TextView timeNow = (TextView) findViewById(R.id.timeNow);
        final TextView typeNow = (TextView) findViewById(R.id.typeNow);
        final TextView totalNow = (TextView) findViewById(R.id.totalNow);
        final TextView targetNow = (TextView) findViewById(R.id.targetNow);

        final EditText noteNow = (EditText) findViewById(R.id.noteNow);
        final EditText countNow = (EditText) findViewById(R.id.countNow);

        final ImageButton workoutNow = (ImageButton) findViewById(R.id.workoutNow);
        final TextView workoutString = (TextView) findViewById(R.id.workoutString);

        dateNow.setText(mSettings.getString(String.valueOf(mSettings.getInt("THIS_ID", 0)) + "_DATE", "14-Фев-1970"));
        timeNow.setText(mSettings.getString(String.valueOf(mSettings.getInt("THIS_ID", 0)) + "_TIME", "23:59"));

        getCurrentColor(mSettings.getInt(String.valueOf(mSettings.getInt("THIS_ID", 0)) + "_COLOR", 0), workoutNow);

        getCurrentType(mSettings.getInt(String.valueOf(mSettings.getInt("THIS_ID", 0)) + "_WORK", 0), workoutNow);

        workoutString.setText(mSettings.getString(String.valueOf(mSettings.getInt("THIS_ID", 0)) + "_NAME", "Нет записи"));

        totalNow.setText(mSettings.getInt(String.valueOf(mSettings.getInt("THIS_ID", 0)) + "_COUNT", 999) + "");
        countNow.setText(mSettings.getInt(String.valueOf(mSettings.getInt("THIS_ID", 0)) + "_COUNT_NOW", 999) + "");
        typeNow.setText(mSettings.getString(String.valueOf(mSettings.getInt("THIS_ID", 0)) + "_TYPE", "разы"));
        noteNow.setText(mSettings.getString(String.valueOf(mSettings.getInt("THIS_ID", 0)) + "_FOOTNOTE", "Примечание"));
        targetNow.setText(mSettings.getInt(String.valueOf(mSettings.getInt("THIS_ID", 0)) + "_TARGET", 999) + "");

        countNow.setRawInputType(0x00000000);
        noteNow.setRawInputType(0x00000000);

        panel_accept.setVisibility(View.INVISIBLE);
        panel_delete.setVisibility(View.INVISIBLE);

        //

        panel_back.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              Intent intent = new Intent("android.intent.action.historychallenge");
                                              startActivity(intent);
                                          }
                                      }
        );

    }
}
