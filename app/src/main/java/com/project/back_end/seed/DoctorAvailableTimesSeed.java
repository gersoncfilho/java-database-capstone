package com.project.back_end.seed;

import com.project.back_end.models.Doctor;
import com.project.back_end.models.DoctorAvailableTimes;
import com.project.back_end.repo.DoctorRepository;
import com.project.back_end.services.DoctorAvailableTimesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class DoctorAvailableTimesSeed {

    private final DoctorAvailableTimesService doctorAvailableTimesService;
    private final DoctorRepository doctorRepository;

    void seed() {
        int ids = 25;

        for (int i = 1; i <= ids; i++) {
            Doctor doctor = doctorRepository.findById((long) i).orElse(null);
            if (doctor == null) continue;
            String[] availableTimes = getAvailableTimes();
            for (String time : availableTimes) {
                DoctorAvailableTimes doctorAvailableTimes = DoctorAvailableTimes.builder()
                        .doctor(doctor)
                        .availableTime(time)
                        .build();
                doctorAvailableTimesService.saveAvailableTime(doctorAvailableTimes);
            }
        }
    }

    String[] getAvailableTimes() {
        return new String[]{
                "09:00-10:00",
                "10:00-11:00",
                "11:00-12:00",
                "14:00-15:00"
        };
    }

}
