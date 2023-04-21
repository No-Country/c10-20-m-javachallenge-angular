package com.nocountryproject.Backend.mapper;

import java.io.IOException;

public interface IMapper<I, O> {
    public O map(I in) throws IOException;
}
