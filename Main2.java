import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;
import java.io.*;

public class Main2 extends JFrame
{	
	public Main2()
	{
		super();
		setSize(200,300);
		BuildingButton bt = new BuildingButton("IT대학1호관");
		add(bt);
	}

	public static void main(String[] args)
	{
		Main2 Main = new Main2();
		Main.setVisible(true);
	}
	
}

class BuildingButton extends JButton implements ActionListener
{
	public BuildingButton(String line)
	{
		setText(line);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//BuildingFrame((호실버튼,예약) 있는 창) 보여주기
		String buildingfile = e.getActionCommand()+".txt";
		
		BuildingFrame buildingFrame = new BuildingFrame(buildingfile);
		buildingFrame.setVisible(true);
	}	
}

class BuildingFrame extends JFrame
{
	public BuildingFrame(String buildingfileName) //파일명 인자는 .txt받아서옴
	{
		// add 호실버튼, 예약버튼 - 배열로 보여쥬기 
		int cnt=0;
		RoomandReservationPanel[] RandRpanel;
		JScrollPane scroll;
		Scanner inputstream = null;
		
		setSize(200,400);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new CheckOnExit(this));
        setLayout(new FlowLayout());
        JLabel title =new JLabel("       강의실 목록             ");
        add(title, BorderLayout.NORTH);
        
        JLabel cf=new JLabel("강의실 버튼을 클릭해 시간표를 확인하세요.");
        add(cf, BorderLayout.AFTER_LAST_LINE);
      
        JPanel big = new JPanel();
        big.setSize(50, 100);
        big.setLayout(new GridLayout(10,1));
        
        GridBagLayout gridbag = new GridBagLayout();
        big.setLayout(gridbag);
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill=GridBagConstraints.BOTH;
        constraint.weightx = 1.0;
        constraint.gridwidth = GridBagConstraints.REMAINDER;
        constraint.gridheight = 1;
        constraint.weighty = 1; 
     
		try
		{
			inputstream = new Scanner(new FileInputStream(buildingfileName));
			while(inputstream.hasNextLine())
			{
				String line = inputstream.nextLine();
				cnt++;
			}
			inputstream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Fatal error, No " + buildingfileName);
			System.exit(0);
		}
		
		try
		{
			inputstream = new Scanner(new FileInputStream(buildingfileName));
			RandRpanel = new RoomandReservationPanel[cnt];
			for(int i=0; i<RandRpanel.length; i++)
			{
				StringTokenizer ptoken = new StringTokenizer(inputstream.nextLine());
				String roomnum = ptoken.nextToken();
				String total = ptoken.nextToken();
				String cur = ptoken.nextToken();
				String cur_pos_state = cur + "/" + total;
				RandRpanel[i]= new RoomandReservationPanel(buildingfileName,roomnum, cur_pos_state);
				big.add(RandRpanel[i]);		
			}
			inputstream.close();
			
			scroll = new JScrollPane(big,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scroll.setPreferredSize(new Dimension(300, 500));
            add(scroll);
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Fatal error, No " + buildingfileName);
			System.exit(0);
		}		
	}
} //BuildingFrame 


class RoomandReservationPanel extends JPanel // BuildingFrame 에서 이 클래스 배열로 선언하고 파일에서 입력받기
{
	public RoomandReservationPanel(String buildingfilename,String roomnumber, String cur_pos_state)
	{
		setLayout(new FlowLayout());
		Room room = new Room(roomnumber);
		ReservationClass reserve = new ReservationClass(buildingfilename,roomnumber,cur_pos_state);
		add(room);
		add(reserve);
	}
}

class ReservationClass extends JButton implements ActionListener
{
	String buildingfilename;
	String roomnumber;
	String totalnumber;
	
