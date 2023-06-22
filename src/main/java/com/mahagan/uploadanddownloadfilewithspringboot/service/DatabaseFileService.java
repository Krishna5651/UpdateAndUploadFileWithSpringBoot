/**
 * Created By Krishna Shinde
 * Date : 05-06-2023
 * Time : 17:12
 * Project: UploadAndDownloadFileWithSpringBoot
 **/

package com.mahagan.uploadanddownloadfilewithspringboot.service;

import com.mahagan.uploadanddownloadfilewithspringboot.exception.FileNotFoundException;
import com.mahagan.uploadanddownloadfilewithspringboot.exception.FileStorageException;
import com.mahagan.uploadanddownloadfilewithspringboot.model.File;
import com.mahagan.uploadanddownloadfilewithspringboot.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DatabaseFileService {
    @Autowired
    private FileRepository fileRepository;

    public File storeFile(MultipartFile file){
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        try{
//            //check the file name contains as invalid characters
            if(fileName.contains("....")){
                throw new FileStorageException("Sorrryyyy!!!!!!  File found Exception to enable dat"+fileName);
            }
            File dbfile=new File(fileName,file.getContentType(),file.getBytes());
            return fileRepository.save(dbfile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file"+fileName+ "Please try again"+ex);
        }

    }
    public File getFile(String file_Id) {
        return fileRepository.findById(file_Id).orElseThrow(() -> new FileNotFoundException("File not found with Id"+file_Id));
    }
}


