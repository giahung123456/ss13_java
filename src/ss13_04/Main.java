package ss13_04;

public class Main {
    public static void main(String[] args) {
    EmergencyRoom emergencyRoom=new EmergencyRoom();
    emergencyRoom.patientCheckIn("a");
    emergencyRoom.patientCheckIn("b");
    emergencyRoom.emergencyCheckIn("c");
    emergencyRoom.treatPatient();
    emergencyRoom.treatPatient();
    emergencyRoom.treatPatient();
    }
}
