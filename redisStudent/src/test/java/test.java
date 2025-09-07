import com.bbs.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class test {
    private Jedis jedis;

    @BeforeEach
    public void setUp() {
        // 建立连接
        jedis = JedisConnectionFactory.getJedisPool();
        // 设置密码
        jedis.auth("123456");
        // 选择数据库
        jedis.select(1);
    }

    @Test
    public void testString() {
        //存入数据
        String result = jedis.set("name", "张三");
        System.out.println("result存入" + result);

        //获取数据
        String value = jedis.get("name");
        System.out.println("name = " + value);
    }

    @Test
    public void testHash() {
        //存入数据
        Long name = jedis.hset("user:1", "name", "李四");
        Long name1 = jedis.hset("user:1", "age", "21");

        System.out.println("result存入" + name + "年龄"+ name1);

        //获取数据
        Map<String, String> stringStringMap = jedis.hgetAll("user:1");
        System.out.println("name = " + stringStringMap);
    }


    @AfterEach
    public void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
