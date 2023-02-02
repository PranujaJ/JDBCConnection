package Jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Jdbc.entity.Course;
import Jdbc.entity.JdbcUtils;

public class CourseDao implements Idao<Course,String>{

	@Override
	public Collection<Course> getAll() {
		// TODO Auto-generated method stub
		Collection<Course>allCourses=new ArrayList<Course>();
		String sqlQuery="select course_Id,course_name,course_duration,course_fees from course_master";
		
		try(Connection conn=JdbcUtils.obtainConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sqlQuery);)
		{
		
			while(rs.next())
			{
				String Id=rs.getString(1);
				String name=rs.getString(2);
				int duration=rs.getInt(3);
				int fees=rs.getInt(4);
				
				Course courseObj=new Course(Id,name,duration,fees);
				allCourses.add(courseObj);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allCourses;
	}

	@Override
	public Course getOne(String courseId) {
		// TODO Auto-generated method stub
		Course foundCourse = null;

		String sqlQuery="select course_name,course_duration,course_fees from course_master where course_Id=?";
		
		try(Connection conn=JdbcUtils.obtainConnection();
			PreparedStatement preStmt=conn.prepareStatement(sqlQuery);
			)
		{
		
			preStmt.setString(1,courseId);
			ResultSet rs=preStmt.executeQuery();
			if(rs.next())
			{
				String Id=rs.getString(1);
				String name=rs.getString(2);
				int duration=rs.getInt(3);
				int fees=rs.getInt(4);
				
				foundCourse=new Course(Id,name,duration,fees);
				
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return foundCourse;
	}

	@Override
	public void create(Course newCourse) {
		// TODO Auto-generated method stub
		
		String sqlQuery="insert into course_master values(?,?,?,?)";
		
		try(Connection conn=JdbcUtils.obtainConnection();
			PreparedStatement preStmt=conn.prepareStatement(sqlQuery);
			)
		{
			String Id=newCourse.getCourseId();
			String name=newCourse.getName();
			int duration=newCourse.getDuration();
			int fees=newCourse.getFees();
			
			preStmt.setString(1, Id);
			preStmt.setString(2, name);
			preStmt.setInt(3, duration);
			preStmt.setInt(4, fees);
			
			int updateCount=preStmt.executeUpdate();
			System.out.println("Record Added. Count: " + updateCount);
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
