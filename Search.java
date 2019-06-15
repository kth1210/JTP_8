/*import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Search extends JFrame implements ActionListener{
	public static final int WIDTH=400;
	public static final int HEIGHT=800;
	JPanel uniPanel=new JPanel();
	private JTextField searchField;
	public static void main(String[] args) {
		Search search=new Search();
		search.setVisible(true);
	}
	public Search()
	{	super();
        setSize(WIDTH, HEIGHT);
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel searchPanel=new JPanel();
		searchField=new JTextField(25);
		JButton searchButton=new JButton("search");
		searchButton.addActionListener(this);
		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		add(searchPanel,BorderLayout.NORTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str=searchField.getText();
		str=str.toUpperCase();
		String str2="";
		int n=str.length();
		int cnt=0;
		JButton[] button=new JButton[100];
		
		uniPanel.setLayout(new BoxLayout(uniPanel,BoxLayout.Y_AXIS));
		
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
				inputFile=new Scanner(new FileInputStream("src/건물.txt"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			while(inputFile.hasNextLine()) {
				String line=inputFile.nextLine();
				if(line.indexOf(str2)!=-1) {
					System.out.println(line);
					button[cnt]=new JButton(line);
					button[cnt].setAlignmentX(Component.CENTER_ALIGNMENT);
					button[cnt].setMaximumSize(new Dimension(300,50));
					button[cnt].setText(line);
					uniPanel.add(button[cnt]);
					button[cnt].setVisible(true);
					cnt++;
				}
			}
			add(uniPanel,BorderLayout.CENTER);
			JScrollPane scroll = new JScrollPane(uniPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scroll.setPreferredSize(new Dimension(300, 500));
            add(scroll);
            
		}
		
	}
}*/
