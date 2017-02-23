package com.hoperincorp.android.fitnesschallenge.frames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hoperincorp.android.fitnesschallenge.R;
import com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary;

import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.APP_PREFERENCES;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.debug;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getExistName;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getExistNote;

public class challengesFrame extends AppCompatActivity {
    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_challengemenu);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        final ImageButton panel_backward = (ImageButton) findViewById(R.id.panel_backward);

        TextView nameFirst = (TextView) findViewById(R.id.name_first);
        TextView nameSecond = (TextView) findViewById(R.id.name_second);
        TextView nameThird = (TextView) findViewById(R.id.name_third);
        TextView nameFourth = (TextView) findViewById(R.id.name_fourth);
        TextView nameFivth = (TextView) findViewById(R.id.name_fifth);
        TextView nameSixth = (TextView) findViewById(R.id.name_sixth);
        TextView nameSeventh = (TextView) findViewById(R.id.name_seventh);
        TextView nameEighth = (TextView) findViewById(R.id.name_eighth);
        TextView nameNinth = (TextView) findViewById(R.id.name_ninth);

        ImageButton note_first = (ImageButton) findViewById(R.id.note_first);
        ImageButton note_second = (ImageButton) findViewById(R.id.note_second);
        ImageButton note_third = (ImageButton) findViewById(R.id.note_third);
        ImageButton note_fourth = (ImageButton) findViewById(R.id.note_fourth);
        ImageButton note_fivth = (ImageButton) findViewById(R.id.note_fifth);
        ImageButton note_sixth = (ImageButton) findViewById(R.id.note_sixth);
        ImageButton note_seventh = (ImageButton) findViewById(R.id.note_seventh);
        ImageButton note_eighth = (ImageButton) findViewById(R.id.note_eighth);
        ImageButton note_ninth = (ImageButton) findViewById(R.id.note_ninth);

        getExistNote(mSettings, note_first, note_second, note_third, note_fourth, note_fivth, note_sixth, note_seventh, note_eighth, note_ninth);
        getExistName(mSettings, nameFirst, nameSecond, nameThird, nameFourth, nameFivth, nameSixth, nameSeventh, nameEighth, nameNinth);

        panel_backward.setOnClickListener(new View.OnClickListener() {
                                              public void onClick(View v) {
                                                  Intent intent = new Intent("android.intent.action.lastdesktop");
                                                  startActivity(intent);
                                              }
                                          }
        );

        note_first.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              //createFiller(mSettings, "FIRST_NOTE", 0);
                                              noteLibrary.setCurrentNote(mSettings, "FIRST_NOTE");
                                              debug(mSettings.getInt("FIRST_NOTE", 0) + "");
                                              if (mSettings.getInt("FIRST_NOTE", 0) <= 0) {
                                                  Intent intent = new Intent("android.intent.action.newchallenge");
                                                  startActivity(intent);
                                              } else if (mSettings.getInt("FIRST_NOTE", 0) > 0) {
                                                  Intent intent = new Intent("android.intent.action.trackchallenge");
                                                  startActivity(intent);
                                              }
                                          }
                                      }
        );
        note_second.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               //createFiller(mSettings, "SECOND_NOTE", 0);
                                               noteLibrary.setCurrentNote(mSettings, "SECOND_NOTE");
                                               debug(mSettings.getInt("SECOND_NOTE", 0) + "");
                                               if (mSettings.getInt("SECOND_NOTE", 0) <= 0) {
                                                   Intent intent = new Intent("android.intent.action.newchallenge");
                                                   startActivity(intent);
                                               } else if (mSettings.getInt("SECOND_NOTE", 0) > 0) {
                                                   Intent intent = new Intent("android.intent.action.trackchallenge");
                                                   startActivity(intent);
                                               }
                                           }
                                       }
        );
        note_third.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              //createFiller(mSettings, "THIRD_NOTE", 0);
                                              noteLibrary.setCurrentNote(mSettings, "THIRD_NOTE");
                                              debug(mSettings.getInt("THIRD_NOTE", 0) + "");
                                              if (mSettings.getInt("THIRD_NOTE", 0) <= 0) {
                                                  Intent intent = new Intent("android.intent.action.newchallenge");
                                                  startActivity(intent);
                                              } else if (mSettings.getInt("THIRD_NOTE", 0) > 0) {
                                                  Intent intent = new Intent("android.intent.action.trackchallenge");
                                                  startActivity(intent);
                                              }
                                          }
                                      }
        );
        note_fourth.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               //createFiller(mSettings, "FOURTH_NOTE", 0);
                                               noteLibrary.setCurrentNote(mSettings, "FOURTH_NOTE");
                                               debug(mSettings.getInt("FOURTH_NOTE", 0) + "");
                                               if (mSettings.getInt("FOURTH_NOTE", 0) <= 0) {
                                                   Intent intent = new Intent("android.intent.action.newchallenge");
                                                   startActivity(intent);
                                               } else if (mSettings.getInt("FOURTH_NOTE", 0) > 0) {
                                                   Intent intent = new Intent("android.intent.action.trackchallenge");
                                                   startActivity(intent);
                                               }
                                           }
                                       }
        );
        note_fivth.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              //createFiller(mSettings, "FIVTH_NOTE", 0);
                                              noteLibrary.setCurrentNote(mSettings, "FIVTH_NOTE");
                                              debug(mSettings.getInt("FIVTH_NOTE", 0) + "");
                                              if (mSettings.getInt("FIVTH_NOTE", 0) <= 0) {
                                                  Intent intent = new Intent("android.intent.action.newchallenge");
                                                  startActivity(intent);
                                              } else if (mSettings.getInt("FIVTH_NOTE", 0) > 0) {
                                                  Intent intent = new Intent("android.intent.action.trackchallenge");
                                                  startActivity(intent);
                                              }
                                          }
                                      }
        );
        note_sixth.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              //createFiller(mSettings, "SIXTH_NOTE", 0);
                                              noteLibrary.setCurrentNote(mSettings, "SIXTH_NOTE");
                                              debug(mSettings.getInt("SIXTH_NOTE", 0) + "");
                                              if (mSettings.getInt("SIXTH_NOTE", 0) <= 0) {
                                                  Intent intent = new Intent("android.intent.action.newchallenge");
                                                  startActivity(intent);
                                              } else if (mSettings.getInt("SIXTH_NOTE", 0) > 0) {
                                                  Intent intent = new Intent("android.intent.action.trackchallenge");
                                                  startActivity(intent);
                                              }
                                          }
                                      }
        );
        note_seventh.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                //createFiller(mSettings, "SEVENTH_NOTE", 0);
                                                noteLibrary.setCurrentNote(mSettings, "SEVENTH_NOTE");
                                                debug(mSettings.getInt("SEVENTH_NOTE", 0) + "");
                                                if (mSettings.getInt("SEVENTH_NOTE", 0) <= 0) {
                                                    Intent intent = new Intent("android.intent.action.newchallenge");
                                                    startActivity(intent);
                                                } else if (mSettings.getInt("SEVENTH_NOTE", 0) > 0) {
                                                    Intent intent = new Intent("android.intent.action.trackchallenge");
                                                    startActivity(intent);
                                                }
                                            }
                                        }
        );
        note_eighth.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               //createFiller(mSettings, "EIGHTH_NOTE", 0);
                                               noteLibrary.setCurrentNote(mSettings, "EIGHTH_NOTE");
                                               debug(mSettings.getInt("EIGHTH_NOTE", 0) + "");
                                               if (mSettings.getInt("EIGHTH_NOTE", 0) <= 0) {
                                                   Intent intent = new Intent("android.intent.action.newchallenge");
                                                   startActivity(intent);
                                               } else if (mSettings.getInt("EIGHTH_NOTE", 0) > 0) {
                                                   Intent intent = new Intent("android.intent.action.trackchallenge");
                                                   startActivity(intent);
                                               }
                                           }
                                       }
        );
        note_ninth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //createFiller(mSettings, "NINTH_NOTE", 0);
                noteLibrary.setCurrentNote(mSettings, "NINTH_NOTE");
                debug(mSettings.getInt("NINTH_NOTE", 0) + "");
                if (mSettings.getInt("NINTH_NOTE", 0) <= 0) {
                    Intent intent = new Intent("android.intent.action.newchallenge");
                                                  startActivity(intent);
                                              } else if (mSettings.getInt("NINTH_NOTE", 0) > 0) {
                    Intent intent = new Intent("android.intent.action.trackchallenge");
                    startActivity(intent);
                }
                                          }
                                      }
        );
    }
}
