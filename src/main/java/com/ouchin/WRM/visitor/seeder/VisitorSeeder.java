package com.ouchin.WRM.visitor.seeder;

import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.visitor.repository.VisitorRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("dev")
public class VisitorSeeder implements CommandLineRunner {


    private final VisitorRepository visitorRepository;

    public VisitorSeeder(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (visitorRepository.count() == 0) {
            List<Visitor> visitors = Arrays.asList(
                    new Visitor("mustapha", "ouchin"),
                    new Visitor("ahmed", "amdah"),
                    new Visitor("ali", "oubna")
            );

            visitorRepository.saveAll(visitors);
            System.out.println("Visitor data seeded successfully");
        }else {
            System.out.println("Visitor data already seeded");
        }


    }
}
