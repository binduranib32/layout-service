package com.ib.layoutservice.controller;

import com.ib.layoutservice.entity.Layout;
import com.ib.layoutservice.service.LayoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/layouts")
public class LayoutController {
    private final LayoutService layoutService;

    public LayoutController(LayoutService layoutService) {
        this.layoutService = layoutService;
    }

    @GetMapping
    public List<Layout> getAllLayouts() {
        return layoutService.getAllLayouts();
    }
}