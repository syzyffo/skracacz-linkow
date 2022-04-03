package com.syzyffo.linkshortener.link;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
class LinkServiceImpl implements LinkService {

    private final LinkRepository reporitory;

    LinkServiceImpl(LinkRepository reporitory){
        this.reporitory = reporitory;
    }


    @Override
    public LinkDto createLink(LinkDto dto) throws LinkAlreadyExistsException {

        Optional<LinkEntity> linkEntity = reporitory.findById(dto.id());
        if(linkEntity.isPresent()){
            throw new LinkAlreadyExistsException(dto.id());
        }
        reporitory.save(LinkEntity.fromDto(dto));
        return dto;
    }

    @Override
    public LinkDto getLink(String id) {
        return reporitory.findById(id)
                .map(LinkEntity::toDto)
                .orElse(null);
    }
}