	public ReservationClass(String buildingfilename,String roomnumber, String current_position_state)
	{
		super(current_position_state);
		addActionListener(this);
		this.buildingfilename=buildingfilename;
		this.roomnumber=roomnumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) //actionListener - ReservePopUp 보여주기 
	{
		// TODO Auto-generated method stub
		ReservePopUp reservepopup = new ReservePopUp();
		reservepopup.setVisible(true);
	}
	
	private class ReservePopUp extends JFrame implements ActionListener
	{
		private int Reserve_All_Num=0;
		
		public ReservePopUp()
		{
			setSize(400,200);
			getContentPane().setBackground(Color.yellow);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        addWindowListener(new CheckOnExit(this));
	         
	        setLayout(new BorderLayout());
	         
	        JLabel Title = new JLabel("예약가능");
	        add(Title, BorderLayout.NORTH);
	      
	        JPanel butpane=new JPanel();
	        butpane.setLayout(new FlowLayout());
	         
	        JButton All=new JButton("통째로");
	        JButton One=new JButton("개인");
	         
	        All.addActionListener(this);
	        One.addActionListener(this);
	         
	        butpane.add(All);
	        butpane.add(One);
	         // 버튼 사이스 Insets 클래스로 조정
	        add(butpane, BorderLayout.SOUTH);
		}
		
		
		public void actionPerformed(ActionEvent e) 
	    {
	       String message=e.getActionCommand();
	       Scanner inputstream=null;
	         
	       if(message.equals("통째로"))
           {
	    	  try
	    	  {
	    		  inputstream = new Scanner(new FileInputStream(buildingfilename));
	    		  while(inputstream.hasNextLine())
	    		  {
	    			  String line= inputstream.nextLine();
	    			  StringTokenizer ptoken = new StringTokenizer(line);
	    			  if(ptoken.nextToken().equals(roomnumber))
	    			  {
	    				  totalnumber=ptoken.nextToken();
	    				  String curnum=ptoken.nextToken();
	    				  if(curnum.equals("0"))
	    				  {
	    					  ReserveALL Allwindow = new ReserveALL();
	    			          Allwindow.setVisible(true);
	    				  }
	    				  else 
	    				  {
	    					  CheckRegister gui=new CheckRegister("     통째로 예약이 불가합니다.    ");
	    					  gui.setVisible(true);
	    				  }
	    				  break;
	    			  }
	    		  }
	    		  inputstream.close();
	    	  }
	    	  catch(FileNotFoundException x)
	    	  {
	    		  System.out.println("No "+ buildingfilename);
	    	  }
	    	}
	       else if(message.contentEquals("개인"))
	       {
	    	   try
		       {
		    	   inputstream = new Scanner(new FileInputStream(buildingfilename));
		    	   while(inputstream.hasNextLine())
		    	   {
		    	       String line= inputstream.nextLine();
		    		   StringTokenizer ptoken = new StringTokenizer(line);
		    		   if(ptoken.nextToken().equals(roomnumber))
		    		   {
		    			  String total=ptoken.nextToken();
		    			  String curnum=ptoken.nextToken();
		    			  if(curnum.equals(total))
		    			  {
		    				 CheckRegister gui=new CheckRegister("     통째로 예약이 불가합니다.    ");
		    			     gui.setVisible(true);
		    			  }
		    			  else 
		    			  {
		    				 ReserveOne Onewindow = new ReserveOne();
		    			     Onewindow.setVisible(true);
		    			  }
		    				  
		    			  break;
		    			}
		    		 }
		    	   inputstream.close();
		       }
		       catch(FileNotFoundException x)
		       {
		    	System.out.println("No "+ buildingfilename);
		       }
           }  
	       
	       
	     }
		
		private class ReserveALL extends JFrame
	    {
	       public static final int ReserveAll_width = 350;
	       public static final int ReserveAll_height = 650;
	       JScrollPane scroll;
	         
