import bean.DataUtils;
import bean.Employee;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description TODO
 * @author hongyanbo
 * @date 2020/4/10
 * @version 1.0.0
 * @since 1.0.0
 */
public class StreamTest {
    @Test
    public void test01(){
        List<Employee> employees = DataUtils.getEmployees();
        Set<Employee> collect = employees.stream().collect(Collectors.toSet());
        System.out.println(collect);

    }
}
