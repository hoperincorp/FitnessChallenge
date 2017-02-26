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
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.hoperincorp.android.fitnesschallenge.R;

import java.util.ArrayList;

import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.APP_PREFERENCES;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.getCurrentPage;

/**
 * Created by laker on 26.02.2017.
 */

public class historyFrame extends AppCompatActivity {

    private SharedPreferences mSettings;
    private ArrayList<String> history = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_history);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        final ImageButton panel_backward = (ImageButton) findViewById(R.id.panel_backward);

        ListView listView = (ListView) findViewById(R.id.historyNow);

        final String[] challenges = new String[]{
                "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
                "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
                "Китти", "Масяня", "Симба"
        };


        int currentID = mSettings.getInt("CURRENT_ID", 0);

        for (int i = 0; i <= currentID; i++) {
            history.add(mSettings.getString(String.valueOf(i) + "_NAME", "Нет записи") + " " +
                    String.valueOf(mSettings.getInt(String.valueOf(i) + "_COUNT_NOW", 0)) + " " +
                    mSettings.getString(String.valueOf(i) + "_DATE", "14-Фев-1970") + " " +
                    mSettings.getString(String.valueOf(i) + "_TIME", "23:59"));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.listview_history, history);

        listView.setAdapter(adapter);

        panel_backward.setOnClickListener(new View.OnClickListener() {
                                              public void onClick(View v) {
                                                  Intent intent = new Intent("android.intent.action.lastdesktop");
                                                  startActivity(intent);
                                              }
                                          }
        );
    }
}
