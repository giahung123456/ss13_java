package ss13_06;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        List<Medicine> medicines=new LinkedList<>();
        do {
            System.out.println("\n||==================== MENU ====================||");
            System.out.println("|| 1. Them thuoc vao don                      ||");
            System.out.println("|| 2. Dieu chinh so luong                     ||");
            System.out.println("|| 3. Xoa thuoc                               ||");
            System.out.println("|| 4. In hoa don                              ||");
            System.out.println("|| 5. Tim thuoc gia re                        ||");
            System.out.println("|| 6. Thoat                                   ||");
            System.out.println("||=============================================||");

            System.out.print("Chon lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Ban da chon: Them thuoc vao don");
                    addMedicine(medicines);
                    break;
                case 2:
                    System.out.println("Ban da chon: Dieu chinh so luong");
                    updateMedicine(medicines);
                    break;
                case 3:
                    System.out.println("Ban da chon: Xoa thuoc");
                    deleteMedicine(medicines);
                    break;
                case 4:
                    System.out.println("Ban da chon: In hoa don");
                    displayMedicines(medicines);
                    break;
                case 5:
                    System.out.println("Ban da chon: Tim thuoc gia re");
                    for(Medicine medicine:medicines){
                        if(medicine.getUnitPrice()<500){
                            System.out.println("Mã id: "+medicine.getDrugId());
                            System.out.println("Tên thuốc: "+medicine.getDrugName());
                            System.out.println("Giá tiền: "+medicine.getUnitPrice());
                            System.out.println("Số lượng: "+medicine.getQuantity());
                            System.out.println("--------------------------------------------");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");
            }

        } while (choice != 6);

    }
    public static void addMedicine(List<Medicine> medicines){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã id: ");
        String id=sc.nextLine();

        System.out.print("Nhập tên thuốc: ");
        String name=sc.nextLine();
        System.out.print("Nhập giá thuốc: ");
        Double price=sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập số lượng: ");
        int quantity=sc.nextInt();
        sc.nextLine();
        int check=0;
        for(Medicine m:medicines){
            if(m.getDrugId().equals(id)){
                m.setQuantity(m.getQuantity()+quantity);
                check=1;
            }
        }
        if(check==0){

            medicines.add(new Medicine(id,name,price,quantity));
        }


    }
    public static void displayMedicines(List<Medicine> medicines){
        Double totalMoney=0.0;

        for(Medicine m:medicines){
            Double medicineMoney=m.getUnitPrice()*m.getQuantity();
            totalMoney +=medicineMoney;
            System.out.println("Mã id: "+m.getDrugId());
            System.out.println("Tên thuốc: "+m.getDrugName());
            System.out.println("Giá tiền: "+m.getUnitPrice());
            System.out.println("Số lượng: "+m.getQuantity());
            System.out.println("Tổng tiền: "+medicineMoney);
            System.out.println("--------------------------------------------");

        }
        System.out.println("Total money: "+totalMoney);
        medicines.clear();
    }
    public static void updateMedicine(List<Medicine> medicines){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập id thuốc cần sửa: ");
        String id=sc.nextLine();

        Iterator<Medicine> i=medicines.iterator();
        while(i.hasNext()){
            Medicine m=i.next();
            if(m.getDrugId().equals(id)){
                System.out.print("Nhập số lượng thuốc mới: ");
                int quantity=sc.nextInt();
                sc.nextLine();
                if(quantity==0){
                    i.remove();
                }else{
                    m.setQuantity(quantity);
                }
                 break;
            }
        }
    }
    public static void deleteMedicine(List<Medicine> medicines){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã id cần xoá: ");
        String id=sc.nextLine();
      Iterator<Medicine> i=medicines.iterator();
      while(i.hasNext()){
          Medicine m=i.next();
          if(m.getDrugId().equals(id)){
              i.remove();
          }
      }
    }
}