	       public ReserveALL()
	       {
	          setSize(ReserveAll_width, ReserveAll_height);
              setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
              addWindowListener(new CheckOnExit(this));
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
         
	            RealDoneRegister window = new  RealDoneRegister();
	            add(window);
	        }
	    } //ReserveAll
		
		private class ReserveOne extends JFrame
	    {
	    	public static final int ReserveOnePopUp_width = 300;
	        public static final int ReserveOnePopUp_height = 150;
	          
	        public ReserveOne()
	        {
	           setSize(ReserveOnePopUp_width, ReserveOnePopUp_height);
	           setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	           addWindowListener(new CheckOnExit(this));
	           setLayout(new FlowLayout());
	           JLabel title =new JLabel("          예약 명단             ");
	           add(title, BorderLayout.NORTH);
	              
	           JLabel cf1=new JLabel("ID                    학번                        등록");
	           add(cf1, BorderLayout.AFTER_LAST_LINE);
	              
	           InputPanel info = new InputPanel("None");
	           add(info);
	         }
	     } //ReserveOne
		
		private class InputPanel extends JPanel implements ActionListener
	    {
	        JTextField id;
	        JTextField num_id;
	        JButton register;
	        int how_many=1;
	        boolean Reserve_one;
	        //public static final int NUMBER_OF_CHAR=6;
            public InputPanel(String idx)
            {         
	            setLayout(new FlowLayout());
	            JLabel idxnum;
	            
	            if(!idx.contentEquals("None"))
	            {
	            	idxnum = new JLabel(idx);
	            	add(idxnum);
	            	Reserve_one=false;
	            }
	            else
	            	Reserve_one=true;
	            	
	    
	            id=new JTextField("Enter ID", 6);
	            num_id = new JTextField("Enter 학번", 10);
	            register = new JButton("등록");
	            register.addActionListener(this);
	            
	            add(id);
	            add(num_id);
	            add(register);   
	         }

             public int getHowMany()
             {
            	 return  how_many;
             }
	         public void actionPerformed(ActionEvent e)
	         {
	            //회원정보 파일//
	        	RegisterDone checkRegister = new RegisterDone("     등록을 완료 하시겠습니까?     ", this);
	        	checkRegister.setVisible(true);
	            
	         }
	         
	         public boolean FindRegister()
	         {
	        	 //id, 비밀번호 , 학번, 이름
	        	 Scanner inputStream=null;
	        	 String line;
	        	 String Id;
	        	 String IdNum;
	        	 try
	        	 {
	        		 inputStream=new Scanner(new FileInputStream("src/info.txt"));	
	        	 }
	        	 
	        	 catch(FileNotFoundException e)
	        	 {
	        		 // 창으로 바꾸기 
	        		 System.out.println("Problem opening Information. Fatal Error");
	                 System.exit(0);
	        	 }	
	        	 
	        	 while(inputStream.hasNextLine())
	    		 {
	    			 line=inputStream.nextLine();
	    			 StringTokenizer ptoken= new StringTokenizer(line);
	    			 Id=ptoken.nextToken();
	    			 if(id.getText().equals(Id))
	    			 {
	    				 Id=ptoken.nextToken(); //비밀번호 넘기기
	    				 IdNum=ptoken.nextToken(); 
	    				 if(num_id.getText().equals(IdNum))
	    					 return true; 
	    			} 			
	    		 }	 
	        	 inputStream.close();
	        	 return false;
	          }
	         
