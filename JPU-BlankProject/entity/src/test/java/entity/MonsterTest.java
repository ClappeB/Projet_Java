package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MonsterTest {

	private static Monster monster;
	private static Map map;
	private String descriptionOfMap, descriptionOfMapAfterRefresh;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		monster = new Octopus(); //Arbitrary choice
	}

	@Before
	public void setUp() throws Exception {
		map = new Map(3,3,"BBB!BOB!BBB");
		descriptionOfMap="";
		descriptionOfMapAfterRefresh="";
	}

	@Test
	public void testMonster() {
		assertNotNull("Should instantiate a monster typed object.", monster);
	}

	@Test
	public void testDiamondExplosion() {
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		((Monster)map.getEntity(1, 1)).diamondExplosion(map);
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Should explode in 9 diamonds.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}

	@Test
	public void testBehaviour() {
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		((Monster)map.getEntity(1, 1)).behaviour(map);
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Monster should move.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}

	@Test
	public void testKill() {
		map=new Map(3,3,"BBB!BOP!BBB");
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		((Monster)map.getEntity(1, 1)).kill(map, (Killable)map.getEntity(2, 1));
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Should make the mobile element going up on the map.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}

}
