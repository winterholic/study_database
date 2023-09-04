import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.*;

public class DBproject{
	Connection con;
	String alltb = "";
	String today = "20220401";
	
	public DBproject() {
	     String Driver="";
	     String 
	url="jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul";
	     String userid="madang";
	     String pwd="madang";
	// 접속변수를 초기화한다. url은 자바 드라이버 이름, 호스트명(localhost), 포트번호를 입력한다
	// userid는 관리자(madang), pwd는 사용자의 비밀번호(madang)를 입력한다.
	     try { /* 드라이버를 찾는 과정 */
	       Class.forName("com.mysql.cj.jdbc.Driver");
	       System.out.println("드라이버 로드 성공");
	     } catch(ClassNotFoundException e) {
	    	 System.out.println("드라이버로드실패");
	         e.printStackTrace();
	      }
	// Class.forName()으로 드라이버를 로딩한다. 드라이버 이름을 Class.forName에 입력한다.      
	     try { /* 데이터베이스를 연결하는 과정 */
	       System.out.println("데이터베이스 연결 준비...");
	       con=DriverManager.getConnection(url, userid, pwd);
	       System.out.println("데이터베이스 연결 성공");
	     } catch(SQLException e) {
	    	 System.out.println("데이터베이스 연결 실패");
	         e.printStackTrace();
	     }
	   }
	
