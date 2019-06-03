package view;
/**
 * ViewPanel test
 */
import static org.junit.Assert.assertNotNull;

import java.util.Observable;

import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import entity.Map;

public class ViewPanelTest {
	/** a IModel */
    private static IModel model;

    /** New fakeModel */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        model = new fakeModel();
    }

    /** Test ViewPanel existence */
    @Test
    public void testViewPanel() {
        ViewPanel vp = new ViewPanel(new ViewFrame(model));
        assertNotNull("View Panel shouldn't be null.", vp);
    }


}

class fakeModel implements IModel {
	/** Get a map */
    @Override
    public Map getMap() {
        return new Map(3,3,"BBB!BBB!BBB");
    }
    /** Load a map */
    @Override
    public void loadMap() {

    }
    /** Get an Observable*/
    @Override
    public Observable getObservable() {
        return new Observable();
    }

}
