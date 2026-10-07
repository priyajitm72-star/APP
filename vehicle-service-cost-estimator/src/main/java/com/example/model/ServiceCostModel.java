package com.example.model;

public class ServiceCostModel {
    private static final int GENERAL_SERVICE_COST = 1000;
    private static final int OIL_CHANGE_COST = 800;
    private static final int BRAKE_SERVICE_COST = 1200;
    private static final int BATTERY_CHECK_COST = 500;

    private boolean generalService;
    private boolean oilChange;
    private boolean brakeService;
    private boolean batteryCheck;

    public void setServices(boolean generalService, boolean oilChange, boolean brakeService, boolean batteryCheck) {
        this.generalService = generalService;
        this.oilChange = oilChange;
        this.brakeService = brakeService;
        this.batteryCheck = batteryCheck;
    }

    public int calculateTotalCost() {
        int totalCost = 0;
        if (generalService) totalCost += GENERAL_SERVICE_COST;
        if (oilChange) totalCost += OIL_CHANGE_COST;
        if (brakeService) totalCost += BRAKE_SERVICE_COST;
        if (batteryCheck) totalCost += BATTERY_CHECK_COST;
        return totalCost;
    }
}