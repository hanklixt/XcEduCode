package com.xuecheng.client.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxt
 * @date 2019-11-11-17:08
 */
@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.database}")
    private String db;


    @Bean
    public GridFSBucket gridFSBucket(MongoClient mongoClient) {
        //gridFs下载文件所需对象创建流程
        final MongoDatabase database = mongoClient.getDatabase(db);
        return GridFSBuckets.create(database);
    }


}
