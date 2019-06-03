package entity;
/**
 * Entity test 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.exceptions.WrongCoordinates;

public class EntityTest {
	/** an entity */
	private static Entity entity;
	/** New player at the pos (5;5) */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new Player(); //Arbitrary choice
		entity.setPosX(5);
		entity.setPosY(5);
	}
	/** Constructor test */
	@Test
	public void testEntity() {
		assertNotNull("Entity constructor should instantiate an entity.", entity);
	}
	/** getSprite test */
	@Test
	public void testGetSprite() {
		assertTrue("Method getSprite should return a sprite in png format", entity.getSprite().getImageName().matches(".+\\.png"));
	}
	/** setSprite test */
	@Test
	public void testSetSprite() {
		entity.setSprite(new Sprite('s', "sprite.png"));
		assertTrue("Set sprite should set the sprite of the entity.", entity.getSprite().getImageName().equals("sprite.png"));
		}
	
	/** getPermeability Test */
	@Test
	public void testGetPermeability() {
		entity.setPermeability(Permeability.NON_INTERACTING);
		ArrayList<Permeability> permeabilities = new ArrayList<Permeability>();
		Permeability[] permeabilitiesArray = Permeability.values();
		for (Permeability permeability : permeabilitiesArray) {
			permeabilities.add(permeability);
		}
		assertTrue("Method getPermeability should return a predefined permeability.", permeabilities.contains(entity.getPermeability()));
	}
	/** setPermeability test */
	@Test
	public void testSetPermeability() {
		entity.setPermeability(Permeability.NON_INTERACTING);
		assertEquals("SetPermeability method should modify entity's permeability.", Permeability.NON_INTERACTING, entity.getPermeability());
	}
	
	/** getPosX test */
	@Test
	public void testGetPosX() {
		assertEquals("Should get the right horizontal position.", 5, entity.getPosX());
	}

	/** setPosX test */
	@Test
	public void testSetPosX() {
		entity.setPosX(8);
		assertEquals("Should set the right horizontal position.", 8, entity.getPosX());
	}
	/** Exceptions test for Wrong X coordinates */
	@Test(expected = WrongCoordinates.class)
	public void testSetWrongPosX() {
		entity.setPosX(-8);
	}
	/** getPosY test */
	@Test
	public void testGetPosY() {
		assertEquals("Should get the right vertical position.", 5, entity.getPosY());
	}
	/** setPosY test */
	@Test
	public void testSetPosY() {
		entity.setPosY(8);
		assertEquals("Should set the right vertical position.", 8, entity.getPosY());
	}
	/** Exceptions test for Wrong Y coordinates */
	@Test(expected = WrongCoordinates.class)
	public void testSetWrongPosY() {
		entity.setPosY(-8);
	}

}
