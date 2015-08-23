package com.synavos.fitbitjob;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.synavos.util.ApplicationConstant;
import com.synavos.util.ApplicationURL;
import com.synavos.util.FitbitApi;

/**
 * Created by bilalilyas on 28/07/15.
 */
public class TokenResue {
    public static void main(String[] args){

        try{
            OAuthService service = new ServiceBuilder()
                    .provider(FitbitApi.class)
                    .apiKey(ApplicationConstant.MY_HEALTH_FITBIT_API_KEY)
                    .apiSecret(ApplicationConstant.MY_HEALTH_FITBIT_API_SECRET)
                    .build();

            // Jan Arnold
            //Token accessToken= new Token("3e70b74f68f9fd4868d1a38d60e07038","fb7ce85b37b72b9a31e15a1ccfc73d8b");

            //Bilal
            Token accessToken= new Token("eed84dde45083855088de32ebe735d52","99cdae3f325b43cccb7fa51313653347");

            OAuthRequest request = new OAuthRequest(Verb.GET,
                    ApplicationURL.PROFILE);
            service.signRequest(accessToken, request); // the access token from step
            //Profile
            final Response response = request.send();
            System.out.println("Profile Info="+response.getBody());
            //request = new OAuthRequest(Verb.GET,ApplicationURL.ACTIVITES);
            request = new OAuthRequest(Verb.GET,"https://api.fitbit.com/1/user/-/activities/date/2015-08-21.json");

            service.signRequest(accessToken, request); // the access token from step
            //activites
            final Response responseActivites = request.send();
            System.out.println("Activities="+responseActivites.getBody());

            request = new OAuthRequest(Verb.GET,"https://api.fitbit.com/1/user/-/sleep/date/2015-07-14.json");
            service.signRequest(accessToken, request); // the access token from step
            //sleep
            final Response responseSleepTime = request.send();
            System.out.println("responseSleepTime="+responseSleepTime.getBody());

            request = new OAuthRequest(Verb.GET, "https://api.fitbit.com/1/user/-/activities/heart/date/2015-08-23/7d.json");
            service.signRequest(accessToken, request); // the access token from step
            //HeartRate
            final Response responseHeartRate = request.send();
            System.out.println("responseHeartRate="+responseHeartRate.getBody());

            //https://api.fitbit.com/1/user/-/devices.json

            request = new OAuthRequest(Verb.GET, ApplicationURL.FITBIT_DEVICES);
            service.signRequest(accessToken, request); // the access token from step
            //HeartRate
            final Response responseDevices = request.send();
            System.out.println("responseDevices="+responseDevices.getBody());

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
