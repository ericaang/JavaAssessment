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
        enrolledCourses = new ArrayList<>();    // stores the courses enrolled by the student
        courseGrade = new HashMap<>();          // stores the grade for the enrolled courses
    }

    public void enrollToCourse( Course course )
    {
        //TODO add course to the enrolledCourses ArrayList
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
        //TODO return the course that corresponds to the courseId provided
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
        //TODO return the list of courses enrolled
        return enrolledCourses;
    }
    //This function sets the grade for the course and stores in the courseGrade HashMap
    public void setGrade(String courseId, double grade){
        if(courseGrade.containsKey(courseId))
        courseGrade.replace(courseId, grade);
        else courseGrade.put(courseId, grade);
    }
    //This function gets the grade for the course
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
