package com.syzyffo.linkshortener.link;

public interface LinkService {

    LinkDto createLink(LinkDto toDto) throws LinkAlreadyExistsException;

    LinkDto getLink(String id);
}
