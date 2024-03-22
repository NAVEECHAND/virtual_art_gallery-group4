package com.service;

import java.sql.SQLException;
import java.util.List;
import com.dao.*;
import com.exception.DatabaseConnectionException;
import com.exception.InvalidInputException;
import com.model.Artwork;
import com.dao.*;


public class ArtworkService {

	ArtworkDao artworkDao = new ArtworkDaoImpl();

	public List<Artwork> fetchArtworks() throws SQLException, DatabaseConnectionException 
	{
		List<Artwork> list = artworkDao.fetchAllArtworks();
		return list;
	}

	public Artwork getArtworkById(List<Artwork> list, int id) throws InvalidInputException 
	{
		for (Artwork c : list) {
			if (c.getId() == id)
				return c;
		}
		throw new InvalidInputException("Artwork not found");
	}

	public Artwork getArtworkByTitle(List<Artwork> list, String title) throws InvalidInputException
	{
		for (Artwork c : list) 
		{
			if (c.getTitle().equals(title))
				return c;
		}
		throw new InvalidInputException("Title doesn't match");
	}

	public void createArtwork(String title, String description, String date, String medium, String imageurl,
			double price)
			throws DatabaseConnectionException, SQLException 
	{

		artworkDao.createArtwork(title, description, date, medium, imageurl,price);

	}

	public void updateArtwork(int id, String field, String newVal) throws DatabaseConnectionException, SQLException, InvalidInputException 
	{
		String fieldd=field.toLowerCase().replace(" ","_");
		if(fieldd.equals("id"))
			throw new InvalidInputException("Artwork could not be updated");
		else
			artworkDao.updateArtwork(id,fieldd,newVal);
		
	}

	public void deleteArtworkById(int id) throws SQLException, DatabaseConnectionException 
	{
		
		artworkDao.deleteArtworkById(id);
		
	}

}