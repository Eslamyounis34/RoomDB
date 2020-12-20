package com.example.roomdb;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    FloatingActionButton floatingActionButton;
    RecyclerView notesList;
    List<Note> notes;
    List<Note>getNotes;
    RecyclerViewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);

        floatingActionButton=v.findViewById(R.id.fab);
        notesList=v.findViewById(R.id.noteslistview);
        getNotes=new ArrayList<>();


        notes=MainActivity.myDataBase.myDOA().getNotes();
        for (Note note : notes)
        {
            getNotes.add(note);


        }
        //GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        notesList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getActivity(),getNotes);
        notesList.setAdapter(recyclerAdapter);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNoteFragment addNoteFragment=new AddNoteFragment();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.containerframelayout,addNoteFragment).addToBackStack(null).commit();
            }
        });


        return v;
    }

}
