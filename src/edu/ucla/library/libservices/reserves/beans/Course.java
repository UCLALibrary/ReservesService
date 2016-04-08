package edu.ucla.library.libservices.reserves.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "theCourse")
@XmlAccessorType( XmlAccessType.FIELD )
public class Course
{
  @XmlElement( name = "courseNumber" )
  private String courseNumber;
  @XmlElement( name = "courseName" )
  private String courseName;
  @XmlElement( name = "sectionID" )
  private int sectionID;
  @XmlElement( name = "departmentID" )
  private int departmentID;
  @XmlElement( name = "srsNumber" )
  private String srsNumber;
  @XmlElement( name = "quarter" )
  private String quarter;

  public Course()
  {
    super();
  }

  public void setCourseNumber( String courseNumber )
  {
    this.courseNumber = courseNumber;
  }

  public String getCourseNumber()
  {
    return courseNumber;
  }

  public void setCourseName( String courseName )
  {
    this.courseName = courseName;
  }

  public String getCourseName()
  {
    return courseName;
  }

  public void setSectionID( int sectionID )
  {
    this.sectionID = sectionID;
  }

  public int getSectionID()
  {
    return sectionID;
  }

  public void setSrsNumber( String srsNumber )
  {
    this.srsNumber = srsNumber;
  }

  public String getSrsNumber()
  {
    return srsNumber;
  }

  public void setQuarter( String quarter )
  {
    this.quarter = quarter;
  }

  public String getQuarter()
  {
    return quarter;
  }

  public void setDepartmentID( int departmentID )
  {
    this.departmentID = departmentID;
  }

  public int getDepartmentID()
  {
    return departmentID;
  }
}
