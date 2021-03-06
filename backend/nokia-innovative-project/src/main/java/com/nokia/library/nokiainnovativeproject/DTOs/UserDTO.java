package com.nokia.library.nokiainnovativeproject.DTOs;

import com.nokia.library.nokiainnovativeproject.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	@Size(min = 3, max = 30, message = "User's name must be 3-30 characters long")
	@NotBlank(message = "User's name can't be null and can't contain whitespace")
	private String firstName;

	@Size(min = 3, max = 30, message = "User's surname must be 3-30 characters long")
	@NotBlank(message = "User's surname can't be null and can't contain whitespace")
	private String lastName;

	@Email(message = "Email should be valid")
	@NotBlank(message = "Email can't be empty")
	@Size(max = 255, message = "The maximum size of the email is 255")
	private String email;

	@NotNull(message = "Password can't be null")
	@Size(min = 7, max = 255, message = "Password must be 7-255 characters long")
	private String password;

	@Valid
	private Address address;
}