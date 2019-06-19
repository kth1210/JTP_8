import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class FirstLayout extends JFrame implements ActionListener{
	static JButton searchButton;
	
	public static void main(String[] args) {
		LoginInterface f = new LoginInterface();
	}
	
	public FirstLayout() {
		setSize(1000,1000);
		setTitle("���ǽ� ã��");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font of = new Font("���� ���",Font.BOLD,20);
		
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
		
		JButton gButton = new JButton("����, IT��");
		gButton.setBounds(380,600,150,50);
		gButton.setFont(of);
		gButton.addActionListener(this);
		bottomPanel.add(gButton);
		
		JButton nButton = new JButton("���");
		nButton.setBounds(320,340,100,50);
		nButton.setFont(of);
		nButton.addActionListener(this);
		bottomPanel.add(nButton);
		
		JButton jgd = new JButton("�ڰ���");
		jgd.setBounds(230,440,115,50);
		jgd.setFont(of);
		jgd.addActionListener(this);
		bottomPanel.add(jgd);
		
		JButton anButton = new JButton("���ǰ�����");
		anButton.setBounds(660,700,110,30);
		anButton.setFont(new Font("���� ���",Font.BOLD,13));
		anButton.addActionListener(this);
		bottomPanel.add(anButton);
		
		JButton sgd = new JButton("��Ȱ���д���");
		sgd.setBounds(805, 450, 115, 30);
		sgd.setFont(new Font("���� ���",Font.BOLD,13));
		sgd.addActionListener(this);
		bottomPanel.add(sgd);
		
		JButton sagwa = new JButton("��ȸ���д���");
		sagwa.setBounds(805, 560, 115, 30);
		sagwa.setFont(new Font("���� ���",Font.BOLD,13));
		sagwa.addActionListener(this);
		bottomPanel.add(sagwa);
		
		JButton the4 = new JButton("��4�յ����ǵ�");
		the4.setBounds(700,480,115,30);
		the4.setFont(new Font("���� ���",Font.BOLD,12));
		the4.addActionListener(this);
		bottomPanel.add(the4);
		
		JButton inmun = new JButton("�ι�����");
		inmun.setBounds(460, 345, 90, 25);
		inmun.setFont(new Font("���� ���",Font.BOLD,13));
		inmun.addActionListener(this);
		bottomPanel.add(inmun);
		
		JButton daehakone = new JButton("���п���");
		daehakone.setBounds(430, 470, 90, 25);
		daehakone.setFont(new Font("���� ���",Font.BOLD,13));
		daehakone.addActionListener(this);
		bottomPanel.add(daehakone);
		
		JButton gp = new JButton("KNU�۷ι��ö���");
		gp.setBounds(480,290,140,30);
		gp.setFont(new Font("���� ���",Font.BOLD,12));
		gp.addActionListener(this);
		bottomPanel.add(gp);
		
		JButton sabum = new JButton("�������");
		sabum.setBounds(670,420,90,25);
		sabum.setFont(new Font("���� ���",Font.BOLD,13));
		sabum.addActionListener(this);
		bottomPanel.add(sabum);
		
		JButton yakhak = new JButton("���д���");
		yakhak.setBounds(570,220,90,25);
		yakhak.setFont(new Font("���� ���",Font.BOLD,13));
		yakhak.addActionListener(this);
		bottomPanel.add(yakhak);
		
		JButton yesul = new JButton("��������");
		yesul.setBounds(500,150,90,30);
		yesul.setFont(new Font("���� ���",Font.BOLD,13));
		yesul.addActionListener(this);
		bottomPanel.add(yesul);
		
		JButton jonghap = new JButton("����������Ÿ");
		jonghap.setBounds(645,245,115,25);
		jonghap.setFont(new Font("���� ���",Font.BOLD,13));
		jonghap.addActionListener(this);
		bottomPanel.add(jonghap);
		
		JButton bokhyun = new JButton("����ȸ��");
		bokhyun.setBounds(210, 385, 90, 25);
		bokhyun.setFont(new Font("���� ���",Font.BOLD,13));
		bokhyun.addActionListener(this);
		bottomPanel.add(bokhyun);
		
		JButton saeng = new JButton("�����а�");
		saeng.setBounds(150,710,90,30);
		saeng.setFont(new Font("���� ���",Font.BOLD,13));
		saeng.addActionListener(this);
		bottomPanel.add(saeng);
		
		JButton hwa = new JButton("ȭ�а�");
		hwa.setBounds(300,735,90,30);
		hwa.setFont(new Font("���� ���",Font.BOLD,13));
		hwa.addActionListener(this);
		bottomPanel.add(hwa);
		
		JButton gyeong = new JButton("������");
		gyeong.setBounds(805, 520, 90, 25);
		gyeong.setFont(new Font("���� ���",Font.BOLD,13));
		gyeong.addActionListener(this);
		bottomPanel.add(gyeong);
		
		JButton ro = new JButton("��������");
		ro.setBounds(750,610,90,30);
		ro.setFont(new Font("���� ���",Font.BOLD,13));
		ro.addActionListener(this);
		bottomPanel.add(ro);
		
		JPanel topPanel = new JPanel();
		searchButton = new JButton("�ǹ� �˻��ϱ�");
		searchButton.setFont(new Font("���� ���",Font.BOLD,20));		
		searchButton.addActionListener(this);

		topPanel.add(searchButton);
		add(topPanel, BorderLayout.NORTH);
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("����, IT��")) {
			Engineering eg = new Engineering();
			eg.setVisible(true);
		}
		else if(actionCommand.equals("���")) {
			Agriculture ac = new Agriculture();
			ac.setVisible(true);
		}
		else if(actionCommand.contentEquals("�ڰ���")) {
			Science sc = new Science();
			sc.setVisible(true);
		}
		else if(actionCommand.equals("�ǹ� �˻��ϱ�")) {
			test T = new test();
			T.setVisible(true);
		}
		else {
			test T2 = new test();
			String str=e.getActionCommand();
			secondWindow secondwindow=new secondWindow(str);
			secondwindow.setVisible(true);
		}
	}
}
