package com.service;
import java.util.*;
import com.dao.Customer;
import com.dao.CustomerDao;
import com.model.CustomerModel;
public class CustomerService {
Customer customer=new Customer();
public List<CustomerModel> fetchAll() {
	List<CustomerModel>list=customer.fetchAll();
	return list;
}
public void delete(int id)
{
	customer.delete(id);
}
public void update(int id) {
	customer.update(id);
}
}
