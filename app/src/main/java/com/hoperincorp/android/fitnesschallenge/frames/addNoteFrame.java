package com.hoperincorp.android.fitnesschallenge.frames;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.hoperincorp.android.fitnesschallenge.R;

public class addNoteFrame extends AppCompatActivity {
    private SharedPreferences mSettings;

    //region SET CURRENT PROFILE

    private void setCurrentProfile(String sCurrentProfile) {
        SharedPreferences.Editor editor = mSettings.edit();
        switch (sCurrentProfile) {
            case "FIRST_PROFILE":
                editor.putInt("CURRENT_PROFILE", 1);
                editor.apply();
                break;
            case "SECOND_PROFILE":
                editor.putInt("CURRENT_PROFILE", 2);
                editor.apply();
                break;
            case "THIRD_PROFILE":
                editor.putInt("CURRENT_PROFILE", 3);
                editor.apply();
                break;
            case "FOURTH_PROFILE":
                editor.putInt("CURRENT_PROFILE", 4);
                editor.apply();
                break;
            case "FIVTH_PROFILE":
                editor.putInt("CURRENT_PROFILE", 5);
                editor.apply();
                break;
            case "SIXTH_PROFILE":
                editor.putInt("CURRENT_PROFILE", 6);
                editor.apply();
                break;
            case "SEVENTH_PROFILE":
                editor.putInt("CURRENT_PROFILE", 7);
                editor.apply();
                break;
            case "EIGHTH_PROFILE":
                editor.putInt("CURRENT_PROFILE", 8);
                editor.apply();
                break;
        }
    }

    //endregion

    //region DEBUGG

    private void debugg(String name, int number) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(name, number);
        editor.apply();
    }

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_addnote);

        final ImageButton panel_backward = (ImageButton) findViewById(R.id.panel_back);

        ImageButton note_first = (ImageButton) findViewById(R.id.note_first);
        ImageButton note_second = (ImageButton) findViewById(R.id.note_second);
        ImageButton note_third = (ImageButton) findViewById(R.id.note_third);
        ImageButton note_fourth = (ImageButton) findViewById(R.id.note_fourth);
        ImageButton note_fivth = (ImageButton) findViewById(R.id.note_fifth);
        ImageButton note_sixth = (ImageButton) findViewById(R.id.note_sixth);
        ImageButton note_seventh = (ImageButton) findViewById(R.id.note_seventh);
        ImageButton note_eighth = (ImageButton) findViewById(R.id.note_eighth);
        ImageButton note_nineth = (ImageButton) findViewById(R.id.note_ninth);

        panel_backward.setOnClickListener(new View.OnClickListener() {
                                              public void onClick(View v) {
                                                  Intent intent = new Intent("android.intent.action.lastdesktop");
                                                  startActivity(intent);
                                              }
                                          }
        );

        note_first.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              debugg("FIRST_PROFILE", 0);
                                              setCurrentProfile("FIRST_NOTE");
                                              if (mSettings.getInt("FIRST_NOTE", 0) > 0) {
                                                  Intent intent = new Intent("android.intent.action.note");
                                                  startActivity(intent);
                                              }
                                          }
                                      }
        );
    }
}
