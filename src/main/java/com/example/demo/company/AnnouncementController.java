package com.example.demo.company;

import com.example.demo.company.dto.AnnouncementDto;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/announcement")
public class AnnouncementController {
    private final AnnouncementWriteService announcementWriteService;

    @PostMapping("/create")
    public Long create(@Valid @RequestBody AnnouncementDto.CreateRequest request) {
        return announcementWriteService.create(request);
    }

    @DeleteMapping
    public void delete(Long announcementId) {
        announcementWriteService.delete(announcementId);
    }
}
