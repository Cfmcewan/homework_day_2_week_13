package com.example.filemanagement.FileManagement.Projections;

import com.example.filemanagement.FileManagement.Models.Folder;
import com.example.filemanagement.FileManagement.Models.User;
import org.springframework.data.rest.core.config.Projection;

import java.nio.file.Files;
import java.util.List;

@Projection(name="embedUser", types= Folder.class)
public interface EmbedUser {
    String getTitle();
    List<Files> getFiles();
    User getUser();
}
