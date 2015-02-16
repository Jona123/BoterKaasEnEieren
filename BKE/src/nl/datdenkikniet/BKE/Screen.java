package nl.datdenkikniet.BKE;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Screen {
	private static JFrame frame;
public static void createWindow(){
	frame = new JFrame("Boter, Kaas en Eieren");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setSize(new Dimension(500,500));
	frame.setVisible(true);
	updateFrame();
}
public static void updateFrame(){
	frame.removeAll();
	frame.getContentPane().add(BKELayout.getLayout(), BorderLayout.CENTER);
	if (Main.logLayout){
	System.out.println(BKELayout.getLayout().getText());
	}
}
}
