package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bo.ExhibitionBO;
import domain.Exhibition;
import util.HibernateUtil;

class ExhibitionBOTest {
	private ExhibitionBO bo;
	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session; 
	@BeforeEach
	void setupBO() {
		bo = new ExhibitionBO();
	}
	@Test
	void testInsertExhibition() {

		Exhibition expected= new Exhibition(2,"hibernate", 2, 0);
		bo.insertExhibition(expected);
		session = sessionFactory.openSession();
		Exhibition actual= (Exhibition) session.get(Exhibition.class, 2);
		assertEquals(expected, actual);
		}

	@Test
	void testListExhibitions() {
		List <Exhibition> expected= Arrays.asList(new Exhibition(1,"avant garde", 3, 1),
				new Exhibition(2,"hibernate", 2, 0));
		
		List<Exhibition> actual = bo.listExhibitions();
		
		if(expected.size()==actual.size())
			for(int i = 0; i < expected.size();i++)
		{
			assertEquals(expected.get(i), actual.get(i));
			}
		else {
			fail("Sizes not the same");
		}
	}
	
	boolean assertEquals(Exhibition expected, Exhibition actual)
	{
		boolean valid = false;
		if(expected.getId()==actual.getId() && expected.getName().equals(actual.getName()) && expected.getNumberOfStalls()==actual.getNumberOfStalls() && expected.getOccupied()==actual.getOccupied())
		valid=true;
		
		return valid;
	}

}
