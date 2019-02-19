package com.example.filemanagement.FileManagement.Repositories;

import com.example.filemanagement.FileManagement.Models.User;
import com.example.filemanagement.FileManagement.Projections.EmbedFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmbedFolder.class)
public interface UserRepository extends JpaRepository<User, Long> {
}
