package win.doyto.query.demo.common;

import win.doyto.query.core.Dialect;

/**
 * HsqldbDialect
 *
 * @author f0rb on 2021-03-04
 */
public class HsqldbDialect implements Dialect {
    @Override
    public String buildPageSql(String sql, int limit, long offset) {
        return sql + " LIMIT " + limit + (sql.startsWith("SELECT") ? " OFFSET " + offset : "");
    }
}