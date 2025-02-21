package com.ib.layoutservice.service;

import com.ib.layoutservice.entity.Layout;
import com.ib.layoutservice.repository.LayoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class LayoutService {

    private final LayoutRepository layoutRepository;  // Lombok will generate the constructor

    // ✅ Explicit Constructor Injection (Recommended)
    public LayoutService(LayoutRepository layoutRepository) {
        this.layoutRepository = layoutRepository;
    }

    public List<Layout> getAllLayouts() {
        return layoutRepository.findAll();
    }
}
