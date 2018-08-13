package com.elaytechnologies.appnotas.adapter;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.SeekBar;
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

@Layout(R.layout.cardview_student_qualify)

public class StudentQualifyAdapterSwipeView {

    @View(R.id.ivPictureStudent) private ImageView ivPictureStudent;
    @View(R.id.tvNameStudent) private TextView tvNameStudent;
    @View(R.id.tvIdStudent) private TextView tvIdStudent;
    @View(R.id.sbNote) private SeekBar sbNote;
    @View(R.id.tvNoteValue) private TextView tvNoteValue;


    private Student student;
    private Activity activity;
    private SwipePlaceHolderView swipePlaceHolderView;

    public StudentQualifyAdapterSwipeView(Student student, Activity activity, SwipePlaceHolderView swipePlaceHolderView) {
        this.student = student;
        this.activity = activity;
        this.swipePlaceHolderView = swipePlaceHolderView;
    }

    @Resolve
    private void onResolve() {
        Picasso.get()
                .load(student.getAvatarUser())
                .error(R.drawable.img_student_boy)
                .into(ivPictureStudent);

        tvNameStudent.setText(student.getNameUser());
        tvIdStudent.setText(student.getIdUser());

        sbNote.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float value = (float) i/10f;
                tvNoteValue.setText(String.valueOf(value));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @SwipeOut
    private void onSwipeOut() {swipePlaceHolderView.addView(this);}
    @SwipeIn
    private void onSwipeIn() {swipePlaceHolderView.addView(this);}
    @SwipeCancelState
    private void onSwipeCancelState() {}
    @SwipeInState
    private void onSwipeInState() {}
    @SwipeOutState
    private void onSwipeOutState() {}
}
