package ss13_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<Integer> a1=new ArrayList<>();
    Collections.addAll(a1,101, 102, 105);
    List<Integer> b1=new ArrayList<>();
    Collections.addAll(b1, 102, 105,108);
    List<Integer> result1=findCommonPatients(a1,b1);
    System.out.println(result1);
//    System.out.println(findCommonPatients(a1,b1));


     List<String> a2=new ArrayList<>();
     Collections.addAll(a2,"DN01", "DN02", "DN03");
     List<String> b2=new ArrayList<>();
     Collections.addAll(b2, "DN02", "DN04");
     System.out.println(findCommonPatients(a2,b2));
    }
    public static <T> List findCommonPatients(List<T> a, List<T> b){
        List<T> common=new ArrayList<>();
        for(T e:a){
            if(b.contains(e)){
                common.add(e);
            }
        }
        return common;
    }
}
