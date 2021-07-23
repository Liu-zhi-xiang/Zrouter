package com.yk.z_apt_procesor.procesor;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.yk.zapt_annotation.annotation.BindView;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/4/2
 * @mail: liuzhixiang@em-data.com.cn
 */
@AutoService(Processor.class)
public class BindViewProcessor extends AbstractProcessor {
    private Messager messager;
    private Elements mElementUtils;
    private Map<String,ClassPoetCreatorProxy> proxyMap=new HashMap<>();

    public Map<String, ClassPoetCreatorProxy> getProxyMap() {
        return proxyMap;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        messager=processingEnvironment.getMessager();
        mElementUtils=processingEnvironment.getElementUtils();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        HashSet<String> supportTypes=new LinkedHashSet<>();
        supportTypes.add(BindView.class.getCanonicalName());
        return supportTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
      messager.printMessage(Diagnostic.Kind.NOTE,"processing...");
      proxyMap.clear();
      //得到所有得注解
        Set<? extends Element > elements=roundEnvironment.getElementsAnnotatedWith(BindView.class);
        for (Element element: elements){
            VariableElement variableElement= (VariableElement) element;
            TypeElement classElement= (TypeElement) variableElement.getEnclosingElement();
            String fullClassName=classElement.getQualifiedName().toString();
            ClassPoetCreatorProxy proxy=proxyMap.get(fullClassName);
            if (proxy==null){
                proxy=new ClassPoetCreatorProxy(mElementUtils,classElement);
                proxyMap.put(fullClassName,proxy);
            }
            BindView bindViewAnnotation =variableElement.getAnnotation(BindView.class);
            int id=bindViewAnnotation.value();
            proxy.putElement(id,variableElement);
        }
        //通过变量proxymap,创建java文件
//        for (String key :proxyMap.keySet()){
//            ClassCreatorProxy proxyInfo=proxyMap.get(key);
//            try{
//                messager.printMessage(Diagnostic.Kind.NOTE,"---->create"+proxyInfo.getProxyClassFullName());
//                JavaFileObject jfo=processingEnv.getFiler().createSourceFile(proxyInfo.getProxyClassFullName(),proxyInfo.getTypeElement());
//                Writer writer=jfo.openWriter();
//                writer.write(proxyInfo.generateJavaCode());
//                writer.flush();
//                writer.close();
//            }catch (IOException e){
//                messager.printMessage(Diagnostic.Kind.NOTE,"--->create" +proxyInfo.getProxyClassFullName() +"error");
//
//            }
//        }
        //通过javapoet生成
        for (String key : proxyMap.keySet()) {
            ClassPoetCreatorProxy proxyInfo = proxyMap.get(key);
            JavaFile javaFile = JavaFile.builder(proxyInfo.getPackageName(), proxyInfo.generateJavaCode()).build();
            try {
                //　生成文件
                javaFile.writeTo(processingEnv.getFiler());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        messager.printMessage(Diagnostic.Kind.NOTE,"process finish...");
        return true;
    }
}
