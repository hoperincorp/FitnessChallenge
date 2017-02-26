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
import android.widget.ImageButton;
import android.widget.TextView;

import com.hoperincorp.android.fitnesschallenge.R;
import com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary;

import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.APP_PREFERENCES;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.debug;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentNoteName;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getExistName;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getExistNote;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentPage;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.pager;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.saveCurrentPage;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.setCurrentNote;

public class challengesFrame extends AppCompatActivity {
    private SharedPreferences mSettings;
    private int workingPage = 1;


    @Override
    protected void onStop() {
        super.onStop();
        saveCurrentPage(mSettings, getCurrentPage(workingPage));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_challengemenu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        final ImageButton panel_backward = (ImageButton) findViewById(R.id.panel_backward);
        final ImageButton panel_next = (ImageButton) findViewById(R.id.panel_next);
        final ImageButton panel_prev = (ImageButton) findViewById(R.id.panel_prev);
        final TextView page = (TextView) findViewById(R.id.pageCurrent);

        final TextView nameFirst = (TextView) findViewById(R.id.name_first);
        final TextView nameSecond = (TextView) findViewById(R.id.name_second);
        final TextView nameThird = (TextView) findViewById(R.id.name_third);
        final TextView nameFourth = (TextView) findViewById(R.id.name_fourth);
        final TextView nameFivth = (TextView) findViewById(R.id.name_fifth);
        final TextView nameSixth = (TextView) findViewById(R.id.name_sixth);
        final TextView nameSeventh = (TextView) findViewById(R.id.name_seventh);
        final TextView nameEighth = (TextView) findViewById(R.id.name_eighth);
        final TextView nameNinth = (TextView) findViewById(R.id.name_ninth);

        final ImageButton note_first = (ImageButton) findViewById(R.id.note_first);
        final ImageButton note_second = (ImageButton) findViewById(R.id.note_second);
        final ImageButton note_third = (ImageButton) findViewById(R.id.note_third);
        final ImageButton note_fourth = (ImageButton) findViewById(R.id.note_fourth);
        final ImageButton note_fivth = (ImageButton) findViewById(R.id.note_fifth);
        final ImageButton note_sixth = (ImageButton) findViewById(R.id.note_sixth);
        final ImageButton note_seventh = (ImageButton) findViewById(R.id.note_seventh);
        final ImageButton note_eighth = (ImageButton) findViewById(R.id.note_eighth);
        final ImageButton note_ninth = (ImageButton) findViewById(R.id.note_ninth);

        getExistNote(mSettings.getInt("CURRENT_PAGE", 0), mSettings, note_first, note_second, note_third, note_fourth, note_fivth, note_sixth, note_seventh, note_eighth, note_ninth);
        getExistName(mSettings.getInt("CURRENT_PAGE", 0), mSettings, nameFirst, nameSecond, nameThird, nameFourth, nameFivth, nameSixth, nameSeventh, nameEighth, nameNinth);

        if (mSettings.getInt("CURRENT_PAGE", 0) == 0) {
            setCurrentNote(mSettings, "FIRST_NOTE");
            workingPage = 1;
            pager(page, workingPage + "");
        } else {
            workingPage = mSettings.getInt("CURRENT_PAGE", 0);
            pager(page, workingPage + "");
        }


        panel_backward.setOnClickListener(new View.OnClickListener() {
                                              public void onClick(View v) {
                                                  Intent intent = new Intent("android.intent.action.lastdesktop");
                                                  startActivity(intent);
                                              }
                                          }
        );

        panel_next.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              if ((workingPage >= 1) && (workingPage < 9)) workingPage++;
                                              page.setText(workingPage + "");
                                              getExistNote(workingPage, mSettings, note_first, note_second, note_third, note_fourth, note_fivth, note_sixth, note_seventh, note_eighth, note_ninth);
                                              getExistName(workingPage, mSettings, nameFirst, nameSecond, nameThird, nameFourth, nameFivth, nameSixth, nameSeventh, nameEighth, nameNinth);
                                              saveCurrentPage(mSettings, getCurrentPage(workingPage));
                                          }
                                      }
        );

        panel_prev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((workingPage > 1) && (workingPage <= 9)) workingPage--;
                page.setText(workingPage + "");
                getExistNote(workingPage, mSettings, note_first, note_second, note_third, note_fourth, note_fivth, note_sixth, note_seventh, note_eighth, note_ninth);
                getExistName(workingPage, mSettings, nameFirst, nameSecond, nameThird, nameFourth, nameFivth, nameSixth, nameSeventh, nameEighth, nameNinth);
                saveCurrentPage(mSettings, getCurrentPage(workingPage));
                                              }
                                          }
        );

        note_first.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              //createFiller(mSettings, "FIRST_NOTE", 0);
                                              setCurrentNote(mSettings, "FIRST_NOTE");
                                              if (mSettings.getInt(getCurrentPage(workingPage) + "FIRST_NOTE" + "_COLOR", 0) <= 0) {
                                                  Intent intent = new Intent("android.intent.action.newchallenge");
                                                  startActivity(intent);
                                              } else if (mSettings.getInt(getCurrentPage(workingPage) + "FIRST_NOTE", 0) > 0) {
                                                  Intent intent = new Intent("android.intent.action.trackchallenge");
                                                  startActivity(intent);
                                              }
                                          }
                                      }
        );
        note_second.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               //createFiller(mSettings, "SECOND_NOTE", 0);
                                               setCurrentNote(mSettings, "SECOND_NOTE");
                                               if (mSettings.getInt(getCurrentPage(workingPage) + "SECOND_NOTE" + "_COLOR", 0) <= 0) {
                                                   Intent intent = new Intent("android.intent.action.newchallenge");
                                                   startActivity(intent);
                                               } else if (mSettings.getInt(getCurrentPage(workingPage) + "SECOND_NOTE", 0) > 0) {
                                                   Intent intent = new Intent("android.intent.action.trackchallenge");
                                                   startActivity(intent);
                                               }
                                           }
                                       }
        );
        note_third.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              //createFiller(mSettings, "THIRD_NOTE", 0);
                                              setCurrentNote(mSettings, "THIRD_NOTE");
                                              if (mSettings.getInt(getCurrentPage(workingPage) + "THIRD_NOTE" + "_COLOR", 0) <= 0) {
                                                  Intent intent = new Intent("android.intent.action.newchallenge");
                                                  startActivity(intent);
                                              } else if (mSettings.getInt(getCurrentPage(workingPage) + "THIRD_NOTE", 0) > 0) {
                                                  Intent intent = new Intent("android.intent.action.trackchallenge");
                                                  startActivity(intent);
                                              }
                                          }
                                      }
        );
        note_fourth.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               //createFiller(mSettings, "FOURTH_NOTE", 0);
                                               setCurrentNote(mSettings, "FOURTH_NOTE");
                                               if (mSettings.getInt(getCurrentPage(workingPage) + "FOURTH_NOTE" + "_COLOR", 0) <= 0) {
                                                   Intent intent = new Intent("android.intent.action.newchallenge");
                                                   startActivity(intent);
                                               } else if (mSettings.getInt(getCurrentPage(workingPage) + "FOURTH_NOTE", 0) > 0) {
                                                   Intent intent = new Intent("android.intent.action.trackchallenge");
                                                   startActivity(intent);
                                               }
                                           }
                                       }
        );
        note_fivth.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              //createFiller(mSettings, "FIVTH_NOTE", 0);
                                              setCurrentNote(mSettings, "FIVTH_NOTE");
                                              if (mSettings.getInt(getCurrentPage(workingPage) + "FIVTH_NOTE" + "_COLOR", 0) <= 0) {
                                                  Intent intent = new Intent("android.intent.action.newchallenge");
                                                  startActivity(intent);
                                              } else if (mSettings.getInt(getCurrentPage(workingPage) + "FIVTH_NOTE", 0) > 0) {
                                                  Intent intent = new Intent("android.intent.action.trackchallenge");
                                                  startActivity(intent);
                                              }
                                          }
                                      }
        );
        note_sixth.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              //createFiller(mSettings, "SIXTH_NOTE", 0);
                                              setCurrentNote(mSettings, "SIXTH_NOTE");
                                              if (mSettings.getInt(getCurrentPage(workingPage) + "SIXTH_NOTE" + "_COLOR", 0) <= 0) {
                                                  Intent intent = new Intent("android.intent.action.newchallenge");
                                                  startActivity(intent);
                                              } else if (mSettings.getInt(getCurrentPage(workingPage) + "SIXTH_NOTE", 0) > 0) {
                                                  Intent intent = new Intent("android.intent.action.trackchallenge");
                                                  startActivity(intent);
                                              }
                                          }
                                      }
        );
        note_seventh.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                //createFiller(mSettings, "SEVENTH_NOTE", 0);
                                                setCurrentNote(mSettings, "SEVENTH_NOTE");
                                                if (mSettings.getInt(getCurrentPage(workingPage) + "SEVENTH_NOTE" + "_COLOR", 0) <= 0) {
                                                    Intent intent = new Intent("android.intent.action.newchallenge");
                                                    startActivity(intent);
                                                } else if (mSettings.getInt(getCurrentPage(workingPage) + "SEVENTH_NOTE", 0) > 0) {
                                                    Intent intent = new Intent("android.intent.action.trackchallenge");
                                                    startActivity(intent);
                                                }
                                            }
                                        }
        );
        note_eighth.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               //createFiller(mSettings, "EIGHTH_NOTE", 0);
                                               setCurrentNote(mSettings, "EIGHTH_NOTE");
                                               if (mSettings.getInt(getCurrentPage(workingPage) + "EIGHTH_NOTE" + "_COLOR", 0) <= 0) {
                                                   Intent intent = new Intent("android.intent.action.newchallenge");
                                                   startActivity(intent);
                                               } else if (mSettings.getInt(getCurrentPage(workingPage) + "EIGHTH_NOTE", 0) > 0) {
                                                   Intent intent = new Intent("android.intent.action.trackchallenge");
                                                   startActivity(intent);
                                               }
                                           }
                                       }
        );
        note_ninth.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              //createFiller(mSettings, "EIGHTH_NOTE", 0);
                                              setCurrentNote(mSettings, "NINTH_NOTE");
                                              if (mSettings.getInt(getCurrentPage(workingPage) + "NINTH_NOTE" + "_COLOR", 0) <= 0) {
                                                  Intent intent = new Intent("android.intent.action.newchallenge");
                                                  startActivity(intent);
                                              } else if (mSettings.getInt(getCurrentPage(workingPage) + "NINTH_NOTE", 0) > 0) {
                                                  Intent intent = new Intent("android.intent.action.trackchallenge");
                                                  startActivity(intent);
                                              }
                                          }
                                      }
        );
    }
}
