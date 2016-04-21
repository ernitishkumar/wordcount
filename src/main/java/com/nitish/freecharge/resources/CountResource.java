package com.nitish.freecharge.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.nitish.freecharge.dao.FileDAO;
import com.nitish.freecharge.model.Count;
import com.nitish.freecharge.model.ErrorMessage;

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
		ErrorMessage error=null;
		Count count=null;
		try{   
			if(query!=null){
				query=query.trim();
				if(query.length()>0 && query.matches("^[A-Za-z]+$")){
					long c=fileDAO.getCount(query.toLowerCase());
					count=new Count(c);
				}else{
					error=new ErrorMessage("Invalid word.Please try again with a new word!");
				}
			}else{
				error=new ErrorMessage("Word Required.Please Try Again with a new word!");
			}
		}catch(Exception e){
			error=new ErrorMessage(e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
		if(count!=null){
			return Response.status(Status.OK).entity(count).build();
		}else{
			return Response.status(Status.BAD_REQUEST).entity(error).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWordCountViaPost(){
		ErrorMessage errorMessage = new ErrorMessage("POST request not supported for this URL. Kindly make a GET request to use the service!");
		return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWordCountViaPut(){
		ErrorMessage errorMessage = new ErrorMessage("PUT request not supported for this URL. Kindly make a GET request to use the service!");
		return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWordCountViaDelete(){
		ErrorMessage errorMessage = new ErrorMessage("DELETE request not supported for this URL. Kindly make a GET request to use the service!");
		return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
	}
	
	@OPTIONS
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWordCountViaOptions(){
		ErrorMessage errorMessage = new ErrorMessage("OPTIONS request not supported for this URL. Kindly make a GET request to use the service!");
		return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
	}
	
	@HEAD
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWordCountViaHead(){
		ErrorMessage errorMessage = new ErrorMessage("HEAD request not supported for this URL. Kindly make a GET request to use the service!");
		return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
	}
}
