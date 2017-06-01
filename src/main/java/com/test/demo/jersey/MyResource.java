package com.test.demo.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("versionStat")
public class MyResource {

  /**
   * Method handling HTTP GET requests. The returned object will be sent to the client as
   * "text/plain" media type.
   *
   * @return String that will be returned as a text/plain response.
   */
  @GET
  @Path("terminalCount")
  @Produces(MediaType.APPLICATION_JSON)
  public String getApkVersion() {
    System.out.println("in");
    return "[{\"softwareVersion\":\"0.0.1\",\"terminalCount\":10},{\"softwareVersion\":\"0.0.2\",\"terminalCount\":190}]";
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHtml() {
    return "...";
  }
}
