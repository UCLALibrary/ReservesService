package edu.ucla.library.libservices.reserves.db.mappers;

import edu.ucla.library.libservices.reserves.beans.CourseV2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CourseMapperV2
  implements RowMapper
{
  public CourseMapperV2()
  {
    super();
  }

  @Override
  public Object mapRow(ResultSet rs, int rowNum)
    throws SQLException
  {
    CourseV2 bean;

    bean = new CourseV2();
    bean.setCourseName(rs.getString("course_name"));
    bean.setCourseNumber(rs.getString("course_number"));
    bean.setDepartmentID(rs.getInt("department_id"));
    bean.setQuarter(rs.getString("quarter"));
    bean.setSectionID(rs.getInt("section_id"));
    bean.setSrsNumber(rs.getString("srs_number"));
    bean.setUrl(rs.getString("url"));

    return bean;
  }
}
