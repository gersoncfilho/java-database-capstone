package com.project.back_end.seed;

import com.project.back_end.models.*;
import com.project.back_end.services.DoctorService;
import com.project.back_end.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class DoctorSeed {
    private final RoleService roleService;
    private final DoctorService doctorService;

    public void seed() {
        Role doctorRole = roleService.findByType(RoleType.ROLE_DOCTOR);
        Address address = Address.builder()
                .addressStreet("123 Main St")
                .addressNumber("101")
                .addressCity("Sample City")
                .addressState("SC")
                .addressType(0)
                .addressZipCode("4605-311")
                .build();
        Doctor doctor = Doctor.builder()
                .name("Dr. John Doe")
                .email("doctor@example.com")
                .password("Password1!")
                .phone("1234567890")
                .address(address)
                .specialty("Cardiology")
                .roles(Set.of(doctorRole))
                .availableTimes(List.of("09:00-12:00", "14:00-17:00"))
                .build();
        doctorService.createIfNotExists(doctor);

        Address address1 = Address.builder()
                .addressStreet("456 Elm St")
                .addressNumber("202")
                .addressCity("Sample City")
                .addressState("SC")
                .addressType(0)
                .addressZipCode("4605-312")
                .build();

        Doctor doctor1 = Doctor.builder()
                .name("Dr. Jane Smith")
                .email("jsmith@example.com")
                .password("Password2!")
                .phone("0987654321")
                .address(address1)
                .specialty("Neurology")
                .roles(Set.of(doctorRole))
                .availableTimes(List.of("10:00-13:00", "15:00-18:00"))
                .build();
        doctorService.createIfNotExists(doctor1);
    }
}
