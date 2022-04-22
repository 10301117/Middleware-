package daoIMP;
import bean.Student;
import dao.StudentDAO;
import java.sql.*;

import connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{
// 添加操作
     public void insert(Student s){
     String sql = "INSERT INTO student (id, name) values (?,?)";
     PreparedStatement pstmt = null;
     DataBaseConnection conn = null;
	    //针对数据库的具体操作
         try{
             conn = new DataBaseConnection();
	        
             pstmt = conn.getConnection().prepareStatement(sql);
             pstmt.setLong(1,s.getID());
             //pstmt.setString(1,s.getID());
             pstmt.setString(2,s.getName());
	  
             pstmt.executeUpdate();
             pstmt.close();
             conn.close();
         }catch(Exception e){  }
    }

    public void update(Student s) {
        String sql = "update Student set name=? where id=?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        try{
            conn = new DataBaseConnection();
            
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1,s.getName());
            pstmt.setString(2,s.getID());
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
    }
    
    public void delete(String iD) {
        String sql = "delete from Student where ID=?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        try{
            conn = new DataBaseConnection();
            
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setString(1,s.getID());
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){}
    }
    
    public List<Student> findAll() {
        String sql = "select * from Student where ID=?";
        List<Student> list = null;
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        ResultSet rs = null;
        try{
            conn = new DataBaseConnection();
            
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setString(1,s.getID());
            
            rs = pstmt.executeQuery();
            Student s = new Student();
            while(rs.next()) {
                s.setID(rs.getSring("id"));
                s.setName(rs.getSring("name"));
                list.add(s);
            }
            pstmt.close();
            conn.close();
            rs.close();
        } catch(Exception e){}
        return list;
    }
    
    public Student findByID(Long id) {
        String sql = "select * from Student where ID=?";
        List<Student> list = null;
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        ResultSet rs = null;
        try{
            conn = new DataBaseConnection();
            
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setString(1,s.getID());
            pstmt.setString(2,id);
            
            rs = pstmt.executeQuery();
            Student s = new Student();
            while(rs.next()) {
                s.setID(rs.getSring("id"));
                s.setName(rs.getSring("name"));
                list.add(s);
            }
            pstmt.close();
            conn.close();
            rs.close();
        } catch(Exception e){}
        return list.get(0);
    }

}