	         private class RegisterDone extends JFrame implements ActionListener
			  {
			      public static final int PopUp_width = 300;
			      public static final int PopUp_height = 100;
			      InputPanel panel;
			      int how_many;
			      public RegisterDone(String str, InputPanel pane)
			      {
			         setSize(PopUp_width, PopUp_height);
			         setLayout(new BorderLayout());
			         panel=pane;
			         how_many=panel.getHowMany();
			         JLabel message = new JLabel(str);
			         add(message, BorderLayout.CENTER);
			         JPanel yesno = new JPanel();
			         yesno.setLayout(new FlowLayout());
			         JButton yes = new JButton("예");
			         JButton no = new JButton("아니오");
			         yes.addActionListener(this);
			         no.addActionListener(this);
			         yesno.add(yes);
			         yesno.add(no);
			         add(yesno, BorderLayout.SOUTH);
			      }

				
			      public void actionPerformed(ActionEvent e)
			       {
			    	   String message = e.getActionCommand();
			    	   CheckRegister gui; 
			    	   ReplaceFile replacefile;
			    	   if(message.equals("예"))
			    	   {
			    		   if(FindRegister()==true)
			    		   {// 만약 회원정보 일치하거나 앞서 중복 신청 안했으면
			    			   if(Reserve_one)
			    				   replacefile= new ReplaceFile(buildingfilename, roomnumber, how_many);
			    			   else
			    				   Reserve_All_Num++;
			    			   panel.setBackground(Color.green);
			    			   gui = new CheckRegister("        등록이 완료되었습니다.         ");
			    			   gui.setVisible(true);
			    			   
			    			  
			    		   }
				              
				           else if(FindRegister()==false)
				           {
				               panel.setBackground(Color.red);
				               gui= new CheckRegister("       확인되지 않은 사용자입니다.  다시 입력해 주세요.     ");
				               gui.setVisible(true);
				           }
			    		   dispose();
			    	   }
			    	   
			    	   else if(message.equals("아니오"))
			    		   dispose();
				       
					
	   	           } 
			   } //RegisterDone
	      } // InputPanel  
		
			private class RealDoneRegister extends JButton implements ActionListener
			{
			   public RealDoneRegister()
			   {
				   super("등록 완료");
				   setBackground(Color.red);
				   addActionListener(this);
			   }

			   public void actionPerformed(ActionEvent e) 
			   {
				   CheckRealRegisterDone window = new CheckRealRegisterDone("        등록을 완료하시겠습니까?      ");
				   window.setVisible(true);
			   }
			   
			   private class CheckRealRegisterDone extends JFrame implements ActionListener
			   {
				   public CheckRealRegisterDone(String str)
				   {
					   setSize(300,100);
					   setLayout(new BorderLayout());
				        
				       JLabel message = new JLabel(str);
				       add(message, BorderLayout.CENTER);
				       JPanel yesno = new JPanel();
				       yesno.setLayout(new FlowLayout());
				       JButton yes = new JButton("예");
				       JButton no = new JButton("아니오");
				       yes.addActionListener(this);
				       no.addActionListener(this);
				       yesno.add(yes);
				       yesno.add(no);
				       add(yesno, BorderLayout.SOUTH);

				   }

				@Override
				  public void actionPerformed(ActionEvent e)
				  {
					// TODO Auto-generated method stub
					String message=e.getActionCommand();
					 if(message.equals("예"))
			    	   {
			    		   if(Integer.parseInt(totalnumber)/4 <= Reserve_All_Num)
			    		   {
			    			   ReplaceFile replace = new ReplaceFile(buildingfilename, roomnumber, Reserve_All_Num);
			    			   CheckRegister gui = new CheckRegister("      등록이 완료되었습니다.       ");
			    			   gui.setVisible(true);
			    		   }
			    		   else if(Integer.parseInt(totalnumber)/4 > Reserve_All_Num)
			    		   {
			    			   CheckRegister gui = new CheckRegister("      강의실 정원의 1/4이 넘지 못합니다.      ");
			    			   gui.setVisible(true);
			    		   }
			    		   else if(Integer.parseInt(totalnumber) < Reserve_All_Num)
			    		   {
			    			   CheckRegister gui = new CheckRegister("      강의실 정원 초과로 예약할 수 없습니다.      ");
			    			   gui.setVisible(true);
			    		   }
			    		  dispose();
			    	   }
				              
				   
			    	 else if(message.equals("아니오"))
			    		 dispose();
				       
					 //회원 중복 체크 기능 넣어야함
			      }
			   }
		   }
	}//ReservePopUp 
		
}

