package com.musala.drones.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final ModelMapper mapper;

    public Mapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public <E> E convert(Object source, Class<E> destinationType) {
        return mapper.map(source, destinationType);
    }
}
