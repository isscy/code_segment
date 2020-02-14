package cn.ff.vconference.controller;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 *  1. 通过继承 范式要在编译的时候就指定类型。 
 * 在运行时new AdvDto<PojoType> 这样是获取不到类型的
 * @author fengfan 2020/2/14
 */
public class TestController {

    public static void main(String[] args) {

        AdvDto ini = new AdvDto();
        System.out.println(ini.toString());
    }

}





class AdvDto extends BaseDto<SysUser, SysAccount>{

}

class BaseDto<S, T>{
  
    // 实体类类型(由构造方法自动赋值)
    private Class<S> sourceClz;
    private Class<T> targetClz;
    public BaseDto() {
        Class c = getClass();
        System.out.println(c);
        Type t = c.getGenericSuperclass();
        System.out.println(t);
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            System.out.println(Arrays.toString(p));
            this.sourceClz = (Class<S>) p[0];
            this.targetClz = (Class<T>) p[1];
        }
    }


    @Override
    public String toString() {
        return "BaseDto{" +
                "sourceClass=" + sourceClz +
                ", targetClass=" + targetClz +
                '}';
    }
}
