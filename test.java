import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class test extends JFrame {
	public static final int WIDTH=400;
	public static final int HEIGHT=800;
	private JButton[] button;
	private JPanel panel2;
	private JPanel uniPanel=new JPanel();
	private JTextField searchField;
	private Font font=new Font("SansSefif",Font.BOLD,20);
	public static String className;
	private int cnt;
	
	public test()
	{	
		super("검색");	
		setSize(WIDTH, HEIGHT);
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel searchPanel=new JPanel();
		searchField=new JTextField(15);
		searchField.setFont(font);
		JButton searchButton=new JButton("검색");
		searchButton.addActionListener(new firstListener());
		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		add(searchPanel,BorderLayout.NORTH);
		JPanel panel2=new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));

		button=new JButton[40];

		for(int i=0;i<40;i++) {

			button[i]=new JButton();
			button[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			button[i].setMaximumSize(new Dimension(300,50));
			button[i].setVisible(false);
			button[i].addActionListener(new secondListener());
			panel2.add(button[i]);

		}

		add(panel2,BorderLayout.CENTER);

		JScrollPane scroll = new JScrollPane(panel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        scroll.setPreferredSize(new Dimension(300, 500));

        add(scroll);
	}

	public class firstListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			String str=searchField.getText();
			str=str.toUpperCase();
			String str2="";
			int n=str.length();
			
			for(int i=0;i<cnt;i++) {
				button[i].setVisible(false);
			}
			cnt = 0;

			while(cnt<n) {

				if(str.charAt(cnt)!=' ')

					str2+=str.charAt(cnt++);

				else cnt++;

			}

			cnt=0;

			if(str2.length()<2) {

				searchField.setText("두글자 이상 입력해주세요");

			}
			else {

				Scanner inputFile=null;

				try {

					inputFile=new Scanner(new FileInputStream("건물.txt"));

				} catch (FileNotFoundException e1) {

					e1.printStackTrace();

				}
				while(inputFile.hasNextLine()) {

					String line=inputFile.nextLine();

					if(line.indexOf(str2)!=-1) {

						button[cnt].setText(line);

						button[cnt].setFont(font);

						button[cnt].setVisible(true);

						cnt++;

					}

				}
				inputFile.close();

			}

		}

	}
}