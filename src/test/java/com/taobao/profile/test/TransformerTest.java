package com.taobao.profile.test;

import com.taobao.profile.Manager;
import com.taobao.profile.instrument.ProfClassAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public class TransformerTest extends ClassLoader {
    @BeforeClass
    public static void before() {
        Manager.instance().initialization();
        Manager.instance().startupThread();
    }

    @Test
    public void testTransformer() throws Exception {
        ClassReader reader = new ClassReader(A.class.getName());
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor visitor = new ProfClassAdapter(writer, "com/taobao/profile/test/A");
        reader.accept(visitor, 0);
        byte[] bs = writer.toByteArray();
        TransformerTest loader = new TransformerTest();
        Class<?> clz = loader.defineClass("com.taobao.profile.test.A", bs, 0, bs.length);
        Object o = clz.newInstance();
        clz.getMethod("m1").invoke(o);
    }
}
