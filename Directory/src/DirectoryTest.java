import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DirectoryTest {
	
	private Utente user1, user2;
	private Risorsa directory;
	private Permesso p1, p2;

	@Before
	public void setUp() throws Exception {
		this.user1 = new Utente("user1");
		this.user2 = new Utente("user2");
		this.directory = new Directory("directory1", this.user1);
		this.p1 = new Permesso("lettura");
		this.p2 = new Permesso("scrittura");
	}

	@Test
	public void testConcediPermesso_Singleton() {
		assertFalse(this.directory.haIlPermesso(p1, user1));
		this.directory.concediPermesso(p1, user1);
		assertTrue(this.directory.haIlPermesso(p1, user1));
	}
	
	@Test
	public void testConcediPermesso_DuePermessiUnUtente() {
		assertFalse(this.directory.haIlPermesso(p1, user1));
		assertFalse(this.directory.haIlPermesso(p2, user1));
		this.directory.concediPermesso(p1, user1);
		this.directory.concediPermesso(p2, user1);
		assertTrue(this.directory.haIlPermesso(p1, user1));
		assertTrue(this.directory.haIlPermesso(p2, user1));
	}
	
	@Test
	public void testConcediPermesso_DueUtentiUnPermesso() {
		assertFalse(this.directory.haIlPermesso(p1, user1));
		assertFalse(this.directory.haIlPermesso(p1, user2));
		this.directory.concediPermesso(p1, user1);
		this.directory.concediPermesso(p1, user2);
		assertTrue(this.directory.haIlPermesso(p1, user1));
		assertTrue(this.directory.haIlPermesso(p1, user2));
	}
	
	@Test
	public void testPermessiDi_UtenteSenzaPermessi() {
		assertEquals(0, this.directory.permessiDi(user1).size());
	}
	
	@Test
	public void testPermessiDi_UtenteCon1Permesso() {
		this.directory.concediPermesso(p1, user1);
		assertEquals(1, this.directory.permessiDi(user1).size());
		assertSame(this.p1, this.directory.permessiDi(user1).get(0));
	}
	
	@Test
	public void testPermessiDi_UtenteCon2Permessi() {
		this.directory.concediPermesso(p2, user1);
		this.directory.concediPermesso(p1, user1);
		assertEquals(2, this.directory.permessiDi(user1).size());
		assertSame(this.p1, this.directory.permessiDi(user1).get(0));
		assertSame(this.p2, this.directory.permessiDi(user1).get(1));
	}

}
