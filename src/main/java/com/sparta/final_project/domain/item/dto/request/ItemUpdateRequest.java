package com.sparta.final_project.domain.item.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemUpdateRequest {
    private String itemName;
    private String itemDescription;
    private List<MultipartFile> itemImages;
}