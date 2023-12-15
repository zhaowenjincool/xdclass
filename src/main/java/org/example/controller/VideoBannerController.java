package org.example.controller;

import org.example.model.entity.VideoBanner;
import org.example.service.VideoBannerService;
import org.example.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/banner")
public class VideoBannerController {
    @Autowired
    private VideoBannerService videoBannerService;
    @GetMapping("list")
    public JsonData list(){
        return JsonData.buildSuccess(videoBannerService.list());
    }
}
