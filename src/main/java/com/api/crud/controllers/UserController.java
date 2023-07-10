package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;

/**
 * Controller class for managing user-related operations.
 * @author David Figuerero
 */

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * Retrieves all users.
	 * 
	 * @return List of users
	 */
	@GetMapping
	public ArrayList<UserModel> getUsers(){
		return this.userService.getUsers();
	}
	
	/**
	 * Saves a user.
	 * 
	 * @param user The user to save
	 * @return The saved user
	 */
	@PostMapping
	public UserModel saveUsers(@RequestBody UserModel user) {
		return this.userService.saveUsers(user);
	}
	
	/**
	 * Retrieves a user by its ID.
	 * 
	 * @param id The ID of the user
	 * @return The user with the specified ID
	 */
	@GetMapping(path ="/{id}")
	public Optional<UserModel> getUserById(@PathVariable Long id){
		return this.userService.getById(id);
	}
	
	/**
	 * Updates a user by its ID.
	 * 
	 * @param request The user request containing updated data
	 * @param id The ID of the user to update
	 * @return The updated user
	 */
	@PutMapping(path ="/{id}")
	public UserModel updateUserById(@RequestBody UserModel request,@PathVariable Long id ){
		return this.userService.updateById(request, id);
	}
	
	
	/**
	 * Deletes a user by its ID.
	 * 
	 * @param id The ID of the user to delete
	 * @return A message indicating the success or failure of the deletion
	 */
	@DeleteMapping(path ="/{id}")
	public String deleteById(@PathVariable Long id) {
		boolean ok = this.userService.daleteUser(id);
		
		System.out.println(ok);
		
		if(ok){
			return "User with id "+ id + " deleted";
		}else {
			return "error, when deleting user: "+id;
		}
		
	}
	
	
	/**
	 * Updates a user partially by its ID.
	 * 
	 * @param request The user request containing partial updated data
	 * @param id The ID of the user to update
	 * @return The updated user
	 */
	@PatchMapping(path ="/{id}")
	public UserModel updateUserPatch(@RequestBody UserModel request,@PathVariable Long id) {
		return this.userService.patchById(request, id);
	}
	

}
