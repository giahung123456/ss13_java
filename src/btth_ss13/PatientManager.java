package btth_ss13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PatientManager {
  private List<Patient> patientList=new LinkedList<>();



    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
    public void addPatient(Patient patient){
        patientList.add(patient);
    }

    public void removePatient(String patientId){
        Iterator<Patient> iterator=patientList.iterator();
        while(iterator.hasNext()){
            Patient patient=iterator.next();
            if(patient.getId().equals(patientId)){
                iterator.remove();
            }
        }

    }
    public void updatePatient(String patientId,Patient updatedPatient){
        for(Patient patient:patientList){
            if(patient.getId().equals(patientId)){
                patient.setName(updatedPatient.getName());
                patient.setAge(updatedPatient.getAge());
                patient.setGender(updatedPatient.getGender());
                patient.setPathology(updatedPatient.getPathology());
            }
        }
    }
    public void displayPatients(){
       for(Patient p:patientList){
           System.out.println("----------------------------------");
           System.out.println("ID: "+p.getId());
           System.out.println("Name: "+p.getName());
           System.out.println("Age: "+p.getAge());
           System.out.println("Gender: "+p.getGender());
           System.out.println("Pathology: "+p.getPathology());
           System.out.println("----------------------------------");
       }

    }
    public void searchPatientByName(String name){
        for(Patient p:patientList){
            if(p.getName().equals(name)){
                System.out.println("----------------------------------");
                System.out.println("ID: "+p.getId());
                System.out.println("Name: "+p.getName());
                System.out.println("Age: "+p.getAge());
                System.out.println("Gender: "+p.getGender());
                System.out.println("Pathology: "+p.getPathology());
                System.out.println("----------------------------------");
            }
        }
    }

}
