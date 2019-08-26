package com.example.notestore.database;

import android.provider.BaseColumns;

public final class NoteStoreDatabaseContract {
    private NoteStoreDatabaseContract(){}

    public static final class CourseInfoEntry implements BaseColumns {
        public static final String TABLE_NAME = "course_info";
        public static final String COLUMN_COURSE_ID = "course_id";
        public static final String COLUMN_COURSE_TITLE = "course_title";

        //CREATE TABLE course_info(_ID INTEGER PRIMARY KEY, course_id TEXT UNIQUE NOT NULL, course_title TEXT NOT NULL)

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME +
                            "(" +
                        _ID +
                            " INTEGER PRIMARY KEY, " +
                        COLUMN_COURSE_ID +
                            " TEXT UNIQUE NOT NULL, " +
                        COLUMN_COURSE_TITLE +
                            " TEXT NOT NULL)";
    }

    public static class NoteInfoEntry implements BaseColumns {
        public static final String TABLE_NAME = "note_info";
        public static final String COLUMN_NOTE_TITLE = "note_title";
        public static final String COLUMN_NOTE_TEXT = "note_text";
        public static final String COLUMN_COURSE_ID = "course_id";

        //CREATE TABLE note_info(_ID INTEGER PRIMARY KEY, note_title TEXT NOT NULL, note_text TEXT, course_id TEXT NOT NULL)

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME +
                            "(" +
                        _ID +
                        " INTEGER PRIMARY KEY, " +
                        COLUMN_NOTE_TITLE +
                            " TEXT NOT NULL, " +
                        COLUMN_NOTE_TEXT +
                            " TEXT, " +
                        COLUMN_COURSE_ID +
                            " TEXT NOT NULL)";
    }
}
