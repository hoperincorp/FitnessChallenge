package com.hoperincorp.android.fitnesschallenge.frames;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.hoperincorp.android.fitnesschallenge.R;

public class addNoteFrame extends AppCompatActivity {

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
    }
}
