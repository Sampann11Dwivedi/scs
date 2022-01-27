import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class kl extends Frame implements ActionListener
{
	Button l;
	Connection con;
	Statement st;
	ResultSet rs;
	kl()
	{
		try
	{con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kevin","root","1234");
	st=con.createStatement();
	    }
		catch(Exception e)
		{System.out.println("Exception"+e);
		}
	setLayout(null);
	l=new Button("View");		
	l.setBounds(100,100,100,30);
	l.addActionListener(this);
	add(l);
	win w1=new win();
	addWindowListener(w1);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==l)
		{
			String str="select * from list";
			try
			{rs=st.executeQuery(str);
			int p=130;
			while(rs.next())
			{
				String a=rs.getString("item");
				String b=rs.getString("from");
				int c=rs.getInt("price");
				String d=rs.getString("grade");
				String s="Item Name: "+a+" From: "+b+" Price: "+c+" Grade: "+d;
				Label l1=new Label(s);
				l1.setBounds(100,p,600,30);
				add(l1);
				p=p+30;
				
			}
			}
			catch(Exception e)
			{System.out.println("error");
			}
		}
	}
	class win extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			dispose();
		}
	}
	
}
class login1 extends Frame implements ActionListener
{
	Label l2,l3,l4,l5,l6;
	TextField t1,t2,t3,t4;
	Button b2,b3;
	List l1;
	MenuBar mb;
	Menu m1;
	MenuItem m11,m12,m13;
	Connection con;
	Statement st;
	ResultSet rs;
	
	login1()
	{ 
	
	try
	{con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kevin","root","1234");
	st=con.createStatement();
	    }
		catch(Exception e)
		{System.out.println("Exception"+e);
		}
	
		setLayout(null);
		mb=new MenuBar();
	    m1=new Menu("File");
	    m11=new MenuItem("New");
		m12=new MenuItem("View");
	    m13=new MenuItem("Exit");
		l1=new List(4,true);
		b2=new Button("Submit");
		b3=new Button("Enter");
		l2=new Label("Item Name");
		l3=new Label("From");
		l4=new Label("Price");
		l5=new Label("Grade");
		l6=new Label("Type");
		t1=new TextField(100);
		t2=new TextField(100);
		t3=new TextField(100);
		t4=new TextField(100);
		l2.setBounds(100,100,100,30);
		l3.setBounds(100,130,100,30);
		l4.setBounds(100,160,100,30);
		l5.setBounds(100,190,100,30);
		l6.setBounds(100,120,100,30);
		t1.setBounds(200,100,200,30);
		t2.setBounds(200,130,200,30);
		t3.setBounds(200,160,200,30);
		t4.setBounds(200,190,200,30);
		l1.setBounds(200,220,100,30);
		b2.setBounds(150,250,100,30);
		b3.setBounds(250,250,100,30);
		l1.add("A grade");
		l1.add("B grade");
		l1.add("C grade");
		l1.add("D grade");
		b2.addActionListener(this);
		b3.addActionListener(this);
		add(l2);
		add(l3);
		add(t1);
		add(t2);
		add(b2);
		add(b3);
		add(l4);
		add(t3);
		add(l5);
		add(l6);
		add(t4);
		mb.add(m1);
		setMenuBar(mb);
		m11.addActionListener(this );
		m12.addActionListener(this );
		m13.addActionListener(this );
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);
		win1 w1=new win1();
		addWindowListener(w1);
		add(l1);
	}
	   class win1 extends WindowAdapter
	   {
		   public void windowClosing(WindowEvent e)
		   {dispose();
		   }
		   public void windowDeactivated(WindowEvent wd)
	{
		setBackground(Color.GRAY);
	}
	public void windowActivated(WindowEvent wd)
	{
		setBackground(Color.PINK);
	}
	   }
		public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==b2) 
                    {
                             try{
                             String str= String.format("Insert into list values ( '%s','%s',%d,'%s') ",t1.getText(),t2.getText(),Integer.parseInt(t3.getText() ),t4.getText());
                             Statement st = con.createStatement();
                             st.executeUpdate(str);
							 
                             }catch(Exception ae)
                             { 
		                       System.out.println("Error");
                             } 
					}
		if(e.getSource()==m11)
		{
			login1 l=new login1();
		    l.setSize(800,800);
		     l.setBackground(Color.PINK);
		   Font f1=new Font("sam",Font.ITALIC,12);
			l.setFont(f1);
	         l.setVisible(true);
		    dispose();
			
		}
		if(e.getSource()==m12)
		{
		 kl k=new kl();
		    k.setSize(800,800);
		     k.setBackground(Color.ORANGE);
			  Font f1=new Font("sam",Font.BOLD,12);
			 k.setFont(f1);
	         k.setVisible(true);
			
		}
         if(e.getSource()==m13) 
		{
		beg b=new beg();
		b.setSize(800,800);
		b.setBackground(Color.blue);
	    Font f1=new Font("sam",Font.ITALIC,12);
		b.setFont(f1);
		b.setVisible(true);
		dispose();
		}

        if(e.getSource()==b3)
		{
			kl k=new kl();
		    k.setSize(800,800);
		     k.setBackground(Color.ORANGE);
			 Font f1=new Font("sam",Font.BOLD,12);
			 k.setFont(f1);
	         k.setVisible(true);
		    
		}
				
	  }
		
		}

