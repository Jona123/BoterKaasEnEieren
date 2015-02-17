package nl.datdenkikniet.BKE;

import java.awt.Dimension;

import javax.swing.JFrame;

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
		updateFrame(false);
	}
	public static void updateFrame(boolean bool){
		frame.getContentPane().removeAll();
		frame.add(BKELayout.getLayout(bool));
		if (Main.logLayout){
			System.out.println(BKELayout.getLayout(false).getText());
		}
		frame.revalidate();
		frame.repaint();
		frame.pack();
	}
	public static void stop(){
		frame.dispose();
	}
}
