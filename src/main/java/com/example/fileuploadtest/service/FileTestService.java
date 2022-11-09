package com.example.fileuploadtest.service;

import com.example.fileuploadtest.dto.FileTestDto;
import com.example.fileuploadtest.entity.FileTest;
import com.example.fileuploadtest.repository.FileTestRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;

@Service
@AllArgsConstructor
public class FileTestService {

    @Autowired
    private final FileTestRepository fileTestRepository;

    private ModelMapper mapper;

    public void savefile(FileTest fileTest){
        fileTestRepository.save(fileTest);
    }

    public void addFile(FileTestDto fileTestDto) throws IOException {
        FileTest fileTest = mapper.map(fileTestDto,FileTest.class);
        fileTest.setFile(Base64.getEncoder().encodeToString(fileTestDto.getTest_file().getBytes()));
        fileTestRepository.save(fileTest);
    }
}
