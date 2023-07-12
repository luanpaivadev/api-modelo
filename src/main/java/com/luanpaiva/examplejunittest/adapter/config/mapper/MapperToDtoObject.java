package com.luanpaiva.examplejunittest.adapter.config.mapper;

import java.util.List;

public interface MapperToDtoObject<I, O> {

    O toDtoObject(I i);
    List<O> toDtoObjectList(List<I> i);
}
