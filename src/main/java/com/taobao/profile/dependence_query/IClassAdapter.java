package com.taobao.profile.dependence_query;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author weigao
 * @since 15/5/25
 */
public abstract class IClassAdapter extends ClassVisitor {

    /**
     * 本地唯一的跟踪ID；使用纳秒作为标记
     */
    protected long localTrackID;

    /**
     * asm注入的类名
     */
    protected String mClassName;

    public IClassAdapter(ClassVisitor classVisitor, String theClass) {
        super(Opcodes.ASM5, classVisitor);
        this.mClassName = theClass;
    }
}
