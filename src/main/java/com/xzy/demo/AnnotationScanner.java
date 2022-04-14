package com.xzy.demo;


import org.objectweb.asm.*;

import java.io.File;
import java.io.FileInputStream;

import static org.objectweb.asm.ClassReader.SKIP_CODE;

/**
 * User: RuzzZZ
 * Date: 2022/4/14
 * Time: 16:33
 */
public class AnnotationScanner {

    static class MyClassVisitor extends ClassVisitor {
        public MyClassVisitor() {
            super(Opcodes.ASM7);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc,
                                         String signature, String[] exceptions) {
            System.out.println("method: name = " + name);
            return new MyMethodVisitor();
        }
    }

    static class MyAnnotationVisitor extends AnnotationVisitor {
        MyAnnotationVisitor() {
            super(Opcodes.ASM7);
        }
        @Override
        public void visit(String name, Object value) {
            System.out.println("annotation: " + name + " = " + value);
            super.visit(name, value);
        }
    }

    static class MyMethodVisitor extends MethodVisitor {
        MyMethodVisitor() {
            super(Opcodes.ASM7);
        }
        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            System.out.println("annotation type: " + desc);
            return new MyAnnotationVisitor();
        }
    }

    @CustomAnnotation("haha")
    public static void main(String[] args) throws Exception {
        ClassReader cr = new ClassReader(AnnotationScanner.class.getCanonicalName());
        cr.accept(new MyClassVisitor(), SKIP_CODE);
    }
}
