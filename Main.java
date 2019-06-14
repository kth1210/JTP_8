import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

// 모든 window exit 창 마다 진짜 취소하겠습니까 windowlistener 넣기
//이게 메인창
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

//이게 버튼창 -> 코드 합칠 때는 이것만 쓰기 
class Reservation extends JButton implements ActionListener {

    
   JButton button;
   int cnt=0;
   
   public Reservation()
   {
	  super("/42 예약가능");
     // button = new JButton(cnt +"/42 예약가능");
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
   
   //Reservation 이너클래스
   private class ReservePopUp extends JFrame implements ActionListener
   {
      public static final int ReservePopUp_width = 400;
      public static final int ReservePopUp_height = 200;
   
      public ReservePopUp()
      {
         setTitle("예약팝업");
         setSize(ReservePopUp_width, ReservePopUp_height);
         getContentPane().setBackground(Color.yellow);
         setLayout(new BorderLayout());
         
         JLabel Title = new JLabel("예약가능");
         add(Title, BorderLayout.NORTH);
      
         JPanel butpane=new JPanel();
         butpane.setLayout(new FlowLayout());
         
          JButton   All=new JButton("통째로");
         JButton One=new JButton("개인");
         
         All.addActionListener(this);
         One.addActionListener(this);
         
         butpane.add(All);
         butpane.add(One);
         // 버튼 사이스 Insets 클래스로 조정
         add(butpane, BorderLayout.SOUTH);
         
          //밑에 통째로는 정원의 1/4 부터 가능하다고 명시하기
      }
      
      
      public void actionPerformed(ActionEvent e) 
      {
         String message=e.getActionCommand();
         
         if(message.equals("통째로"))
         {
            ReserveALL Allwindow = new ReserveALL();
            Allwindow.setVisible(true);
         }
         else if(message.contentEquals("개인"))
         {
            cnt++; //나중에 버튼 ++ 하기
            button.setText(cnt+"/42 예약가능");
            ReserveOne Onewindow = new ReserveOne();
            Onewindow.setVisible(true);
         }
            
         
      }
      
      //ReservePopUp 이너클래스
      private class ReserveALL extends JFrame
      {
         public static final int ReserveAll_width = 350;
         public static final int ReserveAll_height = 650;
         JScrollPane scroll;
         
         public ReserveALL()
         {
            setSize(ReserveAll_width, ReserveAll_height);
            setLayout(new FlowLayout());
            
            JLabel title =new JLabel("          예약 명단             ");
            add(title, BorderLayout.NORTH);
            
            JLabel cf=new JLabel("강의실 정원의 1/4 이상 인원만 예약 가능");
            add(cf, BorderLayout.AFTER_LAST_LINE);
            JLabel cf1=new JLabel("ID                    학번                        등록");
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
      
      //ReservePopUp 이너클래스 
      
      private class ReserveOne extends JFrame
      {
    	  public static final int ReserveOnePopUp_width = 300;
          public static final int ReserveOnePopUp_height = 150;
          
          public ReserveOne()
          {
        	  setSize(ReserveOnePopUp_width, ReserveOnePopUp_height);
        	  setLayout(new FlowLayout());
        	  JLabel title =new JLabel("          예약 명단             ");
              add(title, BorderLayout.NORTH);
              
              JLabel cf1=new JLabel("ID                    학번                        등록");
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
            JTextField num_id = new JTextField("Enter 학번", 10);
            JButton register = new JButton("등록");
            register.addActionListener(this);
            
            add(id);
            add(num_id);
            add(register);
            
         }

         public void actionPerformed(ActionEvent e) {
            
        	//회원정보 파일//
            if(cnt==0) // 만약 회원정보 일치하거나 앞서 중복 신청 안했으면
               setBackground(Color.green);
            else
            {
               setBackground(Color.red);
               RegisterDone gui= new RegisterDone("       확인되지 않은 사용자입니다.   ");
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
         //setTitle("등록 Error");
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
		   
		   super("등록 완료");
		   setBackground(Color.red);
		   addActionListener(this);
	   }

	
	   public void actionPerformed(ActionEvent e) 
	   {
		   RegisterDone window;
		  
		   if(cnt> 10) //정원 따라 수정하기 
		      window = new RegisterDone("   등록이 완료되었습니다 (11:30 ~ 13:00 이용가능)   ");
		   else
			   window = new RegisterDone("           등록이 불가합니다        ");
			   
		   window.setVisible(true);
	   }
   }
}
