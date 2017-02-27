package com.hoperincorp.android.fitnesschallenge.libraries;

import android.content.SharedPreferences;

import static com.hoperincorp.android.fitnesschallenge.libraries.noteLibrary.debug;

/**
 * Created by laker on 26.02.2017.
 */

public class historyLibrary {
    private static int currentID;

    //region ADD TO HISTORY

    public static void addToHistory(SharedPreferences mSettings, String date, String time,
                                    String name, String type, int color, int typeWorkout, int target, String footnote, int countNow) {
        currentID = mSettings.getInt("CURRENT_ID", -1);
        currentID++;
        debug(currentID + "");
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(String.valueOf(currentID) + "_NAME", name);
        editor.apply();
        editor.putString(String.valueOf(currentID) + "_TYPE", type);
        editor.apply();
        editor.putInt(String.valueOf(currentID) + "_COLOR", color);
        editor.apply();
        editor.putInt(String.valueOf(currentID) + "_WORK", typeWorkout);
        editor.apply();
        editor.putInt(String.valueOf(currentID) + "_TARGET", target);
        editor.apply();
        editor.putString(String.valueOf(currentID) + "_FOOTNOTE", footnote);
        editor.apply();
        editor.putString(String.valueOf(currentID) + "_DATE", date);
        editor.apply();
        editor.putString(String.valueOf(currentID) + "_TIME", time);
        editor.apply();
        editor.putInt(String.valueOf(currentID) + "_COUNT_NOW", countNow);
        editor.apply();

        editor.putInt("CURRENT_ID", currentID);
        editor.apply();
    }

    //endregion

    //region GET FROM HISTORY


    //endregion

}
