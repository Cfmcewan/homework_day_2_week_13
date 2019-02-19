package com.example.filemanagement.FileManagement;

import com.example.filemanagement.FileManagement.Models.File;
import com.example.filemanagement.FileManagement.Models.Folder;
import com.example.filemanagement.FileManagement.Models.User;
import com.example.filemanagement.FileManagement.Repositories.FileRepository;
import com.example.filemanagement.FileManagement.Repositories.FolderRepository;
import com.example.filemanagement.FileManagement.Repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileManagementApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createFileFolderAndUserThenSave(){

		User user1 = new User("Bob");
		userRepository.save(user1);

		Folder folder1 = new Folder("All_Documents", user1);
		folderRepository.save(folder1);

		File file1 = new File("document", "txt", "200KB", folder1);
		fileRepository.save(file1);
	}


	@Test
	public void createUserAndAddFolders(){
		User user1 = new User("Bob");
		userRepository.save(user1);

		Folder folder1 = new Folder("All_Documents", user1);
		folderRepository.save(folder1);

		File file1 = new File("document", "txt", "200KB", folder1);
		fileRepository.save(file1);

		user1.addFolder(folder1);
		userRepository.save(user1);
	}

	@Test
	public void createFolderAndAddFiles(){
		User user1 = new User("Bob");
		userRepository.save(user1);

		Folder folder1 = new Folder("All_Documents", user1);
		folderRepository.save(folder1);

		File file1 = new File("document", "txt", "200KB", folder1);
		fileRepository.save(file1);

		folder1.addFiles(file1);
		folderRepository.save(folder1);
	}

	@Test
	public void canRemoveFolderFromUser(){
		User user1 = new User("Bob");
		userRepository.save(user1);

		Folder folder1 = new Folder("All_Documents", user1);
		folderRepository.save(folder1);

		File file1 = new File("document", "txt", "200KB", folder1);
		fileRepository.save(file1);

		user1.addFolder(folder1);
		user1.removeFolder(folder1);
		userRepository.save(user1);
	}

	@Test
	public void canRemoveFileFromFolder(){
		User user1 = new User("Bob");
		userRepository.save(user1);

		Folder folder1 = new Folder("All_Documents", user1);
		folderRepository.save(folder1);

		File file1 = new File("document", "txt", "200KB", folder1);
		fileRepository.save(file1);

		folder1.addFiles(file1);
		folder1.removeFile(file1);
		folderRepository.save(folder1);
	}

	@Test
	public void canUpdateFolderTitle(){
		User user1 = new User("Bob");
		userRepository.save(user1);

		Folder folder1 = new Folder("All_Documents", user1);
		folderRepository.save(folder1);

		Folder folder2 = new Folder("All_Documents", user1);
		folderRepository.save(folder2);

		File file1 = new File("document", "txt", "200KB", folder1);
		fileRepository.save(file1);

		folder1.setTitle("New_Title");
		folderRepository.save(folder1);
	}

	@Test
	public void canUpdateFolderInFile(){
		User user1 = new User("Bob");
		userRepository.save(user1);

		Folder folder1 = new Folder("All_Documents", user1);
		folderRepository.save(folder1);

		Folder folder2 = new Folder("All_Documents", user1);
		folderRepository.save(folder2);

		File file1 = new File("document", "txt", "200KB", folder1);
		fileRepository.save(file1);

		file1.setFolder(folder2);
		fileRepository.save(file1);
	}

	@Test
	public void canUpdateNameOfUser(){
		User user1 = new User("Bob");
		userRepository.save(user1);

		Folder folder1 = new Folder("All_Documents", user1);
		folderRepository.save(folder1);

		Folder folder2 = new Folder("All_Documents", user1);
		folderRepository.save(folder2);

		File file1 = new File("document", "txt", "200KB", folder1);
		fileRepository.save(file1);

		user1.setName("Sally");
		userRepository.save(user1);
	}
}
