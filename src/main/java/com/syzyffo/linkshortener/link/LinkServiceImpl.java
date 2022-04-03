package com.syzyffo.linkshortener.link;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
class LinkServiceImpl implements LinkService {

    private final Map<String, LinkDto> repository;
    public LinkServiceImpl(){
        this.repository=new HashMap<>();
    }

    @Override
    public LinkDto createLink(LinkDto dto) throws LinkAlreadyExistsException {

        if(repository.containsKey(dto.id())) throw new LinkAlreadyExistsException(dto.id());
            repository.put(dto.id(), dto);
            return dto;
    }

    @Override
    public LinkDto getLink(String id) {
        return repository.get(id);
    }
}
