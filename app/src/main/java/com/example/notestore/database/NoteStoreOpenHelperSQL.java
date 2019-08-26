package com.example.notestore.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteStoreOpenHelperSQL extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "NoteStore.db";
    public static final int DATABASE_VRESION = 1;
    public NoteStoreOpenHelperSQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VRESION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(NoteStoreDatabaseContract.CourseInfoEntry.SQL_CREATE_TABLE);
        sqLiteDatabase.execSQL(NoteStoreDatabaseContract.NoteInfoEntry.SQL_CREATE_TABLE);

        DatabaseDataWorker worker = new DatabaseDataWorker(sqLiteDatabase);
        worker.insertCourses();
        worker.insertSampleNotes();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
