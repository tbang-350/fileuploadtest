package com.example.fileuploadtest.controller;

import com.example.fileuploadtest.api.FileTestApi;
import com.example.fileuploadtest.dto.FileTestDto;
import com.example.fileuploadtest.entity.FileTest;
import com.example.fileuploadtest.entity.Image;
import com.example.fileuploadtest.repository.FileTestRepository;
import com.example.fileuploadtest.repository.ImageRepository;
import com.example.fileuploadtest.response.ImageUploadResponse;
import com.example.fileuploadtest.service.FileTestService;
import com.example.fileuploadtest.util.ImageUtility;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@RestController
//@RequestMapping(name = "/api/filetest")
@AllArgsConstructor
public class FileTestController implements FileTestApi {

    @Autowired
    private final FileTestService fileTestService;

    @Autowired
    private final FileTestRepository fileTestRepository;

    @Autowired
    private final ImageRepository imageRepository;

    public static final String dir = System.getProperty("user.home")+"/UPLOADS";

    //bashiri
    @PostMapping("/save")
    public void uploadFile(@ModelAttribute FileTest fileTest , @RequestParam("image")MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        fileTest.setFile(filename);
        fileTestService.savefile(fileTest);
        Path fileStorage = Paths.get(dir,filename).toAbsolutePath().normalize();
        Files.copy(file.getInputStream(),fileStorage, StandardCopyOption.REPLACE_EXISTING);
    }

    //joseph
    @Override
    public void post(@ModelAttribute FileTestDto fileTestDto) throws IOException {
        fileTestService.addFile(fileTestDto);
    }

    @PostMapping("/upload/image")
    public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {

        imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK).body(new ImageUploadResponse("Image uploaded successfully: " + file.getOriginalFilename()));
    }
}
