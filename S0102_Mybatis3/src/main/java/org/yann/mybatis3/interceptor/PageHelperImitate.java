package org.yann.mybatis3.interceptor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({
        @Signature(
                type = Executor.class,
                method = ("query"),
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        ),
        @Signature(
                type = Executor.class,
                method = ("query"),
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}
        )
})
public class PageHelperImitate implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Executor executor = (Executor) invocation.getTarget();
        Object[] args = invocation.getArgs();

        RowBounds rowBounds = (RowBounds) args[2];
        if (rowBounds.getLimit() <= 0) {
            return invocation.proceed();
        }

        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];
        ResultHandler resultHandler = (ResultHandler) args[3];
        CacheKey cacheKey;
        BoundSql boundSql;
        if (args.length == 4) {
            boundSql = ms.getBoundSql(parameter);
            cacheKey = executor.createCacheKey(ms, parameter, rowBounds, boundSql);
        } else {
            cacheKey = (CacheKey) args[4];
            boundSql = (BoundSql) args[5];
        }

        String sql = boundSql.getSql();
        sql += " limit " + (rowBounds.getOffset() > 0 ? rowBounds.getOffset() : 0) + "," + rowBounds.getLimit();


        BoundSql pageBoundSql = new BoundSql(ms.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());

        return executor.query(ms, parameter, rowBounds, resultHandler, cacheKey, pageBoundSql);

        //System.out.println("进来了");
        //return invocation.proceed();
    }
}
