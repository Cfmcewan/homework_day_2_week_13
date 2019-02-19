package com.example.filemanagement.FileManagement.Projections;

import com.example.filemanagement.FileManagement.Models.File;
import com.example.filemanagement.FileManagement.Models.Folder;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="embedFolder", types= File.class)
public interface EmbedFolder {
    String getName();
    String getExtension();
    String getSize();
    Folder getFolder();
}
