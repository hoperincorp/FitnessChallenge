package com.hoperincorp.android.fitnesschallenge.frames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.hoperincorp.android.fitnesschallenge.R;

import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.APP_PREFERENCES;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.debug;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentNoteName;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentPage;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.setChallengeName;

public class newChallengeFrame extends AppCompatActivity {
    private SharedPreferences mSettings;
    private String[] types = {"разы", "килограммы", "минуты", "километры"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_newchallenge);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        ImageButton panel_accept = (ImageButton) findViewById(R.id.panel_accept);
        ImageButton panel_back = (ImageButton) findViewById(R.id.panel_backward);

        final EditText challengeName = (EditText) findViewById(R.id.challengeName);
        final Spinner spinner = (Spinner) findViewById(R.id.types);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        debug(mSettings.getInt("CURRENT_NOTE", 0) + "");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                       long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(159, 112, 48));
                ((TextView) parent.getChildAt(0)).setBackground(new ColorDrawable(Color.rgb(240, 192, 96)));
                ((TextView) parent.getChildAt(0)).setTextSize(18);
                ((TextView) parent.getChildAt(0)).setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                /*String item = (String)parent.getItemAtPosition(position);
                selection.setText(item)*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        panel_accept.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                SharedPreferences.Editor editor = mSettings.edit();
                                                editor.putInt(getCurrentPage(mSettings.getInt("CURRENT_PAGE", 0)) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)), 1);
                                                editor.apply();

                                                setChallengeName(mSettings.getInt("CURRENT_PAGE", 0), mSettings, challengeName.getText().toString());
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
