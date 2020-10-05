package edu.ucla.library.libservices.reserves.webservices;

import edu.ucla.library.libservices.reserves.generators.DepartmentGenerator;

import javax.servlet.ServletConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/allreserves")
@Path("/allreserves/")
public class AllReservesService
{
  @Context
  ServletConfig config;

  public AllReservesService()
  {
    super();
  }

  @GET
  @Produces("text/xml, application/json")
  @Path("/term/{term}")
  @ApiOperation(value = "Finds all reserves lists in {term} academic term", responseContainer = "Response",
                response = DepartmentGenerator.class, httpMethod = "GET", produces = "text/xml, application/json")
  public Response reservesByTerm(@ApiParam(value = "academic term for filter", required = true) @PathParam("term")
                                    String term)
  {
    DepartmentGenerator generator;

    generator = new DepartmentGenerator();
    generator.setDbName(config.getServletContext().getInitParameter("datasource.oracle"));
    generator.setQuarter(term);

    try
    {
      generator.prepV2DeptsByQuarter();
      return Response.ok()
                     .entity(generator)
                     .build();
    }
    catch (Exception e)
    {
      return Response.serverError()
                     .entity("search failed: " + e.getMessage())
                     .build();
    }
  }
}
