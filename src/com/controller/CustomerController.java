package com.controller;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.model.CustomerModel;
import com.service.CustomerService;
public class CustomerController {
public static void main(String[] args) {
	CustomerService customerService=new CustomerService();
	Scanner sc=new Scanner(System.in);
	while(true)
	{
		System.out.println("****************OPS****************");
		System.out.println("ENTER 1 TO FETCH");
		System.out.println("ENTER 2 TO DELETE");
		System.out.println("ENTER 3 TO UPDATE");
		System.out.println("ENTER 4 TO SIGNUP");
		System.out.println("ENTER 0 TO EXIT");
		int input=sc.nextInt();
		if(input==0)
		{
		System.out.println("EXITING.......THANK YOU!!!!");
		break;
		}
		switch(input)
		{
		case 1:
		System.out.println("FETCH ALL DETAILS");
		List<CustomerModel>list=customerService.fetchAll();
		for(CustomerModel c:list)
		{
		System.out.println(c.getCustomerId()+"\t"+c.getUsername()+c.getPassword()+"\t"+c.getEmail()+"\t"+c.getFirstName()+"\t"+c.getLastName()+"\t"
		+c.getDateOfBirth()+"\t"+c.getProfilePic()+"\t"+c.getFavouriteArtwork());
		}
		break;
		
		case 2:
			System.out.println("DELETE");
			System.out.println("Enter the Id to be deleted");
			int id1=sc.nextInt();
			customerService.delete(id1);
			System.out.println("DELETED################");
			break;
		
		case 3:
			System.out.println("UPDATE");
			System.out.println("Enter the password to be updated");
			sc.nextLine();
			String password=sc.nextLine();
			System.out.println("Enter the Id to be updated");
			int id9=sc.nextInt();
			customerService.update(id9);
			System.out.println("UPDATED################");
			break;
		case 4:
	
		default:
			System.out.println("INVALID INPUT");
			break;
	
	}
	
}
}}
