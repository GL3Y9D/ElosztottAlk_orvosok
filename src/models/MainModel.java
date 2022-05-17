/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author fekabatman
 */
public class MainModel {
    

    DataModel DataModel;
    DataExport DataExport;
    public MainModel() {
        this.DataModel = new DataModel();
        this.DataExport = new DataExport();
    }
    public Vector generateData(int Number, String Type){
        if(Type == "Doctor"){
            return this.DataModel.startDoctor(Number);
        }
        else{
            return this.DataModel.startPatient(Number);
        }
    }
    
    public Vector generateDataEnd(String Type){
        if(Type == "Doctor"){
            return this.DataModel.endDoctor();
        }else{
            return this.DataModel.endPatient();
        }
    }
    
    public boolean dataExport(){
        return this.DataExport.export(this.DataModel.endDoctor(),this.DataModel.endPatient());
    }
}