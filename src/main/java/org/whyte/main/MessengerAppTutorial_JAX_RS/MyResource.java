package org.whyte.main.MessengerAppTutorial_JAX_RS;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("myresource")
public class MyResource
{
	//Create MD5 encryptor object
	MD5 encryptor = new MD5();
	
	//Here is how we process a form sent by the HTTP POST method
	@Path("processform")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)//shows what we are expecting to recieve
	public String testForm(@FormParam("fName") String fn, @FormParam("lName") String ln) 
	{
		//Then we can do some processing on the data got from the client.
		//In this example we encrypt the data sent and simply send it back.
		//Encrypt first and last name then return them back to the client.
	    fn = encryptor.getMD5(fn);
	    ln = encryptor.getMD5(ln);
	    
	    return  fn + " " + ln;
	}
}
