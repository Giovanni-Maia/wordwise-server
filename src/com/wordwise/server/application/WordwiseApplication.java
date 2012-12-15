package com.wordwise.server.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;


public class WordwiseApplication  extends Application
{
	@Override  
    public synchronized Restlet createInboundRoot()
	{  
        Router router = new Router(getContext());
        
        router.attach("/words", WordServerResource.class);
  
        return router;  
    }  

}
