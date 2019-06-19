import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class thirdWindow extends JFrame{

		private Image img;

		public thirdWindow(String str) {

			super("½Ã°£Ç¥");

			setSize(400,700);

			JPanel panel=new JPanel() {

				public void paintComponent(Graphics g) {

					ImageIcon icon = new ImageIcon(test.className+"/"+str+".jpg");

					img = icon.getImage();

					g.drawImage(img,0,0,400,600,null);

				}

			};

			add(panel);

		}

	}