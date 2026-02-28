package btth_ss13;

import java.util.Iterator;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PatientManager patientManager=new PatientManager();

        int choice;

        do {
            System.out.println("===== QUAN LY BENH NHAN =====");
            System.out.println("1. Them benh nhan");
            System.out.println("2. Xoa benh nhan");
            System.out.println("3. Cap nhat benh nhan");
            System.out.println("4. Tim kiem benh nhan");
            System.out.println("5. Hien thi danh sach benh nhan");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    // Them benh nhan (Create)
                    addPatientMain(patientManager);
                    break;

                case 2:
                    // Xoa benh nhan (Delete)
                    removePatientMain(patientManager);
                    break;

                case 3:
                    // Cap nhat benh nhan (Update)
                    updatePatientMain(patientManager);
                    break;

                case 4:
                    // Tim kiem benh nhan (Search)
                    System.out.print("Nhập tên cần tìm: ");
                    String nameSearch = sc.nextLine();
                    patientManager.searchPatientByName(nameSearch);
                    break;

                case 5:
                    // Hien thi danh sach benh nhan (Display)
                    patientManager.displayPatients();
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh...");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 0);


    }
    public static void addPatientMain(PatientManager patientManager){
        Scanner sc = new Scanner(System.in);
        Patient patient = new Patient();
        System.out.print("Nhập id : ");
        patient.setId(sc.nextLine());
        System.out.print("Nhập tên: ");
        patient.setName(sc.nextLine());
        System.out.print("Nhập tuổi: ");
        patient.setAge(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập giới tính: ");
        patient.setGender(sc.nextLine());
        System.out.print("Nhập bệnh lý: ");
        patient.setPathology(sc.nextLine());
        patientManager.addPatient(patient);

    }
    public static void removePatientMain(PatientManager patientManager){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID bệnh nhân cần xóa: ");
        String patientId = sc.nextLine();
        patientManager.removePatient(patientId);

    }
    public static void updatePatientMain(PatientManager patientManager){
        Scanner sc = new Scanner(System.in);
        Patient patient = new Patient();
        System.out.print("Nhập id cần sửa: ");
        patient.setId(sc.nextLine());
        System.out.print("Nhập tên mới: ");
        patient.setName(sc.nextLine());
        System.out.print("Nhập tuổi mới: ");
        patient.setAge(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập giới tính mới: ");
        patient.setGender(sc.nextLine());
        System.out.print("Nhập bệnh lý mới: ");
        patient.setPathology(sc.nextLine());
        patientManager.updatePatient(patient.getId(),  patient);
    }
}
