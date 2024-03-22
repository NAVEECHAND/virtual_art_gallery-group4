package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.exception.DatabaseConnectionException;
import com.model.Artwork;

public interface ArtworkDao {

	List<Artwork> fetchAllArtworks() throws SQLException, DatabaseConnectionException;


	void createArtwork(String title, String description, String date, String medium, String imageurl,
			double price) 
			throws SQLException, DatabaseConnectionException;
	
	void updateArtwork(int id, String field, String newVal) 
			throws SQLException, DatabaseConnectionException;
	
	void deleteArtworkById(int id) 
			throws SQLException, DatabaseConnectionException;



	

}