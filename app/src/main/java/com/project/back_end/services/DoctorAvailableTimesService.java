package com.project.back_end.services;

import com.project.back_end.models.DoctorAvailableTimes;

import java.util.List;

public interface DoctorAvailableTimesService {

    void saveAvailableTime(DoctorAvailableTimes doctorAvailableTimes);

    boolean deleteAvailableTime(Long doctorId, Long timeSlotId);

    List<String> getAvailableTimes(Long doctorId);
}
