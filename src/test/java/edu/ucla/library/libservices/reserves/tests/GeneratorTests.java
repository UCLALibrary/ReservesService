package edu.ucla.library.libservices.reserves.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ucla.library.libservices.reserves.generators.CourseGenerator;
import edu.ucla.library.libservices.reserves.generators.DepartmentGenerator;
import edu.ucla.library.libservices.reserves.generators.ItemGenerator;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class GeneratorTests
{
  private final String QUARTER = "201";
  private final int DEPARTMENT = 2;

  private EmbeddedDatabase ds;

  @BeforeEach
  void init()
  {
	  ds = new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .setName("testdb;DATABASE_TO_UPPER=false;MODE=Oracle")
        .addScript("create.sql")
        .addScript("populate.sql")
        .build();
  }

  @Test
  public final void itemTests()
  {
	  ItemGenerator generator;

	  generator = new ItemGenerator();
	  generator.setDs( ds );
	  generator.testPrepItems();

	  assertNotNull( generator.getItems(), "ItemGenerator.getItems should return populated object" );

	  generator.setQuarter( QUARTER );
	  generator.testPrepItemsByQuarter();
	  assertNotNull( generator.getItems(), "ItemGenerator.getItems(quarter) should return populated object" );
  }

  @Test
  public final void courseTests()
  {
	  CourseGenerator generator;

	  generator = new CourseGenerator();
	  generator.setDs( ds );
	  generator.setDepartmentID( DEPARTMENT );
	  generator.testPrepCoursesByDept();

	  assertNotNull( generator.getCourses(), "CourseGenerator.getCourses should return populated object" );

	  generator.setQuarter( QUARTER );
	  generator.testPrepCoursesByQuarter();
	  assertNotNull( generator.getCourses(), "CourseGenerator.getCourses(quarter) should return populated object" );
  }

  @Test
  public final void departmentTests()
  {
	  DepartmentGenerator generator;

	  generator = new DepartmentGenerator();
	  generator.setDs( ds );
	  generator.testPrepCurrentDepts();

	  assertNotNull( generator.getDepartments(), "DepartmentGenerator.getDepartments should return populated object" );

	  generator.setQuarter( QUARTER );
	  generator.testPrepDeptsByQuarter();
	  assertNotNull( generator.getDepartments(), "DepartmentGenerator.getDepartments(quarter) should return populated object" );
  }
}