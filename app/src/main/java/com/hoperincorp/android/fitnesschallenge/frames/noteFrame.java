package com.hoperincorp.android.fitnesschallenge.frames;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.hoperincorp.android.fitnesschallenge.R;

public class noteFrame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_note);

        ImageButton panel_accept = (ImageButton) findViewById(R.id.panel_accept);

        panel_accept.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                Intent intent = new Intent("android.intent.action.newchallenge");
                                                startActivity(intent);
                                            }
                                        }
        );
    }
}
