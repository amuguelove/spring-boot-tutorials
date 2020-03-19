package com.flygopher.common;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class BaseMongoRepositoryImpl<T, ID> extends SimpleMongoRepository<T, ID>
        implements BaseMongoRepository<T, ID> {

    protected final MongoOperations mongoTemplate;

    protected final MongoEntityInformation<T, ID> entityInformation;

    public BaseMongoRepositoryImpl(
            MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
        this.mongoTemplate = mongoOperations;
        this.entityInformation = metadata;
    }

    public MongoOperations getMongoTemplate() {
        return this.mongoTemplate;
    }
}
