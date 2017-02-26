package com.hoperincorp.android.fitnesschallenge.frames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hoperincorp.android.fitnesschallenge.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;

import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.APP_PREFERENCES;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.debug;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentColor;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentNoteName;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentPage;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentType;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getExistName;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getExistNote;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.loadCurrentChallenge;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.setChallengeName;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.vanishingChallenge;

public class currentChallengeFrame extends AppCompatActivity {
    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_currentchallenge);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        ImageButton panel_accept = (ImageButton) findViewById(R.id.panel_accept);
        ImageButton panel_delete = (ImageButton) findViewById(R.id.panel_delete);
        ImageButton panel_back = (ImageButton) findViewById(R.id.panel_backward);

        final TextView dateNow = (TextView) findViewById(R.id.dateNow);
        final TextView timeNow = (TextView) findViewById(R.id.timeNow);
        final TextView typeNow = (TextView) findViewById(R.id.typeNow);
        final TextView totalNow = (TextView) findViewById(R.id.totalNow);

        final EditText footNote = (EditText) findViewById(R.id.noteNow);
        final EditText countNow = (EditText) findViewById(R.id.countNow);

        final ImageButton workoutNow = (ImageButton) findViewById(R.id.workoutNow);
        final TextView workoutString = (TextView) findViewById(R.id.workoutString);

        loadCurrentChallenge(mSettings, mSettings.getInt("CURRENT_PAGE", 0), dateNow, timeNow, workoutNow, workoutString, typeNow, totalNow, footNote);

        panel_accept.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {

                                                if (!footNote.getText().toString().equals("")) {
                                                    SharedPreferences.Editor editor = mSettings.edit();
                                                    editor.putString(getCurrentPage(mSettings.getInt("CURRENT_PAGE", 0)) +
                                                            getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_FOOTNOTE", footNote.getText().toString());
                                                    editor.apply();
                                                }
                                                if (!countNow.getText().toString().equals("")) {
                                                    SharedPreferences.Editor editor = mSettings.edit();
                                                    editor.putInt(getCurrentPage(mSettings.getInt("CURRENT_PAGE", 0)) +
                                                            getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_COUNT", Integer.parseInt(countNow.getText().toString()));
                                                    editor.apply();
                                                }
                                                /*Intent intent = new Intent("android.intent.action.challengemenu");
                                                startActivity(intent);*/
                                            }
                                        }
        );

        panel_delete.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                vanishingChallenge(mSettings, mSettings.getInt("CURRENT_PAGE", 0));
                                                Intent intent = new Intent("android.intent.action.challengemenu");
                                                startActivity(intent);
                                            }
                                        }
        );

        panel_back.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              Intent intent = new Intent("android.intent.action.challengemenu");
                                              startActivity(intent);
                                          }
                                      }
        );
    }
}
