package com.cowaine.corock.chapter03.di;

import java.io.IOException;
import java.io.OutputStream;

public interface Printer<T> {

    void print(OutputStream os, OrderProduct orderProduct) throws IOException;

}
