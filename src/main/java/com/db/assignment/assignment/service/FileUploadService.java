package com.db.assignment.assignment.service;

import com.db.assignment.assignment.entity.OrderEntity;
import com.db.assignment.assignment.exception.NaceNotFoundException;
import com.db.assignment.assignment.vo.OrderVO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface FileUploadService {
    public void singleSave();

    OrderVO fetchNaceDetails(Long orderNo) throws NaceNotFoundException;
}
