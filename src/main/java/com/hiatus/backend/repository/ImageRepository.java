package com.hiatus.backend.repository;


import com.hiatus.backend.model.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageData, Long> {
    ImageData findById(long Id);
}
