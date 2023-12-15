package org.example.service;

import org.example.model.entity.Video;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VideoService {
    List<Video> list();

    Video findDetailById(int videoId);
}
