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
public class DeleteNoteFragment extends Fragment {
    EditText idEditText;
    Button deleteBt;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_delete_note, container, false);
        idEditText=v.findViewById(R.id.idofdeletednote);
        deleteBt=v.findViewById(R.id.submetDeleteBT);

        deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= Integer.parseInt(idEditText.getText().toString());
                Note note=new Note();
                note.setId(id);

                MainActivity.myDataBase.myDOA().deleteNote(note);
                Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();

            }
        });

        return v;
    }

}
