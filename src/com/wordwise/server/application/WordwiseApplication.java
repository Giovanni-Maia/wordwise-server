package com.wordwise.server.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.wordwise.server.resource.DifficultyResource;
import com.wordwise.server.resource.QualityResource;
import com.wordwise.server.resource.RateResource;
import com.wordwise.server.resource.TranslationResource;
import com.wordwise.server.resource.WordResource;


public class WordwiseApplication  extends Application
{
	@Override  
    public synchronized Restlet createInboundRoot()
	{  
        Router router = new Router(getContext());
        
        router.attach("/"+TranslationResource.RESOURCE_NAME, TranslationServerResource.class);
        router.attach("/"+RateResource.RESOURCE_NAME, RateServerResource.class);
        router.attach("/"+QualityResource.RESOURCE_NAME, QualityServerResource.class);
        router.attach("/"+DifficultyResource.RESOURCE_NAME, DifficultyServerResource.class);
        router.attach("/"+WordResource.RESOURCE_NAME, WordServerResource.class);
       
        return router;  
	}
}
