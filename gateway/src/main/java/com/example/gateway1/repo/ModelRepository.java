package com.example.gateway1.repo;

import com.example.gateway1.model.part.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Long> findPartsByMainNameAndSubName(String mainName, String subName);
    List<Model> findByMainName(String mainName);
}
