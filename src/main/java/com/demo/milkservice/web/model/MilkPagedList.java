package com.demo.milkservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MilkPagedList extends PageImpl<MilkDTO> {
    public MilkPagedList(List<MilkDTO> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public MilkPagedList(List<MilkDTO> content) {
        super(content);
    }
}
