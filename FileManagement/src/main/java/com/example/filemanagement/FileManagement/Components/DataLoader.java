package com.example.filemanagement.FileManagement.Components;

import com.example.filemanagement.FileManagement.Models.File;
import com.example.filemanagement.FileManagement.Models.Folder;
import com.example.filemanagement.FileManagement.Models.User;
import com.example.filemanagement.FileManagement.Repositories.FileRepository;
import com.example.filemanagement.FileManagement.Repositories.FolderRepository;
import com.example.filemanagement.FileManagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    public DataLoader(){
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User("Bob");
        userRepository.save(user1);

        Folder folder1 = new Folder("All_Documents", user1);
        folderRepository.save(folder1);

        File file1 = new File("document", "txt", "200KB", folder1);
        fileRepository.save(file1);

        Folder folder2 = new Folder("All_Documents", user1);
        folderRepository.save(folder2);

        user1.addFolder(folder1);
        userRepository.save(user1);

        folder1.addFiles(file1);
        folderRepository.save(folder1);

        user1.addFolder(folder1);
        user1.removeFolder(folder1);
        userRepository.save(user1);

        folder1.addFiles(file1);
        folder1.removeFile(file1);
        folderRepository.save(folder1);

        folder1.setTitle("New_Title");
        folderRepository.save(folder1);

        file1.setFolder(folder2);
        fileRepository.save(file1);

        user1.setName("Sally");
        userRepository.save(user1);
    }

}
