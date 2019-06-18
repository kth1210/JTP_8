import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Engineering extends JFrame implements ActionListener{
	public Engineering() {
		setSize(1200,600);
		setTitle("공대, IT대");
		
		Font of = new Font("맑은 고딕",Font.BOLD,15);
		
		JPanel Map = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("공대, IT대.JPG");
				Image img = icon.getImage();			
				g.drawImage(img, 0, 0, 1180, 550, null);
				g.drawRect(0, 0, 1180, 550);
			}
		};
		
		JButton button1 = new JButton("공대1호관");
		button1.setBounds(140,280,150,50);
		button1.setFont(of);
		add(button1);
		
		JButton button2 = new JButton("공대2호관");
		button2.setBounds(150,150,150,50);
		button2.setFont(of);
		add(button2);
		
		JButton button2a = new JButton("공대2A호관");
		button2a.setBounds(0,110,100,50);
		button2a.setFont(new Font("맑은 고딕",Font.BOLD,12));
		add(button2a);
		
		JButton button3 = new JButton("공대3호관");
		button3.setBounds(380,230,150,50);
		button3.setFont(of);
		add(button3);
		
		JButton button4 = new JButton("공대4호관");
		button4.setBounds(590,240,150,50);
		button4.setFont(of);
		add(button4);
		
		JButton button6 = new JButton("공대6호관");
		button6.setBounds(380,340,150,50);
		button6.setFont(of);
		add(button6);
		
		JButton button7 = new JButton("공대7호관");
		button7.setBounds(590,340,150,50);
		button7.setFont(of);
		add(button7);
		
		JButton button8 = new JButton("공대8호관");
		button8.setBounds(750, 500, 150, 50);
		button8.setFont(of);
		add(button8);
		
		JButton button9 = new JButton("공대9호관");
		button9.setBounds(130, 450, 150, 50);
		button9.setFont(of);
		add(button9);
		
		JButton button12 = new JButton("공대12호관");
		button12.setBounds(420, 30, 140, 50);
		button12.setFont(of);
		add(button12);
		
		JButton it1 = new JButton("IT대학1호관");
		it1.setBounds(1000,290,150,50);
		it1.setFont(of);
		add(it1);
		
		JButton it2 = new JButton("IT대학2호관");
		it2.setBounds(780, 280, 150, 100);
		it2.setFont(of);
		add(it2);
		
		JButton it3 = new JButton("IT대학3호관");
		it3.setBounds(530, 170, 120, 40);
		it3.setFont(of);
		add(it3);
		
		JButton it4 = new JButton("IT대학4호관");
		it4.setBounds(650,130,120,40);
		it4.setFont(of);
		add(it4);
		
		JButton it5 = new JButton("IT융복합관");
		it5.setBounds(780, 140, 120, 60);
		it5.setFont(of);
		add(it5);
		
		add(Map);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
