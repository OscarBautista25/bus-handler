package controllers;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import services.BusService;

public class BusController implements RequestHandler<String,String> {

    @Override
    public String handleRequest(String event, Context context) {
        System.out.println("event:"  + event);
        return BusService.calculateBussize(event);
    }
}

