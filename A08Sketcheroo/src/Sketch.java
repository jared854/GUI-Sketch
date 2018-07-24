import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;


public class Sketch extends JFrame {

	
	private JFrame controlFrame;
	private JRadioButton lineButton, rectangleButton, ellipseButton;
	private JButton drawButton, fillButton, undoButton;
	//private Timer timer;
	private Shapes shapes;
	static Shapes shape;
	static Color newColor;
	private JLabel buttonLabel, fillLabel;
	
	
	public Sketch() {
		setupThisFrame();		
		setupControlFrame();
		setupButtons();
		//setupTimer();
		setupShapes();
		
		showFrames();
	}
	
	private void setupThisFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sketcheroo");
		setLocation(0,0);
		setSize(800,450);
		shape = new Shapes();
		add(shape);
		
	}

	private void setupControlFrame() {
		controlFrame = new JFrame();
		controlFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		controlFrame.setTitle("Controls");
		controlFrame.setLocation(800,0);
		controlFrame.setSize(200,450);
	}

	private void setupButtons() {
		buttonLabel = new JLabel();
		buttonLabel.setOpaque(true);
		buttonLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
		fillLabel = new JLabel();
		fillLabel.setOpaque(true);
		fillLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		drawButton = new JButton("Draw");
		drawButton.addActionListener(new DrawListener());
		
		fillButton = new JButton("Fill");
		fillButton.addActionListener(new FillListener());
		
		lineButton = new JRadioButton("Line");
		lineButton.addActionListener(new ShapeListener());
		
		rectangleButton = new JRadioButton("Rectangle");
		rectangleButton.addActionListener(new ShapeListener());
		
		ellipseButton = new JRadioButton("Ellipse");
		ellipseButton.addActionListener(new ShapeListener());
		
		undoButton = new JButton("Undo");
		undoButton.addActionListener(new UndoListener());
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(lineButton);
		buttonGroup.add(rectangleButton);
		buttonGroup.add(ellipseButton);

		
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.add(drawButton);
		buttonPanel.add(fillButton);
		buttonPanel.add(lineButton);
		buttonPanel.add(rectangleButton);
		buttonPanel.add(ellipseButton);
		buttonPanel.add(undoButton);
		
		buttonPanel.add(buttonLabel);
		buttonPanel.add(fillLabel);
		controlFrame.add(buttonPanel);
		
		
	}
		
	class DrawListener implements ActionListener {
			@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("DRAW");
			newColor = JColorChooser.showDialog(Sketch.this,"Choose Background Color",buttonLabel.getBackground());
			if (newColor != null) {
			    buttonLabel.setBackground(newColor);
			    buttonLabel.setText("         ");
			    
			}
			else{
				buttonLabel.setText(" nothing ");	
			}
		}
	}
	class FillListener implements ActionListener{
			@Override
		public void actionPerformed(ActionEvent e){
			//System.out.println("FILL");
				newColor = JColorChooser.showDialog(Sketch.this,"Choose Background Color",buttonLabel.getBackground());
				if (newColor != null) {
				    fillLabel.setBackground(newColor);
				    fillLabel.setText("         ");
				}
				else{
					fillLabel.setText(" nothing ");	
				}
		}
	}
		
	class ShapeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			//System.out.println("SHAPE");
			if (rectangleButton.isSelected()){
				Shapes.shapes = "Rectangle";
				//System.out.println("rectangle");
			}
			else if (lineButton.isSelected()){
				Shapes.shapes = "Line";
				//System.out.println("line");
			}
			else{
				Shapes.shapes = "Ellipse";
				//System.out.println("ellipse");
			}
		}
	}
	
	class UndoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			//System.out.println("UNDO");
		}
	}

	private void setupShapes() {
		shapes = new Shapes();
	}	

	private void showFrames() {
		controlFrame.setVisible(true);
		setVisible(true);
	}
}
