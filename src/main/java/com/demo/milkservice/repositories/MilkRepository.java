package com.demo.milkservice.repositories;

import com.demo.milkservice.domain.Milk;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface MilkRepository extends PagingAndSortingRepository<Milk,UUID> {
}
