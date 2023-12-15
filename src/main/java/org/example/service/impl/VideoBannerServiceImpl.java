package org.example.service.impl;

import org.example.mapper.VideoBannerMapper;
import org.example.model.entity.VideoBanner;
import org.example.service.VideoBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoBannerServiceImpl implements VideoBannerService {
    @Autowired
    private VideoBannerMapper videoBannerMapper;
    @Override
    public List<VideoBanner> list() {
        return videoBannerMapper.list();
    }
}
