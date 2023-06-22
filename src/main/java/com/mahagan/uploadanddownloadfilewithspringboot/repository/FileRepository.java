/**
 * Created By Krishna Shinde
 * Date : 05-06-2023
 * Time : 16:57
 * Project: UploadAndDownloadFileWithSpringBoot
 **/

package com.mahagan.uploadanddownloadfilewithspringboot.repository;

import com.mahagan.uploadanddownloadfilewithspringboot.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository <File,String> {
}
