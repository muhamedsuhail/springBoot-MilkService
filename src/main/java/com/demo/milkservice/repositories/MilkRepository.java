package com.demo.milkservice.repositories;

import com.demo.milkservice.domain.Milk;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MilkRepository extends PagingAndSortingRepository<Milk,UUID> {
}
