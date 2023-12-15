package org.example.service.impl;

import org.example.mapper.VideoMapper;
import org.example.model.entity.Video;
import org.example.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<Video> list() {
        List<Video> list = videoMapper.list();
        return list;
    }

    @Override
    public Video findDetailById(int videoId) {
        Video video = videoMapper.findDetailById(videoId);
        return video;
    }
}
