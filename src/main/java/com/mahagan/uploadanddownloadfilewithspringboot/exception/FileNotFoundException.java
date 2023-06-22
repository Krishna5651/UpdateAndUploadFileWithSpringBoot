/**
 * Created By Krishna Shinde
 * Date : 05-06-2023
 * Time : 17:34
 * Project: UploadAndDownloadFileWithSpringBoot
 **/

package com.mahagan.uploadanddownloadfilewithspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundException extends RuntimeException{

    public  FileNotFoundException(String message){
        super(message);
    }
    public  FileNotFoundException(String message,Throwable cause){
        super(message,cause);
    }

}


