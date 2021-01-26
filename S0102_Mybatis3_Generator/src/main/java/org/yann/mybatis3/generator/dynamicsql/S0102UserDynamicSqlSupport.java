package org.yann.mybatis3.generator.dynamicsql;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class S0102UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.937+08:00", comments="Source Table: S0102_USER")
    public static final S0102User s0102User = new S0102User();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.938+08:00", comments="Source field: S0102_USER.ID")
    public static final SqlColumn<Long> id = s0102User.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.94+08:00", comments="Source field: S0102_USER.GROUP_ID")
    public static final SqlColumn<Long> groupId = s0102User.groupId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.94+08:00", comments="Source field: S0102_USER.USERNAME")
    public static final SqlColumn<String> username = s0102User.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.941+08:00", comments="Source field: S0102_USER.NAME")
    public static final SqlColumn<String> name = s0102User.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.938+08:00", comments="Source Table: S0102_USER")
    public static final class S0102User extends SqlTable {
        public final SqlColumn<Long> id = column("ID", JDBCType.BIGINT);

        public final SqlColumn<Long> groupId = column("GROUP_ID", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("USERNAME", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("NAME", JDBCType.VARCHAR);

        public S0102User() {
            super("S0102_USER");
        }
    }
}