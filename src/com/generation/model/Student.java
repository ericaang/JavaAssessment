package com.generation.model;

import java.util.*;

public class Student
    extends Person
    implements Evaluation
{

    float PASS_MIN_GRADE = 3.0f;
    ArrayList<Course> enrolledCourses;
    HashMap<String, Double> courseGrade;

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
        enrolledCourses = new ArrayList<>();
        courseGrade = new HashMap<>();
    }

    public void enrollToCourse( Course course )
    {
        //TODO
        if(!enrolledCourses.contains(course)){
            enrolledCourses.add(course);
        }
    }

    @Override
    public List<Course> findPassedCourses()
    {
        ArrayList passCourses = new ArrayList<>();
        //TODO obtain list of courses that the student passed
        if (courseGrade != null){
            for (String courseId: courseGrade.keySet()){
                if (courseGrade.get(courseId) >= 3){
                    passCourses.add(findCourseById(courseId));
                }
            }

        }
        return passCourses;
    }

    public Course findCourseById( String courseId )
    {
        //TODO
       for( Course course: enrolledCourses){
           String courseCode = course.getCode();

           if (courseCode.equals(courseId)) {
               return course;
           }

        }

        return null;
    }

    @Override
    public List<Course> getEnrolledCourses()
    {
        //TODO
        return enrolledCourses;
    }

    public void setGrade(String courseId, double grade){
        if(courseGrade.containsKey(courseId))
        courseGrade.replace(courseId, grade);
        else courseGrade.put(courseId, grade);
    }
    public double getGrade(String courseId){
        if(courseGrade.containsKey(courseId))
            return courseGrade.get(courseId);
        else return -1;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
