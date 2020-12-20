import cn.itcast.web.utils.TableUtils;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author cbh
 * @PackageName:PACKAGE_NAME
 * @ClassName:TableTest
 * @Description:
 * @date 2020-12-19 15:25
 */
public class TableTest {

	@Test
	public void test1() throws SQLException, IOException, ClassNotFoundException {
		TableUtils.isMain();
	}
}
