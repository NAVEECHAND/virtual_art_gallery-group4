package com.model;
import java.util.Date;
public class CustomerModel {
private int customerId;
private String username;
private String password;
private String email;
private String firstName;
private String lastName;
private Date dateOfBirth;
private String profilePic;
private String favouriteArtwork;
public CustomerModel() {}
public CustomerModel(int customerId, String username, String password, String email, String firstName, String lastName,
		Date dateOfBirth, String profilePic, String favouriteArtwork) {
	super();
	this.customerId = customerId;
	this.username = username;
	this.password = password;
	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.profilePic = profilePic;
	this.favouriteArtwork = favouriteArtwork;
}
public CustomerModel(String username, String password, String email, String firstName, String lastName,
		Date dateOfBirth, String profilePic, String favouriteArtwork) {
	super();
	this.username = username;
	this.password = password;
	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.profilePic = profilePic;
	this.favouriteArtwork = favouriteArtwork;
	
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getProfilePic() {
	return profilePic;
}
public void setProfilePic(String profilePic) {
	this.profilePic = profilePic;
}
public String getFavouriteArtwork() {
	return favouriteArtwork;
}
public void setFavouriteArtwork(String favouriteArtwork) {
	this.favouriteArtwork = favouriteArtwork;
}
@Override
public String toString() {
	return "CustomerModel [customerId=" + customerId + ", username=" + username + ", password=" + password + ", email="
			+ email + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
			+ ", profilePic=" + profilePic + ", favouriteArtwork=" + favouriteArtwork + "]";
}
}
