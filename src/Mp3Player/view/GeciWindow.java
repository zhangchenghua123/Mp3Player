package Mp3Player.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;

import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class GeciWindow {
	static JFrame frame;
	static Point originPoint;
	static JLabel label;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frame=new JFrame("Mp3Player");
		originPoint=new Point();
		frame.setSize(500, 100);
		frame.setUndecorated(true);
		com.sun.awt.AWTUtilities.setWindowOpacity(frame, 0.9f);
		frame.setBackground(new Color(0,0,0,0));
		Container mainPanel =new Container();
		mainPanel.setBackground(new Color(255,255,255,50));
		mainPanel.setSize(500, 600);
		frame.setContentPane(mainPanel);
		
		mainPanel.setLayout(null);
		JPanel p1=new JPanel();
		p1.setOpaque(true);
		p1.setLayout(null);
		JPanel p2=new JPanel();
		label=new JLabel("qqqqq");
		label.setOpaque(false);
//		label.setBackground(new Color(50,50,250,50));
		Button button=new Button("fdsa");
		button.setBounds(100, 0, 100, 50);
		p1.setBounds(0, 0, 500, 50);
		p1.setBackground(new Color(50,50,250,50));
		p1.add(label);
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(label);
		label.setBounds(0, 0, 50, 50);
//		p1.add(label);
		
		frame.getContentPane().add(p1);
//		p2.setBounds(0, 50, 500, 50);
		
//		p2.setBackground(new Color(10,10,10,255));
		
		
		p1.add(button);
		frame.setVisible(true);
		p1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				originPoint.x=e.getX();
				originPoint.y=e.getY();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		p1.addMouseMotionListener(new MouseMotionListener() {
			
			
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				Point point=frame.getLocation();
				frame.setLocation(point.x-originPoint.x+e.getX(), point.y+e.getY()-originPoint.y);
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
