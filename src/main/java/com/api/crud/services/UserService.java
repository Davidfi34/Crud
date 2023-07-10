package com.api.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;

import jakarta.persistence.EntityNotFoundException;


/**
 * Service class for managing user-related operations.
 * @author David Figuerero
 */

@Service
public class UserService{
	
	@Autowired
	IUserRepository userRepository;
	
	
	/**
	 * Retrieves all users.
	 * 
	 * @return List of users
	 */
	
	public ArrayList<UserModel> getUsers(){
		return (ArrayList<UserModel>)userRepository.findAll();
	}
	
	/**
	 * Saves a user.
	 * 
	 * @param user The user to save
	 * @return The saved user
	 */
	public UserModel saveUsers(UserModel user) {
		return userRepository.save(user);
		
	}
	
	/**
	 * Retrieves a user by its ID.
	 * 
	 * @param id The ID of the user
	 * @return The user with the specified ID
	 */
	
	public Optional<UserModel> getById(Long id){
		return userRepository.findById(id);
	}
	
	/**
	 * Updates a user by its ID.
	 * 
	 * @param request The user request containing updated data
	 * @param id The ID of the user to update
	 * @return The updated user
	 */
	public UserModel updateById(UserModel request, Long id){
		UserModel user = userRepository.findById(id).get();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		
		return userRepository.save(user);
	}
	
	/**
	 * Deletes a user by its ID.
	 * 
	 * @param id The ID of the user to delete
	 * @return True if the user was deleted successfully, false otherwise
	 */
	public Boolean daleteUser(Long id) {
		try {
			if (userRepository.existsById(id)) {
				userRepository.deleteById(id);
				return true;
			}
			return false;
		}catch(Exception ex){
			return false;
			
		}
	}
	

	/**
	 * Updates a user partially by its ID.
	 * At least one field must be provided for modification.
	 * 
	 * @param request The user request containing partial updated data
	 * @param id The ID of the user to update
	 * @return The updated user
	 * @throws IllegalArgumentException If at least one field is not provided for modification
	 * @throws EntityNotFoundException If the user is not found
	 */
	public UserModel patchById(UserModel request, Long id) {

		   UserModel user = userRepository.findById(id)
		            .orElseThrow(() -> new EntityNotFoundException("User not found"));
		   
		   	if (request.getFirstName() == null && request.getLastName() == null && request.getEmail() == null) {
		        throw new IllegalArgumentException("At least one field must be provided for modification");
		    }

		    if (request.getFirstName() != null) user.setFirstName(request.getFirstName());
		    if (request.getLastName() != null) user.setLastName(request.getLastName());
		    if (request.getEmail() != null) user.setEmail(request.getEmail());

		    return userRepository.save(user);
	}
	
	

}

