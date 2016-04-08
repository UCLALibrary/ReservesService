package edu.ucla.library.libservices.reserves.generators;

import edu.ucla.library.libservices.reserves.beans.Course;
import edu.ucla.library.libservices.reserves.db.mappers.CourseMapper;
import edu.ucla.library.libservices.reserves.db.utiltiy.DataSourceFactory;

import java.util.List;

import javax.sql.DataSource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

@XmlRootElement( name = "courseList" )
public class CourseGenerator
{
  //private DriverManagerDataSource ds;
  private DataSource ds;
  @XmlElement( name = "course" )
  private List<Course> courses;
  private int departmentID;
  private String quarter;
  private String dbName;

  private static final String DEPT_QUERY =
    "SELECT * FROM vger_support.reserve_courses WHERE department_id = ? AND " 
    + "quarter = vger_support.get_current_quarter() ORDER BY course_name";
  private static final String QUARTER_QUERY =
    "SELECT * FROM vger_support.reserve_courses WHERE department_id = ? AND " 
    + "quarter = ? ORDER BY course_name";

  public CourseGenerator()
  {
    super();
  }

  public void setDepartmentID( int departmentID )
  {
    this.departmentID = departmentID;
  }

  private int getDepartmentID()
  {
    return departmentID;
  }

  public void setQuarter( String quarter )
  {
    this.quarter = quarter;
  }

  private String getQuarter()
  {
    return quarter;
  }

  private void makeConnection()
  {
    ds = DataSourceFactory.createDataSource( getDbName() );
    //ds = DataSourceFactory.createVgerSource();
  }

  public void prepCoursesByDept()
  {
    makeConnection();

    courses = new JdbcTemplate( ds ).query( DEPT_QUERY, new Object[]
          { getDepartmentID() }, new CourseMapper() );
  }

  public void prepCoursesByQuarter()
  {
    makeConnection();

    courses = new JdbcTemplate( ds ).query( QUARTER_QUERY, new Object[]
          { getDepartmentID(), getQuarter() }, new CourseMapper() );
  }

  public List<Course> getCourses()
  {
    return courses;
  }

  public void setDbName( String dbName )
  {
    this.dbName = dbName;
  }

  private String getDbName()
  {
    return dbName;
  }
}
