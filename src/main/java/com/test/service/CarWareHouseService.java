package com.test.service;

import java.util.List;

public interface CarWareHouseService {
    Boolean deductCarStock(String type,String userId);

    Boolean addCarStock(String type,String userId);

    List<String> getCarTypes();
}
