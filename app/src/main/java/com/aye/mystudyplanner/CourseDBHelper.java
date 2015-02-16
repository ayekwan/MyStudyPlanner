package com.aye.mystudyplanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by student on 2/16/15 AD.
 */
public class CourseDBHelper extends SQLiteOpenHelper {

    private static final String name = "courses.sqlite3";
    private static final int version = 2;


    public CourseDBHelper(Context ctx) {
        super(ctx, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE course (" +
                "_id integer primary key autoincrement," +
                "code text not null," +             // course code
                "name text not null," +             // course name
                "midterm text not null," +
                "final text not null);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS course;";
        db.execSQL(sql);
        this.onCreate(db);
    }
}

