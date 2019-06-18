import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Agriculture extends JFrame implements ActionListener{
	public Agriculture() {
		setSize(700,500);
		setTitle("³ó´ë");
		
		Font of = new Font("¸¼Àº °íµñ",Font.BOLD,15);
		
		JPanel Map = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("³ó´ë.JPG");
				Image img = icon.getImage();			
				g.drawImage(img, 0, 0, 680, 450, null);
				g.drawRect(0, 0, 680, 450);
			}
		};
		
		JButton n1 = new JButton("³ó´ë1È£°ü");
		n1.setBounds(360, 190, 150, 50);
		n1.setFont(of);
		add(n1);
		
		JButton n2 = new JButton("³ó´ë2È£°ü");
		n2.setBounds(70,200,150,50);
		n2.setFont(of);
		add(n2);
		
		JButton n3 = new JButton("³ó´ë3È£°ü");
		n3.setBounds(150,50,150,50);
		n3.setFont(of);
		add(n3);
		
		add(Map);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
