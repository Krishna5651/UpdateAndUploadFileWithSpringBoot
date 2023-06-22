/**
 * Created By Krishna Shinde
 * Date : 05-06-2023
 * Time : 17:19
 * Project: UploadAndDownloadFileWithSpringBoot
 **/

package com.mahagan.uploadanddownloadfilewithspringboot.exception;

public class FileStorageException extends RuntimeException {

    public FileStorageException(String message){
        super(message);
    }
    public FileStorageException(String message,Throwable cause){
        super(message,cause);
    }
}


