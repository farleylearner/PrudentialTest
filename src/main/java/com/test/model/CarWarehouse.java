package com.test.model;

import com.test.constant.CarModelEnum;
import com.test.model.CarStock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CarWarehouse {
    public static List<CarStock> carStocks = new ArrayList<>();//car stocks

    //key:userId value:{key:carType, value:num}
    public static Map<String,Map<String,Integer>> userIdCarsMap = new HashMap<>();
    static {
        CarStock carStock1 = new CarStock(CarModelEnum.BMW_650.getType(),2);
        CarStock carStock2 = new CarStock(CarModelEnum.TOYOTA_CAMRY.getType(), 2);
        carStocks.add(carStock1);
        carStocks.add(carStock2);
    }
    public CarWarehouse() {

    }


}
