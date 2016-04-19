package com.nitish.freecharge.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.nitish.freecharge.dao.FileDAO;
import com.nitish.freecharge.model.Count;

/**
 * Root resource (exposed at "count" path) which handles HTTP GET method and returns the count value;
 */
@Path("/count")
public class CountResource {

	private FileDAO fileDAO=new FileDAO();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent
	 * to the client as "application/json" media type.
	 *
	 * @return String that will be returned as a application/json response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@QueryParam("query")
	public Response getWordCount(@QueryParam("query")String query) {
		Error error=null;
		Count count=null;
		try{   
			if(query!=null){
				query=query.trim();
				if(query.length()>0 && query.matches("^[A-Za-z]+$")){
					long c=fileDAO.getCount(query.toLowerCase());
					count=new Count(c);
				}else{
					error=new Error("Some Error Occured.Please Try Again With a new word!");
				}
			}else{
				error=new Error("Some Error Occured.Please Try Again!");
			}
		}catch(Exception e){
			error=new Error(e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
		if(count!=null){
			return Response.status(Status.OK).entity(count).build();
			
		}else{
			return Response.status(Status.BAD_REQUEST).entity(error).build();
		}
	}
}
