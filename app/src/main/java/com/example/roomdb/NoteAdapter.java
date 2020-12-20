package com.example.roomdb;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends BaseAdapter {
    Activity activity ;
    List<Note> notes ;

    public NoteAdapter(Activity activity, List<Note> notes) {
        this.activity = activity;
        this.notes = notes;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.note_row,null);
        TextView note=v.findViewById(R.id.notetext);
        note.setText(notes.get(position).getNoteContent());

        return v;
    }
}
