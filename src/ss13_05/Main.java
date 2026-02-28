package ss13_05;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patients=new LinkedList<>();
        int choice=0;
        do {
            System.out.println("||===================== MENU =====================||");
            System.out.println("|| 1. Tiếp nhận bệnh nhân                        ||");
            System.out.println("|| 2. Cập nhật chẩn đoán                         ||");
            System.out.println("|| 3. Xuất viện                                  ||");
            System.out.println("|| 4. Sắp xếp danh sách bệnh nhân                ||");
            System.out.println("|| 5. Hiển thị danh sách bệnh nhân               ||");
            System.out.println("|| 6. Thoát                                      ||");
            System.out.println("||===============================================||");
            System.out.print("Chọn chức năng (1-6): ");
            choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {
                case 1:
                    System.out.println("Bạn chọn: Tiếp nhận bệnh nhân");
                    System.out.print("Nhập ID bệnh nhân: ");
                    String id = sc.nextLine();
                    boolean check= checkId(patients,id);
                    if(check){
                        System.out.print("Nhập tên bệnh nhân: ");
                        String ten = sc.nextLine();

                        System.out.print("Nhập tuổi: ");
                        int tuoi = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nhập chẩn đoán: ");
                        String chandoan = sc.nextLine();
                        patients.add(new Patient(id,ten,tuoi,chandoan));
                    }
                    break;
                case 2:
                    System.out.println("Bạn chọn: Cập nhật chẩn đoán");
                    System.out.print("Nhập id cần cập nhập chuẩn đoán mới: ");
                    String id2=sc.nextLine();

                   if(!checkId(patients,id2)){
                       System.out.print("Nhập chuẩn đoán mới: ");
                       String ten2=sc.nextLine();
                        int index2=searchIndex(patients,id2);
                        patients.get(index2).setDiagnosis(ten2);


                   }else {
                       System.out.println("Không tồn tại id này");
                   }
                    break;
                case 3:
                    System.out.println("Bạn chọn: Xuất viện");
                    System.out.print("Nhập id bệnh nhân cần xoá: ");
                    String id3=sc.nextLine();
                    if(!checkId(patients,id3)){
                        int index3=searchIndex(patients,id3);
                        patients.remove(index3);
                    }
                    break;
                case 4:
                    System.out.println("Bạn chọn: Sắp xếp danh sách bệnh nhân");
                    sortPatient(patients);
                    break;
                case 5:
                    System.out.println("Bạn chọn: Hiển thị danh sách bệnh nhân");
                    for (Patient patient : patients) {
                        System.out.println("id: "+patient.getId());
                        System.out.println("tên: "+patient.getFullName());
                        System.out.println("tuổi: "+patient.getAge());
                        System.out.println("chẩn đoán: "+patient.getDiagnosis());
                        System.out.println("------------------------------");
                    }
                    break;
                case 6:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

            System.out.println();

        } while (choice != 6);
    }
    public static  boolean checkId(List<Patient> p,String id){
        for(Patient t:p){
            if(t.getId().equals(id)){
                System.out.println("id đã tồn tại");
                return false;
            }
        }
        return true;
    }
    public static int searchIndex(List<Patient> patients,String id){
        for (int i = 0; i<patients.size();i++){
            if(patients.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    public static void sortPatient(List<Patient> patients){
        for(int i=0;i<patients.size();i++){
            for(int j=i+1;j<patients.size();j++){
                if(patients.get(i).getAge()<patients.get(j).getAge()){
                    Collections.swap(patients,i,j);
                }else if(patients.get(i).getAge()==patients.get(j).getAge()){
                   if(patients.get(i).getFullName().compareTo(patients.get(j).getFullName()) >0){
                       Collections.swap(patients,i,j);
                   }
                }
            }
        }
        System.out.println("sort patient list");
        for (Patient patient : patients) {
            System.out.println("id: "+patient.getId());
            System.out.println("tên: "+patient.getFullName());
            System.out.println("tuổi: "+patient.getAge());
            System.out.println("chẩn đoán: "+patient.getDiagnosis());
            System.out.println("------------------------------");
        }
    }
}
