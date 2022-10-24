package com.example.new_school.services;

import com.example.new_school.dto.AvatarDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

public interface AvatarService {
    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
    Collection<AvatarDto> getPageAvatars(Integer page, Integer pageSize);
}
