/**
 * Created By Krishna Shinde
 * Date : 05-06-2023
 * Time : 17:09
 * Project: UploadAndDownloadFileWithSpringBoot
 **/

package com.mahagan.uploadanddownloadfilewithspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


public class Response {
    private String file_Name;
    private String file_Download_Url;
    private String file_Type;
    private String size;

    public Response(String fileName, String fileDownloadUrl, String contentType, long size) {
    }

    @Override
    public String toString() {
        return "Response{" +
                "file_Name='" + file_Name + '\'' +
                ", file_Download_Url='" + file_Download_Url + '\'' +
                ", file_Type='" + file_Type + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public String getFile_Name() {
        return file_Name;
    }

    public void setFile_Name(String file_Name) {
        this.file_Name = file_Name;
    }

    public String getFile_Download_Url() {
        return file_Download_Url;
    }

    public void setFile_Download_Url(String file_Download_Url) {
        this.file_Download_Url = file_Download_Url;
    }

    public String getFile_Type() {
        return file_Type;
    }

    public void setFile_Type(String file_Type) {
        this.file_Type = file_Type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Response(String file_Name, String file_Download_Url, String file_Type, String size) {
        this.file_Name = file_Name;
        this.file_Download_Url = file_Download_Url;
        this.file_Type = file_Type;
        this.size = size;
    }

    public Response() {
    }
}


