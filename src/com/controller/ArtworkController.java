package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.DatabaseConnectionException;
import com.exception.InvalidInputException;

import com.model.Artwork;
import com.service.ArtworkService;

import java.util.*;
public class ArtworkController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArtworkService ArtworkService = new ArtworkService();
		while (true) {
			System.out.println();
			System.out.println("*Artwork*");
			System.out.println("press 1. Get Artwork By ArtistId");
			System.out.println("press 2. Search Artwork By Title");
			System.out.println("press 3. Create Artwork");
			System.out.println("press 4. Update Artwork");
			System.out.println("press 5. Delete Artwork");
			System.out.println("press 0. for exit");
			System.out.println("");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exited Thank you!!!");
				break;
			}
			switch (input) {
			case 1:
				try {
					List<Artwork> list = ArtworkService.fetchArtworks();
					System.out.println("Enter Artwork Id: ");
					int id = sc.nextInt();
					Artwork c = ArtworkService.getArtworkById(list, id);
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s", "id",
							"title", "decription", "date", "medium", "imageurl", "price"));
					System.out.println(String.format("%-15d%-15s%-15s%-15s%-15s%-15s%-15s%s", c.getId(),
							c.getTitle(), c.getDescription(), c.getDate(), c.getMedium(), c.getImageurl(),
							c.getPrice()));
				} catch (DatabaseConnectionException | SQLException | InvalidInputException e) {
					System.out.println(e.getMessage());
					break;
				}
				break;
			case 2:
				try {
					List<Artwork> list = ArtworkService.fetchArtworks();
					System.out.println("Enter Artwork By title: ");
					String Title = sc.next();
					Artwork c = ArtworkService.getArtworkByTitle(list, Title);
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s", "id",
							"title", "decription", "date", "medium", "imageurl", "price"));
					System.out.println(String.format("%-15d%-15s%-15s%-15s%-15s%-15s%-15s%s", c.getId(),
							c.getTitle(), c.getDescription(), c.getDate(), c.getMedium(), c.getImageurl(),
							c.getPrice()));
				} catch (SQLException | DatabaseConnectionException | InvalidInputException e) {
					System.out.println(e.getMessage());
					break;
				}
				break;
			case 3:
				System.out.println("Enter Title: ");
				String title=sc.next();
				System.out.println("Enter Description: ");
				String description=sc.next();
				System.out.println("Enter CreationDate: ");
				String date=sc.next();
				System.out.println("Enter Medium: ");
				String medium=sc.next();
				System.out.println("Enter ImageUrl: ");
				String imageurl=sc.next();
				System.out.println("Enter Price: ");
				double price=sc.nextDouble();
				try {
					ArtworkService.createArtwork(title, description, date, medium,imageurl,price);
					System.out.println("Created Successfull!!");
				} catch (DatabaseConnectionException |SQLException e) {
					System.out.println(e.getMessage());
					break;
				} 
				break;
			case 4:
				try {
					List<Artwork>list = ArtworkService.fetchArtworks();
					System.out.println("Enter Artwork to update: ");
					int id = sc.nextInt();
					System.out.println();
					Artwork c = ArtworkService.getArtworkById(list, id);
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s", "id",
							"title", "decription", "date", "medium", "imageurl", "price"));
					System.out.println(String.format("%-15d%-15s%-15s%-15s%-15s%-15s%-15s%s", c.getId(),
							c.getTitle(), c.getDescription(), c.getDate(), c.getMedium(), c.getImageurl(),
							c.getPrice()));
					System.out.println("Things to be updated");
					sc.nextLine();				
					String field=sc.nextLine();
					System.out.println("Enter the new value: ");
					String newVal=sc.next();
					ArtworkService.updateArtwork(id,field,newVal);
					System.out.println("Artwork updated Successfully");
				} catch (SQLException | DatabaseConnectionException | InvalidInputException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				
				System.out.println("Enter Artwork to be Deleted: ");
				int id = sc.nextInt();
				try {
					ArtworkService.deleteArtworkById(id);
					System.out.println("Artwork is Deleted!!");
				} catch (SQLException | DatabaseConnectionException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}
	}
}