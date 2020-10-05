package edu.ucla.library.libservices.reserves.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "theDepartment")
@XmlAccessorType( XmlAccessType.FIELD )
public class DepartmentV2
{
  @XmlElement( name = "departmentID" )
  private int departmentID;
  @XmlElement( name = "departmentCode" )
  private String departmentCode;
  @XmlElement( name = "departmentName" )
  private String departmentName;
  @XmlElement( name = "quarter" )
  private String quarter;
  @XmlElement( name = "courses" )
  private List<CourseV2> courses;

  public DepartmentV2()
  {
    super();
  }

  public void setDepartmentID( int departmentID )
  {
    this.departmentID = departmentID;
  }

  public int getDepartmentID()
  {
    return departmentID;
  }

  public void setDepartmentCode( String departmentCode )
  {
    this.departmentCode = departmentCode;
  }

  public String getDepartmentCode()
  {
    return departmentCode;
  }

  public void setDepartmentName( String departmentName )
  {
    this.departmentName = departmentName;
  }

  public String getDepartmentName()
  {
    return departmentName;
  }

  public void setQuarter( String quarter )
  {
    this.quarter = quarter;
  }

  public String getQuarter()
  {
    return quarter;
  }

  public void setCourses(List<CourseV2> courses)
  {
    this.courses = courses;
  }

  public List<CourseV2> getCourses()
  {
    return courses;
  }
}
