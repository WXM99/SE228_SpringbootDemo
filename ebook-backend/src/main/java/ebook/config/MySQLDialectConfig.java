package ebook.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class MySQLDialectConfig extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
