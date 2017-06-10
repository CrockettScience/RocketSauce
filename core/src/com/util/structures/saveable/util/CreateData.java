package com.util.structures.saveable.util;

/**
 *
 * @author Jonathan Crockett
 */
public interface CreateData<T extends SaveableData>{
        public T createElement();
    }
