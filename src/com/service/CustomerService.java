package com.service;
import java.util.*;
import com.dao.CustomerDao;
import com.model.CustomerModel;
public class CustomerService {
CustomerDao customerDao=new CustomerDao();
public List<CustomerModel> fetchAll() {
	List<CustomerModel>list=customerDao.fetchAll();
	return list;
}
}
