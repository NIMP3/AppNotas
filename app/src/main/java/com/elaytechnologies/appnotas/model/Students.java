package com.elaytechnologies.appnotas.model;

import java.util.ArrayList;

public class Students {

    protected static ArrayList<Student> students = buildStudents();

    public Students() {
        students = buildStudents();
    }

    public static ArrayList<Student> buildStudents() {
        ArrayList list = new ArrayList();

        list.add(new Student(1,"1086434256","Martha Lucia","Suarez Jimenez","https://st2.depositphotos.com/1017986/11136/i/950/depositphotos_111368384-stock-photo-student-girl-with-group-of.jpg","martha@gmail.com","10", "F"));
        list.add(new Student(2,"1085145984","Carlos Joaquin","Ortega Tapia","https://www.tgh.org/sites/default/files/lunchbox871.jpg","carlosortega@gmail.com", "10", "M"));
        list.add(new Student(3,"1086233987","Jenny Lizeth","Salazar Ascuntar","https://www.paintlounge.ca/wp-content/uploads/2017/07/kids.jpg","jennysalazar@gmail.com", "10", "F"));
        list.add(new Student(4,"1087456097","Nathalia Katherine","Escobar Jimenez","http://littlebiblebuddies.com/wp-content/uploads/2010/10/bigstock_Student_Little_Girl_Reading_Wi_81482265.jpg","nathi@gmail.com", "10", "F"));
        list.add(new Student(5,"1085234092","Jesus Mateo","Suarez Noguera","https://321talentshowcase.com/wp-content/uploads/2012/10/Lucas-Sanson-Headshot-819x1024.jpg","jesusmat@gmail.com", "10", "M"));
        list.add(new Student(6,"1086498425","Carlos Efrain","Camues Bacca","https://previews.123rf.com/images/romrodinka/romrodinka1611/romrodinka161100450/66274521-frustrated-and-sad-little-kid-boy-with-glasses-and-lots-of-colorful-books-child-and-student-is-back-.jpg","carloscam@gmail.com", "10", "M"));
        list.add(new Student(7,"1081099452","Jhoana Marcela","Quintero Suarez","https://previews.123rf.com/images/oksun70/oksun701502/oksun70150200168/36675609-student-kid-girl-with-a-book-over-her-head-at-nursery.jpg","jhoanamarce@gmail.com", "10", "F"));
        list.add(new Student(8,"1079453324","Jessica Jhoana","Ortiz Quiroz","https://c8.alamy.com/comp/K6P1DM/smiling-indian-school-kid-girl-student-note-book-writing-studying-K6P1DM.jpg","jessi@gmail.com", "10", "F"));
        list.add(new Student(9,"1089456702","Juan Carlos","Orbes Montenegro","https://thumbs.dreamstime.com/b/asian-child-boy-student-s-uniform-acting-sawaddee-isolated-mean-hello-background-35224643.jpg","juanorbes@gmail.com", "10", "M"));

        return list;
    }
}
