/**
 * Created By Krishna Shinde
 * Date : 05-06-2023
 * Time : 17:38
 * Project: UploadAndDownloadFileWithSpringBoot
 **/

package com.mahagan.uploadanddownloadfilewithspringboot.controller;

import com.mahagan.uploadanddownloadfilewithspringboot.model.File;
import com.mahagan.uploadanddownloadfilewithspringboot.model.Response;
import com.mahagan.uploadanddownloadfilewithspringboot.service.DatabaseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileUploadController {
    @Autowired
    DatabaseFileService databaseFileService;

    @PostMapping("/uploadfile")
    public Response uploadFile(@RequestParam("file")MultipartFile file) {
        File filename = databaseFileService.storeFile(file);

        String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
                .path(filename.getFile_Name())
                .toUriString();

        return new Response(filename.getFile_Name(),fileDownloadUrl,file.getContentType(),file.getSize());


    }


    /*
    *@param files files
    * @return collect(Collectors.toList())
     */
    @PostMapping("/uploadMultipleFiles")
    public List<Response> uploadMultipleFiles(@RequestParam("files")MultipartFile files){
        return Arrays.asList(files)
                .stream()
                .map(file1 -> uploadFile(file1))
                .collect(Collectors.toList());
    }
}


