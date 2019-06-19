import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class secondWindow extends JFrame implements ActionListener{
		private Font font=new Font("SansSefif",Font.BOLD,20);
		public secondWindow(String str) {

			super("강의실 목록");

			setSize(400,800);
			
			Scanner input=null;

			setLayout(new BorderLayout());

			try {

				input=new Scanner(new FileInputStream(str+".txt"));

				

			} catch (FileNotFoundException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			JLabel[] SLabel=new JLabel[40];

			JButton[]SButton=new JButton[40];

			JPanel[] smallPanel=new JPanel[40];

			int i=0;

			String line;

			JPanel SPanel=new JPanel();

			JPanel secondPanel=new JPanel();

			secondPanel.setLayout(new BorderLayout());

			SPanel.setLayout(new BoxLayout(SPanel,BoxLayout.Y_AXIS));

			JLabel title =new JLabel("강의실 목록");

			title.setAlignmentX(Component.CENTER_ALIGNMENT);

	        secondPanel.add(title,BorderLayout.NORTH);

	        JLabel cf=new JLabel("강의실 버튼을 클릭해 시간표를 확인하세요.");

	        cf.setAlignmentX(Component.CENTER_ALIGNMENT);

	        secondPanel.add(cf,BorderLayout.CENTER);

	        add(secondPanel,BorderLayout.NORTH);

			while(input.hasNextLine()) {

				line=input.nextLine();

				StringTokenizer line2=new StringTokenizer(line);

				String building=line2.nextToken();

				String num1=line2.nextToken();

				String num2=line2.nextToken();

				String cur_state = num2+"/"+num1;

				ReservationClass reservation=new ReservationClass(str+".txt",building,cur_state);

				SLabel[i]=new JLabel(building);

				SLabel[i].setFont(font);

				SButton[i]=new JButton(building);

				smallPanel[i]=new JPanel();

				SLabel[i].setAlignmentX(Component.CENTER_ALIGNMENT);

				SLabel[i].setMaximumSize(new Dimension(300,50));

				smallPanel[i].add(SLabel[i]);

				SButton[i].setAlignmentX(Component.CENTER_ALIGNMENT);

				SButton[i].addActionListener(this);

				smallPanel[i].add(SButton[i]);

				smallPanel[i].add(reservation);

				SPanel.add(smallPanel[i]);

				}

			add(SPanel);

			test.className=str;

			JScrollPane scroll = new JScrollPane(SPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	        scroll.setPreferredSize(new Dimension(300, 500));

	        add(scroll);

	       input.close();

			}



		//@Override

		public void actionPerformed(ActionEvent e) {

			String str=e.getActionCommand();

			thirdWindow thirdW=new thirdWindow(str);

			thirdW.setVisible(true);

		}

		

	}