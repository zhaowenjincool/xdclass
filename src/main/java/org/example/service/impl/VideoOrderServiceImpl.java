package org.example.service.impl;

import org.example.mapper.VideoOrderMapper;
import org.example.model.entity.Video;
import org.example.model.entity.VideoOrder;
import org.example.service.VideoOrderService;
import org.example.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public class VideoOrderServiceImpl implements VideoOrderService {
    @Autowired
    private VideoOrderMapper videoOrderMapper;
    @Autowired
    private VideoService videoService;
    @Override
    public int save(int userId, int videoId) {
        VideoOrder videoOrder = videoOrderMapper.findOrderByUserIdAndVideoId(userId, videoId);
        if(videoOrder==null){return 0;}
        Video video = videoService.findDetailById(videoId);
        VideoOrder newvideoOrder = new VideoOrder();
        newvideoOrder.setVideoId(videoId);
        newvideoOrder.setVideoImg(video.getCoverImg());
        newvideoOrder.setVideoTitle(video.getTitle());

        newvideoOrder.setCreateTime(LocalDateTime.now());
        newvideoOrder.setUserId(userId);
        newvideoOrder.setTotalFee(video.getPrice());
        newvideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newvideoOrder.setState(1);
        int i = videoOrderMapper.save(newvideoOrder);
        return i;
    }

    @Override
    public VideoOrder findOrderByUserIdAndVideoId(int userId, int videoId) {
        VideoOrder videoOrder = videoOrderMapper.findOrderByUserIdAndVideoId(userId, videoId);
        return videoOrder;
    }
}
