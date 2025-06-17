package com.project.back_end.services.impl;

import com.project.back_end.models.DoctorAvailableTimes;
import com.project.back_end.repo.DoctorAvailableTimesRepository;
import com.project.back_end.services.DoctorAvailableTimesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class DoctorAvailableTimesServiceImpl implements DoctorAvailableTimesService {

    private final DoctorAvailableTimesRepository doctorAvailableTimesRepository;

    @Override
    @Transactional
    public void saveAvailableTime(DoctorAvailableTimes doctorAvailableTimes) {
        if (doctorAvailableTimes.getId() != null) {
            Optional<DoctorAvailableTimes> existing = doctorAvailableTimesRepository.findById(doctorAvailableTimes.getId());
            if (existing.isPresent()) {
                DoctorAvailableTimes entity = existing.get();
                entity.setAvailableTime(doctorAvailableTimes.getAvailableTime());
                doctorAvailableTimesRepository.save(entity);
            }
        }
        doctorAvailableTimesRepository.save(doctorAvailableTimes);
    }

    @Override
    public boolean deleteAvailableTime(Long doctorId, Long timeSlotId) {
        return false;
    }

    @Override
    public List<String> getAvailableTimes(Long doctorId) {
        return List.of();
    }
}
