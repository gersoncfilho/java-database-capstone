package com.project.back_end.seed;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class SeedDatabaseData implements ApplicationRunner {

    private final RoleSeeder seeder;

    public SeedDatabaseData (RoleSeeder seeder) {
        this.seeder = seeder;
    }

    @Override
    public void run(ApplicationArguments args) {
        seeder.seed();
    }
}
