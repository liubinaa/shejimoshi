package com.shejimoshi.prototype;

import lombok.Getter;
import lombok.Setter;

/**
 * 原型模式：复制。把对象中的依赖关系，在每次使用对象之前，都会创建一个新的对象，并且会将依赖关系完整的赋值给新创建的对象。
 * 要使用clone，一定要实现Cloneable接口
 * clone是潜复制，下面的protoType对象属性，只会复制地址，而不是复制一个新的对象。深克隆可以通过序列化、反射、set方法等方式来实现。
 *
 * @author liubin
 */
@Getter
@Setter
public class ProtoType implements Cloneable {
    private String name;
    private ProtoType protoType;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
