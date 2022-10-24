package com.example.new_school.services;

import com.example.new_school.Utils.AvatarUtils;
import com.example.new_school.dto.AvatarDto;
import com.example.new_school.dto.StudentDto;
import com.example.new_school.models.AvatarEntity;
import com.example.new_school.repositoryies.AvatarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

import static java.nio.file.StandardOpenOption.CREATE_NEW;
@Service
@RequiredArgsConstructor
@Transactional
public class AvatarServiceImpl implements AvatarService {
    @Value("${path.to.avatars.folder}")
    private String avatarsDirectory;
    private final StudentService studentService;
    private final AvatarRepository avatarRepository;

    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        StudentDto student = studentService.getStudent(studentId);
        Path filePath = Path.of(avatarsDirectory, student + "." + getExtensions(avatarFile.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (InputStream is = avatarFile.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024)
        ){
            bis.transferTo(bos);
        }
        AvatarDto avatar = AvatarUtils.migrateEntityToDto(findAvatar(studentId));
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());
        avatarRepository.save(AvatarUtils.migrateDtoToEntity(avatar));
    }

    @Override
    public Collection<AvatarDto> getPageAvatars(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page,pageSize);
        return AvatarUtils.migrateEntityToDtoCollection(avatarRepository.findAll(pageRequest).getContent());
    }

    public AvatarEntity findAvatar(Long studentId){
        return avatarRepository.findById(studentId)
                .orElse(new AvatarEntity());
    }
    private String getExtensions(String fileName) {
        if(fileName!=null){
            return fileName.substring(fileName.lastIndexOf(".") + 1);}
        return null;
    }
}
