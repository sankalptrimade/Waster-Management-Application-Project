package com.project.FoodWasteManagementProject.utils;

import com.project.FoodWasteManagementProject.model.Status;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class StatusUtility {

    public Status setStatus(String statusData){
        JSONObject statusObj = new JSONObject(statusData);
        Status status = new Status();
        status.setStatus(statusObj.getString("status"));
        return status;
    }
}
