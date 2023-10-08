package com.example.demo.company;

import com.example.demo.company.dto.AnnouncementDto;
import com.example.demo.company.dto.AnnouncementDto.DetailResponse;
import com.example.demo.company.dto.AnnouncementDto.ListResponse;
import com.example.demo.company.dto.AnnouncementDto.RegisterRequest;
import com.example.demo.company.dto.AnnouncementDto.UpdateRequest;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/announcement")
public class AnnouncementController {
    private final AnnouncementWriteService announcementWriteService;
    private final AnnouncementReadService announcementReadService;

    @PostMapping("/create")
    public Long create(@Valid @RequestBody AnnouncementDto.CreateRequest request) {
        return announcementWriteService.create(request);
    }

    @DeleteMapping("/{announcementId}")
    public void delete(@PathVariable("announcementId")Long announcementId) {
        announcementWriteService.delete(announcementId);
    }
    @GetMapping("/{announcementId}")
    public DetailResponse detail(@PathVariable("announcementId") Long id) {
        return announcementReadService.detail(id);
    }

    @PutMapping("/{announcementId}")
    public void update(@PathVariable("announcementId") Long id, @Valid @RequestBody UpdateRequest updateRequest) {
        announcementWriteService.update(id,updateRequest);
    }

    @PostMapping("/register")
    public Long register(@Valid @RequestBody RegisterRequest request) {
        return announcementWriteService.register(request);
    }

    @GetMapping
    public List<ListResponse> getAnnouncements(String search) {
        return announcementReadService.getAnnouncements(search);
    }
}
