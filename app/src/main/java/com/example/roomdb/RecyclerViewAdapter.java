package com.example.roomdb;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder>{
    Activity activity ;
    List<Note> notes ;

    public RecyclerViewAdapter(Activity activity, List<Note> notes) {
        this.activity = activity;
        this.notes = notes;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(activity).inflate(R.layout.note_row,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {


        holder.tx.setText(notes.get(position).getNoteContent());

        holder.rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity,NoteActivity.class);
                intent.putExtra("SendContent",notes.get(position).getNoteContent());
                intent.putExtra("SendID",notes.get(position).getId());
                activity.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rv;
        TextView tx;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
          rv =itemView.findViewById(R.id.relativenoteitem);
          tx =itemView.findViewById(R.id.notetext);
        }
    }
}
