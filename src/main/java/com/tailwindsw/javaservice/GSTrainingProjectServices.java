package com.tailwindsw.javaservice;

import com.konylabs.middleware.common.JavaService2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class GSTrainingProjectServices implements JavaService2 {

    private static final Logger LOG = LogManager.getLogger(GSTrainingProjectServices.class);

    public Object invoke(String operationName, Object[] inputPayload, DataControllerRequest request,
            DataControllerResponse response) {
        String userEmail = request.getParameter("email");
        String userName = request.getParameter("name");
        String userOccupation = request.getParameter("Occupation");

        Result result = new Result();
        Record userDetail = userInfoBuilder(userEmail, userName, userOccupation);
        result.addRecord(userDetail);

        LOG.debug("DEBUG ProjectServices");
        LOG.error("ERROR ProjectServices");
        return result;
    }

    public Record userInfoBuilder(String email, String name, String occupation) {
        String randomId = UUID.randomUUID().toString();

        Record userInfo = new Record();
        userInfo.setId("userInfo");
        userInfo.addParam("id", randomId);
        userInfo.addParam("name", name);
        userInfo.addParam("email", email);
        userInfo.addParam("occupation", occupation);

        return userInfo;
    }
}
