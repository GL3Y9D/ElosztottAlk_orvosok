/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.Vector;

/**
 *
 * @author fekabatman
 */
public class DataExport {
    public boolean export(Vector Doctors,Vector Patients){
        try{    
           FileWriter fw=new FileWriter("Orvos.json");
                     
           fw.write(ExportFinalForm(ConvertJsonDoktor(Doctors),ConvertJsonPatient(Patients)));
           
           fw.close();   
           return true;
        }catch(Exception e){
            System.out.println(e);       
           return false;
        }
    }    
   
    public JSONArray ConvertJsonDoktor(Vector Data){
        
        JSONArray ja = new JSONArray();        
        Vector tmp;
        for(int j=0; j<Data.size(); j++)
        {
            tmp = (Vector) Data.get(j);

            JSONObject obj = new JSONObject();
            for (int i=0; i<tmp.size(); i++)
            {

                    if(i==0)
                        obj.put("name", tmp.get(i));
                    else
                        obj.put("specializatio", tmp.get(i));

            }
            ja.add(obj);
        }   

        return ja;
    }
    
    public JSONArray ConvertJsonPatient(Vector Data){
        
        JSONArray ja = new JSONArray();        
        Vector tmp;
        for(int j=0; j<Data.size(); j++)
        {
            tmp = (Vector) Data.get(j);

            JSONObject obj = new JSONObject();
            for (int i=0; i<tmp.size(); i++)
            {

                    if(i==0)
                        obj.put("name", tmp.get(i));
                    if(i==1)
                        obj.put("condition", tmp.get(i));
                    else
                        obj.put("age", tmp.get(i));
            }
            ja.add(obj);
        }   

        return ja;
    }
        
    public String ExportFinalForm(JSONArray Doctors, JSONArray Patients){
        
        JSONObject obj = new JSONObject();
        
        obj.put("doctors", Doctors);
        obj.put("patients", Patients);
                
        return obj.toString();
    }

}
