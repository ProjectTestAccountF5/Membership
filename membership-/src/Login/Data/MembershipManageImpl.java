package Login.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Login.Member;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MembershipManageImpl implements IMembershipManage {
	final static String DRIVER = "org.sqlite.JDBC";
	final static String DB = "jdbc:sqlite:C:/자바취업반/shop.db";
	Connection conn ;
	@FXML 
	TextField IdTxt;
	
	
	public MembershipManageImpl() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DB);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
		}
	}
	@Override
	public boolean MembershipProc(Member member) {
		String sql = 	"INSERT INTO member "+
						"(id, name, pw, phonenum, email ) "+
						"VALUES (?,?,?,?,?) ";
		
		PreparedStatement pStmt;
		try {
			pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, member.getId());
			pStmt.setString(2, member.getName());
			pStmt.setString(3, member.getPw());
			pStmt.setString(4, member.getPhonenum());
			pStmt.setString(5, member.getEmail());
			

			
			pStmt.executeUpdate();
			pStmt.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public int LoginProc(String id, String pw) {
		String sql = 	"SELECT count(*) "+
						"FROM member "+
						"WHERE id=? "+
						"AND pw=? ";
		int result =0;
		PreparedStatement pStmt;
		
		try {
			pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, id);
			pStmt.setString(2, pw);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next())
				result = rs.getInt("count(*)");
			
			pStmt.executeQuery();
			
			pStmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			//return result;
		}
		
		return result;
		
	}
	@Override
	public List<Member> getMember() {
		String sql ="SELECT * "+
				"FROM Member ";
		List<Member> lstMember =new ArrayList<Member>();
		
		try {
			PreparedStatement pStmt =conn.prepareStatement(sql);
			
			ResultSet rs =pStmt.executeQuery();
			
			while(rs.next()) {
				Member member =new Member();
				
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPw(rs.getString("pw"));



				
				lstMember.add(member);
			}
			pStmt.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;
		}
		return lstMember;
}
	

	
	
	@Override
	public boolean Updatemember (String name, String pw, String id) {
		

		String sql ="UPDATE Member SET name = " + "'" + name + "'" +  "," +  "pw = " + "'" + pw  + "'" + " " +  "WHERE id = " + "'" + id + "'";
        System.out.println(sql);
		String url = "jdbc:sqlite:C:/자바취업반/shop.db";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
        try {
        	
        	
        	System.out.println("연결");

  
        	
        	conn = DriverManager.getConnection(url);
        	
        	pstmt = conn.prepareStatement(sql);
        	

        	//로그인창에서 회원정보 수정으로 갈시 이 부분이 동작 안됨
        	pstmt.executeUpdate();
        	//
        	
            pstmt.close();
            conn.close();


			return true;
			
			
        }catch (SQLException e) {
        	System.out.println(e.getMessage());
        	return false;
      
		}
        
	}


	
	
		
	}

