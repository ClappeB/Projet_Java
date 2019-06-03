package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.exceptions.NoSuchEntityExists;

public class FactoryTest {
	
	private static Entity diamond;
	private static Entity bat;
	private static Entity backgroundDirt;
	private static Entity dirt;
	private static Entity exit;
	private static Entity octupus;
	private static Entity player;
	private static Entity rock;
	private static Entity unbreakableBlock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		diamond = Factory.createDiamond();
		bat = Factory.createBat();
		backgroundDirt = Factory.createBackgroundDirt();
		dirt = Factory.createDirt();
		exit = Factory.createExit();
		octupus = Factory.createOctopus();
		player = Factory.createPlayer();
		rock = Factory.createRock();
		unbreakableBlock = Factory.createUnbreakableBlock();
	}

	@Test
	public void testCreateDiamond() {
		assertNotNull("Should create a diamond.",Factory.createDiamond());
		assertNotEquals("Should create different diamonds.", diamond, Factory.createDiamond());
	}

	@Test
	public void testCreateRock() {
		assertNotNull("Should create a rock.",Factory.createRock());
		assertNotEquals("Should create different rocks.", rock, Factory.createRock());
	}

	@Test
	public void testCreateBat() {
		assertNotNull("Should create a bat.",Factory.createBat());
		assertNotEquals("Should create different bats.", bat, Factory.createBat());
	}

	@Test
	public void testCreateOctopus() {
		assertNotNull("Should create a octupus.",Factory.createOctopus());
		assertNotEquals("Should create different octupuses.", octupus, Factory.createOctopus());
	}

	@Test
	public void testCreatePlayer() {
		assertNotNull("Should create a player.", Factory.createPlayer());
		assertEquals("Shouldn't create different players.", player, Factory.createPlayer());
	}

	@Test
	public void testCreateExit() {
		assertNotNull("Should create a exit.", Factory.createExit());
		assertEquals("Shouldn't create different exits.", exit, Factory.createExit());
	}

	@Test
	public void testCreateDirt() {
		assertNotNull("Should create a dirt.",Factory.createDirt());
		assertNotEquals("Should create different dirts.", dirt, Factory.createDirt());
	}

	@Test
	public void testCreateUnbreakableBlock() {
		assertNotNull("Should create an unbreakable block.",Factory.createUnbreakableBlock());
		assertNotEquals("Should create different unbreakable blocks.", unbreakableBlock, Factory.createUnbreakableBlock());
	}

	@Test
	public void testCreateBackgroundDirt() {
		assertNotNull("Should create a background dirt.",Factory.createBackgroundDirt());
		assertNotEquals("Should create different background dirts.", backgroundDirt, Factory.createBackgroundDirt());
	}

	@Test(expected = NoSuchEntityExists.class)
	public void testGetFromFileSymbol() {
		assertTrue("Should return a diamond entity.", Factory.getFromFileSymbol('D') instanceof Diamond);
		assertTrue("Should return a rock entity.", Factory.getFromFileSymbol('R') instanceof Rock);
		assertTrue("Should return a bat entity.", Factory.getFromFileSymbol('C') instanceof Bat);
		assertTrue("Should return a octopus entity.", Factory.getFromFileSymbol('O') instanceof Octopus);
		assertTrue("Should return a player entity.", Factory.getFromFileSymbol('P') instanceof Player);
		assertTrue("Should return a exit entity.", Factory.getFromFileSymbol('E') instanceof Exit);
		assertTrue("Should return a dirt entity.", Factory.getFromFileSymbol('.') instanceof Dirt);
		assertTrue("Should return a unbreakable block entity.", Factory.getFromFileSymbol('U') instanceof UnbreakableBlock);
		assertTrue("Should return a background dirt entity.", Factory.getFromFileSymbol('B') instanceof BackgroundDirt);
		Factory.getFromFileSymbol('X');
		fail("Factory should return an exception when a wrong symbol is passed");		
	}

}
