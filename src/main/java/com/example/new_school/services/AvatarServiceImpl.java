package com.example.new_school.services;

import com.example.new_school.Utils.StudentUtils;
import com.example.new_school.models.AvatarEntity;
import com.example.new_school.models.StudentEntity;
import com.example.new_school.repositoryies.AvatarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;
@Service
@RequiredArgsConstructor
@Transactional
public class AvatarServiceImpl implements AvatarService {
    @Value("${path.to.avatars.folder}")
    private String avatarsDirectory;
    private StudentService studentService;
    private AvatarRepository avatarRepository;
    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        StudentEntity student = StudentUtils.migrateDtoToEntity(studentService.getStudent(studentId));
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
        AvatarEntity avatar = findAvatar(studentId);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());
        avatarRepository.save(avatar);
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
