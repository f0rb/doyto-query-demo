package win.doyto.query.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import win.doyto.query.web.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackages = {"win.doyto.query.demo", "win.doyto.query.web.component"})
public class DemoApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Resource
    public void setDataSource(DataSource dataSource) {
        new ResourceDatabasePopulator(new ClassPathResource("import.sql")).execute(dataSource);
    }
}
