package edu.ucla.library.libservices.reserves.utiltiy;

import edu.ucla.library.libservices.reserves.beans.Department;

import edu.ucla.library.libservices.reserves.beans.Item;
import edu.ucla.library.libservices.reserves.generators.DepartmentGenerator;

import edu.ucla.library.libservices.reserves.generators.ItemGenerator;

import java.util.List;

public class Tester
{
  public Tester()
  {
    super();
  }

  public static void main( String[] args )
  {
    ItemGenerator tester;
    List<Item> items;

    tester = new ItemGenerator();
    tester.setQuarter( "121" );
    tester.setSrsNumber( "022301201" );
    tester.prepItemsByQuarter();

    items = tester.getItems();

    for ( Item theCourse: items )
      System.out.println( "item " + theCourse.getTitle() + " (" +
                          theCourse.getCallNo() + ") (" + theCourse.getCopyNumber() + ")" );
  }
}
