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

  public void setDs( DataSource ds )
  {
    this.ds = ds;
  }

  private DataSource getDs()
  {
    return ds;
  }

  public void setDbName( String dbName )
  {
    this.dbName = dbName;
  }

  private String getDbName()
  {
    return dbName;
  }

  public List<Course> getCourses()
  {
    return courses;
  }

  public List<CourseV3> getV3Courses()
  {
    return v3Courses;
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

  public void testPrepCoursesByDept()
  {
    courses = new JdbcTemplate( getDs() ).query( DEPT_QUERY, new Object[]
          { getDepartmentID() }, new CourseMapper() );
  }

  public void prepCoursesByQuarter()
  {
    makeConnection();

    courses = new JdbcTemplate( ds ).query( QUARTER_QUERY, new Object[]
          { getDepartmentID(), getQuarter() }, new CourseMapper() );
  }

  public void testPrepCoursesByQuarter()
  {
    courses = new JdbcTemplate( getDs() ).query( QUARTER_QUERY, new Object[]
          { getDepartmentID(), getQuarter() }, new CourseMapper() );
  }

  public void prepV3CoursesByQuarter()
  {
    makeConnection();

    v3Courses = new JdbcTemplate(ds).query(V3_QUARTER_QUERY, new Object[] { getQuarter() }, new CourseMapperV3());
  }

  public List<CourseV2> getV2Courses()
  {
    makeConnection();

    v2Courses =
      new JdbcTemplate(ds).query(QUARTER_QUERY, new Object[] { getDepartmentID(), getQuarter() }, new CourseMapperV2());

    for (CourseV2 theCourse: v2Courses)
    {
      ItemGenerator generator;

      generator = new ItemGenerator();
      generator.setSrsNumber(theCourse.getSrsNumber());
      generator.setDbName(getDbName());
      generator.setQuarter(getQuarter());

      theCourse.setItems(generator.getItems());
    }

    return v2Courses;
  }

}
