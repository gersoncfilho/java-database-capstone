package com.project.back_end.services;

import com.project.back_end.models.Doctor;

import java.util.List;
import java.util.Set;

public interface DoctorService {

    List<String> getAvailableTimes(Long doctorId);
    Doctor updateDoctor(Doctor doctor);
    Set<Doctor> getAllDoctors();
    void deleteDoctor(Long doctorId);

    // 9. **validateDoctor Method**:
//    - Validates a doctor's login by checking if the email and password match an existing doctor record.
//    - It generates a token for the doctor if the login is successful, otherwise returns an error message.
//    - Instruction: Make sure to handle invalid login attempts and password mismatches properly with error responses.
    String validateDoctor(String email, String password);
    Doctor getById(Long doctorId);
    void createIfNotExists(Doctor doctor);





   
}
