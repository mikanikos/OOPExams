package soluzione;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Implementa un visualizzatore per la simulazione delle
 * precipitazioni
 * @author Paolo Merialdo (con riuso del codice di David J. Barnes & Michael K�lling)
 */
public class VisualizzatoreGrafico  extends JFrame implements Visualizzatore
{
    private final String STEP_PREFIX = "Passo: ";
    private JLabel stepLabel;
    private FieldView fieldView;

    private Precipitazioni precipitazioni;

	public void setPrecipitazioni (Precipitazioni p) {
		precipitazioni = p;

        fieldView = new FieldView(p.getCartaPrecipitazioni().length, p.getCartaPrecipitazioni()[0].length);

        Container contents = getContentPane();
        contents.add(stepLabel, BorderLayout.NORTH);
        contents.add(fieldView, BorderLayout.CENTER);
        pack();
        setVisible(true);
	}

	public void aggiornaSchermata(int step) {
		showStatus(step, precipitazioni);
	}


    /**
     * Create a view of the given width and height.
     */
    public VisualizzatoreGrafico()
    {

        setTitle("Carta Precipitazioni");
        stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);
        setLocation(100, 50);
    }


    private Color getColor(int livelloPrecipitazioni)
    {
            //return new Color(livelloPrecipitazioni);
            int r = livelloPrecipitazioni * MAX_RGB / 10;
            int g = 255 - livelloPrecipitazioni * MAX_RGB / 10;
            return new Color(r,g,0);
    }

    /**
     * Show the current status of the field.
     * @param step Which iteration step it is.
     * @param stats Status of the field to be represented.
     */
    private void showStatus(int step, Precipitazioni precipitazioni)
    {
        if(!isVisible())
            setVisible(true);

        stepLabel.setText(STEP_PREFIX + step);

        fieldView.preparePaint();

		for (int i=0; i<precipitazioni.getCartaPrecipitazioni().length; i++) {
			for (int j=0; j<precipitazioni.getCartaPrecipitazioni()[i].length; j++)
                    fieldView.drawMark(j, i, getColor(precipitazioni.getCartaPrecipitazioni()[i][j]));
                }
        fieldView.repaint();
    }

    /**
     * Provide a graphical view of a rectangular field. This is
     * a nested class (a class defined inside a class) which
     * defines a custom component for the user interface. This
     * component displays the field.
     * This is rather advanced GUI stuff - you can ignore this
     * for your project if you like.
     */
    private class FieldView extends JPanel
    {
        private final int GRID_VIEW_SCALING_FACTOR = 30;

        private int gridWidth, gridHeight;
        private int xScale, yScale;
        Dimension size;
        private Graphics g;
        private Image fieldImage;

        /**
         * Create a new FieldView component.
         */
        public FieldView(int height, int width)
        {
            gridHeight = height;
            gridWidth = width;
            size = new Dimension(0, 0);
        }

        /**
         * Tell the GUI manager how big we would like to be.
         */
        public Dimension getPreferredSize()
        {
            return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                                 gridHeight * GRID_VIEW_SCALING_FACTOR);
        }

        /**
         * Prepare for a new round of painting. Since the component
         * may be resized, compute the scaling factor again.
         */
        public void preparePaint()
        {
            if(! size.equals(getSize())) {  // if the size has changed...
                size = getSize();
                fieldImage = fieldView.createImage(size.width, size.height);
                g = fieldImage.getGraphics();

                xScale = size.width / gridWidth;
                if(xScale < 1) {
                    xScale = GRID_VIEW_SCALING_FACTOR;
                }
                yScale = size.height / gridHeight;
                if(yScale < 1) {
                    yScale = GRID_VIEW_SCALING_FACTOR;
                }
            }
        }

        /**
         * Paint on grid location on this field in a given color.
         */
        private void drawMark(int x, int y, Color color)
        {
            g.setColor(color);
            g.fillRect(x * xScale, y * yScale, xScale-1, yScale-1);
        }

        /**
         * The field view component needs to be redisplayed. Copy the
         * internal image to screen.
         */
        public void paintComponent(Graphics g)
        {
            if(fieldImage != null) {
                g.drawImage(fieldImage, 0, 0, null);
            }
        }
    }

    private static int MAX_RGB = 255;
}
