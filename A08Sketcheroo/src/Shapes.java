import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;


public class Shapes extends JComponent {

	public static String shapes;
	public static DrawingShapes drawingShapes;
	private int mouseX;
	private int mouseY;
	private Point2D point1;
	private Point2D point2;
	private Line2D line;
	private Rectangle rect;
	private Ellipse2D ellipse;
	private int x;
	private int y;
	private int height;
	private int width;
	

	public Shapes() {
		setupMouse();
		drawingShapes = new DrawingShapes();

	}

	public void setupMouse() {
		mouseX = Integer.MIN_VALUE;
		mouseY = Integer.MIN_VALUE;

		addMouseListener(new mouseAdapter());
		addMouseMotionListener(new mouseMotionAdapter());
	}
	class mouseMotionAdapter extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e){
			//System.out.println("Mouse dragged");
			mouseX = e.getX();
			mouseY = e.getY();
			point2 = new Point2D.Double(mouseX, mouseY);
			repaint();
			//System.out.println(point2);

		}
	}

	class mouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e){
			//System.out.println("Mouse pressed");
			mouseX = e.getX();
			mouseY = e.getY();
			point1 = new Point2D.Double(mouseX, mouseY);
		}

		public void mouseReleased(MouseEvent e){
			//System.out.println("Mouse released");
			if (shapes != null) {
				if (shapes.equals("Line")) {
					if (line != null) {
						DrawingShapes.drawingShapes.add(line);
					}
				} else if (shapes.equals("Ellipse")) {
					if (ellipse != null) {
						DrawingShapes.drawingShapes.add(ellipse);
					}
				} else {
					if (rect != null) {
						DrawingShapes.drawingShapes.add(rect);
					}
				}
				repaint();
			}
		}
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		if (shapes != null){
			if (Shapes.shapes.equals("Line")){
				if(point1 != null){
					line = new Line2D.Double(point1, point2);
					g2D.draw(line);
				}
			}
			else if (Shapes.shapes.equals("Rectangle")){
				if (point1 != null){
					if (point2.getX() > point1.getX() && point2.getY() > point1.getY()){
						width = (int) (point2.getX() - point1.getX());
						height = (int) (point2.getY() - point1.getY());
						rect = new Rectangle((int) point1.getX(), (int) point1.getY(), width, height);
						g2D.draw(rect);
					}
					else if (point2.getX() < point1.getX() && point2.getY() > point1.getY()){
						width = (int) (point1.getX() - point2.getX());
						height = (int) (point2.getY() - point1.getY());
						x = (int) point1.getX() - width;
						y = (int) point1.getY();
						rect = new Rectangle(x, y, width, height);
						g2D.draw(rect);
					}
					else if (point2.getX() > point1.getX() && point2.getY() < point1.getY()){
						width = (int) (point2.getX() - point1.getX());
						height = (int) (point1.getY() - point2.getY());
						x = (int) point1.getX();
						y = (int) point1.getY() - height;
						rect = new Rectangle(x, y, width, height);
						g2D.draw(rect);
					}
					else{
						width = (int) (point1.getX() - point2.getX());
						height = (int) (point1.getY() - point2.getY());
						x = (int) point1.getX() - width;
						y = (int) point1.getY() - height;
						rect = new Rectangle(x, y, width, height);
						g2D.draw(rect);
					}	
				}
			}
			else{
				if (point1 != null){
					if (point2.getX() > point1.getX() && point2.getY() > point1.getY()){
						width = (int) (point2.getX() - point1.getX());
						height = (int) (point2.getY() - point1.getY());
						ellipse = new Ellipse2D.Double((int) point1.getX(), (int) point1.getY(), width, height);
						g2D.draw(ellipse);
					}
					else if (point2.getX() < point1.getX() && point2.getY() > point1.getY()){
						width = (int) (point1.getX() - point2.getX());
						height = (int) (point2.getY() - point1.getY());
						x = (int) point1.getX() - width;
						y = (int) point1.getY();
						ellipse = new Ellipse2D.Double(x, y, width, height);
						g2D.draw(ellipse);
					}
					else if (point2.getX() > point1.getX() && point2.getY() < point1.getY()){
						width = (int) (point2.getX() - point1.getX());
						height = (int) (point1.getY() - point2.getY());
						x = (int) point1.getX();
						y = (int) point1.getY() - height;
						ellipse = new Ellipse2D.Double(x, y, width, height);
						g2D.draw(ellipse);
					}
					else{
						width = (int) (point1.getX() - point2.getX());
						height = (int) (point1.getY() - point2.getY());
						x = (int) point1.getX() - width;
						y = (int) point1.getY() - height;
						ellipse = new Ellipse2D.Double(x, y, width, height);
						g2D.draw(ellipse);
					}
				}
			}
		}





			//		Rectangle rect = new Rectangle(150, 150, 100, 100);
			//		Point2D.Double first = new Point2D.Double(0,0);
			//		Point2D.Double second = new Point2D.Double(100,100);
			//		Line2D.Double line = new Line2D.Double(first, second);
			//		Ellipse2D.Double oval = new Ellipse2D.Double(500, 300, 150, 100);
			//		g2D.setColor(Color.GREEN);
			//		g2D.draw(rect);
			//		g2D.setColor(Color.RED);
			//		g2D.fill(rect);
			//		g2D.setColor(Color.BLACK);
			//		g2D.draw(line);
			//		g2D.setColor(Color.BLUE);
			//		g2D.draw(oval);
			//		g2D.setColor(Color.YELLOW);
			//		g2D.fill(oval);


			//		for(DrawingShapes shape: shapes){
			//			if(m.intersects(shape.getBounds2D())){
			//				if(inside){
			//					shape.display(g2D,alt);	
			//				}
			//				else{
			//					shape.display(g2D, null);	
			//				}
			//			}
			//			if(!m.intersects(shape.getBounds2D())){
			//				if(inside){
			//					shape.display(g2D,alt);	
			//				}
			//				else{
			//					shape.display(g2D,null);	
			//				}
			//			}
			//		}
			//		System.out.println(mouseX);
			//		g2D.setColor(Color.BLACK);
			//		g2D.draw(m);
		}
	}
