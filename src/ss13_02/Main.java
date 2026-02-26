package ss13_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> lists=new ArrayList<>();
        Collections.addAll(lists,"Paracetamol", "Ibuprofen", "Panadol", "Paracetamol", "Aspirin", "Ibuprofen");

        List<String> medicines=new ArrayList<>();
        for(String medicine:lists){
            if(!medicines.contains(medicine)){
                medicines.add(medicine);
            }
        }

        Collections.sort(medicines);
        System.out.println(medicines);
    }
}
