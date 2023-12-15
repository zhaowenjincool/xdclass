package org.example.service;

import org.example.model.entity.Video;
import org.example.model.entity.VideoOrder;

public interface VideoOrderService {
    int save(int userId,int videoId);
    VideoOrder findOrderByUserIdAndVideoId(int userId, int videoId);
}
