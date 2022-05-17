/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Random;
import java.util.Vector;


/**
 *
 * @author fekabatman
 */
public class DataModel {
    
    public DataModel(){
    }
    Patient [] Patients;
    Doctor [] Doctors;
    private static String[] nameList = {"Péter", "Pál", "Laci","Lőrinc","Lajos","László","Lala"};
    private static String[] specializationList = {"Főorvos", "Általános orvos", "Háziorvos","Radiológus","Sportorvos"};
    
    public static String getName(){
        return nameList[(int)(Math.random() * nameList.length)];
    }
    
    public static String getSpecializatio(){
        return specializationList[(int)(Math.random() * specializationList.length)];
    }
    
    public static String getCondition(){
        String condition = Math.random() > .1 ? "Egészséges" : "Beteg";
        return condition;
    }
    
    
    public Vector startDoctor(int Number){
        Doctors = new Doctor [Number];
        Vector<Vector<Object>>  DoctorsList = new Vector<>();
        
        for( int i = 0; i < Number; i++ )
        {
            Doctors[i] = new Doctor(getName(),getSpecializatio());
        }
        for (Doctor doctor : Doctors) {
            Vector <Object> DoctorList = new Vector<>();
            
            DoctorList.add(doctor.getName());
            DoctorList.add(doctor.getSpecializatio());
            
            DoctorsList.add(DoctorList);
        }
        return DoctorsList;
    }
    public Vector startPatient(int Number){
        Patients = new Patient [Number];
        Vector<Vector<Object>> PatientsList = new Vector<>();
        
        for( int i = 0; i < Number; i++ )
        {
            Patients[i] = new Patient(getName(), getCondition(), GenerateAge());
        } 
        for (Patient patient : Patients) {
            Vector <Object> PatientList = new Vector<>();
            
            PatientList.add(patient.getName());
            PatientList.add(patient.getCondition());
            PatientList.add(patient.getAge());
            
            PatientsList.add(PatientList);
        }
        return PatientsList;
    }
    public Vector endPatient(){
        Vector<Vector<Object>> PatientsList = new Vector<>();
        
        for (Patient patient : Patients) {
            Vector <Object> PatientList = new Vector<>();
            
            PatientList.add(patient.getName());
            if(patient.getCondition() == "Egészséges"){
                PatientList.add(patient.setSickness());
            }else{
                 PatientList.add(patient.getCondition());
            }
            PatientList.add(patient.getAge());
            
            PatientsList.add(PatientList);
        }
        return PatientsList;
    }
    public Vector endDoctor(){
        Vector<Vector<Object>>  DoctorsList = new Vector<>();
        
        for (Doctor doctor : Doctors) {
            Vector <Object> DoctorList = new Vector<>();
            
            DoctorList.add(doctor.getName());
            DoctorList.add(doctor.getSpecializatio());
            
            DoctorsList.add(DoctorList);
        }
        return DoctorsList;
    }
    public int GenerateAge(){
        Random r = new Random();
        int low = 20;
        int high = 100;
        int result = r.nextInt(high-low) + low;
        return result;
    }
}