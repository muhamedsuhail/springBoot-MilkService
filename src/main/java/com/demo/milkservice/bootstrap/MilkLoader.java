package com.demo.milkservice.bootstrap;

import com.demo.milkservice.domain.Milk;
import com.demo.milkservice.repositories.MilkRepository;
import com.demo.milkservice.web.model.MilkDTO;
import com.demo.milkservice.web.model.MilkTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class MilkLoader implements CommandLineRunner {

    public static final String MILK_1_UPC = "0631234200036";
    public static final String MILK_2_UPC = "0631234300019";
    public static final String MILK_3_UPC = "0083783375213";

    private final MilkRepository milkRepository;

    @Override
    public void run(String... args) throws Exception {
        if(milkRepository.count() == 0 ) {
            loadMilkObjects();
        }
    }

    private void loadMilkObjects() {
        Milk milk1 = Milk.builder()
                .milkName("Aavin")
                .milkType(MilkTypeEnum.NICE.name())
                .quantityToMilk(200)
                .minOnHand(12)
                .upc(MILK_1_UPC)
                .price(new BigDecimal(25.50))
                .build();

        Milk milk2 = Milk.builder()
                .milkName("Aavin")
                .milkType(MilkTypeEnum.GREEN_MAGIC.name())
                .quantityToMilk(200)
                .minOnHand(12)
                .upc(MILK_2_UPC)
                .price(new BigDecimal(28.50))
                .build();

        Milk milk3 = Milk.builder()
                .milkName("Aavin")
                .milkType(MilkTypeEnum.PREMIUM.name())
                .quantityToMilk(200)
                .minOnHand(12)
                .upc(MILK_3_UPC)
                .price(new BigDecimal(32.50))
                .build();

        milkRepository.save(milk1);
        milkRepository.save(milk2);
        System.out.println("Loaded Milk Objects -> " + milkRepository.count());
    }
}
