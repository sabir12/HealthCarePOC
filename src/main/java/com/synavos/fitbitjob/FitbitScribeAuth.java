package com.synavos.fitbitjob;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.synavos.util.FitbitApi;



/**
 * Created by bilalilyas on 16/07/15.
 */
public class FitbitScribeAuth {
    public static void main(String[] args){
    //key=f984482abd6fb3715ac9ab3c4fe3e3c6
    //secret=15f4916a96ed9a607f993b21e2fb507d
            OAuthService service = new ServiceBuilder()
                    .provider(FitbitApi.class)
                    .apiKey("f984482abd6fb3715ac9ab3c4fe3e3c6")
                    .apiSecret("15f4916a96ed9a607f993b21e2fb507d")
                    .build();
            System.out.println("Service Version="+service.getVersion());

            Token requestToken = service.getRequestToken();
            System.out.println("Temp Request Token[oauth_token,oauth_token_secret]=" + requestToken);
            String authUrl = service.getAuthorizationUrl(requestToken);
            System.out.println("Auth URL=" + authUrl);
            try {
                Desktop.getDesktop().browse(new URI(authUrl));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("RawResponse="+requestToken.getRawResponse());
            System.out.println("Token="+requestToken.getToken());
            System.out.println("Secret="+requestToken.getSecret());
            System.out.println("RequestToken Object="+requestToken.toString());


        System.out.println("Enter PIN Code here : ");
        String pin_code="";
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            pin_code = bufferRead.readLine();

            System.out.println("Entered PIN is:"+pin_code);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        Verifier v = new Verifier(pin_code);
        System.out.println("Verifier Value=" + v.getValue());
        Token accessToken = service.getAccessToken(requestToken, v);
        System.out.println("accessToken&accessTokenSecret_Response="+accessToken);
        System.out.println("accessToken_Raw_Response="+accessToken.getRawResponse());

        OAuthRequest request = new OAuthRequest(Verb.GET,
                "https://api.fitbit.com/1/user/-/activities/heart/date/today/1d.json");
        service.signRequest(accessToken, request); // the access token from step
        // 4
        final Response response = request.send();
        System.out.println(response.getBody());


    }
}
