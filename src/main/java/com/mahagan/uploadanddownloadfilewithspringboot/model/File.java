/**
 * Created By Krishna Shinde
 * Date : 05-06-2023
 * Time : 16:43
 * Project: UploadAndDownloadFileWithSpringBoot
 **/

package com.mahagan.uploadanddownloadfilewithspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.Arrays;

@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String file_Name;
    private String file_Type;
    private byte[] data;

    public File(String fileName, String contentType, byte[] bytes) {
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getFile_Name() {
        return file_Name;
    }

    public void setFile_Name(String file_Name) {
        this.file_Name = file_Name;
    }

    public String getFile_Type() {
        return file_Type;
    }

    public void setFile_Type(String file_Type) {
        this.file_Type = file_Type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public File(String id, String file_Name, String file_Type, byte[] data) {
        this.id = id;
        this.file_Name = file_Name;
        this.file_Type = file_Type;
        this.data = data;
    }

    public File() {
    }

    @Override
    public String toString() {
        return "File{" +
                "id='" + id + '\'' +
                ", file_Name='" + file_Name + '\'' +
                ", file_Type='" + file_Type + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

}


