package com.test.openService.impl;

import com.test.openService.RentService;
import com.test.req.Result;
import com.test.service.CarWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private CarWareHouseService carWareHouseService;

    @Override
    public Result<List<String>> selectRentCar() {
        Result<List<String>> result = new Result<>();
        List<String> carTypes =  carWareHouseService.getCarTypes();
        if(carTypes == null || carTypes.isEmpty()){
            return result.fail("the company don't have cars");
        }
        return result.success(carTypes);
    }

    @Override
    public Result<Boolean> rentCar(String type,String userId) {
        Boolean res =  carWareHouseService.deductCarStock(type,userId);
        Result<Boolean> result = new Result<>();
        if(!res){
            return result.fail("this type of car  are rented by other customers");
        }
        return result.success(true);
    }

    @Override
    public Result<Boolean> cancelRentCar(String type, String userId) {
        Boolean res =  carWareHouseService.addCarStock(type,userId);
        Result<Boolean> result = new Result<>();
        if(!res){
            return result.fail("you don't have rented this kind of car before");
        }
        return result.success(true);
    }
}
