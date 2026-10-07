package com.example.controller;

import com.example.model.ServiceCostModel;
import com.example.view.ServiceView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceController {
    private ServiceView view;
    private ServiceCostModel model;

    public ServiceController(ServiceView view, ServiceCostModel model) {
        this.view = view;
        this.model = model;

        this.view.addCalculateCostListener(new CalculateCostListener());
    }

    class CalculateCostListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String registrationNumber = view.getRegistrationNumber();
            boolean isTwoWheeler = view.isTwoWheelerSelected();
            boolean isCar = view.isCarSelected();
            boolean generalService = view.isGeneralServiceSelected();
            boolean oilChange = view.isOilChangeSelected();
            boolean brakeService = view.isBrakeServiceSelected();
            boolean batteryCheck = view.isBatteryCheckSelected();

            model.setVehicleType(isTwoWheeler ? "Two Wheeler" : "Car");
            model.setServices(generalService, oilChange, brakeService, batteryCheck);
            int totalCost = model.calculateTotalCost();

            view.setTotalCost(totalCost);
        }
    }
}