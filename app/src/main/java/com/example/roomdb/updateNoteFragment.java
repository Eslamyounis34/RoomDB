package com.example.roomdb;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class updateNoteFragment extends Fragment {


    EditText updatedNoteId,updatedNoteContent;
    Button update;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_update_note, container, false);
        updatedNoteId=v.findViewById(R.id.selectednotedupateid);
        updatedNoteContent=v.findViewById(R.id.selectednotedupatecontent);
        update=v.findViewById(R.id.submitupdate);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newNoteContent=updatedNoteContent.getText().toString();
                int id= Integer.parseInt(updatedNoteId.getText().toString());

                Note note=new Note();
                note.setNoteContent(newNoteContent);
                note.setId(id);
                MainActivity.myDataBase.myDOA().updateNote(note);

                Toast.makeText(getContext(), "Updated", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
