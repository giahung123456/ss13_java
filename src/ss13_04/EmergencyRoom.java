package ss13_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmergencyRoom {
    List<String> patients=new LinkedList<>();
    void patientCheckIn(String name){
        patients.addLast(name);

    }
    void emergencyCheckIn(String name){
        patients.addFirst(name);
    }
    void treatPatient(){
        String name=patients.removeFirst();
        if(name=="c"){
            System.out.println("Đang cấp cứu: "+name);
        }else {
            System.out.println("Đang khám: "+name);
        }
    }
}
