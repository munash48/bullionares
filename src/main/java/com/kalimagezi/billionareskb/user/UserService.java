package com.kalimagezi.billionareskb.user;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserModelRepository userModelRepository;
	
	

	public List<User> getAllUsers() {

		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);

		return users;

	}
	
	

	public void addUser(User user) {
		userRepository.save(user);
	}

	public Optional<User> getUser(int id) {
		
	    return userRepository.findById(id);
	}

	public void updateUser(int id, User user) {
		userRepository.save(user);

	}

	public void deleteUser(int id) {
		userRepository.deleteById(id); 
		

	}
	
	
	public User findByEmail (String email) {
		
		
		return userModelRepository.findByEmail(email);
		
	}



	public void saveImage(MultipartFile imageFile, String ppath, String pname) throws IOException {
//  Path currentPath = Paths.get(".");
//	Path absolutePath = currentPath.toAbsolutePath();
//	System.out.println("absolute path is "+absolutePath);
//	String folder=absolutePath +"/src/main/resources/static/images/" +ppath;
		String folder=ppath;
		String thubfilder=ppath+"thumbs/";
		byte[] bytes = imageFile.getBytes();
		
		File directory = new File(folder);
		File directory2 = new File(thubfilder);
	    if (! directory.exists()||! directory2.exists()){
	        directory.mkdirs();
	        directory2.mkdirs();	        
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }
	    
		Path path = Paths.get(folder+ pname);
		Path thumbpath=Paths.get(thubfilder+pname);
		Files.write(path, bytes);
		Files.write(thumbpath, bytes);
		
		String path2=path.toString();
		Thumbnails.of(path2).size(700, 700).toFile(path2);

		
		
	}



	public List<User> getAllByCatid(int catid) {
		// TODO Auto-generated method stub
		return userRepository.findAllByCatid(catid); 
	}



	public User findByResetcode(String resetcode) {
		// TODO Auto-generated method stub
		return userRepository.findAllByResetcode(resetcode); 
	}
	


}
