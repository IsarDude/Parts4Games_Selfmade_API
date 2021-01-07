package oauth;


import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;



public class SimpleOAuthService {
    private static String accessToken = null;
    
    
    /**
     * Contains null or actually authorization flow.
     */
    private static OAuth2CodeGrantFlow flow;
    private static ClientIdentifier clientIdentifier = new ClientIdentifier("1012272884295-oj9v46cl35rssdargirp23k7a7n75gvg.apps.googleusercontent.com", "VkA-vIC38t3BQN9NMVRWQba5");

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        SimpleOAuthService.accessToken = accessToken;
    }

    public static OAuth2CodeGrantFlow getFlow() {
        return flow;
    }

    public static void setFlow(OAuth2CodeGrantFlow flow) {
        SimpleOAuthService.flow = flow;
    }

    public static ClientIdentifier getClientIdentifier() {
        return clientIdentifier;
    }

    public static void setClientIdentifier(ClientIdentifier clientIdentifier) {
        SimpleOAuthService.clientIdentifier = clientIdentifier;
    }
    
    
   
}
