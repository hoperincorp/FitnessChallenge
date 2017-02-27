package com.hoperincorp.android.fitnesschallenge.frames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.hoperincorp.android.fitnesschallenge.R;

import static com.hoperincorp.android.fitnesschallenge.libraries.historyLibrary.removeFromHistory;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.APP_PREFERENCES;
import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.debug;

public class desktopFrame extends AppCompatActivity {
    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(177, 172, 169)));
        setContentView(R.layout.activity_desktop);

        ImageButton backward = (ImageButton) findViewById(R.id.panel_addnote);
        ImageButton history = (ImageButton) findViewById(R.id.panel_history);
        ImageButton last = (ImageButton) findViewById(R.id.panel_last);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        backward.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            Intent intent = new Intent("android.intent.action.challengemenu");
                                            startActivity(intent);
                                        }
                                    }
        );

        history.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.historychallenge");
                                            startActivity(intent);
                                        }
                                    }
        );

    }
}
