package ss13_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Double> patients=new ArrayList<>();
        Collections.addAll(patients,36.5, 40.2, 37.0, 12.5, 39.8, 99.9, 36.8);
        Iterator<Double> iterator=patients.iterator();
        while(iterator.hasNext()){
            Double patient=iterator.next();

            if(patient<34.0||patient>42.0){
                iterator.remove();
            }

        }
        System.out.println(patients);
        double sum=0.0;

        for(Double patient:patients){
            sum+=patient;

        }
        System.out.println(sum/patients.size());
    }
}
