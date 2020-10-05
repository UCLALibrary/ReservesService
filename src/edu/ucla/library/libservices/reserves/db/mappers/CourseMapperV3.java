package edu.ucla.library.libservices.reserves.db.mappers;

import edu.ucla.library.libservices.reserves.beans.CourseV3;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CourseMapperV3
  implements RowMapper
{
  public CourseMapperV3()
  {
    super();
  }

  @Override
  public Object mapRow(ResultSet rs, int i)
    throws SQLException
  {
    CourseV3 bean;

    bean = new CourseV3();
    bean.setCourseName(rs.getString("course_name"));
    bean.setCourseNumber(rs.getString("course_number"));
    bean.setDepartmentID(rs.getInt("department_id"));
    bean.setDepartmentName(rs.getString("department_name"));
    bean.setQuarter(rs.getString("quarter"));
    bean.setSectionID(rs.getInt("section_id"));
    bean.setSrsNumber(rs.getString("srs_number"));
    bean.setUrl(rs.getString("url"));

    return bean;
  }
}
