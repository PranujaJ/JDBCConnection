import java.util.Collection;

import Jdbc.dao.CourseDao;
import Jdbc.dao.Idao;
import Jdbc.entity.Course;

public class JdbcExample {
	
	private static void addNewCourse() {
		Idao<Course, String> idaoRef = new CourseDao();
		Course crs = new Course("ML", "Machine Learning", 5, 20000);
		idaoRef.create(crs);
	}
	
	private static void showAllCourses() {
		// TODO Auto-generated method stub
		Idao<Course,String> idaoRef=new CourseDao(); 
		Collection <Course>courseList=idaoRef.getAll();
		for(Course currentCourse : courseList)
			System.out.println(currentCourse);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		showAllCourses();
		//addNewCourse();
	}

	

}
