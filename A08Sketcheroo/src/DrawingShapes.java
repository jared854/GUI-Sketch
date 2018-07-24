import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class DrawingShapes{

	public static ArrayList<Shape> drawingShapes;

	public DrawingShapes(){
		drawingShapes = new ArrayList<Shape>();
	}
	public void addNewShapes(Shape shapes){
		drawingShapes.add(shapes);
	}
}