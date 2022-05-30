package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        //TODO check if student ID already exist, if not 11add student object into HashMap
        if(!students.containsKey(student.getId())){
            students.put(student.getId(), student);
        }
        else System.out.println("Student ID already exist!");

    }

    public Student findStudent( String studentId )
    {
        //TODO find student in the Hashmap students and return the object
        if(students.containsKey(studentId))
            return students.get(studentId);
        return null;
    }

    public boolean showSummary() {
        //TODO display student information and list of enrolled courses

        if(!students.isEmpty()) {
            for (Student student : students.values()) {
                String str = "";
                str += student;
                str += printCoursesList(student);
                System.out.println(str);
            }
            return true;
        }

        return false;
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO add course to student
        students.get(studentId).enrollToCourse(course);

    }

    public String printCoursesList(Student student){
        String str = "";

        for (Course course : student.getEnrolledCourses()) {
            str += "\n" + course;
            double grade = student.getGrade(course.getCode());
            if(grade != -1){
                str += " Grade: " + grade;
            }
        }
        return str;
    }

}
