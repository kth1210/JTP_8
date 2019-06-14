import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class FirstLayout extends JFrame{

	public static void main(String[] args) {
		FirstLayout set = new FirstLayout();	
		set.setVisible(true);
	}
	
	public FirstLayout() {
		setSize(1000,1000);
		setTitle("°­ÀÇ½Ç Ã£±â");
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		JPanel bottomPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("map.gif");
				Image img = icon.getImage();
				g.drawImage(img, 50, 0, 870, 840, null);
				g.drawRect(50, 0, 870, 840);
			}
		};
		
		bottomPanel.setLayout(new GridLayout(10,10));
		add(bottomPanel, BorderLayout.CENTER);
		
		JPanel topPanel = new JPanel();
		JTextField searchField = new JTextField(20);
		searchField.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,30));
		JButton searchButton = new JButton("°Ë»ö");
		searchButton.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
		topPanel.add(searchField);
		topPanel.add(searchButton);
		add(topPanel, BorderLayout.NORTH);
		
		
	}
}
