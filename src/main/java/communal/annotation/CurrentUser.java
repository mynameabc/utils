package communal.annotation;

import java.lang.annotation.*;

/**
 * @Author: 林少君
 * @Date: 2020/7/21 18:45
 * 当前用户
 */
@Target(ElementType.PARAMETER)          //Annotation所修饰的对象范围:方法参数
@Retention(RetentionPolicy.RUNTIME)     //Annotation被保留时间:运行时保留(有效)
@Documented                             //标记注解:java工具文档化
public @interface CurrentUser {}
