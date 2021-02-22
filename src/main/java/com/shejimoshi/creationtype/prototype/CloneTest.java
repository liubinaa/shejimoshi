package com.shejimoshi.creationtype.prototype;

/**
 * @author liubin
 */
public class CloneTest {
    public static void main(String[] args) {
        ProtoType p = new ProtoType();
        p.setName("Tom");
        p.setProtoType(new ProtoType());
        try {
            ProtoType clone = (ProtoType) p.clone();
            System.out.println(p.getProtoType());
            System.out.println(clone.getProtoType());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
