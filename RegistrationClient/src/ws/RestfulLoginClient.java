package ws;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class RestfulLoginClient {
	private WebResource webresource;
	private Client client;
	private static final String REST_SERVICE_URL = "http://localhost:8090/RegistrationRestServices/rest/";
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String PASS = "pass";
	private static final String FAIL = "fail";

	public RestfulLoginClient() {
		client = Client.create(new DefaultClientConfig());
		webresource = client.resource(REST_SERVICE_URL).path("customer_login");
	}

	public String testUpdateUserLogin(String email, String password) {
		Form form = new Form();
		form.add("email", email);
		form.add("pwd", password);
		ClientResponse response = webresource.path("login").type(MediaType.APPLICATION_FORM_URLENCODED)
				.post(ClientResponse.class, form);
		String output = response.getEntity(String.class);
		System.out.println("Response" + output);

		return output;
	}
}
