import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xuecheng.manage_cms.ManageCmsApplication;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * @author lxt
 * @date 2019-11-11-16:05
 */
@SpringBootTest(classes = ManageCmsApplication.class)
@RunWith(value = SpringRunner.class)
public class GirdFsTest {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Test
    public void Test() {
        final File file = new File("E:\\index_banner.html");
        try {
            final InputStream inputStream = new FileInputStream(file);

            final ObjectId objectId = gridFsTemplate.store(inputStream, "测试文件", "");
            System.out.println(objectId);
        } catch (FileNotFoundException e) {


        }
    }

    /**
     * 获取文件流
     */
    @Test
    public void Test1() {
        String fieldId = "5a7719d76abb5042987eec3a";
        //根据id查询文件
        final GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(fieldId)));
        //下载文件
        final GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());

        final GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        try {
            final InputStream inputStream = gridFsResource.getInputStream();
            final String s = IOUtils.toString(inputStream);
            System.out.println(s);
        } catch (IOException e) {


        }
    }

    /**
     * 根据id删除文件
     */
    @Test
    public void delete() {
        String fieldId = "5a7719d76abb5042987eec3a";
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(fieldId)));
    }
}
