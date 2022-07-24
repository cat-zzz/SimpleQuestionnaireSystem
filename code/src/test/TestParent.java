
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith是JUnit的一个注解, 用来告诉JUnit不要使用内置的方式进行单元测试, 而应该使用指定的类做单元测试 对于Spring单元测试总是要使用SpringJUnit4ClassRunner.class
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
//如果有多个配置文件他的value是接受一个String数组 String支持通配符
//@ContextConfiguration({"classpath:application.xml","classpath:spring-mvc.xml"})
//@ContextConfiguration("classpath:spring-*.xml")
@ContextConfiguration("classpath:applicationContext.xml")
public class TestParent{
    @Test
    public void t01(){
        System.out.println("hello");
    }
}


