package com.luanpaiva.examplejunittest.adapter.config.mapper;

import java.util.List;

public interface MapperToDomainObject<I, O> {

    O toDomainObject(I i);
    List<O> toDomainObjectList(List<I> i);
}
