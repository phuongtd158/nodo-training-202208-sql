package edu.hanoi.jazz.springjazz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {

    private static final Logger LOGGER = Logger.getLogger(ContextStartEventHandler.class);

    @Autowired
    private DataSource dataSource;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        LOGGER.info("Context start application " + dataSource);
        String createTableHnGroupSql = "create table hn_group(\n" +
                "\tid int auto_increment primary key,\n" +
                "    name varchar(100)\n" +
                ")";
        String createTableHnUserSql = "create table hn_user(\n" +
                "\tusername varchar(100) primary key,\n" +
                "\tpassword varchar(100) not null,\n" +
                "    email varchar(100) not null,\n" +
                "    age int,\n" +
                "    group_id int,\n" +
                "    constraint GROUP_FK foreign key(group_id) references hn_group(id)\n" +
                ")";
        try {
            createTable("hn_group", createTableHnGroupSql);
            createTable("hn_user", createTableHnUserSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void createTable(String name, String sql) throws SQLException {
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, name, null);

        if (resultSet.next()) {
            LOGGER.info("Table " + resultSet.getString("TABLE_NAME") + " already exist!");
            return;
        }

        dataSource.getConnection().createStatement().executeUpdate(sql);
    }
}
