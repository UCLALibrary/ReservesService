package edu.ucla.library.libservices.reserves.tests;

import edu.ucla.library.libservices.reserves.beans.Course;
import edu.ucla.library.libservices.reserves.beans.Department;
import edu.ucla.library.libservices.reserves.beans.Item;

import org.junit.jupiter.api.Test;

import org.meanbean.test.BeanTester;

public class BeanAccessTests
{
  @Test
  public void courseAccessMethodsWork()
  {
    new BeanTester().testBean(Course.class);
  }

  @Test
  public void departmentAccessMethodsWork()
  {
    new BeanTester().testBean(Department.class);
  }

  @Test
  public void itemAccessMethodsWork()
  {
    new BeanTester().testBean(Item.class);
  }

}