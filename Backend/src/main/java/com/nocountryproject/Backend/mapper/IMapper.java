package com.nocountryproject.Backend.mapper;

public interface IMapper<I, O> {
    public O map(I in);
}
