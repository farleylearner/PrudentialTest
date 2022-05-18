package com.test.openService;

import com.test.req.Result;

import java.util.List;

public interface RentService {

    Result<List<String>> selectRentCar();

    Result<Boolean> rentCar(String type,String userId);

    Result<Boolean> cancelRentCar(String type,String userId);

}
