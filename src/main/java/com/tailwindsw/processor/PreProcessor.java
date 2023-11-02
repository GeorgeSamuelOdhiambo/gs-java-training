package com.tailwindsw.processor;

import com.konylabs.middleware.common.DataPreProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Result;

import java.util.HashMap;

public class PreProcessor implements DataPreProcessor2 {
    public boolean execute(HashMap inputMap, DataControllerRequest req, DataControllerResponse res, Result result) {
        req.addRequestParam_("Occupation","Developer");
        return true;
    }
}
