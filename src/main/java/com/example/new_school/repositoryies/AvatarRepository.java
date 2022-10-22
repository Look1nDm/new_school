package com.example.new_school.repositoryies;

import com.example.new_school.models.AvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<AvatarEntity,Long> {
}
