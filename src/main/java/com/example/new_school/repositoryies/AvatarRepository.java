package com.example.new_school.repositoryies;

import com.example.new_school.models.AvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AvatarRepository extends JpaRepository<AvatarEntity,Long> {
}
