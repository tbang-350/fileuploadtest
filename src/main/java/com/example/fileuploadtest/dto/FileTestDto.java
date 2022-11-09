package com.example.fileuploadtest.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileTestDto {
    private String route_name;
    private Double latitude;
    private Double longitude;
    private MultipartFile test_file;
}
