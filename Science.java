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
		setTitle("�ڿ����д���");
		
		Font of = new Font("���� ���",Font.BOLD,15);
		
		JPanel Map = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("�ڿ����д���.JPG");
				Image img = icon.getImage();			
				g.drawImage(img, 0, 0, 680, 200, null);
				g.drawRect(0, 0, 680, 200);
			}
		};
		
		JButton s1 = new JButton("�ڿ����д���");
		s1.setBounds(90,30,150,50);
		s1.setFont(of);
		s1.addActionListener(this);
		add(s1);
		
		JButton s2 = new JButton("��2���а�");
		s2.setBounds(50,130,150,50);
		s2.setFont(of);
		s2.addActionListener(this);
		add(s2);
		
		JButton s3 = new JButton("��1���а�");
		s3.setBounds(280,120,150,50);
		s3.setFont(of);
		s3.addActionListener(this);
		add(s3);
		
		JButton s4 = new JButton("������а�");
		s4.setBounds(500,120,150,50);
		s4.setFont(of);
		s4.addActionListener(this);
		add(s4);
		
		add(Map);
	}

	public void actionPerformed(ActionEvent e) {
		test T2 = new test();
		String str=e.getActionCommand();
		secondWindow secondwindow=new secondWindow(str);
		secondwindow.setVisible(true);
	}

}
