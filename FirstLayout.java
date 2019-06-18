import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class FirstLayout extends JFrame implements ActionListener{

	public static void main(String[] args) {
		FirstLayout set = new FirstLayout();	
		set.setVisible(true);
	}
	
	public FirstLayout() {
		setSize(1000,1000);
		setTitle("°­ÀÇ½Ç Ã£±â");
		setLayout(new BorderLayout());
		
		Font of = new Font("¸¼Àº °íµñ",Font.BOLD,20);
		
		JPanel bottomPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("map.gif");
				Image img = icon.getImage();
				g.drawImage(img, 50, 0, 870, 840, null);
				g.drawRect(50, 0, 870, 840);
			}
		};
		
		bottomPanel.setLayout(null);
		add(bottomPanel, BorderLayout.CENTER);
		
		JButton gButton = new JButton("°ø´ë, IT´ë");
		gButton.setBounds(380,600,150,50);
		gButton.setFont(of);
		gButton.addActionListener(this);
		bottomPanel.add(gButton);
		
		JButton nButton = new JButton("³ó´ë");
		nButton.setBounds(320,340,100,50);
		nButton.setFont(of);
		nButton.addActionListener(this);
		bottomPanel.add(nButton);
		
		JButton jgd = new JButton("ÀÚ°ú´ë");
		jgd.setBounds(230,440,115,50);
		jgd.setFont(of);
		jgd.addActionListener(this);
		bottomPanel.add(jgd);
		
		JButton anButton = new JButton("¼öÀÇ°ú´ëÇÐ");
		anButton.setBounds(660,700,110,30);
		anButton.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(anButton);
		
		JButton sgd = new JButton("»ýÈ°°úÇÐ´ëÇÐ");
		sgd.setBounds(805, 450, 115, 30);
		sgd.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(sgd);
		
		JButton sagwa = new JButton("»çÈ¸°úÇÐ´ëÇÐ");
		sagwa.setBounds(805, 560, 115, 30);
		sagwa.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(sagwa);
		
		JButton the4 = new JButton("Á¦4ÇÕµ¿°­ÀÇµ¿");
		the4.setBounds(700,480,115,30);
		the4.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,12));
		bottomPanel.add(the4);
		
		JButton inmun = new JButton("ÀÎ¹®´ëÇÐ");
		inmun.setBounds(460, 345, 90, 25);
		inmun.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(inmun);
		
		JButton daehakone = new JButton("´ëÇÐ¿øµ¿");
		daehakone.setBounds(430, 470, 90, 25);
		daehakone.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(daehakone);
		
		JButton gp = new JButton("KNU±Û·Î¹úÇÃ¶óÀÚ");
		gp.setBounds(480,290,140,30);
		gp.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,12));
		bottomPanel.add(gp);
		
		JButton sabum = new JButton("»ç¹ü´ëÇÐ");
		sabum.setBounds(670,420,90,25);
		sabum.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(sabum);
		
		JButton yakhak = new JButton("¾àÇÐ´ëÇÐ");
		yakhak.setBounds(570,220,90,25);
		yakhak.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(yakhak);
		
		JButton yesul = new JButton("¿¹¼ú´ëÇÐ");
		yesul.setBounds(500,150,90,30);
		yesul.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(yesul);
		
		JButton jonghap = new JButton("Á¾ÇÕÁ¤º¸¼¾Å¸");
		jonghap.setBounds(645,245,115,25);
		jonghap.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(jonghap);
		
		JButton bokhyun = new JButton("º¹ÇöÈ¸°ü");
		bokhyun.setBounds(210, 385, 90, 25);
		bokhyun.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(bokhyun);
		
		JButton saeng = new JButton("»ý¹°ÇÐ°ü");
		saeng.setBounds(150,710,90,30);
		saeng.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(saeng);
		
		JButton hwa = new JButton("È­ÇÐ°ü");
		hwa.setBounds(300,735,90,30);
		hwa.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(hwa);
		
		JButton gyeong = new JButton("°æ»ó´ëÇÐ");
		gyeong.setBounds(805, 520, 90, 25);
		gyeong.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(gyeong);
		
		JButton ro = new JButton("¹ý°ú´ëÇÐ");
		ro.setBounds(750,610,90,30);
		ro.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,13));
		bottomPanel.add(ro);
		
		JPanel topPanel = new JPanel();
		JTextField searchField = new JTextField(20);
		searchField.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,30));
		JButton searchButton = new JButton("°Ë»ö");
		searchButton.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
		topPanel.add(searchField);
		topPanel.add(searchButton);
		add(topPanel, BorderLayout.NORTH);	
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("°ø´ë, IT´ë")) {
			Engineering eg = new Engineering();
			eg.setVisible(true);
		}
		else if(actionCommand.equals("³ó´ë")) {
			Agriculture ac = new Agriculture();
			ac.setVisible(true);
		}
		else if(actionCommand.contentEquals("ÀÚ°ú´ë")) {
			Science sc = new Science();
			sc.setVisible(true);
		}
	}
}
