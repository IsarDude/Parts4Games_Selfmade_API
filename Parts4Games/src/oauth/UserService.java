package oauth;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;


import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.OAuth2FlowGoogleBuilder;
import oauth.SimpleOAuthService;



public class UserService {

    @Context
    private UriInfo uriInfo;
    
    // methoden-Parameter muss den vorherigen path mitgeben 
    public Response googleAuthRedirect() {
        final String redirectURI = UriBuilder.fromUri(uriInfo.getBaseUri()).path("oauth2/authorize?redirectpath=" + "queryParamFürRedirectAufVorherigenPath").build().toString(); 

        final OAuth2CodeGrantFlow flow = OAuth2ClientSupport.googleFlowBuilder(
                SimpleOAuthService.getClientIdentifier(),
                redirectURI,
                "openid")
                .prompt(OAuth2FlowGoogleBuilder.Prompt.CONSENT).build();

        SimpleOAuthService.setFlow(flow);

        // startet den flow 
        final String googleAuthURI = flow.start();

        // redirect user to Google Authorization URI.
        return Response.seeOther(UriBuilder.fromUri(googleAuthURI).build()).build();
    }  

    
    	
}

