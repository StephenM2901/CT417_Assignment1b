/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.software_assignment_1b;

import com.mycompany.software_assignment_1.Course;
import com.mycompany.software_assignment_1.Module;
import com.mycompany.software_assignment_1.Student;
import java.util.ArrayList;

/**
 *
 * @author stephen murphy 17410394
 */
public class Driver {

    public static void main(String[] args) {
        //Courses Setup
        Course cs = new Course("Computer Science", "15/09/2020", "20/05/2021");
        Course ece = new Course("Electronic and Computer Engineering", "18/09/2020", "27/05/2021");
        
        Student student1 = new Student("Tom Smith", "15/01/1999", 21, 12345678);
        Student student2 = new Student("Sam Jones", "12/05/1998", 22, 34563785);
        Student student3 = new Student("Emily Black", "17/04/1998", 22, 34594321);
        Student student4 = new Student("Sarah Murphy", "24/09/2000", 21, 52735251);
        Student student5 = new Student("Tim O Shea", "09/12/1999", 20, 13486061);
        Student student6 = new Student("Rachel Kelly", "19/11/1998", 21, 19075098);
        
        //Students Setup
        ArrayList<Student> eceStudents = new ArrayList();
        eceStudents.add(student1);
        eceStudents.add(student2);
        eceStudents.add(student3);
        
        ArrayList<Student> csStudents = new ArrayList();
        csStudents.add(student4);
        csStudents.add(student5);
        csStudents.add(student6);
        
        //Modules Setup
        Module module1 = new Module("Software Engineering III", "CT417");
        Module module2 = new Module("Machine Learning", "CT4101");
        Module module3 = new Module("Digital Signal Processing", "EE445");
        Module module4 = new Module("SoC Design", "EE451");
        Module module5 = new Module("Programming", "CT432");
        
        ArrayList<Module> csModules = new ArrayList();
        csModules.add(module1);
        csModules.add(module2);
        csModules.add(module5);
        
        ArrayList<Module> eceModules = new ArrayList();
        eceModules.add(module1);
        eceModules.add(module2);
        eceModules.add(module3);
        eceModules.add(module4);
        
        for(Module i : eceModules) {
            i.addCourse(ece);
            ece.addModule(i);
            
            for(Student j : eceStudents) {
                j.addModule(i);
            }
        }
        
        for(Student i : eceStudents) {
            i.addCourse(ece);
            ece.addStudent(i);
        }
        
        
        for(Module i : csModules) {
            i.addCourse(cs);
            cs.addModule(i);
            
            for(Student j : csStudents) {
                j.addModule(i);
            }
        }
        
        for(Student i : csStudents) {
            i.addCourse(cs);
            cs.addStudent(i);
        }
        
        //Print info
        System.out.println(ece.getName() + " modules:");
        for(int i=0;i<ece.moduleCount();i++) {
            System.out.println(ece.getModule(i).getName());
        }
        
        System.out.println("\n" + cs.getName() + " modules:");
        for(int i=0;i<cs.moduleCount();i++) {
            System.out.println(cs.getModule(i).getName());
        }
        
        System.out.println("\nStudents:");
        
        for(Student i : csStudents) {
            System.out.println("\n" + i.getName() + "," + i.getUsername());
            
            System.out.println("Courses:");
            for(int j=0;j<i.courseCount();j++) {
                System.out.println(i.getCourse(j).getName());
            }
            System.out.println("Modules:");
            for(int j=0;j<i.moduleCount();j++) {
                System.out.println(i.getModule(j).getName());
            }
        }
        
        for(Student i : eceStudents) {
            System.out.println("\n" + i.getName() + "," + i.getUsername());
            
            System.out.println("Courses:");
            for(int j=0;j<i.courseCount();j++) {
                System.out.println(i.getCourse(j).getName());
            }
            System.out.println("Modules:");
            for(int j=0;j<i.moduleCount();j++) {
                System.out.println(i.getModule(j).getName());
            }
        }
        
    } 
}
