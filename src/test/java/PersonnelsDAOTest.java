import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import fr.uvsq21920965.pglp51.Personnels;
import fr.uvsq21920965.pglp51.PersonnelsDAO;

/**
 * PersonnelsTest Classe.
 * @author Sarra Belmahd.
 *
 */
public class PersonnelsDAOTest {
	PersonnelsDAO pdao = new PersonnelsDAO();
	Personnels p = new Personnels.Builder("Boo", "Thome", "web designer").build();
	

	@Test
	public  void createTest() {
		String fileName ="/home/oem/git/pglp_5.1/src/main/resources/"+p.getNom()+"_"+p.getPrenom()+".txt";
		File expectedfile = new File(fileName);
		expectedfile.delete();
		pdao.create(p);
		assertTrue(expectedfile.exists());
	}
	
	@Test
	public  void updateTest() {
		String fileName ="/home/oem/git/pglp_5.1/src/main/resources/"+p.getNom()+"_"+p.getPrenom()+".txt";
		Personnels p1=pdao.find(fileName);
		p1 = new Personnels.Builder("Boo", "Thome", "administrator").build();
		pdao.update(p1);
		assertEquals(p1.getFonctions(),"administrator");
	}
	
	@Test
	public  void findTest() {
		String fileName ="/home/oem/git/pglp_5.1/src/main/resources/"+p.getNom()+"_"+p.getPrenom()+".txt";
		Personnels p1=pdao.find(fileName);
		assertEquals(p1.getNom(),"Boo");
		assertEquals(p1.getPrenom(),"Thome");
		assertEquals(p1.getFonctions(),"web designer");
	}
	@Test
	public  void deleteTest() {
		String fileName ="/home/oem/git/pglp_5.1/src/main/resources/"+p.getNom()+"_"+p.getPrenom()+".txt";
		File expectedfile = new File(fileName);
		expectedfile.delete();
		pdao.create(p);
		assertTrue(expectedfile.exists());
		pdao.delete(p);
		assertFalse(expectedfile.exists());
	}
}
