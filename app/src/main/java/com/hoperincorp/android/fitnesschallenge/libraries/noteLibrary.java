package com.hoperincorp.android.fitnesschallenge.libraries;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hoperincorp.android.fitnesschallenge.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by laker on 23.02.2017.
 */

public class noteLibrary {
    public static final String APP_PREFERENCES = "FitnessChallenger";

    //region VANISHING CHALLENGE

    public static void vanishingChallenge(SharedPreferences mSettings, int thisPage) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_NAME", "Нет записи");
        editor.apply();
        editor.putString(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_TYPE", "разы");
        editor.apply();
        editor.putInt(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_COLOR", 0);
        editor.apply();
        editor.putInt(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_WORK", 0);
        editor.apply();
        editor.putInt(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_TARGET", 999);
        editor.apply();
        editor.putInt(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_COUNT", 0);
        editor.apply();
        editor.putString(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_FOOTNOTE", "Примечание");
        editor.apply();
    }

    //endregion

    //region LOAD CURRENT CHALLENGE

    public static void loadCurrentChallenge(SharedPreferences mSettings, int thisPage, TextView cDate,
                                            TextView cTime, ImageButton cButton, TextView cString, TextView cType, TextView cTotal, TextView cFN) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        SimpleDateFormat data = new SimpleDateFormat("dd-MMM-yyyy");
        cDate.setText(data.format(c.getTime()));
        cTime.setText(time.format(c.getTime()));

        getCurrentColor(mSettings.getInt(getCurrentPage(mSettings.getInt("CURRENT_PAGE", 0)) +
                getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_COLOR", 0), cButton);

        getCurrentType(mSettings.getInt(getCurrentPage(mSettings.getInt("CURRENT_PAGE", 0)) +
                getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_WORK", 0), cButton);

        cString.setText(mSettings.getString(getCurrentPage(mSettings.getInt("CURRENT_PAGE", 0)) +
                getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_NAME", "Нет записи"));


        cType.setText(mSettings.getString(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_TYPE", "разы"));
        cTotal.setText(String.valueOf(mSettings.getInt(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_COUNT", 999)));
        cFN.setText(mSettings.getString(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_FOOTNOTE", "Примечание"));

    }

    //endregion

    //region SAVE NEW CHALLENGE

    public static void saveNewChallenge(SharedPreferences mSettings, int thisPage, String name, String type, int color, int typeWorkout, int target) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_NAME", name);
        editor.apply();
        editor.putString(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_TYPE", type);
        editor.apply();
        editor.putInt(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_COLOR", color);
        editor.apply();
        editor.putInt(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_WORK", typeWorkout);
        editor.apply();
        editor.putInt(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_TARGET", target);
        editor.apply();
        editor.putInt(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_COUNT", 0);
        editor.apply();
        editor.putString(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_FOOTNOTE", "Примечание");
        editor.apply();
    }

    //endregion

    //region GET CURRENT TYPE

    public static void getCurrentType(int thisWork, ImageButton imageButton) {
        switch (thisWork) {
            case 0:
                imageButton.setImageResource(0);
                break;
            case 1:
                imageButton.setImageResource(0);
                break;
            case 2:
                imageButton.setImageResource(R.mipmap.workout_1);
                break;
            case 3:
                imageButton.setImageResource(R.mipmap.workout_2);
                break;
            case 4:
                imageButton.setImageResource(R.mipmap.workout_3);
                break;
            case 5:
                imageButton.setImageResource(R.mipmap.workout_4);
                break;
            case 6:
                imageButton.setImageResource(R.mipmap.workout_5);
                break;
            case 7:
                imageButton.setImageResource(R.mipmap.workout_6);
                break;
            case 8:
                imageButton.setImageResource(R.mipmap.workout_7);
                break;
            case 9:
                imageButton.setImageResource(R.mipmap.workout_8);
                break;
            case 10:
                imageButton.setImageResource(R.mipmap.workout_9);
                break;
            case 11:
                imageButton.setImageResource(R.mipmap.workout_10);
                break;
            case 12:
                imageButton.setImageResource(R.mipmap.workout_11);
                break;
            case 13:
                imageButton.setImageResource(R.mipmap.workout_12);
                break;
            case 14:
                imageButton.setImageResource(R.mipmap.workout_13);
                break;
            case 15:
                imageButton.setImageResource(R.mipmap.workout_14);
                break;
            case 16:
                imageButton.setImageResource(R.mipmap.workout_15);
                break;
            case 17:
                imageButton.setImageResource(R.mipmap.workout_16);
                break;
            case 18:
                imageButton.setImageResource(R.mipmap.workout_17);
                break;
            case 19:
                imageButton.setImageResource(R.mipmap.workout_18);
                break;
            case 20:
                imageButton.setImageResource(R.mipmap.workout_19);
                break;
            case 21:
                imageButton.setImageResource(R.mipmap.workout_20);
                break;
            case 22:
                imageButton.setImageResource(R.mipmap.workout_21);
                break;
            case 23:
                imageButton.setImageResource(R.mipmap.workout_22);
                break;
            case 24:
                imageButton.setImageResource(R.mipmap.workout_23);
                break;
            case 25:
                imageButton.setImageResource(R.mipmap.workout_24);
                break;
            case 26:
                imageButton.setImageResource(R.mipmap.workout_25);
                break;
            case 27:
                imageButton.setImageResource(R.mipmap.workout_26);
                break;
            case 28:
                imageButton.setImageResource(R.mipmap.workout_27);
                break;
            case 29:
                imageButton.setImageResource(R.mipmap.workout_28);
                break;
            case 30:
                imageButton.setImageResource(R.mipmap.workout_29);
                break;
            case 31:
                imageButton.setImageResource(R.mipmap.workout_30);
                break;
            case 32:
                imageButton.setImageResource(R.mipmap.workout_31);
                break;
        }
    }

    //endregion

    //region GET CURRENT COLOR

    public static void getCurrentColor(int thisColor, ImageButton imageButton) {
        switch (thisColor) {
            case 0:
                imageButton.setBackgroundResource(R.mipmap.note_add_new_upgrade);
                break;
            case 1:
                imageButton.setBackgroundResource(R.mipmap.previewimage_default);
                break;
            case 2:
                imageButton.setBackgroundResource(R.mipmap.previewimage_blue);
                break;
            case 3:
                imageButton.setBackgroundResource(R.mipmap.previewimage_cyan);
                break;
            case 4:
                imageButton.setBackgroundResource(R.mipmap.previewimage_green);
                break;
            case 5:
                imageButton.setBackgroundResource(R.mipmap.previewimage_orange);
                break;
            case 6:
                imageButton.setBackgroundResource(R.mipmap.previewimage_purple);
                break;
            case 7:
                imageButton.setBackgroundResource(R.mipmap.previewimage_red);
                break;
            case 8:
                imageButton.setBackgroundResource(R.mipmap.previewimage_white);
                break;
            case 9:
                imageButton.setBackgroundResource(R.mipmap.previewimage_yellow);
                break;
        }
    }

    //endregion

    //region PAGER

    public static void pager(TextView currentPage, String text) {
        currentPage.setText(text);
    }


    //endregion


    //region GET CURRENT PAGE

    public static String getCurrentPage(int sCurrentPage) {
        String thisPage = "";
        switch (sCurrentPage) {
            case 1:
                thisPage = "FIRST_";
                break;
            case 2:
                thisPage = "SECOND_";
                break;
            case 3:
                thisPage = "THIRD_";
                break;
            case 4:
                thisPage = "FOURTH_";
                break;
            case 5:
                thisPage = "FIVTH_";
                break;
            case 6:
                thisPage = "SIXTH_";
                break;
            case 7:
                thisPage = "SEVENTH_";
                break;
            case 8:
                thisPage = "EIGHTH_";
                break;
            case 9:
                thisPage = "NINTH_";
                break;
        }
        return thisPage;
    }

    //endregion


    //region SAVE CURRENT PAGE

    public static void saveCurrentPage(SharedPreferences mSettings, String sCurrentPage) {
        SharedPreferences.Editor editor = mSettings.edit();
        switch (sCurrentPage) {
            case "FIRST_":
                editor.putInt("CURRENT_PAGE", 1);
                editor.apply();
                break;
            case "SECOND_":
                editor.putInt("CURRENT_PAGE", 2);
                editor.apply();
                break;
            case "THIRD_":
                editor.putInt("CURRENT_PAGE", 3);
                editor.apply();
                break;
            case "FOURTH_":
                editor.putInt("CURRENT_PAGE", 4);
                editor.apply();
                break;
            case "FIVTH_":
                editor.putInt("CURRENT_PAGE", 5);
                editor.apply();
                break;
            case "SIXTH_":
                editor.putInt("CURRENT_PAGE", 6);
                editor.apply();
                break;
            case "SEVENTH_":
                editor.putInt("CURRENT_PAGE", 7);
                editor.apply();
                break;
            case "EIGHTH_":
                editor.putInt("CURRENT_PAGE", 8);
                editor.apply();
                break;
            case "NINTH_":
                editor.putInt("CURRENT_PAGE", 9);
                editor.apply();
                break;
        }
    }

    //endregion

    //region TEST THIS PAGE

    public static String testThisPage(int currentPage) {
        String testPage = "";
        if (currentPage == 1) testPage = "FIRST_";
        else if (currentPage == 2) testPage = "SECOND_";
        return testPage;
    }

    //endregion


    //region SET CURRENT NOTE

    public static void setCurrentNote(SharedPreferences mSettings, String sCurrentNote) {
        SharedPreferences.Editor editor = mSettings.edit();
        switch (sCurrentNote) {
            case "FIRST_NOTE":
                editor.putInt("CURRENT_NOTE", 1);
                editor.apply();
                break;
            case "SECOND_NOTE":
                editor.putInt("CURRENT_NOTE", 2);
                editor.apply();
                break;
            case "THIRD_NOTE":
                editor.putInt("CURRENT_NOTE", 3);
                editor.apply();
                break;
            case "FOURTH_NOTE":
                editor.putInt("CURRENT_NOTE", 4);
                editor.apply();
                break;
            case "FIVTH_NOTE":
                editor.putInt("CURRENT_NOTE", 5);
                editor.apply();
                break;
            case "SIXTH_NOTE":
                editor.putInt("CURRENT_NOTE", 6);
                editor.apply();
                break;
            case "SEVENTH_NOTE":
                editor.putInt("CURRENT_NOTE", 7);
                editor.apply();
                break;
            case "EIGHTH_NOTE":
                editor.putInt("CURRENT_NOTE", 8);
                editor.apply();
                break;
            case "NINTH_NOTE":
                editor.putInt("CURRENT_NOTE", 9);
                editor.apply();
                break;
        }
    }

    //endregion

    //region GET CURRENT NOTE NAME

    public static String getCurrentNoteName(int currentNote) {
        String sCurrentNote = "";
        switch (currentNote) {
            case 1:
                sCurrentNote = "FIRST_NOTE";
                break;
            case 2:
                sCurrentNote = "SECOND_NOTE";
                break;
            case 3:
                sCurrentNote = "THIRD_NOTE";
                break;
            case 4:
                sCurrentNote = "FOURTH_NOTE";
                break;
            case 5:
                sCurrentNote = "FIVTH_NOTE";
                break;
            case 6:
                sCurrentNote = "SIXTH_NOTE";
                break;
            case 7:
                sCurrentNote = "SEVENTH_NOTE";
                break;
            case 8:
                sCurrentNote = "EIGHTH_NOTE";
                break;
            case 9:
                sCurrentNote = "NINTH_NOTE";
                break;
            case 0:
                sCurrentNote = "FIRST_NOTE";
                break;
        }
        return sCurrentNote;
    }

    //endregion

    //region GET EXIST NOTE
    public static void getExistNote(int thisPage, SharedPreferences mSettings, ImageButton note_first, ImageButton note_second, ImageButton note_third, ImageButton note_fourth,
                                    ImageButton note_fivth, ImageButton note_sixth, ImageButton note_seventh, ImageButton note_eighth, ImageButton note_ninth) {

        getCurrentColor(mSettings.getInt(getCurrentPage(thisPage) + "FIRST_NOTE" + "_COLOR", 0), note_first);
        getCurrentColor(mSettings.getInt(getCurrentPage(thisPage) + "SECOND_NOTE" + "_COLOR", 0), note_second);
        getCurrentColor(mSettings.getInt(getCurrentPage(thisPage) + "THIRD_NOTE" + "_COLOR", 0), note_third);
        getCurrentColor(mSettings.getInt(getCurrentPage(thisPage) + "FOURTH_NOTE" + "_COLOR", 0), note_fourth);
        getCurrentColor(mSettings.getInt(getCurrentPage(thisPage) + "FIVTH_NOTE" + "_COLOR", 0), note_fivth);
        getCurrentColor(mSettings.getInt(getCurrentPage(thisPage) + "SIXTH_NOTE" + "_COLOR", 0), note_sixth);
        getCurrentColor(mSettings.getInt(getCurrentPage(thisPage) + "SEVENTH_NOTE" + "_COLOR", 0), note_seventh);
        getCurrentColor(mSettings.getInt(getCurrentPage(thisPage) + "EIGHTH_NOTE" + "_COLOR", 0), note_eighth);
        getCurrentColor(mSettings.getInt(getCurrentPage(thisPage) + "NINTH_NOTE" + "_COLOR", 0), note_ninth);

        getCurrentType(mSettings.getInt(getCurrentPage(thisPage) + "FIRST_NOTE" + "_WORK", 0), note_first);
        getCurrentType(mSettings.getInt(getCurrentPage(thisPage) + "SECOND_NOTE" + "_WORK", 0), note_second);
        getCurrentType(mSettings.getInt(getCurrentPage(thisPage) + "THIRD_NOTE" + "_WORK", 0), note_third);
        getCurrentType(mSettings.getInt(getCurrentPage(thisPage) + "FOURTH_NOTE" + "_WORK", 0), note_fourth);
        getCurrentType(mSettings.getInt(getCurrentPage(thisPage) + "FIVTH_NOTE" + "_WORK", 0), note_fivth);
        getCurrentType(mSettings.getInt(getCurrentPage(thisPage) + "SIXTH_NOTE" + "_WORK", 0), note_sixth);
        getCurrentType(mSettings.getInt(getCurrentPage(thisPage) + "SEVENTH_NOTE" + "_WORK", 0), note_seventh);
        getCurrentType(mSettings.getInt(getCurrentPage(thisPage) + "EIGHTH_NOTE" + "_WORK", 0), note_eighth);
        getCurrentType(mSettings.getInt(getCurrentPage(thisPage) + "NINTH_NOTE" + "_WORK", 0), note_ninth);
    }

    //endregion

    //region GET EXIST NAME

    public static void getExistName(int thisPage, SharedPreferences mSettings, TextView nameFirst, TextView nameSecond, TextView nameThird,
                                    TextView nameFourth, TextView nameFivth, TextView nameSixth, TextView nameSeventh, TextView nameEighth, TextView nameNinth) {
        nameFirst.setText(mSettings.getString(getCurrentPage(thisPage) + "FIRST_NOTE_NAME", "Нет записи"));
        nameSecond.setText(mSettings.getString(getCurrentPage(thisPage) + "SECOND_NOTE_NAME", "Нет записи"));
        nameThird.setText(mSettings.getString(getCurrentPage(thisPage) + "THIRD_NOTE_NAME", "Нет записи"));
        nameFourth.setText(mSettings.getString(getCurrentPage(thisPage) + "FOURTH_NOTE_NAME", "Нет записи"));
        nameFivth.setText(mSettings.getString(getCurrentPage(thisPage) + "FIVTH_NOTE_NAME", "Нет записи"));
        nameSixth.setText(mSettings.getString(getCurrentPage(thisPage) + "SIXTH_NOTE_NAME", "Нет записи"));
        nameSeventh.setText(mSettings.getString(getCurrentPage(thisPage) + "SEVENTH_NOTE_NAME", "Нет записи"));
        nameEighth.setText(mSettings.getString(getCurrentPage(thisPage) + "EIGHTH_NOTE_NAME", "Нет записи"));
        nameNinth.setText(mSettings.getString(getCurrentPage(thisPage) + "NINTH_NOTE_NAME", "Нет записи"));
    }

    //endregion

    //region DEBUG

    public static void debug(String logger) {
        Log.d("debugLog:", logger + "");
    }

    //endregion

    //region CREATE FILLER

    public static void createFiller(SharedPreferences mSettings, String name, int number) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(name, number);
        editor.apply();
    }

    //endregion

    //region SET CHALLENGE NAME

    public static void setChallengeName(int thisPage, SharedPreferences mSettings, String name) {
        if ((name != null)) {
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString(getCurrentPage(thisPage) + getCurrentNoteName(mSettings.getInt("CURRENT_NOTE", 0)) + "_NAME", name);
            editor.apply();
        }
    }

    //endregion

}
