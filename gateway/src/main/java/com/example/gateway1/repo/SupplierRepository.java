package com.example.gateway1.repo;

import com.example.gateway1.model.part.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
