package com.example.roomdb;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewNotes extends Fragment {


    TextView viewData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_view_notes, container, false);
        viewData=v.findViewById(R.id.dataTx);

        List<Note> notes=MainActivity.myDataBase.myDOA().getNotes();

        String data="";

        for (Note note : notes)
        {
            String getNoteContent=note.getNoteContent();
            int getId=note.getId();

            data=data+"\n\n"+"ID : "+getId+"\n Note : "+getNoteContent;
        }
        viewData.setText(data);

        return v;
    }

}
