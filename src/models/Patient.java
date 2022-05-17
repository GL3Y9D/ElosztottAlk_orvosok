/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


/**
 *
 * @author fekabatman
 */
public class Patient{
    
    String name;
    String condition;
    int age;
    public Patient(String name,String condition,int age){
        this.name = name;
        this.condition = condition;
        this.age = age;
         
    }
    
    public String getCondition() {
        return condition;
    }
    
    public String getName() {
        return name;
    }
    public String setSickness(){
        String result = Math.random() > .1 ? "Egészséges" : "Beteg";
        this.condition = result;
        return this.condition;
    }
    public int getAge(){
        return age;
    }
}
