package test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.CustomersDao;
import entity.Customers;
import entity.Ts;


public class T {
	SqlSession session;
	@Before
	public void before() throws IOException{
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		session = factory.openSession();
	}
	
	@After
	public void after(){
		session.commit();
		session.close();
	}
	@Test
	public void t1(){
		CustomersDao dao = session.getMapper(CustomersDao.class);
		List<Customers> list = dao.query("a", "",null);
		for (Customers customers : list) {
			System.out.println(customers);
		}
	}
	@Test
	public void t2(){
		CustomersDao dao = session.getMapper(CustomersDao.class);
		Customers cu=new Customers();
		cu.setCity("USA");
		
		List<Customers> list = dao.query2(cu);
		for (Customers customers : list) {
			System.out.println(customers);
		}
	}
	@Test
	public void t3(){
		CustomersDao dao = session.getMapper(CustomersDao.class);
		Ts t=new Ts();
		t.setInfo("aaaa");
		Integer list = dao.add(t);
		
	}
	@Test
	public void t4(){
		CustomersDao dao = session.getMapper(CustomersDao.class);
		List<Integer> l=new ArrayList<Integer>();
		l.add(11);
		dao.del(l);
	}
	@Test
	public void t5(){
		CustomersDao dao = session.getMapper(CustomersDao.class);
		List<Customers> list = dao.query3("a");
		for (Customers customers : list) {
			System.out.println(customers);
		}
	}
	
	@Test
	public void t6(){
		CustomersDao dao = session.getMapper(CustomersDao.class);
		Customers cu=new Customers();
		cu.setCustomerNumber(112);
		cu.setAddressLine2("qqqq");
		dao.update(cu);
	}
}
