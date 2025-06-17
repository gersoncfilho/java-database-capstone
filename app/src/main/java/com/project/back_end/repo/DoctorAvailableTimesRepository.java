package com.project.back_end.repo;

import com.project.back_end.models.DoctorAvailableTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorAvailableTimesRepository extends JpaRepository<DoctorAvailableTimes, Long> {
}
