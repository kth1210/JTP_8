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
		setTitle("���");
		
		Font of = new Font("���� ���",Font.BOLD,15);
		
		JPanel Map = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("���.JPG");
				Image img = icon.getImage();			
				g.drawImage(img, 0, 0, 680, 450, null);
				g.drawRect(0, 0, 680, 450);
			}
		};
		
		JButton n1 = new JButton("���1ȣ��");
		n1.setBounds(360, 190, 150, 50);
		n1.setFont(of);
		n1.addActionListener(this);
		add(n1);
		
		JButton n2 = new JButton("���2ȣ��");
		n2.setBounds(70,200,150,50);
		n2.setFont(of);
		n2.addActionListener(this);
		add(n2);
		
		JButton n3 = new JButton("���3ȣ��");
		n3.setBounds(150,50,150,50);
		n3.setFont(of);
		n3.addActionListener(this);
		add(n3);
		
		add(Map);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		test T2 = new test();
		String str=e.getActionCommand();
		secondWindow secondwindow=new secondWindow(str);
		secondwindow.setVisible(true);
	}

}
