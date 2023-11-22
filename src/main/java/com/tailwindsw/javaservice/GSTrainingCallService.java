package com.tailwindsw.javaservice;

import com.dbp.core.fabric.extn.DBPServiceExecutor;
import com.dbp.core.fabric.extn.DBPServiceExecutorBuilder;
import com.konylabs.middleware.common.JavaService2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Result;
import java.util.HashMap;
import java.util.Map;

public class GSTrainingCallService implements JavaService2 {
  public Object invoke(String operationName, Object[] inputPayload, DataControllerRequest request, DataControllerResponse response) throws Exception {
    HashMap<String, Object> requestParameters = new HashMap<>();
    requestParameters.put("accountId", request.getParameter("accountId"));
    return invokeServiceAndGetResult(request, requestParameters, request.getHeaderMap());
  }
  
  public static Result invokeServiceAndGetResult(DataControllerRequest request, Map<String, Object> requestParameters, Map<String, Object> headerParams) {
    String serviceName = "GSMockApiUsers";
    String operationName = "getUserById";
    try {
      DBPServiceExecutor serviceExecutor = DBPServiceExecutorBuilder.builder().withServiceId(serviceName).withOperationId(operationName).withRequestParameters(requestParameters).build();
      return serviceExecutor.getResult();
    } catch (Exception e) {
      Result result = new Result();
      result.addParam("message", "Exception " + e.getMessage());
      return result;
    } 
  }
}