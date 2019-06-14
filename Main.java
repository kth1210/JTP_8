import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

// ��� window exit â ���� ��¥ ����ϰڽ��ϱ� windowlistener �ֱ�
//�̰� ����â
public class Main extends JFrame{

	   public static final int Window_width = 200;
	   public static final int Window_height = 300;
	   
	   JButton button;
	   int cnt=0;
	   
	   public Main()
	   {
	      super();
	      setSize(Window_width, Window_height);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      Reservation window = new Reservation();
	      add(window);
	      
	   }   
	  
	   public static void main(String[] args)
	   {
	      Main gui=new Main();
	      gui.setVisible(true);
	   }
	   
}

//�̰� ��ưâ -> �ڵ� ��ĥ ���� �̰͸� ���� 
class Reservation extends JButton implements ActionListener {

    
   JButton button;
   int cnt=0;
   
   public Reservation()
   {
	  super("/42 ���డ��");
     // button = new JButton(cnt +"/42 ���డ��");
      addActionListener(this);
     
   }   
   public void actionPerformed(ActionEvent e)
   {
      ReservePopUp window=new ReservePopUp();
      window.setVisible(true);
   }

   
   public static void main(String[] args)
   {
	   Reservation gui=new Reservation();
      gui.setVisible(true);
   }
   
   //Reservation �̳�Ŭ����
   private class ReservePopUp extends JFrame implements ActionListener
   {
      public static final int ReservePopUp_width = 400;
      public static final int ReservePopUp_height = 200;
   
      public ReservePopUp()
      {
         setTitle("�����˾�");
         setSize(ReservePopUp_width, ReservePopUp_height);
         getContentPane().setBackground(Color.yellow);
         setLayout(new BorderLayout());
         
         JLabel Title = new JLabel("���డ��");
         add(Title, BorderLayout.NORTH);
      
         JPanel butpane=new JPanel();
         butpane.setLayout(new FlowLayout());
         
          JButton   All=new JButton("��°��");
         JButton One=new JButton("����");
         
         All.addActionListener(this);
         One.addActionListener(this);
         
         butpane.add(All);
         butpane.add(One);
         // ��ư ���̽� Insets Ŭ������ ����
         add(butpane, BorderLayout.SOUTH);
         
          //�ؿ� ��°�δ� ������ 1/4 ���� �����ϴٰ� ����ϱ�
      }
      
      
      public void actionPerformed(ActionEvent e) 
      {
         String message=e.getActionCommand();
         
         if(message.equals("��°��"))
         {
            ReserveALL Allwindow = new ReserveALL();
            Allwindow.setVisible(true);
         }
         else if(message.contentEquals("����"))
         {
            cnt++; //���߿� ��ư ++ �ϱ�
            button.setText(cnt+"/42 ���డ��");
            ReserveOne Onewindow = new ReserveOne();
            Onewindow.setVisible(true);
         }
            
         
      }
      
      //ReservePopUp �̳�Ŭ����
      private class ReserveALL extends JFrame
      {
         public static final int ReserveAll_width = 350;
         public static final int ReserveAll_height = 650;
         JScrollPane scroll;
         
