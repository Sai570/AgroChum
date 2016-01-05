package ws;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import entites.Customer;

public class RestfulClient {

	private WebResource webresource;
	private Client client;
	private static final String REST_SERVICE_URL = "http://localhost:8090/RegistrationRestServices/rest/";
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String PASS = "pass";
	private static final String FAIL = "fail";

	public RestfulClient() {
		client = Client.create(new DefaultClientConfig());
		webresource = client.resource(REST_SERVICE_URL).path("customer_reg");
		// webresource =
		// client.resource(UriBuilder.fromUri(REST_SERVICE_URL).build());
		// this.client = ClientBuilder.newClient();
	}

	public String testUpdateUser(String fname, String lname, String email, String password) {
		Form form = new Form();
		form.add("fname", fname);
		form.add("lname", lname);
		form.add("email", email);
		form.add("pwd", password);
	/*	form.add("gender", gender);
		form.add("dob", dob);
		form.add("c_number", c_number);*/
		ClientResponse response = webresource.path("register").type(MediaType.APPLICATION_FORM_URLENCODED)
				.post(ClientResponse.class, form);
		String output = response.getEntity(String.class);
		System.out.println("Response" + output);

		return output;
	}

	public String checkEmailAvailability(String emailavail) throws JSONException {

		Form form = new Form();
		form.add("email", emailavail);

		ClientResponse response = webresource.path("check_email").type(MediaType.APPLICATION_FORM_URLENCODED)
				.post(ClientResponse.class, form);
		System.out.println("Response**" + response.getStatus());
		String avail = response.getEntity(String.class);
		System.out.println("Avail" + avail);
		return avail;
	}

	public String getCurrentCustomerId(String emailavail) throws JSONException {
		String userId = "";
		Form form = new Form();
		form.add("email", emailavail);

		ClientResponse response = webresource.path("get_userId").type(MediaType.APPLICATION_FORM_URLENCODED)
				.post(ClientResponse.class, form);
		System.out.println("Response**" + response.getStatus());

		userId = response.getEntity(String.class);
		System.out.println("userId" + userId);
		return userId;
	}
	
	
	public List<Customer> getCurrentCustomerDetails(String emailavail) throws JSONException {
		String userId = "";
		List<Customer> cusList = null;
		Form form = new Form();
		form.add("email", emailavail);

		ClientResponse response = webresource.path("get_userId").type(MediaType.APPLICATION_FORM_URLENCODED)
				.post(ClientResponse.class, form);
		System.out.println("Response**" + response.getStatus());

		userId = response.getEntity(String.class);
		System.out.println("userId" + userId);
		return cusList;
	}


}
