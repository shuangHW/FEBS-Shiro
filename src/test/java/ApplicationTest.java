import cc.mrbird.febs.FebsShiroApplication;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ：mmzs
 * @date ：Created in 2020/5/29 15:10
 * @description：测试数据库加密（JAVA代码方式）
 * @modified By：
 * @version: 1.0$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FebsShiroApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//classes属性指定启动类，SpringBootTest.WebEnvironment.RANDOM_PORT经常和测试类中@LocalServerPort一起在注入属性时使用。会随机生成一个端口号。
public class ApplicationTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${jasypt.encryptor.password}")
    //密钥
    private String encryptorPassword;

    //@Value("${spring.datasource.dynamic.datasource.base.username}")
    private String datasourceUname;

    //@Value("${spring.datasource.dynamic.datasource.base.password}")
    private String datasourcePass;

    @Test
    public void dataSourceEncryptorTest() {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(encryptorPassword);

        datasourceUname = "root";
        datasourcePass = "root123456";
        String encryptedDatasourceUsername = encryptor.encrypt(datasourceUname);
        String encryptedDatasourcePassword = encryptor.encrypt(datasourcePass);

        logger.info("数据库用户名加密结果：{}", encryptedDatasourceUsername);
        logger.info("数据库密码加密结果：{}", encryptedDatasourcePassword);
        logger.info("把生成的密钥加上ENC(),替换xml配置文件：ENC("+encryptedDatasourceUsername+"); ENC("+encryptedDatasourcePassword+")");
    }
}