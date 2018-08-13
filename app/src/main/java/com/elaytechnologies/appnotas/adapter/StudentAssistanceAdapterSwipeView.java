package com.elaytechnologies.appnotas.adapter;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.model.Student;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.squareup.picasso.Picasso;

@Layout(R.layout.cardview_student_assistance)

public class StudentAssistanceAdapterSwipeView {

    @View(R.id.ivPictureStudent) private ImageView ivPictureStudent;
    @View(R.id.tvNameStudent) private TextView tvNameStudent;
    @View(R.id.tvIdStudent) private TextView tvIdStudent;
    @View(R.id.tvTypeAssistance) private TextView tvTypeAssistance;
    @View(R.id.tvNumberStudent) private TextView tvNumberStudent;
    @View(R.id.cbStatusAssistance) private TextView cbStatusAssistance;


    private Student student;
    //private Assistance assistance;
    private Activity activity;
    private SwipePlaceHolderView swipePlaceHolderView;
    private int position;

    public StudentAssistanceAdapterSwipeView(Student student, Activity activity, SwipePlaceHolderView swipePlaceHolderView, int position) {
        this.student = student;
        this.activity = activity;
        this.swipePlaceHolderView = swipePlaceHolderView;
        this.position = position;
    }

    @Resolve
    private void onResolve() {
        Picasso.get()
                .load(student.getAvatarUser())
                .error(R.drawable.img_student_boy)
                .into(ivPictureStudent);

        tvNameStudent.setText(student.getNameUser());
        tvIdStudent.setText(student.getIdUser());

        tvNumberStudent.setText(String.valueOf(position));
    }

    @SwipeOut private void onSwipeOut() {swipePlaceHolderView.addView(this);}
    @SwipeIn private void onSwipeIn() {swipePlaceHolderView.addView(this);}
    @SwipeCancelState private void onSwipeCancelState() {}
    @SwipeInState private void onSwipeInState() {}
    @SwipeOutState private void onSwipeOutState() {}
}
