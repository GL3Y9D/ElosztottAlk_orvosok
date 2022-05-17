/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.util.Vector;
import models.MainModel;
import view.MainFrame;

import javax.swing.table.DefaultTableModel;



/**
 *
 * @author fekabatman
 */
public class MainController {
    MainFrame mainFrame;
    MainModel mainModel;
    public MainController() {
        
        this.mainFrame = new MainFrame();
        this.mainModel = new MainModel();
        
        setUp();
    }
    private void setUp(){
        this.mainFrame.setVisible(true);
        this.mainFrame.setSize(830, 470);
        this.mainFrame.setResizable(false);
        this.mainFrame.getStartBtn().setEnabled(false);
        ActionListener();
    }
    private void ActionListener(){
        mainFrame.getStartBtn().addActionListener(event -> start());
        mainFrame.getGenerateBtn().addActionListener(event -> generate());
    }
    private void start(){
        Vector PatientVector = this.mainModel.generateDataEnd("Patient");
        Vector DoctorVector = this.mainModel.generateDataEnd("Doctor");        
        setUpNextDoctorTables(DoctorVector);
        setUpNextPatientTables(PatientVector);
        dataExport();
    }
            
    private void generate(){
        if(checkField()){
            this.mainFrame.getStartBtn().setEnabled(true);
            
            Vector DoctorVector = this.mainModel.generateData(Integer.valueOf(this.mainFrame.getDoctorField().getText()), "Doctor");
            Vector PatientVector = this.mainModel.generateData(Integer.valueOf(this.mainFrame.getPatientField().getText()), "Patient");
                       
            setUpPrePatientTables(PatientVector);
            setUpPreDoctorTables(DoctorVector);
        }   
    }
    private boolean checkField(){
        if(this.mainFrame.getDoctorField().getText().equals("") || this.mainFrame.getPatientField().getText().equals(""))
        { 
            this.mainFrame.getStatusLabel().setText("Űzes Mező(k)");
            return false;
        }
        try {
            Integer.parseInt(this.mainFrame.getPatientField().getText());
            Integer.parseInt(this.mainFrame.getDoctorField().getText());
            this.mainFrame.getStatusLabel().setText("Generálva");
        }
        catch (NumberFormatException e) {
             this.mainFrame.getStatusLabel().setText("Nem megfelelő formátum");
             return false;
        }
        return true;
    }

    private void setUpPrePatientTables(Vector data){
        DefaultTableModel tblMdl = (DefaultTableModel)mainFrame.getPrevPatientTable().getModel();
        tblMdl.setRowCount(0);        
        for (Integer i = 0; i < data.size(); i++)
        {
            tblMdl.addRow((Vector<?>) data.get(i));
        }
        mainFrame.getPrevPatientTable().setAutoCreateRowSorter(true);
    }
    
    private void setUpPreDoctorTables(Vector data){
        DefaultTableModel tblMdl = (DefaultTableModel)mainFrame.getPrevDoctorTable().getModel();
        tblMdl.setRowCount(0);        
        for (Integer i = 0; i < data.size(); i++)
        {
            tblMdl.addRow((Vector<?>) data.get(i));
        }
        mainFrame.getPrevDoctorTable().setAutoCreateRowSorter(true);
    }
    private void setUpNextPatientTables(Vector data){
        DefaultTableModel tblMdl = (DefaultTableModel)mainFrame.getNextPatientTable().getModel();
        tblMdl.setRowCount(0);        
        for (Integer i = 0; i < data.size(); i++)
        {
            tblMdl.addRow((Vector<?>) data.get(i));
        }
        mainFrame.getNextPatientTable().setAutoCreateRowSorter(true);
    }
    
    private void setUpNextDoctorTables(Vector data){
        DefaultTableModel tblMdl = (DefaultTableModel)mainFrame.getNextDoctorTable().getModel();
        tblMdl.setRowCount(0);        
        for (Integer i = 0; i < data.size(); i++)
        {
            tblMdl.addRow((Vector<?>) data.get(i));
        }
        mainFrame.getNextDoctorTable().setAutoCreateRowSorter(true);
    }
    public void dataExport(){
        if(this.mainModel.dataExport()){
            this.mainFrame.getStatusLabel().setText("Adatok exportálva");
        }else{
            this.mainFrame.getStatusLabel().setText("Exportálás sikertelen");
        }
    }
}
