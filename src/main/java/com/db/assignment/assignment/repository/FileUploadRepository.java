package com.db.assignment.assignment.repository;

import com.db.assignment.assignment.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends JpaRepository<OrderEntity,Long> {
}
