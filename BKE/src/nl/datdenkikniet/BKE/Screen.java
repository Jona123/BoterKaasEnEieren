package nl.datdenkikniet.BKE;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Screen {
	private static JFrame frame;
	public static void createWindow(){
		frame = new JFrame("Boter, Kaas en Eieren");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(new Dimension(300,200));
		frame.setVisible(true);
		frame.addKeyListener(new KeyL());
		frame.setLocationRelativeTo(null);
		updateFrame();
	}
	public static void updateFrame(){
		frame.getContentPane().removeAll();
		JLabel label = BKELayout.getLayout();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(label);
		frame.revalidate();
		frame.repaint();
		frame.pack();
	}
	public static void stop(){
		frame.dispose();
	}
}
