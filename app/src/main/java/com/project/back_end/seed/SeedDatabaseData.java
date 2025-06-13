package com.project.back_end.seed;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class SeedDatabaseData implements ApplicationRunner {

    private final RoleSeeder roleSeeder;
    private final DoctorSeed doctorSeeder;

    public SeedDatabaseData (RoleSeeder roleSeeder, DoctorSeed doctorSeeder) {
        this.roleSeeder = roleSeeder;
        this.doctorSeeder = doctorSeeder;
    }

    @Override
    public void run(ApplicationArguments args) {
        roleSeeder.seed();
        doctorSeeder.seed();
    }
}
