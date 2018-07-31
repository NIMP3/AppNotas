package com.elaytechnologies.appnotas.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.model.Task;
import com.elaytechnologies.appnotas.view.ContainerTaskActivity;

import java.util.ArrayList;

public class TaskAdapterRecyclerView extends RecyclerView.Adapter<TaskAdapterRecyclerView.TaskViewHolder>{

    private ArrayList<Task> tasks;
    private int resource;
    private Activity activity;

    public TaskAdapterRecyclerView(ArrayList<Task> tasks, int resource, Activity activity) {
        this.tasks = tasks;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        final Task task = tasks.get(position);

        holder.textViewTypeTask.setText(task.getTypeTask());
        holder.textViewDescriptionTaks.setText(task.getDescriptionTask());

        switch (task.getTypeTask()){
            case "EXAMEN":
                holder.textViewStampTask.setBackgroundColor(activity.getResources().getColor(R.color.colorTypeTaskTest));
                break;
            case "TRABAJO":
                holder.textViewStampTask.setBackgroundColor(activity.getResources().getColor(R.color.colorTypeTaskWork));
                break;
            case "EXPOSICIÓN":
                holder.textViewStampTask.setBackgroundColor(activity.getResources().getColor(R.color.colorTypeTaskExpo));
                break;
        }

        //Evento OnClick sobre una Actividad = Descripción detallada de la actividad seleccionada
        holder.cardViewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ContainerTaskActivity.class);
                intent.putExtra("type",task.getTypeTask()); //Titulo del nuevo Activity
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        private CardView cardViewTask;
        private TextView textViewStampTask;
        private TextView textViewTypeTask;
        private TextView textViewDescriptionTaks;

        public TaskViewHolder(View itemView) {
            super(itemView);

            cardViewTask = itemView.findViewById(R.id.cardviewTask);
            textViewStampTask = itemView.findViewById(R.id.textViewStampTask);
            textViewTypeTask = itemView.findViewById(R.id.textViewTypeTask);
            textViewDescriptionTaks = itemView.findViewById(R.id.textViewDescriptionTask);

        }
    }
}
