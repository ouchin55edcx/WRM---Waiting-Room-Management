package com.ouchin.WRM.visitor.seeder;

import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.visitor.repository.VisitorRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
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
                    new Visitor("Mustapha", "Ouchin")
                            .setCreatedAt(java.time.LocalDateTime.now())
                            .setUpdatedAt(java.time.LocalDateTime.now()),
                    new Visitor("Ahmed", "Amdah")
                            .setCreatedAt(java.time.LocalDateTime.now())
                            .setUpdatedAt(java.time.LocalDateTime.now()),
                    new Visitor("Ali", "Oubna")
                            .setCreatedAt(java.time.LocalDateTime.now())
                            .setUpdatedAt(java.time.LocalDateTime.now()),
                    new Visitor("Sara", "Smith")
                            .setCreatedAt(java.time.LocalDateTime.now())
                            .setUpdatedAt(java.time.LocalDateTime.now()),
                    new Visitor("John", "Doe")
                            .setCreatedAt(java.time.LocalDateTime.now())
                            .setUpdatedAt(java.time.LocalDateTime.now())
            );

            visitorRepository.saveAll(visitors);
            System.out.println("Visitor data seeded successfully");
        } else {
            System.out.println("Visitor data already seeded");
        }
    }
}
