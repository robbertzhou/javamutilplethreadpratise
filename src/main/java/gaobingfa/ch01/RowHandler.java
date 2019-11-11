package gaobingfa.ch01;

import java.sql.ResultSet;

/**
 * 数据库jdbc的Row对象处理,
 * 定义一个泛型，从数据库的result处理后的对象，由业务逻辑自己处理
 */
public interface RowHandler<T> {
    T handle(ResultSet rs);
}
