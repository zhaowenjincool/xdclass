package org.example.controller;

import org.example.model.entity.Video;
import org.example.service.VideoService;
import org.example.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pri/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @GetMapping("list")
    public JsonData list(){
        List<Video> list = videoService.list();
        return JsonData.buildSuccess(list);
    }
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam("video_id") int videoId){
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }
}
