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
public class Doctor {
    
    String name;
    String specializatio;

    public Doctor(String name,String specializatio){;
        this.name = name;
        this.specializatio = specializatio;
       
    }
    
    public String getSpecializatio() {
        return specializatio;
    }
    
    public String getName() {
        return name;
    }

}
