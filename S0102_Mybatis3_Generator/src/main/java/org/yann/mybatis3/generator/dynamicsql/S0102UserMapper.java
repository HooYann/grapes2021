package org.yann.mybatis3.generator.dynamicsql;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.yann.mybatis3.generator.dynamicsql.S0102UserDynamicSqlSupport.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.yann.mybatis3.generator.dynamicsql.S0102User;

@Mapper
public interface S0102UserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.981+08:00", comments="Source Table: S0102_USER")
    BasicColumn[] selectList = BasicColumn.columnList(id, groupId, username, name);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.943+08:00", comments="Source Table: S0102_USER")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.946+08:00", comments="Source Table: S0102_USER")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.948+08:00", comments="Source Table: S0102_USER")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<S0102User> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.95+08:00", comments="Source Table: S0102_USER")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<S0102User> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.952+08:00", comments="Source Table: S0102_USER")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("S0102UserResult")
    Optional<S0102User> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.954+08:00", comments="Source Table: S0102_USER")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="S0102UserResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="GROUP_ID", property="groupId", jdbcType=JdbcType.BIGINT),
        @Result(column="USERNAME", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<S0102User> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.959+08:00", comments="Source Table: S0102_USER")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.96+08:00", comments="Source Table: S0102_USER")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, s0102User, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.962+08:00", comments="Source Table: S0102_USER")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, s0102User, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.964+08:00", comments="Source Table: S0102_USER")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.965+08:00", comments="Source Table: S0102_USER")
    default int insert(S0102User record) {
        return MyBatis3Utils.insert(this::insert, record, s0102User, c ->
            c.map(id).toProperty("id")
            .map(groupId).toProperty("groupId")
            .map(username).toProperty("username")
            .map(name).toProperty("name")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.969+08:00", comments="Source Table: S0102_USER")
    default int insertMultiple(Collection<S0102User> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, s0102User, c ->
            c.map(id).toProperty("id")
            .map(groupId).toProperty("groupId")
            .map(username).toProperty("username")
            .map(name).toProperty("name")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.972+08:00", comments="Source Table: S0102_USER")
    default int insertSelective(S0102User record) {
        return MyBatis3Utils.insert(this::insert, record, s0102User, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(groupId).toPropertyWhenPresent("groupId", record::getGroupId)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(name).toPropertyWhenPresent("name", record::getName)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.984+08:00", comments="Source Table: S0102_USER")
    default Optional<S0102User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, s0102User, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.986+08:00", comments="Source Table: S0102_USER")
    default List<S0102User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, s0102User, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.989+08:00", comments="Source Table: S0102_USER")
    default List<S0102User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, s0102User, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.991+08:00", comments="Source Table: S0102_USER")
    default Optional<S0102User> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.992+08:00", comments="Source Table: S0102_USER")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, s0102User, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.994+08:00", comments="Source Table: S0102_USER")
    static UpdateDSL<UpdateModel> updateAllColumns(S0102User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(groupId).equalTo(record::getGroupId)
                .set(username).equalTo(record::getUsername)
                .set(name).equalTo(record::getName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.996+08:00", comments="Source Table: S0102_USER")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(S0102User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(groupId).equalToWhenPresent(record::getGroupId)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(name).equalToWhenPresent(record::getName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:41.999+08:00", comments="Source Table: S0102_USER")
    default int updateByPrimaryKey(S0102User record) {
        return update(c ->
            c.set(groupId).equalTo(record::getGroupId)
            .set(username).equalTo(record::getUsername)
            .set(name).equalTo(record::getName)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-24T20:49:42+08:00", comments="Source Table: S0102_USER")
    default int updateByPrimaryKeySelective(S0102User record) {
        return update(c ->
            c.set(groupId).equalToWhenPresent(record::getGroupId)
            .set(username).equalToWhenPresent(record::getUsername)
            .set(name).equalToWhenPresent(record::getName)
            .where(id, isEqualTo(record::getId))
        );
    }
}