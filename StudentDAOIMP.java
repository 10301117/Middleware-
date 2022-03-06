package DAO;

import javax.sql.DataSource;
import java.util.List;

public class StudentDAOIMP implements StudentDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setdatasource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void insertStu(Student s){
        String sql = "insert into Student([ID],[name]) values (?,?)";
        jdbcTemplate.insert(sql,s.getId(),s.getName());
    }

    @Override
    public void deleteStu(Student s) {
        String sql = "delete from Student where ID=?";
        jdbcTemplate.delete(sql,s.getId());
    }

    @Override
    public void updateStu(Student s) {
        String sql = "update Student set name=? where ID=?";
        jdbcTemplate.update(sql,s.getName(),s.getId());
    }

    @Override
    public Student findStuByID(String id) {
        String sql = "select * from Student where ID=?";
        List<Student> list= jdbcTemplate.query(sql,id,new StudentMapper());
        return list.get(0);
    }

    @Override
    public List<Student> getAll() {
        String sql = "select * from Student where ID=?";
        List<Student> list = jdbcTemplate.query(sql,new StudentMapper());
        return list;
    }
}
