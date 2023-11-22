package com.tailwindsw.processor;

import com.konylabs.middleware.common.DataPreProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;
import com.konylabs.middleware.registry.AppRegistryException;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GSTrainingPreProcessor implements DataPreProcessor2 {
    public boolean execute(HashMap inputMap, DataControllerRequest req, DataControllerResponse res, Result result) throws AppRegistryException {
        req.addRequestParam_("Occupation", "Developer");
        //data from runtime env variables
        String name = req.getServicesManager().getConfigurableParametersHelper().getServerProperty("GS_CONFIG");
        String email = req.getParameter("email");
        String name1 = req.getParameter("name");
        // req.getHeaderMap().put(); //add to header

        if (!email.isEmpty() && isValidEmail(email) && name1.isEmpty()) {
            return true;
        } else {
            result.addRecord(errorSmsBuilder());
            result.addOpstatusParam(8009);
            result.addHttpStatusCodeParam(401);
            result.addErrMsgParam("Invalid Inputs!");
            return false;
        }
        
    }

    public boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public Record errorSmsBuilder() {
        Record errorResult = new Record();
        errorResult.setId("error");
        errorResult.addParam("error_message", "Unable to validate your inputs");
        return errorResult;
    }
}
