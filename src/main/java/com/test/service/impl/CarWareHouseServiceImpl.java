package com.test.service.impl;

import com.test.controller.CarRentController;
import com.test.model.CarStock;
import com.test.model.CarWarehouse;
import com.test.service.CarWareHouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarWareHouseServiceImpl implements CarWareHouseService {
    private static Logger logger = LoggerFactory.getLogger(CarWareHouseServiceImpl.class);

    @Override
    public Boolean deductCarStock(String type,String userId) {
        if(CarWarehouse.carStocks.isEmpty()){
            return false;
        }
        synchronized (CarWareHouseServiceImpl.class){
            boolean res = false;
            for(CarStock carStock: CarWarehouse.carStocks){
                int size = carStock.getSize();
                if(size>0 && carStock.getType().equals(type)){
                    --size;
                    carStock.setSize(size);
                    res = true;
                }
            }
            if(!res){
                return false;
            }
            if(CarWarehouse.userIdCarsMap.isEmpty() ||
                    CarWarehouse.userIdCarsMap.keySet().stream()
                            .noneMatch(user->user.equals(userId))){
                Map<String,Integer> map = new HashMap<>();
                map.put(type,1);
                CarWarehouse.userIdCarsMap.put(userId,map);
                return true;
            }
            for (Map.Entry<String, Map<String, Integer>> entry :
                    CarWarehouse.userIdCarsMap.entrySet()) {
                if (entry.getKey().equals(userId)) {
                    Map<String, Integer> map = entry.getValue();
                    Integer value = map.get(type);
                    map.put(type, value == null? 1 : value + 1);
                    CarWarehouse.userIdCarsMap.put(userId,map);
                }
            }

        }
        return true;
    }

    @Override
    public Boolean addCarStock(String type, String userId) {
        if(CarWarehouse.carStocks.isEmpty()){
            return false;
        }
        boolean res = false;
        synchronized (CarWareHouseServiceImpl.class){
            if(CarWarehouse.userIdCarsMap.isEmpty() ||
                    CarWarehouse.userIdCarsMap.keySet().stream()
                            .noneMatch(user->user.equals(userId))){
                return false;
            }
            for (Map.Entry<String, Map<String, Integer>> entry :
                    CarWarehouse.userIdCarsMap.entrySet()) {
                if (entry.getKey().equals(userId)) {
                    Map<String, Integer> map = entry.getValue();
                    Integer value = map.get(type);
                    if(value == null || value==0){
                        return false;
                    }
                    map.put(type,  value - 1);
                    CarWarehouse.userIdCarsMap.put(userId,map);
                }
            }
            for(CarStock carStock: CarWarehouse.carStocks){
                int size = carStock.getSize();
                if(size<2 && carStock.getType().equals(type)){
                    ++size;
                    carStock.setSize(size);
                    res = true;
                }
            }
        }
        return res;
    }


    @Override
    public List<String> getCarTypes() {
        if(CarWarehouse.carStocks.isEmpty()){
            return null;
        }
        return CarWarehouse.carStocks.stream()
                .map(CarStock::getType)
                .collect(Collectors.toList());
    }
}
