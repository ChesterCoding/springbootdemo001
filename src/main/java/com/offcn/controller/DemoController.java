package com.offcn.controller;


import com.offcn.po.Car;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController//ResponseBody+controller  以json对象响应给前端
@RequestMapping("/")
public class DemoController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello,Java!";
    }

    @RequestMapping("/car")
    public Car findCar() {
        Car car = new Car(1, "b", 888.98D, new Date());
        return car;

    }

    @RequestMapping("/findAll")
    public List<Car> findAll() {
        List cars = new ArrayList();
        Car car = new Car(1, "b", 888.98D, new Date());
        Car car2 = new Car(2, "b", 888.98D, new Date());
        Car car3 = new Car(3, "b", 888.98D, new Date());
        Car car4 = new Car(4, "b", 888.98D, new Date());
        cars.add(car);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        return cars;
    }


    /*参数传递*/
    @RequestMapping("/findOne")
    public Car findOne(Integer id) {
        Car car = new Car(id, "a", 999.93d, new Date());
        return car;
    }


    /**
     * 路径传参
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/findPath/{id}/{name}")
    public String findPath(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return "id=" + id + " name=" + name;
    }


    /**
     *传递是json数据格式
     * @param car
     * @return
     */
    @RequestMapping("/findCarToJson")
    public Car findCarToJson(@RequestBody Car car) {
        System.out.println(car.toString());
        return car;
    }


    /**
     * 参数传递方式4：自动封装
     * @param car
     * @return
     */
    @RequestMapping("/findCar2")
    public Car findCar2(Car car) {
        System.out.println(car.toString());
        return car;
    }

    //增加一个自动封装参数转换器
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

}
