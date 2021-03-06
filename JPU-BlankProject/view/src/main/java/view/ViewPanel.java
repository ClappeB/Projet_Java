package view;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * 
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
        this.setViewFrame(viewFrame);
        viewFrame.getModel().getMap().addObserver(this);
    }

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame7
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}
		
	/** View refresh. */
	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/** Update entity's position. */
	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	   protected void paintComponent(final Graphics graphics) {
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        try {
            for(int y=0; y < this.getViewFrame().getModel().getMap().getHeight(); y++)
            {
                for(int x=0; x < this.getViewFrame().getModel().getMap().getWidth(); x++)
                {
                    this.getViewFrame().getModel().getMap().getEntity(x,y).getSprite().loadImage();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int y=0; y < this.getViewFrame().getModel().getMap().getHeight(); y++)
        {
            for(int x=0; x < this.getViewFrame().getModel().getMap().getWidth(); x++)
            {
                graphics.drawImage(this.getViewFrame().getModel().getMap().getEntity(x,y).getSprite().getImage(), x*32, y*32, this);
            }
        }
      
	}
	
}
