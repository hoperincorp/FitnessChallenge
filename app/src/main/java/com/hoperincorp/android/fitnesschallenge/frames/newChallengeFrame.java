package com.hoperincorp.android.fitnesschallenge.frames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
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
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentColor;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentNoteName;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentPage;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentType;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.saveNewChallenge;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.setChallengeName;

public class newChallengeFrame extends AppCompatActivity {
    private SharedPreferences mSettings;
    private String[] types = {"разы", "килограммы", "минуты", "километры"};
    private boolean isType = false, isColor = false;

    private int currentColor = 1, workoutType = 1, currentTarget = 1;
    private String currentName = "null", currentType = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_newchallenge);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        ImageButton panel_accept = (ImageButton) findViewById(R.id.panel_accept);
        ImageButton panel_back = (ImageButton) findViewById(R.id.panel_backward);

        final ImageButton color_select = (ImageButton) findViewById(R.id.colorSelect);
        final ImageButton color_preview = (ImageButton) findViewById(R.id.colorPreview);
        final ImageButton type_select = (ImageButton) findViewById(R.id.typeSelect);
        final ImageButton type_preview = (ImageButton) findViewById(R.id.typePreview);
        final ImageButton support_next = (ImageButton) findViewById(R.id.supportNext);
        final ImageButton support_prev = (ImageButton) findViewById(R.id.supportPrev);


        final EditText challengeName = (EditText) findViewById(R.id.challengeName);
        final EditText target = (EditText) findViewById(R.id.target);
        final Spinner spinner = (Spinner) findViewById(R.id.types);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        debug(mSettings.getInt("CURRENT_NOTE", 0) + "");

        color_select.setVisibility(View.INVISIBLE);
        type_select.setVisibility(View.INVISIBLE);

        //region SPINNER
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position,
                                       long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(159, 112, 48));
                ((TextView) parent.getChildAt(0)).setBackground(new ColorDrawable(Color.rgb(240, 192, 96)));
                ((TextView) parent.getChildAt(0)).setTextSize(18);
                ((TextView) parent.getChildAt(0)).setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                currentType = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //endregion

        support_next.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                if (isColor && !isType) {
                                                    if ((currentColor >= 1) && (currentColor < 9)) currentColor++;
                                                    getCurrentColor(currentColor, color_preview);
                                                    getCurrentColor(currentColor, type_preview);

                                                } else if (!isColor && isType) {
                                                    if ((workoutType >= 1) && (workoutType < 32))
                                                        workoutType++;
                                                    getCurrentType(workoutType, type_preview);
                                                }
                                            }
                                        }
        );

        support_prev.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                if (isColor && !isType) {
                                                    if ((currentColor > 1) && (currentColor <= 9)) currentColor--;
                                                    getCurrentColor(currentColor, color_preview);
                                                    getCurrentColor(currentColor, type_preview);

                                                } else if (!isColor && isType) {
                                                    if ((workoutType > 1) && (workoutType <= 32))
                                                        workoutType--;
                                                    getCurrentType(workoutType, type_preview);
                                                }
                                            }
                                        }
        );

        color_preview.setOnClickListener(new View.OnClickListener() {
                                             public void onClick(View v) {
                                                 color_select.setVisibility(View.VISIBLE);
                                                 type_select.setVisibility(View.INVISIBLE);

                                                 support_next.setBackgroundResource(R.mipmap.panel_support_next);
                                                 support_prev.setBackgroundResource(R.mipmap.panel_support_prev);

                                                 isColor = true;
                                                 isType = false;
                                             }
                                         }
        );

        type_preview.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                color_select.setVisibility(View.INVISIBLE);
                                                type_select.setVisibility(View.VISIBLE);

                                                support_next.setBackgroundResource(R.mipmap.panel_support_next);
                                                support_prev.setBackgroundResource(R.mipmap.panel_support_prev);

                                                isType = true;
                                                isColor = false;
                                            }
                                        }
        );

        panel_accept.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                SharedPreferences.Editor editor = mSettings.edit();
                                                editor.putInt(getCurrentPage(mSettings.getInt("CURRENT_PAGE", 0)) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)), 1);
                                                editor.apply();

                                                setChallengeName(mSettings.getInt("CURRENT_PAGE", 0), mSettings, challengeName.getText().toString());

                                                debug("OIL " + challengeName.getText().toString() + " + " + target.getText().toString());
                                                if ((!challengeName.getText().toString().equals("")) && (!target.getText().toString().equals(""))) {
                                                    saveNewChallenge(mSettings, mSettings.getInt("CURRENT_PAGE", 0),
                                                            challengeName.getText().toString(), currentType, currentColor, workoutType, Integer.parseInt(target.getText().toString()));

                                                    Intent intent = new Intent("android.intent.action.challengemenu");
                                                    startActivity(intent);
                                                }
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
