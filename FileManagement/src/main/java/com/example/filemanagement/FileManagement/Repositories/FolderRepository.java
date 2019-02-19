package com.example.filemanagement.FileManagement.Repositories;


import com.example.filemanagement.FileManagement.Models.Folder;
import com.example.filemanagement.FileManagement.Projections.EmbedFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmbedFiles.class)
public interface FolderRepository extends JpaRepository<Folder, Long> {
}

