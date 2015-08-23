package com.synavos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.synavos.util.ApplicationConstant;
import com.synavos.util.FitbitApi;


/**
 * Created by bilalilyas on 10/08/15.
 */
//@WebServlet(name = "FitbitActivitesServlet")
public class FitbitActivitesServlet extends HttpServlet {
    private void processRequest(HttpServletRequest request, HttpServletResponse response){
        try{
            // Set response content type
            //--response.setContentType("text/html");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Actual logic goes here.
            PrintWriter out = response.getWriter();

            OAuthService service = new ServiceBuilder()
                    .provider(FitbitApi.class)
                    .apiKey(ApplicationConstant.MY_HEALTH_FITBIT_API_KEY)
                    .apiSecret(ApplicationConstant.MY_HEALTH_FITBIT_API_SECRET)
                    .build();

            //User Jan
            //Token accessToken= new Token("3e70b74f68f9fd4868d1a38d60e07038","fb7ce85b37b72b9a31e15a1ccfc73d8b");
            //User Bilal
            Token accessToken= new Token("eed84dde45083855088de32ebe735d52","99cdae3f325b43cccb7fa51313653347");
            OAuthRequest requestOAuth = new OAuthRequest(Verb.GET,
                    "https://api.fitbit.com/1/user/-/activities/date/2015-08-21.json");
            service.signRequest(accessToken, requestOAuth); // the access token from step


            final Response responseActivites = requestOAuth.send();
            System.out.println("Activities="+responseActivites.getBody());
            out.println(responseActivites.getBody());

            requestOAuth = new OAuthRequest(Verb.GET,"https://api.fitbit.com/1/user/-/sleep/date/2015-07-14.json");
            service.signRequest(accessToken, requestOAuth); // the access token from step
            // 4
            final Response responseSleepTime = requestOAuth.send();
            System.out.println("responseSleepTime="+responseSleepTime.getBody());

            requestOAuth = new OAuthRequest(Verb.GET,"https://api.fitbit.com/1/user/-/activities/heart/date/today/1d.json");
            service.signRequest(accessToken, requestOAuth); // the access token from step
            // 4
            final Response responseHeartRate = requestOAuth.send();
            System.out.println("responseHeartRate="+responseHeartRate.getBody());


        }catch(Exception e){
            e.printStackTrace();

        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
