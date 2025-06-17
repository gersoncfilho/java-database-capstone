package com.project.back_end.seed;

import com.project.back_end.models.Address;
import com.project.back_end.models.Doctor;
import com.project.back_end.models.enums.RoleType;
import com.project.back_end.services.DoctorService;
import com.project.back_end.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class DoctorSeed {

    private final RoleService roleService;
    private final DoctorService doctorService;


    public void seed() {
        List<String[]> doctorsData = List.of(
                new String[]{"dr.adams@example.com", "Dr. Emily Adams", "P@ass12345", "5551012020", "Cardiologist", "Sample Street", "100", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.johnson@example.com", "Dr. Mark Johnson", "S@cure4567", "5552023030", "Neurologist", "Sample Street", "200", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.lee@example.com", "Dr. Sarah Lee", "L@ePass987", "5553034040", "Orthopedist", "Sample Street", "300", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.wilson@example.com", "Dr. Tom Wilson", "W!ls0nPwd", "5554045050", "Pediatrician", "Sample Street", "400", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.brown@example.com", "Dr. Alice Brown", "B#ownie123", "5555056060", "Dermatologist", "Sample Street", "500", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.taylor@example.com", "Dr. Taylor Grant", "T#ylor321", "5556067070", "Cardiologist", "Sample Street", "600", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.white@example.com", "Dr. Sam White", "W#iteSecure1", "5557078080", "Neurologist", "Sample Street", "700", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.clark@example.com", "Dr. Emma Clark", "C!arkPass456", "5558089090", "Orthopedist", "Sample Street", "800", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.davis@example.com", "Dr. Olivia Davis", "D@vis789", "5559090101", "Pediatrician", "Sample Street", "900", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.moore@example.com", "Dr. Ella Moore", "D@vis788", "5551112222", "Cardiologist", "Sample Street", "120", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.martin@example.com", "Dr. Leo Martin", "M?rtinp1ss", "5552223333", "Neurologist", "Sample Street", "130", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.jackson@example.com", "Dr. Ivy Jackson", "J@ckson11", "5553334444", "Orthopedist", "Sample Street", "140", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.thomas@example.com", "Dr. Owen Thomas", "T#o1asPWD", "5554445555", "Pediatrician", "Sample Street", "150", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.hall@example.com", "Dr. Ava Hall", "H@llhall2", "5555556666", "Dermatologist", "Sample Street", "160", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.green@example.com", "Dr. Mia Green", "G$eenle2af", "5556667777", "Cardiologist", "Sample Street", "170", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.baker@example.com", "Dr. Jack Baker", "B@keitu3p", "5557778888", "Neurologist", "Sample Street", "180", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.walker@example.com", "Dr. Nora Walker", "Q@lkpass12", "5558889999", "Orthopedist", "Sample Street", "109", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.young@example.com", "Dr. Liam Young", "Y@ung123", "5559990000", "Pediatrician", "Sample Street", "109", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.king@example.com", "Dr. Zoe King", "K!ngkong1", "5550001111", "Dermatologist", "Sample Street", "300", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.scott@example.com", "Dr. Lily Scott", "S@ottis4h", "5551112223", "Cardiologist", "Sample Street", "400", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.evans@example.com", "Dr. Lucas Evans", "E#ansEv1", "5552223334", "Neurologist", "Sample Street", "500", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.turner@example.com", "Dr. Grace Turner", "T#rne5rBurner", "5553334445", "Orthopedist", "Sample Street", "200", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.hill@example.com", "Dr. Ethan Hill", "H!llclim5b", "5554445556", "Pediatrician", "Sample Street", "2200", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.ward@example.com", "Dr. Ruby Ward", "W!rdWar3d", "5555556667", "Dermatologist", "Sample Street", "2100", "Sample city", "ST", "1", "12345-000"},
                new String[]{"dr.miller@example.com", "Dr. Henry Miller", "M@llerti3es", "5550101111", "Dermatologist", "Sample Street", "110", "Sample city", "ST", "1", "12345-000"}
        );

        for (String[] data : doctorsData) {
            Address address = Address.builder()
                    .addressStreet(data[5])
                    .addressNumber(data[6])
                    .addressCity(data[7])
                    .addressState(data[8])
                    .addressType(Integer.valueOf(data[9]))
                    .addressZipCode(data[10])
                    .build();

            Doctor doctor = Doctor.builder()
                    .roles(Set.of(roleService.findByType(RoleType.ROLE_DOCTOR)))
                    .email(data[0])
                    .name(data[1])
                    .password(data[2]) // I will not encrypt right now.
                    .phone(data[3])
                    .specialty(data[4])
                    .address(address)
                    .createdAt(LocalDateTime.now())
                    .availableTimes(new ArrayList<>())
                    .build();
            System.out.println("Creating doctor: " + doctor.getName());
            doctorService.createIfNotExists(doctor);
        }
    }
}
        