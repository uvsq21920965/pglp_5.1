import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import fr.uvsq21920965.pglp51.CompositePersonnels;
import fr.uvsq21920965.pglp51.CompositePersonnelsDAO;
import fr.uvsq21920965.pglp51.Personnels;


/**
 * CompositePersonnelsDAOTest classe.
 * @author sarra Belmahdi.
 *
 */
public class CompositePersonnelsDAOTest {
	CompositePersonnelsDAO cpdao = new CompositePersonnelsDAO();
	CompositePersonnels cp = new CompositePersonnels(5);
	Personnels p = new Personnels.Builder("Boo", "Thome", "web designer").build();
	

	@Test
	public  void createTest() {
		cp.add(p);
		String fileName ="/home/oem/git/pglp_5.1/src/main/resources/groupe"+cp.getId()+".txt";
		File expectedfile = new File(fileName);
		expectedfile.delete();
		cpdao.create(cp);
		assertTrue(expectedfile.exists());
	}

	@Test
	public  void updateTest() {
		cp.add(p);
		String fileName ="/home/oem/git/pglp_5.1/src/main/resources/groupe"+cp.getId()+".txt";
		CompositePersonnels cp1=cpdao.find(fileName);
		Personnels p1 = new Personnels.Builder("Boo", "Thome", "administrator").build();
		cp1 = new CompositePersonnels(5);
		cp1.add(p1);
		cpdao.update(cp1);
		assertEquals(((Personnels)cp1.getPersonnes().get(0)).getFonctions(),"administrator");
	}
	@Test
	public  void findTest() {
		cp.add(p);
		String fileName ="/home/oem/git/pglp_5.1/src/main/resources/groupe"+cp.getId()+".txt";
		CompositePersonnels cp1=cpdao.find(fileName);
		assertEquals(((Personnels)cp1.getPersonnes().get(0)).getNom(),"Boo");
		assertEquals(((Personnels)cp1.getPersonnes().get(0)).getPrenom(),"Thome");
		assertEquals(((Personnels)cp1.getPersonnes().get(0)).getFonctions(),"web designer");
	}
	@Test
	public  void deleteTest() {
		cp.add(p);
		String fileName ="/home/oem/git/pglp_5.1/src/main/resources/groupe"+cp.getId()+".txt";
		File expectedfile = new File(fileName);
		expectedfile.delete();
		cpdao.create(cp);
		assertTrue(expectedfile.exists());
		cpdao.delete(cp);
		assertFalse(expectedfile.exists());
	}
	
	

}
