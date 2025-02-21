package com.ib.layoutservice.service;

import com.ib.layoutservice.entity.Layout;
import com.ib.layoutservice.repository.LayoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LayoutService {

    private final LayoutRepository layoutRepository;

    public LayoutService(LayoutRepository layoutRepository) {
        this.layoutRepository = layoutRepository;
    }

    public List<Layout> getAllLayouts() {
        return layoutRepository.findAll();
    }

    @Transactional
    public void updateLayout(long layoutId, String layoutName) {
        Layout saveLayout = layoutRepository.findById(layoutId).orElseThrow();
        saveLayout.setLayoutname(layoutName);
        layoutRepository.save(saveLayout);
    }
}