package com.ib.layoutservice.controller;

import com.ib.layoutservice.entity.Layout;
import com.ib.layoutservice.service.LayoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/layouts")
public class LayoutController {
    private final LayoutService layoutService;

    public LayoutController(LayoutService layoutService) {
        this.layoutService = layoutService;
    }

    @GetMapping
    public List<Layout> getAllLayouts() {
        return layoutService.getAllLayouts();
    }

    @PutMapping("/{layoutId}/update/{layoutName}")
    public ResponseEntity<String> updateUserLayout(@PathVariable Long layoutId, @PathVariable String layoutName) {
        layoutService.updateLayout(layoutId, layoutName);
        return ResponseEntity.ok("User layout updated successfully");
    }
}