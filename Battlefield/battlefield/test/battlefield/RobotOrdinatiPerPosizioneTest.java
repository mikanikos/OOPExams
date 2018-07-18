package battlefield;

import static org.junit.Assert.*;

import org.junit.*;

public class RobotOrdinatiPerPosizioneTest {

	// (vedi DOMANDA 5)
	// scrivere dei test-case minimali per il metodo
	// Battlefield.getRobotOrdinatiPerPosizione()

	private Battlefield field;

	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
	}

	@Test
	public void testCampoVuoto() {
		assertEquals(0, this.field.getAllRobots().size());
		assertEquals(0, this.field.getRobotOrdinatiPerPosizione().size());
	}
	
	@Test
	public void testSingleton() {
		Robot r1 = new Chaser(new Position(0,0));
		this.field.addRobot(r1);
		assertEquals(1, this.field.getAllRobots().size());
		assertEquals(1, this.field.getRobotOrdinatiPerPosizione().size());
		assertSame(r1, this.field.getRobotOrdinatiPerPosizione().get(0));
	}
	
	@Test
	public void testDoubletonConXdiversa() {
		Robot r1 = new Chaser(new Position(0,0));
		this.field.addRobot(r1);
		Robot r2 = new Walker(new Position(1,0));
		this.field.addRobot(r2);
		assertEquals(2, this.field.getAllRobots().size());
		assertEquals(2, this.field.getRobotOrdinatiPerPosizione().size());
		assertSame(r1, this.field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(r2, this.field.getRobotOrdinatiPerPosizione().get(1));
	}
	
	@Test
	public void testDoubletonConXuguale() {
		Robot r1 = new Chaser(new Position(0,0));
		this.field.addRobot(r1);
		Robot r2 = new Walker(new Position(0,1));
		this.field.addRobot(r2);
		assertEquals(2, this.field.getAllRobots().size());
		assertEquals(2, this.field.getRobotOrdinatiPerPosizione().size());
		assertSame(r1, this.field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(r2, this.field.getRobotOrdinatiPerPosizione().get(1));
	}
	
	@Test
	public void test4Robots() {
		Robot r1 = new Chaser(new Position(1,1));
		this.field.addRobot(r1);
		Robot r2 = new Walker(new Position(0,1));
		this.field.addRobot(r2);
		Robot r3 = new Chaser(new Position(1,0));
		this.field.addRobot(r3);
		Robot r4 = new Walker(new Position(0,0));
		this.field.addRobot(r4);
		assertEquals(4, this.field.getAllRobots().size());
		assertEquals(4, this.field.getRobotOrdinatiPerPosizione().size());
		assertSame(r4, this.field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(r2, this.field.getRobotOrdinatiPerPosizione().get(1));
		assertSame(r3, this.field.getRobotOrdinatiPerPosizione().get(2));
		assertSame(r1, this.field.getRobotOrdinatiPerPosizione().get(3));
	}
	
	

}
