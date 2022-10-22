package com.example.new_school.Utils;

import com.example.new_school.dto.AvatarDto;
import com.example.new_school.models.AvatarEntity;

import java.util.Collection;
import java.util.stream.Collectors;

public class AvatarUtils {

    public static AvatarDto migrateEntityToDto(AvatarEntity entity) {
        return new AvatarDto(entity.getId(),entity.getFilePath(),entity.getFileSize(),
                entity.getMediaType(),entity.getData());
    }
    public static AvatarEntity migrateDtoToEntity(AvatarDto dto) {
        return new AvatarEntity(dto.getId(),dto.getFilePath(),dto.getFileSize(),
                dto.getMediaType(),dto.getData());
    }
    public static Collection<AvatarDto> migrateEntityToDtoCollection(Collection<AvatarEntity> list){
        return list.stream()
                .map(AvatarUtils::migrateEntityToDto).collect(Collectors.toList());
    }
    public static Collection<AvatarEntity> migrateDtoToEntityCollection(Collection<AvatarDto> list){
        return list.stream()
                .map(AvatarUtils::migrateDtoToEntity).collect(Collectors.toList());
    }
}
