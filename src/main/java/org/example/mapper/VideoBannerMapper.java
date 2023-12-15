package org.example.mapper;

import org.example.model.entity.VideoBanner;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VideoBannerMapper {
    List<VideoBanner> list();
}
