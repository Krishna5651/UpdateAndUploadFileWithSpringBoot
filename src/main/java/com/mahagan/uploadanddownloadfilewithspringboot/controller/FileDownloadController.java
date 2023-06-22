/**
 * Created By Krishna Shinde
 * Date : 05-06-2023
 * Time : 17:41
 * Project: UploadAndDownloadFileWithSpringBoot
 **/

package com.mahagan.uploadanddownloadfilewithspringboot.controller;

import com.mahagan.uploadanddownloadfilewithspringboot.model.File;
import com.mahagan.uploadanddownloadfilewithspringboot.service.DatabaseFileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController {
    @Autowired
    private DatabaseFileService databaseFileService;
    @GetMapping("/downloadFile/{file_Name:.+}")
public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
    /*
    * Load file as a resourse from local
     */
    File file=databaseFileService.getFile(fileName);

    return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(file.getFile_Type()))
            .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;fileName=\""+file.getFile_Name()+"\"")
            .body(new ByteArrayResource(file.getData()));

}

}