         public ReserveALL()
         {
            setSize(ReserveAll_width, ReserveAll_height);
            setLayout(new FlowLayout());
            
            JLabel title =new JLabel("          ���� ���             ");
            add(title, BorderLayout.NORTH);
            
            JLabel cf=new JLabel("���ǽ� ������ 1/4 �̻� �ο��� ���� ����");
            add(cf, BorderLayout.AFTER_LAST_LINE);
            JLabel cf1=new JLabel("ID                    �й�                        ���");
            add(cf1, BorderLayout.AFTER_LAST_LINE);
         
            JPanel big = new JPanel();
            big.setSize(250, 300);
            big.setLayout(new GridLayout(20,1));
            
            GridBagLayout gridbag = new GridBagLayout();
            big.setLayout(gridbag);
            GridBagConstraints constraint = new GridBagConstraints();
            constraint.fill=GridBagConstraints.BOTH;
            constraint.weightx = 1.0;
            constraint.gridwidth = GridBagConstraints.REMAINDER;
            constraint.gridheight = 1;
            constraint.weighty = 1; 

            InputPanel[] input = new InputPanel[70];
                  
            for(int i=0; i<input.length; i++) {
               input[i]=new InputPanel(Integer.toString(i+1));
               gridbag.setConstraints(input[i], constraint);
               big.add(input[i]);   
            }
            
            
            scroll = new JScrollPane(big,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scroll.setPreferredSize(new Dimension(300, 500));
            add(scroll);
            
           // DoneRegister register_done = new DoneRegister();
           // register_done.addActionListener(this));
            RealDoneRegister window = new  RealDoneRegister();
            
            add(window);
         }
         
      }
      
      //ReservePopUp �̳�Ŭ���� 
      
      private class ReserveOne extends JFrame
      {
    	  public static final int ReserveOnePopUp_width = 300;
          public static final int ReserveOnePopUp_height = 150;
          
          public ReserveOne()
          {
        	  setSize(ReserveOnePopUp_width, ReserveOnePopUp_height);
        	  setLayout(new FlowLayout());
        	  JLabel title =new JLabel("          ���� ���             ");
              add(title, BorderLayout.NORTH);
              
              JLabel cf1=new JLabel("ID                    �й�                        ���");
              add(cf1, BorderLayout.AFTER_LAST_LINE);
              
              InputPanel info = new InputPanel("None");
              add(info);
                   
          }
          
      }
      
      private class InputPanel extends JPanel implements ActionListener
      {
         int cnt=1;
         //public static final int NUMBER_OF_CHAR=6;
         public InputPanel(String idx)
         {
            
            setLayout(new FlowLayout());
            JLabel idxnum;
            
            if(!idx.contentEquals("None"))
            {
            	idxnum = new JLabel(idx);
            	add(idxnum);
            }
            	
            
            JTextField id=new JTextField("Enter ID", 6);
            JTextField num_id = new JTextField("Enter �й�", 10);
            JButton register = new JButton("���");
            register.addActionListener(this);
            
            add(id);
            add(num_id);
            add(register);
            
         }

         public void actionPerformed(ActionEvent e) {
            
        	//ȸ������ ����//
            if(cnt==0) // ���� ȸ������ ��ġ�ϰų� �ռ� �ߺ� ��û ��������
               setBackground(Color.green);
            else
            {
               setBackground(Color.red);
               RegisterDone gui= new RegisterDone("       Ȯ�ε��� ���� ������Դϴ�.   ");
               gui.setVisible(true);
            }
         }
         
      }
           
      
   }


   private class RegisterDone extends JFrame
   {
      public static final int PopUp_width = 300;
      public static final int PopUp_height = 100;
      
      public RegisterDone(String str)
      {
         //setTitle("��� Error");
         setSize(PopUp_width, PopUp_height);
         setLayout(new BorderLayout());
         
         JLabel message = new JLabel(str);
         add(message, BorderLayout.CENTER);
      }
   }
   
   private class RealDoneRegister extends JButton implements ActionListener
   {
	   int cnt =70;
	   public RealDoneRegister()
	   {
		   
		   super("��� �Ϸ�");
		   setBackground(Color.red);
		   addActionListener(this);
	   }

	
	   public void actionPerformed(ActionEvent e) 
	   {
		   RegisterDone window;
		  
		   if(cnt> 10) //���� ���� �����ϱ� 
		      window = new RegisterDone("   ����� �Ϸ�Ǿ����ϴ� (11:30 ~ 13:00 �̿밡��)   ");
		   else
			   window = new RegisterDone("           ����� �Ұ��մϴ�        ");
			   
		   window.setVisible(true);
	   }
   }
}
