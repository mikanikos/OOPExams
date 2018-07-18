package soluzione;

import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * Implementa un visualizzatore di istogramma per la simulazione delle
 * precipitazioni
 *
 * @author Paolo Merialdo (con (pessimo) riuso del codice di David J. Barnes & Michael K�lling)
 */
public class VisualizzatoreGraficoIstogramma  extends JFrame implements Visualizzatore
{
    private final String STEP_PREFIX = "Passo: ";
    private JLabel stepLabel;
    private FieldView fieldView;

    private Precipitazioni precipitazioni;

    /**
     * Create a view of the given width and height.
     */
    public VisualizzatoreGraficoIstogramma(){
		setTitle("Carta Precipitazioni");
        stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);
        setLocation(150, 200);
    }


	private Map<Integer,Integer> costruisciIstogramma() {
		Map<Integer,Integer> istogramma;
		istogramma = new TreeMap<Integer,Integer>();
		int valoreInt;
		Integer chiave;
		Integer valore;

		for (int i=0; i<precipitazioni.getCartaPrecipitazioni().length; i++)
			for (int j=0; j<precipitazioni.getCartaPrecipitazioni()[i].length; j++) {
				chiave = precipitazioni.getCartaPrecipitazioni()[i][j];
				valore = istogramma.get(chiave);
				valoreInt = 1;
				if (valore!=null)
					valoreInt += valore.intValue();
				istogramma.put(chiave,new Integer(valoreInt));
		}
		return istogramma;
	}


	public void setPrecipitazioni (Precipitazioni p) {
		precipitazioni = p;

        fieldView = new FieldView(10, 10);

        Container contents = getContentPane();
        contents.add(stepLabel, BorderLayout.NORTH);
        contents.add(fieldView, BorderLayout.CENTER);
        pack();
        setVisible(true);
	}

	public void aggiornaSchermata(int step) {
		Map<Integer,Integer> istogramma = this.costruisciIstogramma();
		showStatus(step, istogramma);
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
    private void showStatus(int step, Map<Integer,Integer> istogramma) {
        if(!isVisible())
            setVisible(true);

        stepLabel.setText(STEP_PREFIX + step);

        fieldView.preparePaint();

		java.util.List<Integer> chiaviIstogramma = new LinkedList<Integer>(istogramma.keySet());
		Collections.sort(chiaviIstogramma);
		Iterator itChiavi = chiaviIstogramma.iterator();
		while (itChiavi.hasNext()){
			Integer chiave = (Integer)itChiavi.next();
			int intChiave = chiave.intValue();
			int intValore = istogramma.get(chiave).intValue();
            fieldView.drawBar(intChiave, 100, Color.BLACK);
            fieldView.drawBar(intChiave, intValore, getColor(intChiave));
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
        private void drawBar(int x, int altezzaBarra, Color color)
        {
            g.setColor(color);
            g.fillRect(x * xScale, 0, xScale-1, altezzaBarra/gridHeight * GRID_VIEW_SCALING_FACTOR);
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
