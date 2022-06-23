package com.example.gateway1.repo;

import com.example.gateway1.model.part.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {
    List<Part> findByOriginalModelId (Long originalModelId);
    List<Part> findByOriginalModelIdInOrReplaceModelsIn (Iterable<Long> originalModelId,
                                                          Iterable<Long> replaceModelId);
    List<Part> findByReplaceModels(Long replaceModelId);
}
