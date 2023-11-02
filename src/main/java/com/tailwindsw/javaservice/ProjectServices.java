package com.tailwindsw.javaservice;

import com.konylabs.middleware.common.JavaService2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProjectServices implements JavaService2 {

    private static final Logger LOG = LogManager.getLogger(ProjectServices.class);
    public Object invoke(String operationName, Object[] inputPayload, DataControllerRequest request, DataControllerResponse response){
        Result result = new Result();
        result.addParam("id","34");
        result.addParam("Name","George Samuel");
        result.addParam("Email","georgeodhi98@gmail.com");
        result.addParam("Occupation",request.getParameter("Occupation"));

        LOG.debug("DEBUG ProjectServices");
        LOG.error("ERROR ProjectServices");
        return result;
    }
}
