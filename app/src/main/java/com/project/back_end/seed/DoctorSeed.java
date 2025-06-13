package com.project.back_end.seed;

import com.project.back_end.models.*;
import com.project.back_end.services.DoctorService;
import com.project.back_end.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
                .role(doctorRole)
                .availableTimes(List.of("09:00-12:00", "14:00-17:00"))
                .build();
        doctorService.createIfNotExists(doctor);
    }
}
