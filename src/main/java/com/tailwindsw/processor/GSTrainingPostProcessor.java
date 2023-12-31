package com.tailwindsw.processor;

import com.konylabs.middleware.common.DataPostProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Result;

public class GSTrainingPostProcessor implements DataPostProcessor2 {
    public Object execute(Result result, DataControllerRequest req, DataControllerResponse res) {
        String name = req.getParameter("name");
        if (name != null && !name.isEmpty()) {
            return result;
        }
        result.addParam("name", "Default");
        return result;
    }
}
