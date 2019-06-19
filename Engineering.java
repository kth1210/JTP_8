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
		setTitle("����, IT��");
		
		Font of = new Font("���� ���",Font.BOLD,15);
		
		JPanel Map = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("����, IT��.JPG");
				Image img = icon.getImage();			
				g.drawImage(img, 0, 0, 1180, 550, null);
				g.drawRect(0, 0, 1180, 550);
			}
		};
		
		JButton button1 = new JButton("����1ȣ��");
		button1.setBounds(140,280,150,50);
		button1.setFont(of);
		button1.addActionListener(this);
		add(button1);
		
		JButton button2 = new JButton("����2ȣ��");
		button2.setBounds(150,150,150,50);
		button2.setFont(of);
		button2.addActionListener(this);
		add(button2);
		
		JButton button2a = new JButton("����2Aȣ��");
		button2a.setBounds(0,110,100,50);
		button2a.setFont(new Font("���� ���",Font.BOLD,12));
		button2a.addActionListener(this);
		add(button2a);
		
		JButton button3 = new JButton("����3ȣ��");
		button3.setBounds(380,230,150,50);
		button3.setFont(of);
		button3.addActionListener(this);
		add(button3);
		
		JButton button4 = new JButton("����4ȣ��");
		button4.setBounds(590,240,150,50);
		button4.setFont(of);
		button4.addActionListener(this);
		add(button4);
		
		JButton button6 = new JButton("����6ȣ��");
		button6.setBounds(380,340,150,50);
		button6.setFont(of);
		button6.addActionListener(this);
		add(button6);
		
		JButton button7 = new JButton("����7ȣ��");
		button7.setBounds(590,340,150,50);
		button7.setFont(of);
		button7.addActionListener(this);
		add(button7);
		
		JButton button8 = new JButton("����8ȣ��");
		button8.setBounds(750, 500, 150, 50);
		button8.setFont(of);
		button8.addActionListener(this);
		add(button8);
		
		JButton button9 = new JButton("����9ȣ��");
		button9.setBounds(130, 450, 150, 50);
		button9.setFont(of);
		button9.addActionListener(this);
		add(button9);
		
		JButton button12 = new JButton("����12ȣ��");
		button12.setBounds(420, 30, 140, 50);
		button12.setFont(of);
		button12.addActionListener(this);
		add(button12);
		
		JButton it1 = new JButton("IT����1ȣ��");
		it1.setBounds(1000,290,150,50);
		it1.setFont(of);
		it1.addActionListener(this);
		add(it1);
		
		JButton it2 = new JButton("IT����2ȣ��");
		it2.setBounds(780, 280, 150, 100);
		it2.setFont(of);
		it2.addActionListener(this);
		add(it2);
		
		JButton it3 = new JButton("IT����3ȣ��");
		it3.setBounds(530, 170, 120, 40);
		it3.setFont(of);
		it3.addActionListener(this);
		add(it3);
		
		JButton it4 = new JButton("IT����4ȣ��");
		it4.setBounds(650,130,120,40);
		it4.setFont(of);
		it4.addActionListener(this);
		add(it4);
		
		JButton it5 = new JButton("IT�����հ�");
		it5.setBounds(780, 140, 120, 60);
		it5.setFont(of);
		it5.addActionListener(this);
		add(it5);
		
		add(Map);
	}
	
	public void actionPerformed(ActionEvent e) {
		test T2 = new test();
		String str=e.getActionCommand();
		secondWindow secondwindow=new secondWindow(str);
		secondwindow.setVisible(true);
	}

}
