package com.example.roomdb;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddNoteFragment extends Fragment {

    EditText getNote;
    String noteContent="";
    FloatingActionButton save;
    public AddNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v=inflater.inflate(R.layout.fragment_add_user, container, false);

      getNote=v.findViewById(R.id.notedataet);
      save=v.findViewById(R.id.savebtn);






        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteContent=getNote.getText().toString();
                Note note=new Note();
                note.setNoteContent(noteContent);
                MainActivity.myDataBase.myDOA().addNote(note);
                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();

            }
        });

      return v;


    }
}