class login extends Frame implements ActionListener
{
	Label l2,l3;
	TextField t1,t2;
	Button b2;
	MenuBar mb;
	Menu m1;
	MenuItem m13;
	Connection con;
	Statement st;
	ResultSet rs;
	login()
	{
		try{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kevin","root","1234");
		st=con.createStatement();
		}catch(Exception e)
		{
			System.out.println("Exception" +e);
		}
		setLayout(null);
		mb=new MenuBar();
	    m1=new Menu("File");
	    m13=new MenuItem("Exit");
		b2=new Button("Enter");
		l2=new Label("Username");
		l3=new Label("Password");
		t1=new TextField(100);
		t2=new TextField(100);
		l2.setBounds(100,100,100,30);
		l3.setBounds(100,130,100,30);
		t1.setBounds(200,100,100,30);
		t2.setBounds(200,130,100,30);
		b2.setBounds(150,160,100,30);
		b2.addActionListener(this);
		add(l2);
		add(l3);
		add(t1);
		add(t2);
		add(b2);
		mb.add(m1);
		setMenuBar(mb);
		m13.addActionListener(this );
		m1.add(m13);
		win1 w1=new win1();
		addWindowListener(w1);
	}
	   class win1 extends WindowAdapter
	   {
		   public void windowClosing(WindowEvent e)
		   {dispose();
		   }
		   public void windowDeactivated(WindowEvent wd)
	{
		setBackground(Color.GRAY);
	}
	public void windowActivated(WindowEvent wd)
	{
		setBackground(Color.GREEN);
	}
	   }
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==m13) 
		       {
		        beg b=new beg();
		        b.setSize(800,800);
		        b.setBackground(Color.blue);
                Font f1=new Font("sam",Font.ITALIC,12);
			    b.setFont(f1);
	          	b.setVisible(true);
		        dispose();
		        }
			if(e.getSource()==b2)
			{
				String str="select * from login1";
				try{
					rs=st.executeQuery(str);
					String s1=t1.getText();
					String s2=t2.getText();
					while(rs.next())
					{
						String s3=rs.getString("unm");
						String s4=rs.getString("pwd");
						String s5=rs.getString("role");
						if(s1.equals(s3) && s2.equals(s4))
						{
							if(s5.equals("manger"))
							{
								login1 l=new login1();
		                         l.setSize(800,800);
								 Font f1=new Font("sam",Font.ITALIC,12);
				                  l.setBackground(Color.PINK);
				                   l.setVisible(true);
								   l.setFont(f1);
				                  dispose();
								
									
							}
							else
							{
								kl k=new kl();
		                       k.setSize(800,800);
		                       k.setBackground(Color.ORANGE);
			                   Font f1=new Font("sam",Font.BOLD,12);
			                   k.setFont(f1);
	                           k.setVisible(true);
							}
						}else
							{
								Label l1=new Label("Incorrect password");
								l1.setBounds(300,190,200,30);
								add(l1);
							}
						
						
					}
				}catch(Exception ae)
				{System.out.println("Exception" +ae);
				}
			}
			}
		}
class beg extends Frame implements ActionListener,Runnable
{
	Label l1;
	Button b1,b2;
	int p;
	int n;
	Thread t1;
	beg()
	{
		setLayout(null);
		t1=new Thread(this);
		l1=new Label("Welcome Sir (Click on button to coninue)");
		b1=new Button("Continue");
		b2=new Button("0");
		l1.setBounds(100,100,300,30);
		b1.setBounds(100,130,100,30);
		b2.setBounds(220,175,30,30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(l1);
		add(b1);
		add(b2);
		win w=new win();
		addWindowListener(w);
		p=0;n=1;
	}
	class win extends WindowAdapter
	{public void windowClosing(WindowEvent e)
		{dispose();
		}
		public void windowDeactivated(WindowEvent wd)
	    {
		setBackground(Color.GRAY);
	     }
	public void windowActivated(WindowEvent wd)
	    {
		setBackground(Color.BLUE);
	     }
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.drawOval(200+p,160+p,70,70);
		g.fillOval(200+p,160+p,70,70);
		p=p+20;
		if(n%2==0)
		{setBackground(Color.green);
		}
		else
		{setBackground(Color.blue);
		}
	}
	public void run()
	{try{
		for(int i=0;i<=20;i++)
		{repaint();
      	Thread.sleep(100);
		n=n+1;
		}
	}catch(Exception e)
	{
	System.out.println("Exception");
	}
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==b2)
		{
		t1.start();
		}
		if(e.getSource()==b1)
		{
		login l=new login();
		l.setSize(800,800);
		l.setBackground(Color.GREEN);
		Font f1=new Font("sam",Font.BOLD,12);
		l.setVisible(true);
		l.setFont(f1);
		dispose();
		}
	}
}
class sara1{
	public static void main(String[]args){
		beg b=new beg();
		Color c1=new Color(175,85,125);
		Font f1=new Font("sam",Font.ITALIC,12);
		b.setSize(800,800);
		b.setBackground(c1);
		b.setFont(f1);
		b.setVisible(true);
	}
}