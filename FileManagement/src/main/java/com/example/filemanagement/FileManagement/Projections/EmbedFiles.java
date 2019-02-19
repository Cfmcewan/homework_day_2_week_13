package com.example.filemanagement.FileManagement.Projections;

import com.example.filemanagement.FileManagement.Models.Folder;
import org.springframework.data.rest.core.config.Projection;

import java.nio.file.Files;
import java.util.List;

@Projection(name="embedFiles", types= Folder.class)
public interface EmbedFiles {
    String getTitle();
    List<Files> getFiles();
}
