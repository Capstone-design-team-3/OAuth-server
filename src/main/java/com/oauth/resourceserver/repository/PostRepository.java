package com.oauth.resourceserver.repository;

import com.oauth.resourceserver.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
