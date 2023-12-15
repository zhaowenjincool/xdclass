package org.example.controller;

import org.example.model.entity.Video;
import org.example.model.request.VideoOrderRequest;
import org.example.service.VideoOrderService;
import org.example.service.VideoService;
import org.example.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {
    @Autowired
    private VideoOrderService videoOrderService;

    @PostMapping("save")
    public JsonData save(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("userId");

        int i = videoOrderService.save(userId, videoOrderRequest.getVideoId());
        return i==1?JsonData.buildSuccess("下单成功"):JsonData.buildError("下单失败");
    }

}
