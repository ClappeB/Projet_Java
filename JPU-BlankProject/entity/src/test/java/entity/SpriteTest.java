package entity;
/**
 * Sprite test
 */
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
	/** a Sprite */
	private static Sprite sprite;
	
	/** New Sprite */
	@Before
	public void setUp() throws Exception {
		sprite = new Sprite('P', "face1.png");
	}
	/** Test Sprite existense */
	@Test
	public void testSpriteCharString() {
		assertNotNull("Constructor should instantiate a Sprite.", sprite);
	}
	/** Test the load image */
	@Test
	public void testGetImage() throws Exception {
		sprite.loadImage();
		assertTrue("Should return an image.", sprite.getImage() instanceof Image);
	}

	/** Test the image name get */
	@Test
	public void testGetImageName() {
		assertEquals("Should return the good image name.", "face1.png", sprite.getImageName());
	}

	/** Test the image name set */
	@Test
	public void testSetImageName() {
		sprite.setImageName("image.png");
		assertEquals("Should return the good image name.", "image.png", sprite.getImageName());
	}

	/** Test the display of the image in console */
	@Test
	public void testGetConsoleImage() {
		assertEquals("Should return the good image name.", 'P', sprite.getConsoleImage());
	}

	/** Test the set of the image in console */
	@Test
	public void testSetConsoleImage() {
		sprite.setConsoleImage('S');
		assertEquals("Should set the image name.", 'S', sprite.getConsoleImage());
	}

	/** Test exceptions */
	@Test
	public void testIsImageLoaded() throws Exception {
		sprite.loadImage();
		assertTrue("Image should be loaded.", sprite.isImageLoaded());
	}

	/** Test the loading of the image */
	@Test
	public void testSetImageLoaded() {
		sprite.setImageLoaded(false);
		assertFalse("Should return false.", sprite.isImageLoaded());
		sprite.setImageLoaded(true);
		assertTrue("Should return true.", sprite.isImageLoaded());
	}

	/** Test exceptions loading */
	@Test
	public void testLoadImage() throws Exception {
		sprite.loadImage();
		assertTrue("Should return true.", sprite.isImageLoaded());
	}

}
