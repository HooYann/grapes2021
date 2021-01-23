package org.yann.mybatis3.mapper;

import org.yann.mybatis3.entity.S0102Group;
import org.yann.mybatis3.entity.S0102GroupCollection;

public interface S0102GroupCollectionMapper {

    S0102GroupCollection collection(Long id);

    S0102GroupCollection collectionByStep(Long id);

}
