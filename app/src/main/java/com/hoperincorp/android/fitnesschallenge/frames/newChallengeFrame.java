package com.hoperincorp.android.fitnesschallenge.frames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.hoperincorp.android.fitnesschallenge.R;

import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.APP_PREFERENCES;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.debug;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentNoteName;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.setChallengeName;

public class newChallengeFrame extends AppCompatActivity {
    private SharedPreferences mSettings;

    //region TEST NOTE

    private void testNote(String note) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(note, 1);
        editor.apply();
    }

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_newchallenge);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        ImageButton panel_accept = (ImageButton) findViewById(R.id.panel_accept);
        ImageButton panel_back = (ImageButton) findViewById(R.id.panel_backward);

        final EditText challengeName = (EditText) findViewById(R.id.challengeName);

        debug(mSettings.getInt("CURRENT_NOTE", 0) + "");

        panel_accept.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                testNote(getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)));
                                                setChallengeName(mSettings, challengeName.getText().toString());
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
