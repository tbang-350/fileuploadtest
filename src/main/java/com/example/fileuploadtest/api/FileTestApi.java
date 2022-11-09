package com.example.fileuploadtest.api;

import com.example.fileuploadtest.dto.FileTestDto;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileTestApi {
//    @RequestMapping(path = "/post",method = RequestMethod.POST)
//    public void post(@ModelAttribute FileTestDto fileTestDto)throws IOException;

    //    @PostMapping("/upload")
    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public void post(@ModelAttribute FileTestDto fileTestDto) throws IOException;
}
