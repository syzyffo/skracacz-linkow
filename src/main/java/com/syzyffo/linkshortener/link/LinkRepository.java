package com.syzyffo.linkshortener.link;

import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<LinkEntity, String> {
}
