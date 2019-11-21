package com.example.practical6;

import java.util.ArrayList;

public class Student {
    int rollno,mark1,mark2,mark3,total;
    double avg;
    Student()
    {

    }
    Student(int rollno,int mark1,int mark2,int mark3)
    {
        this.rollno=rollno;
        this.mark1=mark1;
        this.mark2=mark2;
        this.mark3=mark3;
        total=(mark1+mark2+mark3);
        avg=total/3;
    }
     double Average(ArrayList<Student> stArray)
    {
        double classAvg=0;
        for(Student ob:stArray)
        {
            classAvg=classAvg+ob.avg;
        }
        return classAvg/stArray.size();
    }
    Student Min(ArrayList<Student> stArray)
    {
        int min=999;
        Student st=new Student();
        for(Student ob:stArray)
        {
            if(ob.total<min)
            {
                st=ob;
                min=ob.total;
            }
        }
        return st;
    }
    Student Max(ArrayList<Student> stArray)
    {
        int max=0;
        Student st=new Student();
        for(Student ob:stArray)
        {
            if(ob.total>max)
            {
                st=ob;
                max=ob.total;
            }
        }
        return st;
    }
    int aboveAvgStudent(double classAvg,ArrayList<Student> stArray)
    {
        int counter=0;
        for(Student ob:stArray)
        {
            if(ob.avg>classAvg)
                counter++;
        }
        return counter;
    }
    String data()
    {
        return "Roll no: "+rollno+"\nMark 1: "+mark1+"\nMark 2: "+mark2+"\nMark 3: "+mark3+"\nAverage: "+avg;
    }
}
