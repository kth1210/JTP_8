import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;
import java.io.*;

/*public class Main2 extends JFrame
{	
	public Main2()
	{
		super();
		setSize(200,300);
		BuildingButton bt = new BuildingButton("IT����1ȣ��");
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
		//BuildingFrame((ȣ�ǹ�ư,����) �ִ� â) �����ֱ�
		String buildingfile = e.getActionCommand()+".txt";
		
		BuildingFrame buildingFrame = new BuildingFrame(buildingfile);
		buildingFrame.setVisible(true);
	}	
}

class BuildingFrame extends JFrame
{
	public BuildingFrame(String buildingfileName) //���ϸ� ���ڴ� .txt�޾Ƽ���
	{
		// add ȣ�ǹ�ư, �����ư - �迭�� ������� 
		int cnt=0;
		RoomandReservationPanel[] RandRpanel;
		JScrollPane scroll;
		Scanner inputstream = null;
		
		setSize(200,400);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new CheckOnExit(this));
        setLayout(new FlowLayout());
        JLabel title =new JLabel("       ���ǽ� ���             ");
        add(title, BorderLayout.NORTH);
        
        JLabel cf=new JLabel("���ǽ� ��ư�� Ŭ���� �ð�ǥ�� Ȯ���ϼ���.");
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
			File input = new File(buildingfileName);
			inputstream = new Scanner(new FileInputStream(input));
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
} //BuildingFrame */


