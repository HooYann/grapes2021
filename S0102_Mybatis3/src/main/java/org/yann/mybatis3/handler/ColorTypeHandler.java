package org.yann.mybatis3.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes({Color.class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class ColorTypeHandler extends BaseTypeHandler<Color> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Color parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }
    @Override
    public Color getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Color.get(rs.getString(columnName));
    }
    @Override
    public Color getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Color.get(rs.getString(columnIndex));
    }
    @Override
    public Color getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Color.get(cs.getString(columnIndex));
    }
}
