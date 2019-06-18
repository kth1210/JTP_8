import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Science extends JFrame implements ActionListener{
	public Science() {
		setSize(700,250);
		setTitle("자연과학대학");
		
		Font of = new Font("맑은 고딕",Font.BOLD,15);
		
		JPanel Map = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("자연과학대학.JPG");
				Image img = icon.getImage();			
				g.drawImage(img, 0, 0, 680, 200, null);
				g.drawRect(0, 0, 680, 200);
			}
		};
		
		JButton s1 = new JButton("자연과학대학");
		s1.setBounds(90,30,150,50);
		s1.setFont(of);
		add(s1);
		
		JButton s2 = new JButton("제2과학관");
		s2.setBounds(50,130,150,50);
		s2.setFont(of);
		add(s2);
		
		JButton s3 = new JButton("제1과학관");
		s3.setBounds(280,120,150,50);
		s3.setFont(of);
		add(s3);
		
		JButton s4 = new JButton("생명공학관");
		s4.setBounds(500,120,150,50);
		s4.setFont(of);
		add(s4);
		
		add(Map);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