class RoomandReservationPanel extends JPanel // BuildingFrame ���� �� Ŭ���� �迭�� �����ϰ� ���Ͽ��� �Է¹ޱ�
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
	ReservationClass object = this;
	public ReservationClass(String buildingfilename,String roomnumber, String current_position_state)
	{
		super(current_position_state);
		addActionListener(this);
		this.buildingfilename=buildingfilename;
		this.roomnumber=roomnumber;
		//this.totalnumber=totalnumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) //actionListener - ReservePopUp �����ֱ� 
	{
		// TODO Auto-generated method stub
		ReservePopUp reservepopup = new ReservePopUp();
		reservepopup.setVisible(true);
	}
	
	private class IDnNum
	{
		String id;
		String num;
		
		public IDnNum(String id, String idnum)
		{
			this.id=id;
			num=idnum;
		}
	}

	
	private class ReservePopUp extends JFrame implements ActionListener
	{
		private int Reserve_All_Num=0;
		private int id_num=0;
		private IDnNum[] idnum;
		public ReservePopUp()
		{
			setSize(400,200);
			getContentPane().setBackground(Color.yellow);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        addWindowListener(new CheckOnExit(this));
	         
	        setLayout(new BorderLayout());
	         
	        JLabel Title = new JLabel("���డ��");
	        add(Title, BorderLayout.NORTH);
	      
	        JPanel butpane=new JPanel();
	        butpane.setLayout(new FlowLayout());
	         
	        JButton All=new JButton("��°��");
	        JButton One=new JButton("����");
	         
	        All.addActionListener(this);
	        One.addActionListener(this);
	         
	        butpane.add(All);
	        butpane.add(One);
	         // ��ư ���̽� Insets Ŭ������ ����
	        add(butpane, BorderLayout.SOUTH);
	        
	        idnum = new IDnNum[100];
		}
		

		
		public void actionPerformed(ActionEvent e) 
	    {
	       String message=e.getActionCommand();
	       Scanner inputstream=null;
	         
	       if(message.equals("��°��"))
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
	    					  CheckRegister gui=new CheckRegister("     ��°�� ������ �Ұ��մϴ�.    ");
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
	       else if(message.contentEquals("����"))
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
		    				 CheckRegister gui=new CheckRegister("     ��°�� ������ �Ұ��մϴ�.    ");
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
         
	            RealDoneRegister window = new  RealDoneRegister(input);
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
	           JLabel title =new JLabel("          ���� ���             ");
	           add(title, BorderLayout.NORTH);
	              
	           JLabel cf1=new JLabel("ID                    �й�                        ���");
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
	        InputPanel input;
	        //public static final int NUMBER_OF_CHAR=6;
            public InputPanel(String idx)
            {         
	            setLayout(new FlowLayout());
	            JLabel idxnum;
	            input=this;
	            
	            if(!idx.contentEquals("None"))
	            {
	            	idxnum = new JLabel(idx);
	            	add(idxnum);
	            	Reserve_one=false;
	            }
	            else
	            	Reserve_one=true;
	            	
	    
	            id=new JTextField("Enter ID", 6);
	            num_id = new JTextField("Enter �й�", 10);
	            register = new JButton("���");
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
	            //ȸ������ ����//
	        	RegisterDone checkRegister = new RegisterDone("     ����� �Ϸ� �Ͻðڽ��ϱ�?     ", input);
	        	checkRegister.setVisible(true);
	            
	         }
	         
	         public boolean FindRegister(InputPanel panel)
	         {
	        	 //id, ��й�ȣ , �й�, �̸�
	        	 Scanner inputStream=null;
	        	 String line;
	        	 String Id;
	        	 String IdNum;
	        	 boolean result=false;
	        	 try
	        	 {
	        		 inputStream=new Scanner(new FileInputStream("ȸ�����.txt"));	
	        		
	        	 }
	        	 
	        	 catch(FileNotFoundException e)
	        	 {
	        		 // â���� �ٲٱ� 
	        		 System.out.println("Problem opening Information. Fatal Error");
	                 System.exit(0);
	        	 }	
	        	 
	        	 while(inputStream.hasNextLine())
	    		 {
	    			 line=inputStream.nextLine();
	    			 StringTokenizer ptoken= new StringTokenizer(line, "/");
	    			 Id=ptoken.nextToken();
	    			 if(panel.id.getText().equals(Id))
	    			 {
	    				 Id=ptoken.nextToken(); //��й�ȣ �ѱ��
	    				 IdNum=ptoken.nextToken(); 
	    				 if(panel.num_id.getText().equals(IdNum)) {
	    					result=true;
	    					break;
	    					  }
	    			} 			
	    		 }	 
	        	
	        	 inputStream.close();
	        	return result;
	          }
	         	
	         public boolean FindDuplicate()
	         {
	        	 Scanner inputStream=null;
	        	 String line;
	        	 String Id;
	        	 String IdNum;
	        	 String etc;
	        	 String duplicate;
	        	 String name;
	        	 boolean result=false;
	        	 try
	        	 {
	        		 inputStream=new Scanner(new FileInputStream("ȸ�����.txt"));	
	        	 }
	        	 
	        	 catch(FileNotFoundException e)
	        	 {
	        		 // â���� �ٲٱ� 
	        		 System.out.println("Problem opening Information. Fatal Error");
	                 System.exit(0);
	        	 }	
	        	 
	        	 while(inputStream.hasNextLine())
	    		 {
	        		 line=inputStream.nextLine();
	    			 StringTokenizer ptoken= new StringTokenizer(line, "/");
	    			 Id=ptoken.nextToken();
	    			 if(id.getText().equals(Id))
	    			 {
	    				 Id=ptoken.nextToken(); //��й�ȣ �ѱ��
	    				 IdNum=ptoken.nextToken(); //�й�
	    				
	    				 if(num_id.getText().equals(IdNum))
	    				 {
	    					 name=ptoken.nextToken(); //�̸�
		    				 etc=ptoken.nextToken();
	    					 duplicate=ptoken.nextToken();
	    					 if(duplicate.equals("0"))
	    	    				 result= true;
	    					 else
	    						 result=false;
	    	    			 
	    				 }   					
	    			 }
	    			 
	        	 }
	        	 
	        	 inputStream.close();
	        	 return result; 
	        	 
	        	
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
			         JButton yes = new JButton("��");
			         JButton no = new JButton("�ƴϿ�");
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
			    	   if(message.equals("��"))
			    	   {
			    		   if(FindRegister(panel)==true)
			    		   {// ���� ȸ������ ��ġ�ϰų� �ռ� �ߺ� ��û ��������
			    			   
			    			   if(FindDuplicate()==true) 
			    			   {
			    				   if(Reserve_one) {
				    				   replacefile= new ReplaceFile(buildingfilename, roomnumber, how_many);
				    				   String line= object.getText();
				    				   StringTokenizer ptoken = new StringTokenizer(line, "/");
				    				   int cur = Integer.parseInt(ptoken.nextToken())+1;
				    				   line = cur+"/"+ptoken.nextToken();
				    				   object.setText(line);
				    				   RenewIDfile renewID= new RenewIDfile(input);
				    			   }
				    				   
				    			   else {
				    				   idnum[id_num]=new IDnNum(id.getText(), num_id.getText());
				    				   id_num++;
				    				   Reserve_All_Num++;
				    				   
				    			   }
				    				  
				    			   
				    			   panel.setBackground(Color.green);
				    			   gui = new CheckRegister("        ����� �Ϸ�Ǿ����ϴ�.         ");
				    			   gui.setVisible(true);
				    			   
			    			   }
			    			  
			    			   else if(FindDuplicate()==false)
			    			   {
			    				   panel.setBackground(Color.red);
					               gui= new CheckRegister("      �ߺ��� ���� ������Դϴ�.      ");
					               gui.setVisible(true);
			    			   }
			    		   }
			    		   
			    		  	              
				           else if(FindRegister(panel)==false)
				           {
				               panel.setBackground(Color.red);
				               gui= new CheckRegister("       Ȯ�ε��� ���� ������Դϴ�.  �ٽ� �Է��� �ּ���.     ");
				               gui.setVisible(true);
				           }
			    		   
				          
			    		   dispose();
			    	   }
			    	   
			    	   else if(message.equals("�ƴϿ�"))
			    		   dispose();
				       
					
	   	           } 
			   	} //RegisterDone
	      	} // InputPanel  
	
			
		private class RenewIDfile
		{
				
			private String originfilename;
			private String replacefilename;
			private InputPanel panel;
			private IDnNum[] panelary;
			
			public RenewIDfile(IDnNum[] paneary)
			{
				originfilename="ȸ�����.txt";
				replacefilename="replace"+ originfilename;
				panelary=paneary;
	
				try {
					replaceforAll();
				}
				
					catch(IOException e)
					{
						System.out.println("Error on deleting file");
					}
				}
				
				public RenewIDfile(InputPanel panel)
				{
					originfilename="ȸ�����.txt";
					replacefilename="replace"+ originfilename;
					
					this.panel=panel;
					try {
						replaceforOne();
					}
				
					catch(IOException e)
					{
						System.out.println("Error on deleting file");
					}
				}

				public void replaceforOne() throws IOException
				{
					BufferedReader inputbuffer = null;
					BufferedWriter outputbuffer = null;
					String ID;
					String ID_num;
					String pw;
					String name;
					String etc;
					String duplicate;
					try
					{
						inputbuffer=new BufferedReader(new FileReader(originfilename));
						outputbuffer = new BufferedWriter(new FileWriter(replacefilename));
						String line;
						
						while((line =inputbuffer.readLine())!=null)
						{
							StringTokenizer ptoken = new StringTokenizer(line,"/");
							ID=ptoken.nextToken();
							if(ID.equals(panel.id.getText()))
							{
								pw=ptoken.nextToken(); // ���
								ID_num= ptoken.nextToken();
								if(ID_num.contentEquals(panel.num_id.getText())) {
									name =ptoken.nextToken();
									etc=ptoken.nextToken();
									duplicate =ptoken.nextToken(); 
									duplicate = roomnumber;
									line = ID + " " +pw + " "+ ID_num+ " "+ name+ " "+ etc+" "+ duplicate;
								}	
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
					
				
					File replace = new File(replacefilename);
					if(!old.delete())
						System.out.println("no delete");
					replace.renameTo(new File("ȸ�����.txt"));
			
				} // replaceforOne
				
				public void replaceforAll() throws IOException
				{
					BufferedReader inputbuffer = null;
					BufferedWriter outputbuffer = null;
					Scanner input=null;
					PrintWriter output=null;
					String ID;
					String ID_num;
					String pw;
					String name;
					String etc;
					String duplicate;
					try
					{
						inputbuffer=new BufferedReader(new FileReader(originfilename));
						outputbuffer = new BufferedWriter(new FileWriter(replacefilename));
						String line;
						
						while((line =inputbuffer.readLine())!=null)
						{
							StringTokenizer ptoken = new StringTokenizer(line,"/");
							ID=ptoken.nextToken();
							
							if(ID.equals(panelary[0].id))
							{
								pw=ptoken.nextToken(); // ���
								ID_num= ptoken.nextToken();
								if(ID_num.contentEquals(panelary[0].num))
								{
									name =ptoken.nextToken();
									etc=ptoken.nextToken();
									duplicate =ptoken.nextToken(); 
									duplicate = roomnumber;
									line = ID + " " +pw + " "+ ID_num+ " "+ name+ " "+ etc+" "+ duplicate;	
								}	
							}
							
							outputbuffer.write(line+"\r\n");
							
						}
						
						inputbuffer.close();
						outputbuffer.close();
						
						File old = new File(originfilename);
						old.delete();
						File replace = new File(replacefilename);
						replace.renameTo(new File("ȸ�����.txt"));
						
						for(int i=1; i<Reserve_All_Num; i++)
						{
							input=new Scanner(new FileInputStream(originfilename));
							output = new PrintWriter(new FileOutputStream(replacefilename));
							
							while((input.hasNextLine()))
							{
								line=input.nextLine();
								StringTokenizer ptoken = new StringTokenizer(line,"/");
								ID=ptoken.nextToken();
								
								if(ID.equals(panelary[i].id))
								{
									pw=ptoken.nextToken(); // ���
									ID_num= ptoken.nextToken();
									if(ID_num.contentEquals(panelary[i].num))
									{
										name =ptoken.nextToken();
										etc=ptoken.nextToken();
										duplicate =ptoken.nextToken(); 
										duplicate = roomnumber;
										line = ID + " " +pw + " "+ ID_num+ " "+ name+ " "+ etc+" "+ duplicate;
										
									
									}
									
								 }
								
								output.print(line+"\r\n");
							}
							
							input.close();
							output.close();
							
							File old1 = new File(originfilename);
							old.delete();
							File replace1 = new File(replacefilename);
							replace1.renameTo(new File("ȸ�����.txt"));
								
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
					
			
				} // replaceforAll
			} //RenewIDfile
			
			private class RealDoneRegister extends JButton implements ActionListener
			{
				InputPanel[] input;
			   public RealDoneRegister(InputPanel[] input)
			   {
				   super("��� �Ϸ�");
				   setBackground(Color.red);
				   addActionListener(this);
				   this.input= input;
			   }

			   public void actionPerformed(ActionEvent e) 
			   {
				   CheckRealRegisterDone window = new CheckRealRegisterDone("        ����� �Ϸ��Ͻðڽ��ϱ�?      ");
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
				       JButton yes = new JButton("��");
				       JButton no = new JButton("�ƴϿ�");
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
					 if(message.equals("��"))
			    	   {
			    		   if(Integer.parseInt(totalnumber)/4 <= Reserve_All_Num)
			    		   {
			    			   RenewIDfile renewId = new RenewIDfile(idnum);
			    			   ReplaceFile replace = new ReplaceFile(buildingfilename, roomnumber, Reserve_All_Num);
			    			   CheckRegister gui = new CheckRegister("      ����� �Ϸ�Ǿ����ϴ�.       ");
			    			   gui.setVisible(true);
			    		   }
			    		   else if(Integer.parseInt(totalnumber)/4 > Reserve_All_Num)
			    		   {
			    			   CheckRegister gui = new CheckRegister("      ���ǽ� ������ 1/4�� ���� ���մϴ�.      ");
			    			   gui.setVisible(true);
			    		   }
			    		   else if(Integer.parseInt(totalnumber) < Reserve_All_Num)
			    		   {
			    			   CheckRegister gui = new CheckRegister("      ���ǽ� ���� �ʰ��� ������ �� �����ϴ�.      ");
			    			   gui.setVisible(true);
			    		   }
			    		  dispose();
			    	   }
				              
				   
			    	 else if(message.equals("�ƴϿ�"))
			    		 dispose();
				       
					 //ȸ�� �ߺ� üũ ��� �־����
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
	
	public ReplaceFile( String filename, String roomnumber, int how_many_register) // ������ü�� .txt �޾Ƽ���
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
		String duplicate;
		try
		{
			inputbuffer=new BufferedReader(new FileReader(originfilename));
			outputbuffer = new BufferedWriter(new FileWriter(replacefilename));
			String line;
			while((line =inputbuffer.readLine())!=null)
			{
				StringTokenizer ptoken = new StringTokenizer(line,"/");
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

class Room extends JButton //���� �� ȣ�� ��ư 
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
		   JLabel confirm = new JLabel("     â�� �����ðڽ��ϱ�?      ");
		   add(confirm);
		   
		   JPanel pane = new JPanel();
		   pane.setLayout(new FlowLayout());
		   JButton yes =new JButton("��");
		   JButton no = new JButton("�ƴϿ�");
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
			
			if(message.equals("��")) {
				dispose();
				frame.dispose();
			}
			else if(message.equals("�ƴϿ�"))
				dispose();
	   }
}


