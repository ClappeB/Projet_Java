package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Image;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpriteTest {

	private static Sprite sprite;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		sprite = new Sprite('P', "face1.png");
	}

	@Test
	public void testSpriteCharString() {
		assertNotNull("Constructor should instantiate a Sprite.", sprite);
	}

	@Test
	public void testGetImage() throws Exception {
		sprite.loadImage();
		assertTrue("Should return an image.", sprite.getImage() instanceof Image);
	}

	@Test
	public void testGetImageName() {
		assertEquals("Should return the good image name.", "face1.png", sprite.getImageName());
	}

	@Test
	public void testSetImageName() {
		sprite.setImageName("image.png");
		assertEquals("Should return the good image name.", "image.png", sprite.getImageName());
	}

	@Test
	public void testGetConsoleImage() {
		assertEquals("Should return the good image name.", 'P', sprite.getConsoleImage());
	}

	@Test
	public void testSetConsoleImage() {
		sprite.setConsoleImage('S');
		assertEquals("Should set the image name.", 'S', sprite.getConsoleImage());
	}

	@Test
	public void testIsImageLoaded() throws Exception {
		sprite.loadImage();
		assertTrue("Image should be loaded.", sprite.isImageLoaded());
	}

	@Test
	public void testSetImageLoaded() {
		sprite.setImageLoaded(false);
		assertFalse("Should return false.", sprite.isImageLoaded());
		sprite.setImageLoaded(true);
		assertTrue("Should return true.", sprite.isImageLoaded());
	}

	@Test
	public void testLoadImage() throws Exception {
		sprite.loadImage();
		assertTrue("Should return true.", sprite.isImageLoaded());
	}

}
