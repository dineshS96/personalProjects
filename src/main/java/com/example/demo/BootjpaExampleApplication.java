package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;

@SpringBootApplication
public class BootjpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext con = SpringApplication.run(BootjpaExampleApplication.class, args);
		UserRepository userRepository = con.getBean(UserRepository.class);
		
		  User user = new User(); 
		  user.setName("Dinesh"); 
		  user.setCity("Mumbai");
		  user.setStatus("SA");
		  
		  User user1 = userRepository.save(user); 
		  System.out.println(user1);
		 
		
		/*
		 * User user2=new User(); user2.setName("Uttam"); user2.setCity("city1");
		 * user2.setStatus("python p");
		 * 
		 * User user3=new User(); user3.setName("Ankit"); user3.setCity("city2");
		 * user3.setStatus("Java p");
		 * 
		 * List<User> users=List.of(user2,user3);
		 * 
		 * Iterable<User> result=userRepository.saveAll(users); result.forEach(user->{
		 * System.out.println(user); });
		 * 
		 * 
		 * System.out.println("Saved user:"+result);
		 */
		
		/*
		 * Optional<User> optional = userRepository.findById(1); 
		 * User user = optional.get(); 
		 * user.setName("Ankit sharma"); 
		 * userRepository.save(user);
		 * System.out.println(user);
		 */
		//Iterable<User> findAll = userRepository.findAll();
		/*
		 * Iterator<User> iterator = itr.iterator(); 
		 * while(iterator.hasNext()) 
		 * { User
		 * user = iterator.next(); System.out.println(user); }
		 */
		
		/*
		 * itr.forEach(new Consumer<User>() {
		 * 
		 * @Override 
		 * public void accept(User t) 
		 * { // TODO Auto-generated method stub
		 * System.out.println(t); } } );
		 */
		
		//itr.forEach(user->System.out.println(user));
		
		//userRepository.deleteById(1);
		
		/*
		 * Iterable<User> allusers = userRepository.findAll();
		 * allusers.forEach(user->System.out.println(user));
		 * userRepository.deleteAll(allusers);
		 */
		
		//List<User> users=userRepository.findByNameAndCity("shubham","kanpur");
		//users.forEach(e->System.out.println(e));
		  
		  List<User> allUser = userRepository.getAllUser();
		  
		  allUser.forEach(e->System.out.println(e));
		  
		  List<User> userByName = userRepository.getUserByName("Shubham");
		  userByName.forEach(e->System.out.println(e));
	}

}
