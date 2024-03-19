package com.controller;
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
		System.out.println("ENTER 2 TO UPDATE");
		System.out.println("ENTER 3 TO DELETE");
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
		default:
		System.out.println("INVALID INPUT");
		break;
		}
	}
	
}
}
