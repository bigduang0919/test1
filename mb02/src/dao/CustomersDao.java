package dao;

import java.util.List;

import entity.Customers;
import entity.Ts;

public interface CustomersDao {
	public List<Customers> query(String keyword,String country,Integer salesRepEmployeeNumber);
	public Integer add(Ts t);
	public List<Customers> query2(Customers c);
	public void del(List<Integer> l);
	public List<Customers> query3(String keyword);
	public Integer update(Customers c);
	public int add1(Customers c);
	
}
