package view;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Observable;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import entity.Map;
import entity.Sprite;

public class ViewPanelTest {

    private static IModel model;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        model = new fakeModel();
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testViewPanel() {
        ViewPanel vp = new ViewPanel(new ViewFrame(model));
        assertNotNull("View Panel shouldn't be null.", vp);
    }

    @Test
    public void testUpdateObservableObject() {
    }

    @Test
    public void testPaintComponentGraphics() {
    }

}

class fakeModel implements IModel {

    @Override
    public Map getMap() {
        return null;
    }

    @Override
    public void loadMap() {

    }

    @Override
    public Observable getObservable() {
        return new Observable();
    }

}
