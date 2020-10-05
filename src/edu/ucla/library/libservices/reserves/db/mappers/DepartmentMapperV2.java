package edu.ucla.library.libservices.reserves.db.mappers;

import edu.ucla.library.libservices.reserves.beans.DepartmentV2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DepartmentMapperV2
  implements RowMapper
{
  public DepartmentMapperV2()
  {
    super();
  }

  @Override
  public Object mapRow(ResultSet rs, int i)
    throws SQLException
  {
    DepartmentV2 bean;

    bean = new DepartmentV2();
    bean.setDepartmentCode( rs.getString( "department_code" ) );
    bean.setDepartmentID( rs.getInt( "department_id" ) );
    bean.setDepartmentName( rs.getString( "department_name" ) );
    bean.setQuarter( rs.getString( "quarter" ) );

    return bean;
  }
}
