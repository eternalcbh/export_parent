package cn.itcast.generate;

import lombok.extern.log4j.Log4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author cbh
 * @PackageName:cn.itcast.generate
 * @ClassName:GeneratorSqlMapTest
 * @Description:
 * @date 2020-12-27 21:01
 */
@Log4j
public class GeneratorSqlMapTest {

	public void generator() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		ArrayList<String> warning = new ArrayList<>();
		boolean overwrite = true;

		//指定 逆向配置文件
		InputStream in = GeneratorSqlMapTest.class.getClassLoader().getResourceAsStream("mybatis/mybatis-generator-config.xml");

		ConfigurationParser cp = new ConfigurationParser(warning);
		Configuration configuration = cp.parseConfiguration(in);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);

		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warning);
		myBatisGenerator.generate(null);
		in.close();
	}

	public static void main(String[] args) {
		GeneratorSqlMapTest generatorSqlMapTest = new GeneratorSqlMapTest();
		try {
			generatorSqlMapTest.generator();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
