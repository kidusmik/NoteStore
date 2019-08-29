package com.example.notestore.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notestore.Helpers.NoteInfo;
import com.example.notestore.R;
import com.example.notestore.activities.NoteActivity;
import com.example.notestore.database.NoteStoreDatabaseContract;
import com.example.notestore.database.NoteStoreDatabaseContract.NoteInfoEntry;

import java.util.List;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final LayoutInflater mlayoutInflater;
//    private final List<NoteInfo> mNotes;
    private Cursor mCursor;
    private int mCoursePos;
    private int mNoteTitlePos;
    private int mIdPos;

    public NoteRecyclerAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
        mlayoutInflater = LayoutInflater.from(mContext);
        populateColumnPositions();
    }

    private void populateColumnPositions() {
        if(mCursor == null)
            return;

        mCoursePos = mCursor.getColumnIndex(NoteInfoEntry.COLUMN_COURSE_ID);
        mNoteTitlePos = mCursor.getColumnIndex(NoteInfoEntry.COLUMN_NOTE_TITLE);
        mIdPos = mCursor.getColumnIndex(NoteInfoEntry._ID);

    }

    public void changeCursor(Cursor cursor){
        if(mCursor!=null)
            mCursor.close();

        mCursor = cursor;
        populateColumnPositions();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mlayoutInflater.inflate(R.layout.item_note_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        String course = mCursor.getString(mCoursePos);
        String noteTitle = mCursor.getString(mNoteTitlePos);
        int id = mCursor.getInt(mIdPos);
//        NoteInfo note = mNotes.get(position);
        holder.mTextCourse.setText(course);
        holder.mTextTitle.setText(noteTitle);
        holder.mId = id;
    }

    @Override
    public int getItemCount()
    {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mTextCourse;
        public final TextView mTextTitle;
        public int mId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextCourse = itemView.findViewById(R.id.course_note_list);
            mTextTitle = itemView.findViewById(R.id.title_note_list);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, NoteActivity.class);
//                    intent.putExtra(NoteActivity.NOTE_ID, mId);
                    intent.putExtra(NoteActivity.NOTE_ID, mId);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
