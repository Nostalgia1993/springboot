package com.example;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    private static String scanner(String in){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入"+in + ":");
        if (scanner.hasNext()){
            String next = scanner.next();
            if(StringUtils.isNotEmpty(next)){
                return next;
            }
        }
        throw new MybatisPlusException("请输入正确的"+in+"! ");
    }

    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        //配置GlobalConfig
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
        globalConfig.setAuthor("nostalgia");
        globalConfig.setOpen(false);
        //service接口不加i
        globalConfig.setServiceName("%sService");
        autoGenerator.setGlobalConfig(globalConfig);

        //配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        autoGenerator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(null);
        packageConfig.setParent("com.example");
        autoGenerator.setPackageInfo(packageConfig);

        //设置模板引擎
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

        //自定义配置
        InjectionConfig injectionConfig  = new InjectionConfig() {
            @Override
            public void initMap() {
                //to do nothing
            }
        };
        //模板引擎是freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        //自定义输出配置
        List<FileOutConfig> fileList = new ArrayList<>();
        fileList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return System.getProperty("user.dir")+"/src/main/resources/mapper/"+packageConfig.getModuleName()+
                        "/"+tableInfo.getEntityName()+"Mapper"+StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileList);
        autoGenerator.setCfg(injectionConfig);

        //模板配置
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setSuperEntityClass("com.nostalgia.mybatis_plus.BaseEntity");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setSuperControllerClass("com.nostalgia.mybatis_plus.BaseController");
        strategyConfig.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategyConfig.setSuperEntityColumns("id","created","modified","status");
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setTablePrefix(packageConfig.getModuleName() + "_");
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();


    }
}