	public void MyFrame() { // 제 1 실행창
		JFrame jf0 = new JFrame();
	    JPanel jp0 = new JPanel();
	    
	    jf0.setTitle("18011501/김대선");
	    jf0.setBounds(0, 0, 400, 400);
	    jf0.setDefaultCloseOperation(jf0.EXIT_ON_CLOSE);
	    
	    jp0.setLayout(null);
		jf0.add(jp0);
		
		JButton jbt1, jbt2;
		
		JLabel jl0 = new JLabel("오늘의 날짜  : ");
		jl0.setBounds(10, 0, 80, 50);
		jp0.add(jl0);
		
		JLabel jl1 = new JLabel(today);
		jl1.setBounds(100, 0, 100, 50);
		jp0.add(jl1);
		
		jp0.add(jbt1=new JButton("관리자 계정"));
	    jbt1.setBounds(40, 130, 140, 80);
	     
	    jp0.add(jbt2=new JButton("회원 계정"));
	    jbt2.setBounds(200, 130, 140, 80);
	    
	    jbt1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		MyManagerFrame();
	    	}
	    });
	    
	    jbt2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		MyClientFrame();
	    	}
	    });
	    jf0.setVisible(true);
	}
	
	
	String clientID;
	JTextArea jta1;
	
	String clientq;
	String mname = "", dname = "", aname = "", gname = "";
	
	
	public void MyClientFrame() { // 회원 모드
		 JFrame jf1 = new JFrame();
	     JPanel jp1 = new JPanel();
	     
	     jf1.setTitle("18011501/김대선");
	     jf1.setBounds(0, 0, 1200, 350);
	     jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);
	     
		 jp1.setLayout(null);
		 jf1.add(jp1);
		 
	     JLabel jl1 = new JLabel("회원 아이디  : ");
		 jl1.setBounds(20, 20, 100, 30);
	     jp1.add(jl1);
	     
	     JTextField jtf1 = new JTextField();
		 jtf1.setBounds(120, 20, 100, 30);
	     jp1.add(jtf1);
	     
	     JButton jbt1;
	     jp1.add(jbt1=new JButton("로그인"));
	     jbt1.setBounds(240, 20, 100, 30);
	     
	     jta1 = new JTextArea();
	     jp1.add(jta1);
	     jta1.setBounds(400, 20, 700, 30);
	     
	     jbt1.addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	    		clientID = jtf1.getText();
	 	    		int temp = Integer.parseInt(clientID);
	 	    		String jtastring = "로그인되었습니다. 고객 ID는" + clientID + "입니다. ";
	 	    		jta1.setText(jtastring);
	 	    	}
	 	    });
	     
	     JLabel jl2 = new JLabel("영화명  : ");
		 jl2.setBounds(20, 60, 60, 30);
	     jp1.add(jl2);
	     
	     JTextField jtf2 = new JTextField();
		 jtf2.setBounds(80, 60, 140, 30);
	     jp1.add(jtf2);
	     
	     JLabel jl3 = new JLabel("감독명  : ");
		 jl3.setBounds(240, 60, 60, 30);
	     jp1.add(jl3);
	     
	     JTextField jtf3 = new JTextField();
		 jtf3.setBounds(300, 60, 140, 30);
	     jp1.add(jtf3);
	     
	     JLabel jl4 = new JLabel("배우명  : ");
		 jl4.setBounds(460, 60, 60, 30);
	     jp1.add(jl4);
	     
	     JTextField jtf4 = new JTextField();
		 jtf4.setBounds(520, 60, 140, 30);
	     jp1.add(jtf4);
	     
	     JLabel jl5 = new JLabel("장르  : ");
		 jl5.setBounds(680, 60, 60, 30);
	     jp1.add(jl5);
	     
	     JTextField jtf5 = new JTextField();
		 jtf5.setBounds(740, 60, 140, 30);
	     jp1.add(jtf5);
	     
	     JButton jbt2;
	     jp1.add(jbt2=new JButton("영화 조회 하기")); //모든 영화에 대한 조회 기능
	     jbt2.setBounds(900, 60, 150, 30);
	     
	     JButton jbt3;
	     jp1.add(jbt3=new JButton("입력취소")); //입력 취소 기능
	     jbt3.setBounds(1070, 60, 100, 30);
	     
	     jbt2.addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	    		mname = jtf2.getText();
	 	    		dname = jtf3.getText();
	 	    		aname = jtf4.getText();
	 	    		gname = jtf5.getText();
	 	    		int stringcheck = 0;

	 	    		if(!mname.equals("")){
	 	    			mname = "(movie_info.movie_name = \"" + mname + "\")";
	 	    		 stringcheck++;
	 	    		}

	 	    		if(!dname.equals("")){
	 	    		 if(stringcheck == 0){
	 	    			 dname = "(movie_info.director_name = \"" + dname + "\")";
	 	    		 }
	 	    		 else{
	 	    			 dname = "and (movie_info.director_name = \"" + dname + "\")";
	 	    		 }
	 	    		 stringcheck++;
	 	    		}

	 	    		if(!aname.equals("")){
	 	    		 if(stringcheck == 0){
	 	    			 aname = "(movie_info.actor_name = \"" + aname + "\")";
	 	    		 }
	 	    		 else{
	 	    			 aname = "and (movie_info.actor_name = \"" + aname + "\")";
	 	    		 }
	 	    		 stringcheck++;
	 	    		}

	 	    		if(!gname.equals("")){
	 	    		 if(stringcheck == 0){
	 	    			 gname = "(movie_info.genre = \"" + gname + "\")";
	 	    		 }
	 	    		 else{
	 	    			 gname = "and (movie_info.genre= \"" + gname + "\")";
	 	    		 }
	 	    		 stringcheck++;
	 	    		}
	 	    		if(stringcheck == 0) {
	 	    			clientq = "select * from movie_info;";
	 	    		}
	 	    		else {
	 	    			clientq = "select *\r\n"
		                        + "from movie_info\r\n"
		                        + "where (" + mname + dname + aname + gname + ");"; 
	 	    		}
	 	    		movietable(clientq);
	 	    	}
	 	    });
	     
	     jbt3.addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	    		mname = "";
	 	    		dname = "";
	 	    		aname = "";
	 	    		gname = "";
	 	    	}
	 	    });
	     
	     JButton jbt4;
	     jp1.add(jbt4=new JButton("예매한 영화 정보 조회")); //예매한 영화 정보 조회
	     jbt4.setBounds(40, 110, 1100, 30);
	     
	     jbt4.addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	    		bookingmovie();
	 	    	}
	 	    });
	     
	     JButton jbt5;
	     jp1.add(jbt5=new JButton("예매 영화 조회 후 예매 취소")); //예매한 영화 정보 조회
	     jbt5.setBounds(40, 160, 1100, 30);
	     
	     jbt5.addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	    		deletebookingmovie();
	 	    	}
	 	    });
	     
	     JButton jbt6;
	     jp1.add(jbt6=new JButton("예매 영화 조회 후 다른 영화로 예매 변경")); //예매한 영화 정보 조회
	     jbt6.setBounds(40, 210, 1100, 30);
	     
	     jbt6.addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	    		changingbookingmovie();
	 	    	}
	 	    });
	     
	     JButton jbt7;
	     jp1.add(jbt7=new JButton("예매 영화 조회 후 다른 날짜로 예매 변경")); //예매한 영화 정보 조회
	     jbt7.setBounds(40, 260, 1100, 30);
	     
	     jbt7.addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	    		changingmoviedate();
	 	    	}
	 	    });
	     
         jf1.setVisible(true);
	}
	
	JTable jt;
	String [][] data;
	String movienum;
	String theaternum;
	String ticketnum;
	public void movietable(String a) {
		String clientq1 = a;
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("영화 조회");
		jf.setBounds(0, 0, 800, 400);
		
		jf.add(jp);
		
		jf.add(jt = new JTable());
		
		data = new String[50][10];
		
		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
	  	  	 Statement stmt=con.createStatement();
	  	  	 ResultSet rs=stmt.executeQuery(clientq1);
	  	  	 int i = 0;
	  	  	 while(rs.next()) {
	  	  		int j = 0;
	  	  		data[i][j] = rs.getString(1);
	  	  		j++;
	  	  		data[i][j] = rs.getString(2);
	  	  		j++;
	  	  		data[i][j] = rs.getString(3);
	  	  		j++;
	  	  		data[i][j] = rs.getString(4);
	  	  		j++;
	  	  		data[i][j] = rs.getString(5);
  	  			j++;
  	  			data[i][j] = rs.getString(6);
	  			j++;
	  			data[i][j] = rs.getString(7);
  	  			j++;
  	  			data[i][j] = rs.getString(8);
	  			j++;
	  			data[i][j] = rs.getString(9);
  	  			j++;
  	  			
  	  			i++;
	  	  	 }
	  	  } catch(SQLException e) {
	  	  	   e.printStackTrace();
	  	  	   jta1.setText("적절하지 않은 입력값입니다.");
	  	    }
		
		String[] title = {"movie_id","movie_name","movie_time","movie_age","director_name","actor_name","genre","movie_intro","release_date","booking?"};
		jt=new JTable(data,title); // table=new JTable(데이터-2차원배열, 컬럼배열);
		jt.getColumnModel().getColumn(9).setCellRenderer(new TableCell());
        jt.getColumnModel().getColumn(9).setCellEditor(new TableCell());
		JScrollPane scroll = new JScrollPane(jt);
		scroll.setPreferredSize(new Dimension(750,300));
		jp.setBounds(0, 0, 800, 400);
		jp.add(scroll);
		jf.setVisible(true);
	}
	
	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
 
        public TableCell() {
            jb = new JButton("예매");
            jb.addActionListener(e -> {
            	int row = jt.getSelectedRow();
            	int col = jt.getSelectedColumn();
            	movienum = data[row][0];
            	String q0;
            	try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
            		Statement stmt=con.createStatement();
  	    			q0 = "SELECT screening_date_info.theater_id\r\n"
  	            			+ "from screening_date_info\r\n"
  	            			+ "where screening_date_info.movie_id = " + movienum + ";";
  	    			ResultSet rs=stmt.executeQuery(q0);
  	    			rs.next();
       	  	  	 	theaternum = rs.getString(1);
       	  	  	 	q0 = "select ticket_info.ticket_id\r\n"
       	  	  	 			+ "from ticket_info\r\n"
       	  	  	 			+ "where (ticket_info.theater_id = "
       	  	  	 			+ theaternum
       	  	  	 			+ ") and (ticket_info.issuance_check = 'X');";
       	  	  	 	rs=stmt.executeQuery(q0);
       	  	  	 	rs.next();
       	  	  	 	ticketnum = rs.getString(1);
       	  	  	 	if(!ticketnum.equals("")) {
       	  	  	 		q0 = "insert into book_info values( NULL ,NULL, NULL, 14000,"
       	  	  	 			+ clientID + ", \"20220401\" );";
       	  	  	 		stmt.executeUpdate(q0);
       	  	  	 		q0 = "UPDATE seat_info\r\n"
       	  	  	 				+ "SET seat_check = 'O'\r\n"
       	  	  	 				+ "where (seat_info.seat_id = (select ticket_info.seat_id from "
       	  	  	 				+ "ticket_info where ticket_info.ticket_id = "+ ticketnum +")) and (seat_info.schedule_id = \r\n"
       	  	  	 				+ "(select ticket_info.schedule_id from ticket_info "
       	  	  	 				+ "where ticket_info.ticket_id = "+ ticketnum + "));";
       	  	  	 		stmt.executeUpdate(q0);
       	  	  	 		q0 = "UPDATE ticket_info\r\n"
    	  	  	 			+ "SET ticket_info.book_id = (SELECT book_id\r\n"
    	  	  	 			+ "from book_info\r\n"
    	  	  	 			+ "where book_id = (select max(book_id) from book_info)),\r\n"
    	  	  	 			+ "ticket_info.issuance_check = 'O'\r\n"
    	  	  	 			+ "where ticket_info.ticket_id = " + ticketnum + ";";
       	  	  	 		stmt.executeUpdate(q0);
       	  	  	 		String bc01 = "예매에 성공하였습니다.";
       	  	  	 		bookingchecking(bc01);
       	  	  	 	}
       	  	  	 	else {
       	  	  	 		String bc02 = "예매할 수 없습니다.";
       	  	  	 		bookingchecking(bc02);
       	  	  	 	}
       	  	  	 
       	  	  } catch(SQLException e5) {
       	  	  	   e5.printStackTrace();
       	  	    }
                //예매하기
            	
            });
        }
 
        @Override
        public Object getCellEditorValue() {
            return null;
        }
 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return jb;
        }
 
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            return jb;
        }
    }
	
	public void bookingchecking(String bc) {
		JFrame jf = new JFrame();
	    JPanel jp = new JPanel();
	     
	    jf.setTitle("예매 확인");
	    jf.setBounds(0, 0, 200, 200);
	    
		jp.setLayout(null);
		jf.add(jp);
		
		JLabel jl = new JLabel(bc);
		jl.setBounds(20, 60, 200, 40);
		
		jp.add(jl);
	    
	    jf.setVisible(true);
	}
	
	JTable jt1;
	String [][] data2;
	String [] bookdata;
	public void bookingmovie() {
		String bookmovieinfo = "select m.movie_name, m.movie_time, t.theater_id, t.seat_id, t.selling_price, m.movie_id   \r\n"
				+ "from book_info b\r\n"
				+ "left join ticket_info t on b.book_id = t.book_id\r\n"
				+ "left join screening_date_info sd on sd.schedule_id = t.schedule_id\r\n"
				+ "left join movie_info m on m.movie_id = sd.movie_id\r\n"
				+ "where client_id = " + clientID + ";";
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("예매한 영화 정보");
		jf.setBounds(0, 0, 800, 400);
		
		jf.add(jp);
		
		jf.add(jt = new JTable());
		
		data2 = new String[50][6];
		
		bookdata = new String[50];
		
		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
	  	  	 Statement stmt=con.createStatement();
	  	  	 ResultSet rs=stmt.executeQuery(bookmovieinfo);
	  	  	 int i = 0;
	  	  	 while(rs.next()) {
	  	  		int j = 0;
	  	  		data2[i][j] = rs.getString(1);
	  	  		j++;
	  	  		data2[i][j] = rs.getString(2);
	  	  		j++;
	  	  		data2[i][j] = rs.getString(3);
	  	  		j++;
	  	  		data2[i][j] = rs.getString(4);
	  	  		j++;
	  	  		data2[i][j] = rs.getString(5);
 	  			j++;
 	  			bookdata[i] = rs.getString(6);
 	  			i++;
	  	  	 }
	  	  } catch(SQLException e) {
	  		  jta1.setText("적절하지 않은 입력값입니다.");
	  	  	  e.printStackTrace();
	  	    }
		String[] title = {"movie_name","screening schedule","theater_id","seat_id","selling_price","more info?"};
		
		jt1=new JTable(data2,title); // table=new JTable(데이터-2차원배열, 컬럼배열);
		jt1.getColumnModel().getColumn(5).setCellRenderer(new TableCell2());
        jt1.getColumnModel().getColumn(5).setCellEditor(new TableCell2());
		JScrollPane scroll = new JScrollPane(jt1);
		scroll.setPreferredSize(new Dimension(750,300));
		jp.setBounds(0, 0, 800, 400);
		jp.add(scroll);
		jf.setVisible(true);
	}
	String BookID;
	class TableCell2 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
 
        public TableCell2() {
            jb = new JButton("자세한 정보");
            jb.addActionListener(e -> {
            	int row = jt1.getSelectedRow();
            	BookID = bookdata[row];
            	MoreinformationFrame();
            });
        }
 
        @Override
        public Object getCellEditorValue() {
            return null;
        }
 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return jb;
        }
 
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            return jb;
        }
    }
	
	public void MoreinformationFrame() {
		int tempbook = Integer.parseInt(BookID);
		String query2 = "select *\r\n"
				+ "from ticket_info\r\n"
				+ "where ticket_info.book_id = " + BookID + ";";
		String query3 = "select *\r\n"
				+ "from screening_date_info\r\n"
				+ "where screening_date_info.schedule_id = (select ticket_info.schedule_id "
				+ "from ticket_info where ticket_info.book_id = " + BookID + ");";
		String query4 = "select *\r\n"
				+ "from theater_info\r\n"
				+ "where theater_info.theater_id = (select ticket_info.theater_id "
				+ "from ticket_info where ticket_info.book_id = " + BookID + ");";
		
		JFrame jf = new JFrame();
	    JPanel jp = new JPanel();
	     
	    jf.setTitle("자세한 정보");
	    jf.setBounds(0, 0, 1000, 500);
	    
		jp.setLayout(null);
		jf.add(jp);
		
		jta = new JTextArea();
	    JScrollPane scroll = new JScrollPane(jta);
	     
	    jp.add(scroll);
        scroll.setBounds(30, 50, 900, 300);
		
        String moreinfostore = "";
        
        try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
     	  	 Statement stmt=con.createStatement();
     	  	 ResultSet rs=stmt.executeQuery(query3);
     	  	 moreinfostore = moreinfostore + "모든 상영일정\n";
     	  	 moreinfostore = moreinfostore + "\t상영일정번호 \t영화번호 \t상영관번호 \t상영시작일 \t상영요일 \t상영회차 \t상영시작시간\n";
     	  	 while(rs.next()) {
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(1);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(2);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(3);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(4);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(5);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(6);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(7);
     	  	 	moreinfostore = moreinfostore + "\n\n";
     	  	 }
     	  	 moreinfostore = moreinfostore + "모든 상영관\n";
     	  	moreinfostore = moreinfostore + "\t상영관번호 \t좌석수 \t상영관 사용여부\n";
     	  	 rs=stmt.executeQuery(query4);
     	  	while(rs.next()) {
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(1);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(2);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(3);
     	  	 	moreinfostore = moreinfostore + "\n\n";
     	  	 }
     	  	moreinfostore = moreinfostore + "모든 티켓\n";
     	  	moreinfostore = moreinfostore + "\t티켓번호 \t상영일정번호 \t상영관번호 \t좌석번호 \t예매번호 \t발권여부 \t표준가격 \t판매가격\n";
     	  	rs=stmt.executeQuery(query2);
     	  	while(rs.next()) {
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(1);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(2);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(3);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(4);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(5);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(6);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(7);
     	  	 	moreinfostore = moreinfostore + "\t"+rs.getString(8);
     	  	 	moreinfostore = moreinfostore + "\n\n";
     	  	 }
     	  	 jta.setText(moreinfostore);
     	  } catch(SQLException e) {
     	  	   e.printStackTrace();
     	    }

        
		jf.setVisible(true);
		
	}
	
	JTable jt2;
	String [][] data3;
	String [] bookdata2;
	String [] bookdata3;
	
	public void deletebookingmovie() {
		String bookmovieinfo = "select m.movie_name, m.movie_time, t.theater_id, t.seat_id, t.selling_price, t.book_id, t.ticket_id   \r\n"
				+ "from book_info b\r\n"
				+ "left join ticket_info t on b.book_id = t.book_id\r\n"
				+ "left join screening_date_info sd on sd.schedule_id = t.schedule_id\r\n"
				+ "left join movie_info m on m.movie_id = sd.movie_id\r\n"
				+ "where client_id = " + clientID + ";";
		
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("예매한 영화 정보");
		jf.setBounds(0, 0, 800, 400);
		
		jf.add(jp);
		
		jf.add(jt2 = new JTable());
		
		data3 = new String[50][6];
		
		bookdata2 = new String[50];
		bookdata3 = new String[50];
		
		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
	  	  	 Statement stmt=con.createStatement();
	  	  	 ResultSet rs=stmt.executeQuery(bookmovieinfo);
	  	  	 int i = 0;
	  	  	 while(rs.next()) {
	  	  		int j = 0;
	  	  		data3[i][j] = rs.getString(1);
	  	  		j++;
	  	  		data3[i][j] = rs.getString(2);
	  	  		j++;
	  	  		data3[i][j] = rs.getString(3);
	  	  		j++;
	  	  		data3[i][j] = rs.getString(4);
	  	  		j++;
	  	  		data3[i][j] = rs.getString(5);
 	  			j++;
 	  			bookdata2[i] = rs.getString(6);
 	  			bookdata3[i] = rs.getString(7);
 	  			i++;
	  	  	 }
	  	  } catch(SQLException e) {
	  		  jta1.setText("적절하지 않은 입력값입니다.");
	  	  	  e.printStackTrace();
	  	    }
		String[] title = {"movie_name","screening schedule","theater_id","seat_id","selling_price","delete booking?"};
		
		jt2=new JTable(data3, title); // table=new JTable(데이터-2차원배열, 컬럼배열);
		jt2.getColumnModel().getColumn(5).setCellRenderer(new TableCell3());
        jt2.getColumnModel().getColumn(5).setCellEditor(new TableCell3());
		JScrollPane scroll = new JScrollPane(jt2);
		scroll.setPreferredSize(new Dimension(750,300));
		jp.setBounds(0, 0, 800, 400);
		jp.add(scroll);
		jf.setVisible(true);
	}
	String ticketnum2;
	String booknum2;
	class TableCell3 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
 
        public TableCell3() {
            jb = new JButton("예매정보 삭제");
            jb.addActionListener(e -> {
            	//삭제기능
            	int row = jt2.getSelectedRow();
            	ticketnum2 = bookdata3[row];
            	booknum2 = bookdata2[row];
            	String q0;
            	 try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
            		 
            		 Statement stmt=con.createStatement();
            		 ResultSet rs;
        	  	  	 	System.out.println(ticketnum2);
        	  	  	 	if(!ticketnum2.equals("")) {
        	  	  	 		q0 = "SET foreign_key_checks = 0;";
        	  	  	 		stmt.executeUpdate(q0);
        	  	  	 		q0 = "UPDATE seat_info\r\n"
        	  	  	 				+ "SET seat_check = 'X'\r\n"
        	  	  	 				+ "where (seat_info.seat_id = (select ticket_info.seat_id"
        	  	  	 				+ " from ticket_info where ticket_info.ticket_id = "+ ticketnum2 + "))"
        	  	  	 						+ " and (seat_info.schedule_id = \r\n"
        	  	  	 				+ "(select ticket_info.schedule_id from ticket_info"
        	  	  	 				+ " where ticket_info.ticket_id = " + ticketnum2 + "));";
        	  	  	 		stmt.executeUpdate(q0);
        	  	  	 		q0 = "delete from book_info\r\n"
        	  	  	 				+ "where book_info.book_id = (select ticket_info.book_id from"
        	  	  	 				+ " ticket_info where ticket_info.ticket_id =" + ticketnum2 + ");";
        	  	  	 		stmt.executeUpdate(q0);
        	  	  	 		q0 = "SET foreign_key_checks = 1;";
        	  	  	 		stmt.executeUpdate(q0);
        	  	  	 		q0 = "UPDATE ticket_info\r\n"
        	  	  	 				+ "SET book_id = NULL , issuance_check = 'X'\r\n"
        	  	  	 				+ "where ticket_info.ticket_id = " + ticketnum2 + ";";
        	  	  	 		stmt.executeUpdate(q0);
        	  	  	 		String bc01 = "예매를 취소하였습니다.";
        	  	  	 		bookingchecking(bc01);
        	  	  	 	}
        	  	  	 	else {
        	  	  	 		String bc02 = "예매를 취소할 수 없습니다.";
        	  	  	 		bookingchecking(bc02);
        	  	  	 	}

             	  } catch(SQLException e0) {
             	  	   e0.printStackTrace();
             	    }
            });
        }
 
        @Override
        public Object getCellEditorValue() {
            return null;
        }
 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return jb;
        }
 
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            return jb;
        }
    }
	
	JTable jt3;
	String [][] data4;
	String [] bookdata4;
	String [] bookdata5;
	
	public void changingbookingmovie() {
		String bookmovieinfo = "select m.movie_name, m.movie_time, t.theater_id, t.seat_id, t.selling_price, t.book_id, t.ticket_id   \r\n"
				+ "from book_info b\r\n"
				+ "left join ticket_info t on b.book_id = t.book_id\r\n"
				+ "left join screening_date_info sd on sd.schedule_id = t.schedule_id\r\n"
				+ "left join movie_info m on m.movie_id = sd.movie_id\r\n"
				+ "where client_id = " + clientID + ";";
		
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("예매한 영화 정보");
		jf.setBounds(0, 0, 800, 400);
		
		jf.add(jp);
		
		jf.add(jt3 = new JTable());
		
		data4 = new String[50][6];
		
		bookdata4 = new String[50];
		bookdata5 = new String[50];
		
		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
	  	  	 Statement stmt=con.createStatement();
	  	  	 ResultSet rs=stmt.executeQuery(bookmovieinfo);
	  	  	 int i = 0;
	  	  	 while(rs.next()) {
	  	  		int j = 0;
	  	  		data4[i][j] = rs.getString(1);
	  	  		j++;
	  	  		data4[i][j] = rs.getString(2);
	  	  		j++;
	  	  		data4[i][j] = rs.getString(3);
	  	  		j++;
	  	  		data4[i][j] = rs.getString(4);
	  	  		j++;
	  	  		data4[i][j] = rs.getString(5);
 	  			j++;
 	  			bookdata4[i] = rs.getString(6);
 	  			bookdata5[i] = rs.getString(7);
 	  			i++;
	  	  	 }
	  	  } catch(SQLException e) {
	  		  jta1.setText("적절하지 않은 입력값입니다.");
	  	  	  e.printStackTrace();
	  	    }
		String[] title = {"movie_name","screening schedule","theater_id","seat_id","selling_price","changing booking?"};
		
		jt3=new JTable(data4, title); // table=new JTable(데이터-2차원배열, 컬럼배열);
		jt3.getColumnModel().getColumn(5).setCellRenderer(new TableCell4());
        jt3.getColumnModel().getColumn(5).setCellEditor(new TableCell4());
		JScrollPane scroll = new JScrollPane(jt3);
		scroll.setPreferredSize(new Dimension(750,300));
		jp.setBounds(0, 0, 800, 400);
		jp.add(scroll);
		jf.setVisible(true);
	}
	
	String ticketnum3;
	String booknum3;
	class TableCell4 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
 
        public TableCell4() {
            jb = new JButton("예매정보 변경");
            jb.addActionListener(e -> {
            	//변경기능
            	int row = jt3.getSelectedRow();
            	ticketnum3 = bookdata5[row];
            	booknum3 = bookdata4[row];
            	moviecategory();
            });
        }
 
        @Override
        public Object getCellEditorValue() {
            return null;
        }
 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return jb;
        }
 
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            return jb;
        }
    }
	
	JTable jt4;
	String [][] data5;
	String [] moviedata;
	public void moviecategory() {
		String q0 = "select movie_name, movie_id\r\n"
				+ "from movie_info";
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("예매할 영화 정보");
		jf.setBounds(0, 0, 800, 400);
		
		jf.add(jp);
		
		jf.add(jt4 = new JTable());
		
		data5 = new String[50][2];
		
		moviedata = new String[50];
		try {
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery(q0);
			int i = 0;
			while(rs.next()) {
				int j = 0;
	  	  		data5[i][j] = rs.getString(1);
 	  			moviedata[i] = rs.getString(2);
 	  			i++;
			}
		}
		catch(SQLException e3) {
			jta1.setText("적절하지 않은 입력값입니다.");
  	  	    e3.printStackTrace();
  	    }
		String[] title = {"movie_name","changing this movie?",};
		
		jt4=new JTable(data5, title); // table=new JTable(데이터-2차원배열, 컬럼배열);
		jt4.getColumnModel().getColumn(1).setCellRenderer(new TableCell5());
        jt4.getColumnModel().getColumn(1).setCellEditor(new TableCell5());
		JScrollPane scroll = new JScrollPane(jt4);
		scroll.setPreferredSize(new Dimension(750,300));
		jp.setBounds(0, 0, 800, 400);
		jp.add(scroll);
		jf.setVisible(true);
	}
	
	String movienum0;
	String fseatnum = "";
	String ftheanum = "";
	class TableCell5 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
 
        public TableCell5() {
            jb = new JButton("해당영화로 영화 변경");
            jb.addActionListener(e -> {
            	//해당 영화로 변경기능
            	int row = jt4.getSelectedRow();
            	movienum0 = moviedata[row];
            	String q0 = "select *\r\n" //영화번호가 movienum0인 상영일정들 중의 상영관 번호를 가진 좌석중 좌석사용여부가 X인 좌석 찾기
            			+ "from seat_info\r\n"
            			+ "where (seat_info.seat_check = 'X') and (seat_info.theater_id in (select\r\n"
            			+ "theater_info.theater_id from theater_info where theater_info.theater_id in (select\r\n"
            			+ "screening_date_info.theater_id from screening_date_info where screening_date_info.movie_id = "
            			+ movienum0 + ")));";
            	try {
        			Statement stmt=con.createStatement();
        			ResultSet rs = stmt.executeQuery(q0);
        			rs.next();
        			fseatnum = fseatnum + rs.getString(1);
        			ftheanum = ftheanum + rs.getString(2);
        			if(fseatnum.equals("")) {
        				String warn1 = "해당 영화는 여석이 없습니다.";
        				String warn2 = "";
        				warningchange(warn1, warn2);
        			}
        			else {
        				q0 = "UPDATE seat_info\r\n"
        						+ "SET seat_info.seat_check = 'O'\r\n"
        						+ "where seat_id = " + fseatnum + ";";
        				stmt.executeUpdate(q0);
        				q0 = "UPDATE seat_info\r\n"
        						+ "SET seat_info.seat_check = 'X'\r\n"
        						+ "where seat_info.seat_id = (SELECT ticket_id from "
        						+ "ticket_info where ticket_info.ticket_id = " + ticketnum3 + ");";
        				stmt.executeUpdate(q0);
        				q0 = "select schedule_id , theater_id, seat_id\r\n"
        						+ "from ticket_info\r\n"
        						+ "where ticket_info.seat_id = " + fseatnum + ";";
        				rs = stmt.executeQuery(q0);
        				rs.next();
        				String temp1, temp2, temp3;
        				temp1= rs.getString(1);
        				temp2= rs.getString(2);
        				temp3= rs.getString(3);
        				q0 = "select schedule_id , theater_id, seat_id\r\n"
        						+ "from ticket_info\r\n"
        						+ "where ticket_info.ticket_id = " + ticketnum3 + ";";
        				rs = stmt.executeQuery(q0);
        				rs.next();
        				String temp4, temp5, temp6;
        				temp4= rs.getString(1);
        				temp5= rs.getString(2);
        				temp6= rs.getString(3);
        				q0 = "UPDATE ticket_info\r\n"
        						+ "SET ticket_info.schedule_id = " + temp1 + ", "
        						+ "ticket_info.theater_id = " + temp2 +", ticket_info.seat_id = " + temp3 + "\r\n"
        						+ "where ticket_info.seat_id = " + ticketnum3 + ";";
        				stmt.executeUpdate(q0);
        				q0 = "UPDATE ticket_info\r\n"
        						+ "SET ticket_info.schedule_id = " + temp4 + ", "
        						+ "ticket_info.theater_id = " + temp5 +", ticket_info.seat_id = " + temp6 + "\r\n"
        						+ "where ticket_info.ticket_id = " + fseatnum + ";";
        				stmt.executeUpdate(q0);
        				String warn1 = "해당 영화로 변경하였습니다.";
        				String warn2 = "창을 다시 열어 확인해주세요.";
        				warningchange(warn1, warn2);
        			}
        		}
        		catch(SQLException e3) {
          	  	    e3.printStackTrace();
          	    }
            });
        }
 
        @Override
        public Object getCellEditorValue() {
            return null;
        }
 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return jb;
        }
 
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            return jb;
        }
    }
	
	public void warningchange(String a, String b) {
		JFrame jf = new JFrame();
	    JPanel jp = new JPanel();
	     
	    jf.setTitle("영화예매 변경안내");
	    jf.setBounds(0, 0, 200, 200);
	    
		jp.setLayout(null);
		jf.add(jp);
		
		JLabel jl = new JLabel(a);
		jl.setBounds(20, 60, 200, 40);
		
		JLabel jl0 = new JLabel(b);
		jl0.setBounds(20, 80, 200, 40);
		
		jp.add(jl);
		jp.add(jl0);
	    
	    jf.setVisible(true);
	}
	
	JTable jt6;
	String [][] data6;
	String [] ticketdata6;
	String [] schdata6;
	
	String ticketnum6;
	String scheduleid6;
	public void changingmoviedate() {
		String bookmovieinfo = "select m.movie_name, m.movie_time, t.theater_id, t.seat_id, t.selling_price, t.ticket_id, t.schedule_id  \r\n"
				+ "from book_info b\r\n"
				+ "left join ticket_info t on b.book_id = t.book_id\r\n"
				+ "left join screening_date_info sd on sd.schedule_id = t.schedule_id\r\n"
				+ "left join movie_info m on m.movie_id = sd.movie_id\r\n"
				+ "where client_id = " + clientID + ";";
		
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("예매한 영화 정보");
		jf.setBounds(0, 0, 800, 400);
		
		jf.add(jp);
		
		jf.add(jt6 = new JTable());
		
		data6 = new String[50][6];
		
		ticketdata6 = new String[50];
		schdata6 = new String[50];
		
		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
	  	  	 Statement stmt=con.createStatement();
	  	  	 ResultSet rs=stmt.executeQuery(bookmovieinfo);
	  	  	 int i = 0;
	  	  	 while(rs.next()) {
	  	  		int j = 0;
	  	  		data6[i][j] = rs.getString(1);
	  	  		j++;
	  	  		data6[i][j] = rs.getString(2);
	  	  		j++;
	  	  		data6[i][j] = rs.getString(3);
	  	  		j++;
	  	  		data6[i][j] = rs.getString(4);
	  	  		j++;
	  	  		data6[i][j] = rs.getString(5);
 	  			j++;
 	  			ticketdata6[i] = rs.getString(6);
 	  			schdata6[i] = rs.getString(7);
 	  			i++;
	  	  	 }
	  	  } catch(SQLException e) {
	  		  jta1.setText("적절하지 않은 입력값입니다.");
	  	  	  e.printStackTrace();
	  	    }
		String[] title = {"movie_name","screening schedule","theater_id","seat_id","selling_price","changing date?"};
		
		jt6=new JTable(data6, title); // table=new JTable(데이터-2차원배열, 컬럼배열);
		jt6.getColumnModel().getColumn(5).setCellRenderer(new TableCell6());
        jt6.getColumnModel().getColumn(5).setCellEditor(new TableCell6());
		JScrollPane scroll = new JScrollPane(jt6);
		scroll.setPreferredSize(new Dimension(750,300));
		jp.setBounds(0, 0, 800, 400);
		jp.add(scroll);
		jf.setVisible(true);
	}
	
	
	class TableCell6 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
 
        public TableCell6() {
            jb = new JButton("상영일정 변경하기");
            jb.addActionListener(e -> {
            	//다른 상영일정으로 변경
            	int row = jt6.getSelectedRow();
            	ticketnum6 = ticketdata6[row];
            	scheduleid6 = schdata6[row];
            	datecategory();
            });
        }
 
        @Override
        public Object getCellEditorValue() {
            return null;
        }
 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return jb;
        }
 
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            return jb;
        }
    }
	
	JTable jt7;
	String [][] data7;
	String [] scheduledata;
	String currentday;
	
	public void datecategory() {
		String q0 = "select screening_start_date\r\n"
				+ "from screening_date_info\r\n"
				+ "where screening_date_info.schedule_id = (select ticket_info.schedule_id"
				+ " from ticket_info where ticket_info.ticket_id = " + ticketnum6 + ");";
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("예매한 영화 정보");
		jf.setBounds(0, 0, 800, 400);
		
		jf.add(jp);
		
		jf.add(jt7 = new JTable());
		
		data7 = new String[50][3];
		
		scheduledata = new String[50];
		try {
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery(q0);
			rs.next();
			currentday = rs.getString(1);
			q0 = "select screening_start_date, schedule_id\r\n"
					+ "from screening_date_info\r\n"
					+ "where (screening_date_info.theater_id = (select theater_id\r\n"
					+ "from ticket_info where ticket_info.ticket_id = " + ticketnum6 +"))\r\n"
					+ "and (screening_date_info.schedule_id != (select schedule_id \r\n"
					+ "from ticket_info where ticket_info.ticket_id = " + ticketnum6 + "));";
			rs = stmt.executeQuery(q0);
			int i = 0;
			while(rs.next()) {
				int j = 0;
				data7[i][j] = currentday;
				j++;
	  	  		data7[i][j] = rs.getString(1);
 	  			scheduledata[i] = rs.getString(2);
 	  			i++;
			}
		}
		catch(SQLException e3) {
			jta1.setText("적절하지 않은 입력값입니다.");
  	  	    e3.printStackTrace();
  	    }
		String[] title = {"current date" , "date list" , "selecting this date?",};
		
		jt7=new JTable(data7, title); // table=new JTable(데이터-2차원배열, 컬럼배열);
		jt7.getColumnModel().getColumn(2).setCellRenderer(new TableCell7());
        jt7.getColumnModel().getColumn(2).setCellEditor(new TableCell7());
		JScrollPane scroll = new JScrollPane(jt7);
		scroll.setPreferredSize(new Dimension(750,300));
		jp.setBounds(0, 0, 800, 400);
		jp.add(scroll);
		jf.setVisible(true);
	}
	
	String schedulenum7;
	String seatnum7;
	String ticketnum7;
	String schedulenum6;
	String theaternum6;
	String seatnum6;
	class TableCell7 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
 
        public TableCell7() {
            jb = new JButton("해당날짜로 변경");
            jb.addActionListener(e -> {
            	//해당 영화로 변경기능
            	int row = jt7.getSelectedRow();
            	schedulenum7 = scheduledata[row];
            	String q0 = "select seat_id\r\n"
            			+ "from seat_info\r\n"
            			+ "where (seat_info.schedule_id = " + schedulenum7 + ")"
            			+ " and (seat_info.seat_check = 'X');";
            	try {
        			Statement stmt=con.createStatement();
        			ResultSet rs = stmt.executeQuery(q0);
        			rs.next();
        			seatnum7 = rs.getString(1);
        			if(seatnum7.equals("")) {
        				String warn1 = "해당일에 여석이 없습니다.";
        				String warn2 = "";
        				warningchange(warn1, warn2);
        			}
        			else {
        				q0 = "select ticket_id\r\n"
        						+ "from ticket_info\r\n"
        						+ "where (ticket_info.schedule_id = " + schedulenum7 + ")"
        						+ " and (ticket_info.seat_id = " + seatnum7 + ");";
        				rs = stmt.executeQuery(q0);
        				rs.next();
        				ticketnum7 = rs.getString(1);
        				q0 = "select schedule_id, theater_id, seat_id\r\n"
        						+ "from ticket_info\r\n"
        						+ "where ticket_info.ticket_id = " + ticketnum6 + ";";
        				rs = stmt.executeQuery(q0);
        				rs.next();
        				schedulenum6 = rs.getString(1);
        				theaternum6 = rs.getString(2);
        				seatnum6 = rs.getString(3);
        				q0 = "UPDATE seat_info\r\n"
        						+ "SET seat_check = 'X'\r\n"
        						+ "where (seat_id = " + seatnum6 + ") and (schedule_id =" + schedulenum6 + ");";
        				stmt.executeUpdate(q0);
        				q0 = "UPDATE seat_info\r\n"
        						+ "SET seat_check = 'O'\r\n"
        						+ "where (seat_id = " + seatnum7 + ") and (schedule_id =" + schedulenum7 + ");";
        				stmt.executeUpdate(q0);
        				q0 = "UPDATE ticket_info\r\n"
        						+ "SET schedule_id = " + schedulenum6 + " , seat_id = " + seatnum6 + "\r\n"
        						+ "where ticket_id = " + ticketnum7 + ";";
        				stmt.executeUpdate(q0);
        				q0 = "UPDATE ticket_info\r\n"
        						+ "SET schedule_id = " + schedulenum7 + " , seat_id = " + seatnum7 + "\r\n"
        						+ "where ticket_id = " + ticketnum6 + ";";
        				stmt.executeUpdate(q0);
        				String warn1 = "해당 날짜로 변경하였습니다.";
        				String warn2 = "창을 다시 열어 확인해주세요.";
        				warningchange(warn1, warn2);
        			}
        		}
        		catch(SQLException e3) {
          	  	    e3.printStackTrace();
          	    }
            });
        }
 
        @Override
        public Object getCellEditorValue() {
            return null;
        }
 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return jb;
        }
 
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            return jb;
        }
    }
	
	JTextArea jta;
	public void MyManagerFrame() { // 관리자모드
		 JFrame jf2 = new JFrame();
	     JPanel jp2 = new JPanel();
	     JTextField jtf1 = new JTextField();
	     
	     jf2.setTitle("18011501/김대선");
	     jf2.setBounds(0, 0, 1000, 900);
	     jf2.setDefaultCloseOperation(jf2.EXIT_ON_CLOSE);
	     
		 jp2.setLayout(null);
		 jf2.add(jp2);
		 
		 jtf1.setBounds(60, 130, 650, 100);
	     jp2.add(jtf1);
		 
		 JButton jbt1, jbt2, jbt3;
		 
		 jp2.add(jbt1=new JButton("초기화"));
	     jbt1.setBounds(340, 20, 140, 80);
	     
	     jp2.add(jbt2=new JButton("모든 테이블 출력"));
	     jbt2.setBounds(520, 20, 140, 80);
	     
	     jp2.add(jbt3=new JButton("입력/변경/삭제"));
	     jbt3.setBounds(730, 140, 140, 80);
	     
	     jta =new JTextArea();
	     JScrollPane scroll = new JScrollPane(jta);
	     
	     jp2.add(scroll);
         scroll.setBounds(60, 270, 850, 400);
         
         jbt1.addActionListener(new ActionListener() {
  	    	public void actionPerformed(ActionEvent e) {
  	    		inittable();
  	    	}
  	    });
         
         jbt2.addActionListener(new ActionListener() {
 	    	public void actionPerformed(ActionEvent e) {
 	    		allsearch();
 	    		jta.setText(alltb);
 	    	}
 	    });
         
         jbt3.addActionListener(new ActionListener() {
  	    	public void actionPerformed(ActionEvent e) {
  	    		String tempstr = jtf1.getText();
  	    		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
  	    			Statement stmt=con.createStatement();
  	    			stmt.executeUpdate(tempstr);
 			  	  } catch(SQLException e1) {
 			  		jta.setText("적절하지 않은 입력값입니다.");
 			  	  	   e1.printStackTrace();
 			  	    }
  	    	}
  	    });
         
         
         jf2.setVisible(true);
	}
	
	public void inittable() { // 초기화하기
		try { 
			String query = "Drop table if exists ticket_info;";
  			Statement stmt=con.createStatement();
  			stmt.executeUpdate(query);
  			query = "Drop table if exists book_info;";
  			stmt.executeUpdate(query);
  			query = "Drop table if exists client_info;";
  			stmt.executeUpdate(query);
  			query = "Drop table if exists seat_info;";
  			stmt.executeUpdate(query);
  			query = "Drop table if exists screening_date_info;";
  			stmt.executeUpdate(query);
  			query = "Drop table if exists theater_info;";
  			stmt.executeUpdate(query);
  			query = "Drop table if exists movie_info;";
  			stmt.executeUpdate(query);
  			query = "create table movie_info (\r\n"
  					+ "   movie_id integer,\r\n"
  					+ "    movie_name varchar(20),\r\n"
  					+ "    movie_time integer,\r\n"
  					+ "    movie_age integer,\r\n"
  					+ "    director_name varchar(20),\r\n"
  					+ "    actor_name varchar(20),\r\n"
  					+ "    genre varchar(10),\r\n"
  					+ "    movie_intro varchar(30),\r\n"
  					+ "    release_date varchar(8)\r\n"
  					+ ");";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE movie_info\r\n"
  					+ "  ADD CONSTRAINT movie_id_pk PRIMARY KEY (movie_id);";
  			stmt.executeUpdate(query);
  			query = "create table theater_info (\r\n"
  					+ "   theater_id       integer,\r\n"
  					+ "    seat_count      integer,\r\n"
  					+ "    theater_use_check   varchar(1)\r\n"
  					+ ");";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE theater_info\r\n"
  					+ "  ADD CONSTRAINT theater_id_pk PRIMARY KEY (theater_id);";
  			stmt.executeUpdate(query);
  			query = "create table screening_date_info (\r\n"
  					+ "   schedule_id integer,\r\n"
  					+ "    movie_id integer,\r\n"
  					+ "    theater_id integer,\r\n"
  					+ "    screening_start_date varchar(8),\r\n"
  					+ "    screening_day varchar(3),\r\n"
  					+ "    screening_session integer,\r\n"
  					+ "    screening_start_time varchar(4)\r\n"
  					+ ");";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE screening_date_info\r\n"
  					+ "  ADD CONSTRAINT schedule_id_pk PRIMARY KEY (schedule_id);";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE screening_date_info\r\n"
  					+ "  ADD (CONSTRAINT R_2 FOREIGN KEY (movie_id) REFERENCES movie_info (movie_id));";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE screening_date_info\r\n"
  					+ "  ADD (CONSTRAINT R_3 FOREIGN KEY (theater_id) REFERENCES theater_info (theater_id));";
  			stmt.executeUpdate(query);
  			query = "create table seat_info (\r\n"
  					+ "   seat_id            integer,\r\n"
  					+ "   schedule_id 			integer,\r\n"
  					+ "    theater_id         integer,\r\n"
  					+ "    seat_check         varchar(1)\r\n"
  					+ ");";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE seat_info\r\n"
  					+ "  ADD CONSTRAINT seat_schedule_id_pk PRIMARY KEY (seat_id, schedule_id);";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE seat_info\r\n"
  					+ "  ADD (CONSTRAINT R_10 FOREIGN KEY (schedule_id) REFERENCES screening_date_info (schedule_id));";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE seat_info\r\n"
  					+ "  ADD (CONSTRAINT R_4 FOREIGN KEY (theater_id) REFERENCES theater_info (theater_id));";
  			stmt.executeUpdate(query);
  			query = "create table client_info (\r\n"
  					+ "   client_id      integer,\r\n"
  					+ "    client_name      varchar(3),\r\n"
  					+ "    phone_number         varchar(10),\r\n"
  					+ "    email      varchar(50)\r\n"
  					+ ");";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE client_info\r\n"
  					+ "  ADD CONSTRAINT client_id_pk PRIMARY KEY (client_id);";
  			stmt.executeUpdate(query);
  			query = "create table book_info (\r\n"
  					+ "   book_id    integer AUTO_INCREMENT PRIMARY KEY,\r\n"
  					+ "    payment_method   varchar(4),\r\n"
  					+ "    payment_check   varchar(1),\r\n"
  					+ "    payment_amount   integer,\r\n"
  					+ "    client_id      integer,\r\n"
  					+ "    book_date varchar(8)\r\n"
  					+ ");";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE book_info\r\n"
  					+ "  ADD (CONSTRAINT R_5 FOREIGN KEY (client_id) REFERENCES client_info (client_id));";
  			stmt.executeUpdate(query);
  			query = "create table ticket_info (\r\n"
  					+ "   ticket_id            integer,\r\n"
  					+ "    schedule_id   integer,\r\n"
  					+ "    theater_id   integer,\r\n"
  					+ "    seat_id               integer,\r\n"
  					+ "    book_id               integer,\r\n"
  					+ "    issuance_check            varchar(1),\r\n"
  					+ "    standard_price         integer,\r\n"
  					+ "    selling_price         integer\r\n"
  					+ ");";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE ticket_info\r\n"
  					+ "  ADD CONSTRAINT ticket_id_pk PRIMARY KEY (ticket_id);";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE ticket_info\r\n"
  					+ "  ADD (CONSTRAINT R_6 FOREIGN KEY (schedule_id) REFERENCES screening_date_info (schedule_id));";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE ticket_info\r\n"
  					+ "  ADD (CONSTRAINT R_7 FOREIGN KEY (theater_id) REFERENCES theater_info (theater_id));";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE ticket_info\r\n"
  					+ "  ADD (CONSTRAINT R_8 FOREIGN KEY (seat_id) REFERENCES seat_info (seat_id));";
  			stmt.executeUpdate(query);
  			query = "ALTER TABLE ticket_info\r\n"
  					+ "  ADD (CONSTRAINT R_9 FOREIGN KEY (book_id) REFERENCES book_info (book_id));";
  			stmt.executeUpdate(query);
  			query = "insert into movie_info values(1, \"범죄도시2\", 106, 15, \"이상용\", \"마동석\", \"범죄\", \"인기배우 마동석의 범죄액션영화\", \"20210118\");";
  			stmt.executeUpdate(query);
  			query = "insert into movie_info values(2, \"닥터스트레인지2\", 126, 12, \"샘 레이미\", \"베네딕트 컵버배치\", \"판타지\", \"마블영화\", \"20210204\");";
  			stmt.executeUpdate(query);
  			query = "insert into movie_info values(3, \"스파이더맨\", 148, 12, \"존 왓츠\", \"톰 홀랜드\", \"판타지\", \"마블영화\", \"20210329\");";
  			stmt.executeUpdate(query);
  			query = "insert into movie_info values(4, \"블랙위도우\", 134, 12, \"케이트 쇼트랜드\", \"스칼릿 조핸슨\", \"애니메이션\", \"인기 애니메이션 극장판\", \"20210412\");";
  			stmt.executeUpdate(query);
  			query = "insert into movie_info values(5, \"귀멸의칼날\", 117, 15, \"소토자키 하루오\", \"이경태\", \"애니메이션\", \"마블영화\", \"20210501\");";
  			stmt.executeUpdate(query);
  			query = "insert into movie_info values(6, \"베놈2\", 97, 15, \"앤디 서키스\", \"톰 하디\", \"판타지\", \"마블영화\", \"20210624\");";
  			stmt.executeUpdate(query);
  			query = "insert into movie_info values(7, \"크루엘라\", 133, 12, \"크레이그 질레스피\", \"엠마 스톤\", \"드라마\", \"관객들의 대호평작\", \"20210705\");";
  			stmt.executeUpdate(query);
  			query = "insert into movie_info values(8, \"반도\", 116, 15, \"연상호\", \"강동원\", \"액션\", \"흥행작 부산행의 후속작\", \"20210801\");";
  			stmt.executeUpdate(query);
  			query = "insert into movie_info values(9, \"극한직업\", 111, 15, \"이병헌\", \"류승룡\", \"코미디\", \"한국의 인기 코미디 영화\", \"20210927\");";
  			stmt.executeUpdate(query);
  			query = "insert into movie_info values(10, \"겨울왕국2\", 103, 0, \"크리스 벅\", \"크리스틴 벨\", \"애니메이션\", \"디즈니 애니메이션\", \"20211030\");";
  			stmt.executeUpdate(query);
  			query = "insert into theater_info values(1, 3, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into theater_info values(2, 2, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into theater_info values(3, 4, \"O\");";
  			stmt.executeUpdate(query);
  			query  = "insert into theater_info values(4, 2, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into theater_info values(5, 5, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into theater_info values(6, 2, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into theater_info values(7, 3, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into theater_info values(8, 4, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into theater_info values(9, 2, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into theater_info values(10, 3, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(1, 9, 1, \"20220427\", \"수요일\", 1, \"0700\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(2, 3, 2, \"20220429\", \"금요일\", 1, \"0655\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(3, 8, 3, \"20220501\", \"수요일\", 1, \"0720\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(4, 2, 4, \"20220504\", \"토요일\", 1, \"1120\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(5, 7, 5, \"20220505\", \"일요일\", 1, \"0830\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(6, 4, 6, \"20220512\", \"일요일\", 1, \"1000\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(7, 1, 7, \"20220518\", \"토요일\", 1, \"0940\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(8, 6, 8, \"20220524\", \"금요일\", 1, \"0725\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(9, 10, 9, \"20220530\", \"목요일\", 1, \"1230\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(10, 5, 10, \"20220601\", \"수요일\", 1, \"1200\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(11, 9, 1, \"20220428\", \"목요일\", 2, \"0700\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(12, 3, 2, \"20220430\", \"토요일\", 2, \"0655\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(13, 8, 3, \"20220502\", \"목요일\", 2, \"0720\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(14, 2, 4, \"20220505\", \"일요일\", 2, \"1120\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(15, 7, 5, \"20220506\", \"월요일\", 2, \"0830\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(16, 4, 6, \"20220513\", \"월요일\", 2, \"1000\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(17, 1, 7, \"20220519\", \"일요일\", 2, \"0940\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(18, 6, 8, \"20220525\", \"토요일\", 2, \"0725\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(19, 10, 9, \"20220531\", \"금요일\", 2, \"1230\");";
  			stmt.executeUpdate(query);
  			query = "insert into screening_date_info values(20, 5, 10, \"20220602\", \"목요일\", 2, \"1200\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(1, 1, 1, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(2, 1, 1, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(3, 1, 1, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(4, 2, 2, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(5, 2, 2, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(6, 3, 3, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(7, 3, 3, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(8, 3, 3, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(9, 3, 3, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(10, 4, 4, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(11, 4, 4, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(12, 5, 5, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(13, 5, 5, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(14, 5, 5, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(15, 5, 5, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(16, 5, 5, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(17, 6, 6, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(18, 6, 6, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(19, 7, 7, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(20, 7, 7, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(21, 7, 7, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(22, 8, 8, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(23, 8, 8, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(24, 8, 8, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(25, 8, 8, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(26, 9, 9, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(27, 9, 9, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(28, 10, 10, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(29, 10, 10, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(30, 10, 10, \"O\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(1, 11, 1, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(2, 11, 1, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(3, 11, 1, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(4, 12, 2, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(5, 12, 2, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(6, 13, 3, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(7, 13, 3, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(8, 13, 3, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(9, 13, 3, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(10, 14, 4, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(11, 14, 4, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(12, 15, 5, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(13, 15, 5, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(14, 15, 5, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(15, 15, 5, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(16, 15, 5, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(17, 16, 6, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(18, 16, 6, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(19, 17, 7, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(20, 17, 7, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(21, 17, 7, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(22, 18, 8, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(23, 18, 8, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(24, 18, 8, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(25, 18, 8, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(26, 19, 9, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(27, 19, 9, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(28, 20, 10, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(29, 20, 10, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into seat_info values(30, 20, 10, \"X\");";
  			stmt.executeUpdate(query);
  			query = "insert into client_info values(1, \"이예원\", \"9246512344\",\"Yewon142@gmail.com\");";
  			stmt.executeUpdate(query);
  			query = "insert into client_info values(2, \"김민섭\", \"7223545567\",\"minseop77@gmail.com\");";
  			stmt.executeUpdate(query);
  			query = "insert into client_info values(3, \"김하영\", \"5577547713\",\"hayeong9975@gmail.com\");";
  			stmt.executeUpdate(query);
  			query = "insert into client_info values(4, \"신민재\", \"9943564894\", \"minjae1541@gmail.com\");";
  			stmt.executeUpdate(query);
  			query = "insert into client_info values(5, \"김창준\", \"4563315488\", \"changjun32@gmail.com\");";
  			stmt.executeUpdate(query);
  			query = "insert into client_info values(6, \"윤지원\", \"8998468565\", \"jiwon824@gmail.com\");";
  			stmt.executeUpdate(query);
  			query = "insert into client_info values(7, \"김진호\", \"8798746564\", \"jinho9292@gmail.com\");";
  			stmt.executeUpdate(query);
  			query = "insert into client_info values(8, \"박준재\", \"1215665448\", \"junjae28@gmail.com\");";
  			stmt.executeUpdate(query);
  			query = "insert into client_info values(9, \"안해인\", \"4654651231\", \"haein0234@gmail.com\");";
  			stmt.executeUpdate(query);
  			query = "insert into client_info values(10, \"이지현\", \"8798454646\", \"jihyeon0808@gmail.com\");";
  			stmt.executeUpdate(query);
  			query = "insert into book_info values(1, \"카드\", \"O\", 14000, 10, \"20220320\");";
  			stmt.executeUpdate(query);
  			query = "insert into book_info values(2, \"카드\", \"O\", 14000, 7, \"20220305\");";
  			stmt.executeUpdate(query);
  			query = "insert into book_info values(3, \"휴대폰\", \"O\", 14000, 8, \"20220307\");";
  			stmt.executeUpdate(query);
  			query = "insert into book_info values(4, \"카드\", \"O\", 14000, 1, \"20220313\");";
  			stmt.executeUpdate(query);
  			query = "insert into book_info values(5, \"카드\", \"O\", 14000, 4, \"20220311\");";
  			stmt.executeUpdate(query);
  			query = "insert into book_info values(6, \"현장결제\", \"O\", 14000, 2, \"20220320\");";
  			stmt.executeUpdate(query);
  			query = "insert into book_info values(7, \"카드\", \"O\", 14000, 9, \"20220320\");";
  			stmt.executeUpdate(query);
  			query = "insert into book_info values(8, \"카드\", \"O\", 14000, 6, \"20220306\");";
  			stmt.executeUpdate(query);
  			query = "insert into book_info values(9, \"카드\", \"O\", 14000, 3, \"20220304\");";
  			stmt.executeUpdate(query);
  			query = "insert into book_info values(10, \"휴대폰\", \"O\", 14000, 5, \"20220317\");";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(1, 1, 1, 1, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(2, 1, 1, 2, 4, \"O\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(3, 1, 1, 3, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(4, 2, 2, 4, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(5, 2, 2, 5, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(6, 3, 3, 6, 10, \"O\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(7, 3, 3, 7, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(8, 3, 3, 8, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(9, 3, 3, 9, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(10, 4, 4, 10, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(11, 4, 4, 11, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(12, 5, 5, 12, 3, \"O\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(13, 5, 5, 13, 7, \"O\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(14, 5, 5, 14, 8, \"O\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(15, 5, 5, 15, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(16, 5, 5, 16, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(17, 6, 6, 17, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(18, 6, 6, 18, 1, \"O\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(19, 7, 7, 19, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(20, 7, 7, 20, 6, \"O\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(21, 7, 7, 21, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(22, 8, 8, 22, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(23, 8, 8, 23, 2, \"O\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(24, 8, 8, 24, 9, \"O\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(25, 8, 8, 25, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(26, 9, 9, 26, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(27, 9, 9, 27, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(28, 10, 10, 28, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(29, 10, 10, 29, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(30, 10, 10, 30, 5, \"O\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(31, 11, 1, 1, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(32, 11, 1, 2, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(33, 11, 1, 3, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(34, 12, 2, 4, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(35, 12, 2, 5, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(36, 13, 3, 6, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(37, 13, 3, 7, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(38, 13, 3, 8, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(39, 13, 3, 9, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(40, 14, 4, 10, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(41, 14, 4, 11, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(42, 15, 5, 12, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(43, 15, 5, 13, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(44, 15, 5, 14, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(45, 15, 5, 15, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(46, 15, 5, 16, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(47, 16, 6, 17, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(48, 16, 6, 18, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(49, 17, 7, 19, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(50, 17, 7, 20, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(51, 17, 7, 21, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(52, 18, 8, 22, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(53, 18, 8, 23, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(54, 18, 8, 24, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(55, 18, 8, 25, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(56, 19, 9, 26, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(57, 19, 9, 27, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(58, 20, 10, 28, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(59, 20, 10, 29, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			query = "insert into ticket_info values(60, 20, 10, 30, NULL, \"X\", 14000, 14000);";
  			stmt.executeUpdate(query);
  			jta.setText("데이터 베이스를 초기화하였습니다, 초기화된 내용을 확인해보려면 모든 테이블 출력버튼을 눌러주세요.");
		  	  } catch(SQLException e1) {
		  		  jta.setText("적절하지 않은 입력값입니다.");
		  	  	  e1.printStackTrace();
		  	    }
	}
	
	public void allsearch() { // 모든 정보 검색
		alltb = "";
		 String query = "select * from movie_info";
		 try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
	  	  	 Statement stmt=con.createStatement();
	  	  	 ResultSet rs=stmt.executeQuery(query);
	  	  	 alltb = alltb + "movie_info table\n";
	  	  	 while(rs.next()) {
	  	  		alltb = alltb + "\t"+rs.getString(1);
	  	  		alltb = alltb + "\t"+rs.getString(2);
	  	  		alltb = alltb + "\t\t"+rs.getString(3);
	  	  		alltb = alltb + "\t"+rs.getString(4);
	  	  		alltb = alltb + "\t"+rs.getString(5);
	  	  		alltb = alltb + "\t\t"+rs.getString(6);
	  	  		alltb = alltb + "\t\t"+rs.getString(7);
	  	  		alltb = alltb + "\t"+rs.getString(8);
	  	  		alltb = alltb + "\n";
	  	  	 }
	  	  	 query = "select * from theater_info";
	  	  	 rs=stmt.executeQuery(query);
	  	  	alltb = alltb + "\ntheater_info table\n";
	  	  	while(rs.next()) {
	  	  		alltb = alltb + "\t"+rs.getString(1);
	  	  		alltb = alltb + "\t"+rs.getString(2);
	  	  		alltb = alltb + "\t"+rs.getString(3);
	  	  		alltb = alltb + "\n";
	  	  	 }
	  	  	query = "select * from screening_date_info";
	  	  	rs=stmt.executeQuery(query);
	  	  	alltb = alltb + "\nscreening_date_info table\n";
	  	  	while(rs.next()) {
	  	  		alltb = alltb + "\t"+rs.getString(1);
	  	  		alltb = alltb + "\t"+rs.getString(2);
	  	  		alltb = alltb + "\t"+rs.getString(3);
	  	  		alltb = alltb + "\t"+rs.getString(4);
	  	  		alltb = alltb + "\t\t"+rs.getString(5);
	  	  		alltb = alltb + "\t"+rs.getString(6);
	  	  		alltb = alltb + "\t"+rs.getString(7);
	  	  		alltb = alltb + "\n";
	  	  	 }
	  	  	query = "select * from seat_info";
	  	  	rs=stmt.executeQuery(query);
	  	  	alltb = alltb + "\nseat_info table\n";
	  	  	while(rs.next()) {
  	  			alltb = alltb + "\t"+rs.getString(1);
  	  			alltb = alltb + "\t"+rs.getString(2);
  	  			alltb = alltb + "\t"+rs.getString(3);
  	  			alltb = alltb + "\t"+rs.getString(3);
  	  			alltb = alltb + "\n";
	  	  	}
	  	  	query = "select * from client_info";
	  	  	rs=stmt.executeQuery(query);
	  	  	alltb = alltb + "\nclient_info table\n";
	  	  	while(rs.next()) {
	  	  		alltb = alltb + "\t"+rs.getString(1);
	  	  		alltb = alltb + "\t"+rs.getString(2);
	  	  		alltb = alltb + "\t"+rs.getString(3);
	  	  		alltb = alltb + "\t"+rs.getString(4);
	  	  		alltb = alltb + "\n";
	  	  	 }
	  	  	query = "select * from book_info";
	  	  	rs=stmt.executeQuery(query);
	  	  	alltb = alltb + "\nbook_info table\n";
	  	  	while(rs.next()) {
	  	  		alltb = alltb + "\t"+rs.getString(1);
	  	  		alltb = alltb + "\t"+rs.getString(2);
	  	  		alltb = alltb + "\t"+rs.getString(3);
	  	  		alltb = alltb + "\t"+rs.getString(4);
	  	  		alltb = alltb + "\t"+rs.getString(5);
	  	  		alltb = alltb + "\t"+rs.getString(6);
	  	  		alltb = alltb + "\n";
	  	  	 }
	  	  	query = "select * from ticket_info";
	  	  	rs=stmt.executeQuery(query);
	  	  	alltb = alltb + "\nticket_info table\n";
	  	  	while(rs.next()) {
	  	  		alltb = alltb + "\t"+rs.getString(1);
	  	  		alltb = alltb + "\t"+rs.getString(2);
	  	  		alltb = alltb + "\t"+rs.getString(3);
	  	  		alltb = alltb + "\t"+rs.getString(4);
	  	  		alltb = alltb + "\t"+rs.getString(5);
	  	  		alltb = alltb + "\t"+rs.getString(6);
	  	  		alltb = alltb + "\t"+rs.getString(7);
	  	  		alltb = alltb + "\t"+rs.getString(8);
	  	  		alltb = alltb + "\n";
	  	  	 }
	  	  	
	  	  } catch(SQLException e) {
	  		  jta.setText("적절하지 않은 입력값입니다.");
	  	  	  e.printStackTrace();
	  	    }
	}
	
	public void JTableRemoveRow() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]) { // 메인함수
		DBproject dbp = new DBproject();
		dbp.MyFrame();
	}
}