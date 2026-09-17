import doctor.Doctor;
import patient.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main7b {
    public static void main(String[] args) {
        // Create doctors
        Doctor doctor1 = new Doctor(1, "Dr. Smith", "Cardiology", 150.0);
        Doctor doctor2 = new Doctor(2, "Dr. Jones", "Neurology", 200.0);

        // Create patients
        Patient patient1 = new Patient(1, "Alice", "Heart Disease", 30);
        Patient patient2 = new Patient(2, "Bob", "Migraine", 25);
        Patient patient3 = new Patient(3, "Charlie", "Hypertension", 40);

        // Assign patients to doctors based on specialization
        Map<Doctor, List<Patient>> doctorPatientMap = new HashMap<>();
        doctorPatientMap.put(doctor1, new ArrayList<>());
        doctorPatientMap.put(doctor2, new ArrayList<>());

        // Assign patients
        if (patient1.getDisease().equals("Heart Disease")) {
            doctorPatientMap.get(doctor1).add(patient1);
        } else {
            doctorPatientMap.get(doctor2).add(patient1);
        }

        if (patient2.getDisease().equals("Migraine")) {
            doctorPatientMap.get(doctor2).add(patient2);
        } else {
            doctorPatientMap.get(doctor1).add(patient2);
        }

        if (patient3.getDisease().equals("Hypertension")) {
            doctorPatientMap.get(doctor1).add(patient3);
        } else {
            doctorPatientMap.get(doctor2).add(patient3);
        }

        // Display patient and doctor details
        double totalConsultationFee = 0.0;

        for (Map.Entry<Doctor, List<Patient>> entry : doctorPatientMap.entrySet()) {
            Doctor doctor = entry.getKey();
            List<Patient> patients = entry.getValue();

            for (Patient patient : patients) {
                patient.displayPatientInfo();
                doctor.displayDoctorInfo();
                totalConsultationFee += doctor.getConsultationFee();
            }
        }

        // Display total consultation fee collected by each doctor
        System.out.println("Total consultation fee collected by each doctor:");
        for (Map.Entry<Doctor, List<Patient>> entry : doctorPatientMap.entrySet()) {
            Doctor doctor = entry.getKey();
            System.out.println(doctor.getName() + ": " + (doctor.getConsultationFee() * entry.getValue().size()));
        }
    }
}