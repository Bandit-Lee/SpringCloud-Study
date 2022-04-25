import com.bandit.springCloud.GatewayApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @author Bandit
 * @createTime 2022/4/25 14:33
 */
@SpringBootTest(classes = Test.class)
public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
    }
}
