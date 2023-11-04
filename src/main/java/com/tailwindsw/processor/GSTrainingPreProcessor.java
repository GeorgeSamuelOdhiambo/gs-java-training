package com.tailwindsw.processor;

import com.konylabs.middleware.common.DataPreProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Result;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GSTrainingPreProcessor implements DataPreProcessor2 {
    public boolean execute(HashMap inputMap, DataControllerRequest req, DataControllerResponse res, Result result) {
        req.addRequestParam_("Occupation", "Developer");
        String email = req.getParameter("email");
        // req.getHeaderMap().put(); //add to header

        if (isValidEmail(email)) {
            return true;
        } else {
            result = errorSmsBuilder();
            return false;
        }
        
    }

    public boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public Result errorSmsBuilder() {
        Result errorResult = new Result();
        errorResult.addParam("error_message", "Unable to validate your inputs");
        errorResult.addOpstatusParam(8009);
        errorResult.addHttpStatusCodeParam(401);
        errorResult.addErrMsgParam("Invalid Inputs!");
        return errorResult;
    }
}
