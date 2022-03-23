package com.demo.milkservice.bootstrap;

import com.demo.milkservice.domain.Milk;
import com.demo.milkservice.repositories.MilkRepository;
import com.demo.milkservice.web.model.MilkTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MilkLoader implements CommandLineRunner {

    private final MilkRepository milkRepository;

    public MilkLoader(MilkRepository milkRepository) {
        this.milkRepository = milkRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadMilkObjects();
    }

    private void loadMilkObjects() {
        if(milkRepository.count() == 0){
            milkRepository.save(Milk.builder()
                    .milkName("Aavin")
                    .milkType("Nice")
                    .quantityToMilk(200).
                    minOnHand(12)
                    .upc(135792468012L)
                    .price(new BigDecimal(25.50))
                    .build());

            milkRepository.save(Milk.builder()
                    .milkName("Aavin")
                    .milkType("Green Magic")
                    .quantityToMilk(200).
                    minOnHand(12)
                    .upc(135792468013L)
                    .price(new BigDecimal(28.50))
                    .build());
            System.out.println("Loaded Milk Objects -> " + milkRepository.count());
        }
    }
}