class ReplaceFile
{
	String originfilename;
	String replacefilename;
	String roomnumber;
	String room;
	int how_many_register;
	String totalnum;
	
	public ReplaceFile(String filename, String roomnumber, int how_many_register) // 인자자체로 .txt 받아서옴
	{
		originfilename=filename;
		replacefilename="replace"+ filename +".txt";
		this.roomnumber=roomnumber;
		this.how_many_register=how_many_register;
		try {
			replace();
		}
		
		catch(IOException e)
		{
			System.out.println("Error on deleting file");
		}
	}

	public void replace() throws IOException
	{
		BufferedReader inputbuffer = null;
		BufferedWriter outputbuffer = null;
		String cur_num;
		String cur_num_plus;
		
		try
		{
			inputbuffer=new BufferedReader(new FileReader(originfilename));
			outputbuffer = new BufferedWriter(new FileWriter(replacefilename));
			String line;
			while((line =inputbuffer.readLine())!=null)
			{
				StringTokenizer ptoken = new StringTokenizer(line);
				room =ptoken.nextToken();
				//System.out.println(line);
				//System.out.println(room);
				if(room.equals(roomnumber))
				{
					totalnum=ptoken.nextToken();
					cur_num = ptoken.nextToken();
					cur_num_plus = Integer.toString(Integer.parseInt(cur_num)+how_many_register);
					line=room+" "+totalnum+" "+cur_num_plus;
					//System.out.println(how_many_register);
				}
				outputbuffer.write(line+"\r\n");
			}
		}
		catch(Exception e)
		{
			System.out.println("No" + originfilename + "replacing file");
		}
		finally
		{
			try 
			{
				if(inputbuffer!=null)
					inputbuffer.close();
			}
			catch(IOException e)
			{
				System.out.println("Error replacing file");
			}
			
			try 
			{
				if(outputbuffer!=null)
					outputbuffer.close();
			}
			catch(IOException e)
			{
				System.out.println("Error replacing file");
			}
		}
		
		File old = new File(originfilename);
		
		old.delete();
		
		File replace = new File(replacefilename);
		replace.renameTo(old);
	}
}

class CheckRegister extends JFrame
{
	public CheckRegister(String str)
	{
		setSize(300,100);
		setLayout(new BorderLayout());
        
        JLabel message = new JLabel(str);
        add(message, BorderLayout.CENTER);
	}
}

class Room extends JButton //세희가 줄 호실 버튼 
{
	public Room(String roomnum)
	{
		setText(roomnum);
	}
}


class CheckOnExit extends WindowAdapter
{
	JFrame frame;
	public CheckOnExit(JFrame frame)
	{
		this.frame=frame;
    }
	
	public void windowClosing(WindowEvent e)
    {
		ComfirmWindow checker = new ComfirmWindow(frame);
    	checker.setVisible(true);
    }
}

class ComfirmWindow extends JFrame implements ActionListener
{
	   JFrame frame;
	   public ComfirmWindow(JFrame frame)
	   {
		   setSize(300,130);
		   setLayout(new FlowLayout());
		   JLabel confirm = new JLabel("     창을 닫으시겠습니까?      ");
		   add(confirm);
		   
		   JPanel pane = new JPanel();
		   pane.setLayout(new FlowLayout());
		   JButton yes =new JButton("예");
		   JButton no = new JButton("아니오");
		   yes.addActionListener(this);
		   no.addActionListener(this);
		   
		   pane.add(yes);
		   pane.add(no);
		   add(pane);
		   
		   this.frame=frame;
	   }

	@Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			String message = e.getActionCommand();
			
			if(message.equals("예")) {
				dispose();
				frame.dispose();
			}
			else if(message.equals("아니오"))
				dispose();
	   }
}