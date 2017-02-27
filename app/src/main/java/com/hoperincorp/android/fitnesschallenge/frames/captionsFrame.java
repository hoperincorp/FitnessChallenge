package com.hoperincorp.android.fitnesschallenge.frames;

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

/**
 * Created by laker on 27.02.2017.
 */

public class captionsFrame extends AppCompatActivity {

    private SharedPreferences mSettings;
    private ArrayList<String> history = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_captions);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final ImageButton panel_backward = (ImageButton) findViewById(R.id.panel_backward);

        panel_backward.setOnClickListener(new View.OnClickListener() {
                                              public void onClick(View v) {
                                                  Intent intent = new Intent("android.intent.action.challengemenu");
                                                  startActivity(intent);
                                              }
                                          }
        );

        ListView listView = (ListView) findViewById(R.id.captionsNow);

        final String[] peoples = new String[]{
                "Hea Poh Lin",
                "Stock Image Folio",
                "Gan Khoon Lay",
                "Andrea Nobis",
                "AlfredoCreates.com",
                "Arunkumar",
                "Matthew Brinkley",
                "aguycalledgary",
                "icon 54",
                "lastpark",
                "for more info about autors please visit:",
                "https://thenounproject.com"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.listview_history, peoples);

        listView.setAdapter(adapter);

    }
}
