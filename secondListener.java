import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class secondListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str=e.getActionCommand();
			secondWindow secondW=new secondWindow(str);
			secondW.setVisible(true);
		}
}