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
        Video video = videoService.findDetailById(videoId);
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(videoId);
        videoOrder.setVideoImg(video.getCoverImg());
        videoOrder.setVideoTitle(video.getTitle());

        videoOrder.setCreateTime(LocalDateTime.now());
        videoOrder.setUserId(userId);
        videoOrder.setTotalFee(video.getPrice());
        videoOrder.setOutTradeNo(UUID.randomUUID().toString());
        videoOrder.setState(1);
        int i = videoOrderMapper.save(videoOrder);
        return i;
    }
}
