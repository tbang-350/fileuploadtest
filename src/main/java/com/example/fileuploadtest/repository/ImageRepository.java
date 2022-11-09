package com.example.fileuploadtest.repository;


import com.example.fileuploadtest.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
