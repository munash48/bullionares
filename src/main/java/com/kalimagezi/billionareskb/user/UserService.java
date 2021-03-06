package com.kalimagezi.billionareskb.user;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kalimagezi.billionareskb.category.Category;
import com.kalimagezi.billionareskb.category.CategoryService;
import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserController userController;
	@Autowired
	private CounterService counterService ;
	@Autowired
	private CategoryService categoryService ;

	
	@Autowired
	private UserModelRepository userModelRepository;
	
	

	public List<User> getAllUsers() {

		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);

		return users;

	}
	
	

//	public void addUser(User user) {
//		
//		userRepository.save(user);
//		
//		
//	}
	public String addUser(User user) {

		JSONObject jsonObject = new JSONObject();
		
		if(user.getEmail().equals("mugwanyan@kyu.ac.ug")) {
			user.setRole("ROLE_ADMIN");
			user.setCatid(1);
			
		}
		
		
		try {
			
			userRepository.save(user);	
			Category category =categoryService.getCategory(user.getCatid()).orElseThrow(null);
			category.setNoMembers(category.getNoMembers()+1);
			categoryService.addCategory(category);
						
			jsonObject.put("status", "success");
			jsonObject.put("message", user.getEmail()+" Created successfully sending password link");
			
			userController.createUseradons(user); 
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				jsonObject.put("message", user.getEmail()+" Already taken choose another");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		

		return jsonObject.toString();
	}
	

	public Optional<User> getUser(int id) {
		
	    return userRepository.findById(id);
	}

	public String updateUser(User user) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		
		userRepository.save(user);
		Counter counter =counterService.getUCounter(user.getId());
		
		jsonObject.put("message", user.getEmail()+" Updated successfully");
		jsonObject.put("noVotes", counter.getNoVotes());
		jsonObject.put("noTVotes", counter.getTotal());
		jsonObject.put("about", user.getAboutme());
		jsonObject.put("status", "success");
				
		return jsonObject.toString();

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
