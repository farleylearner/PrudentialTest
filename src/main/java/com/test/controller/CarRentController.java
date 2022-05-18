package com.test.controller;

import com.test.constant.CarModelEnum;
import com.test.openService.RentService;
import com.test.req.Result;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/car")
public class CarRentController {
    private static Logger logger = LoggerFactory.getLogger(CarRentController.class);

    @Autowired
    private RentService rentService;

    @ResponseBody
    @RequestMapping("/list")
    public Result<List<String>> queryCars() {
        return  rentService.selectRentCar();
    }


    @ResponseBody
    @RequestMapping(value = "/rent", method = RequestMethod.POST)
    public Result<Boolean> rentCars(@RequestBody Map map) {
        Result<Boolean> result = new Result<>();
        if(map == null ||map.isEmpty()){
            return result.fail("param is null");
        }
        String type = (String) map.get("type");
        String userId = (String) map.get("userId");
        if(Strings.isBlank(type) || Strings.isBlank(userId)){
            return result.fail("param is null");
        }

        if(Arrays.stream(CarModelEnum.values())
                .noneMatch(carModelEnum -> carModelEnum.getType().equals(type))){
            return result.fail("this kind of car is not in our warehouse");
        }
        return  rentService.rentCar(type,userId);
    }

    @ResponseBody
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public Result<Boolean> cancelRentCar(@RequestBody Map map) {
        Result<Boolean> result = new Result<>();
        if(map == null ||map.isEmpty()){
            return result.fail("param is null");
        }
        String type = (String) map.get("type");
        String userId = (String) map.get("userId");
        if(Strings.isBlank(type) || Strings.isBlank(userId)){
            return result.fail("param is null");
        }

        if(Arrays.stream(CarModelEnum.values())
                .noneMatch(carModelEnum -> carModelEnum.getType().equals(type))){
            return result.fail("this kind of car is not in our warehouse");
        }
        return  rentService.cancelRentCar(type,userId);
    }

}
