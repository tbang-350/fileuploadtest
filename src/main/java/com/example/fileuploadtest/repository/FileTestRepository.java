package com.example.fileuploadtest.repository;

import com.example.fileuploadtest.entity.FileTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileTestRepository extends JpaRepository<FileTest,Long> {
}
