package com.clt.api.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @ClassName : CodeGenerator
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:28
 * @Description :代码生成器
 **/
public class CodeGenerator {

    public static void main(String[] args) {
        String[] models = {"api-dao", "api-service", "api-commons"};
        for (String model : models) {
            shell(model);
        }
    }

    private static void shell(String model) {
        File file = new File(model);
        String path = file.getAbsolutePath();

        //用来获取Mybatis-Plus.properties文件的配置信息
        final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");

        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOpen(false);
        gc.setOutputDir(path + rb.getString("OutputDir"));
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setAuthor(rb.getString("Author"));
        gc.setMapperName(rb.getString("MapperName"));
        gc.setXmlName(rb.getString("XmlName"));
        gc.setServiceName(rb.getString("ServiceName"));
        gc.setServiceImplName(rb.getString("ServiceImplName"));
        gc.setControllerName(rb.getString("ControllerName"));
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(rb.getString("Url"));
        dsc.setDriverName(rb.getString("DriverName"));
        dsc.setUsername(rb.getString("UserName"));
        dsc.setPassword(rb.getString("Password"));
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        if ("api-dao".equals(model)) {
            pc.setParent(rb.getString("PackageParent"));
            pc.setEntity(rb.getString("PackageEntity"));
            pc.setMapper(rb.getString("PackageMapper"));
        } else if ("api-service".equals(model)) {
            pc.setParent(rb.getString("PackageParent"));
            pc.setServiceImpl(rb.getString("PackageServiceImpl"));
            pc.setService(rb.getString("PackageService"));
        }
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        List<FileOutConfig> focList = new ArrayList<>();

        if ("api-dao".equals(model)) {
            focList.add(new FileOutConfig(rb.getString("DaoTemplatePath")) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return rb.getString("OutputDirXml") + "/mapper/" + tableInfo.getEntityName() + rb.getString("DaoTemplateFileName");
                }
            });
        }

        if ("api-commons".equals(model)) {
            focList.add(new FileOutConfig(rb.getString("CommonsCreateTemplatePath")) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return rb.getString("OutputDirParam") + "/" + tableInfo.getEntityName() + rb.getString("CommonsCreateTemplateFileName");
                }
            });
            focList.add(new FileOutConfig(rb.getString("CommonsEditTemplatePath")) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return rb.getString("OutputDirParam") + "/" + tableInfo.getEntityName() + rb.getString("CommonsEditTemplateFileName");
                }
            });
        }
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        if ("api-dao".equals(model)) {
            tc.setMapper(rb.getString("DaoTemplateConfigPath"));
            tc.setController(null);
            tc.setService(null);
            tc.setServiceImpl(null);
            tc.setXml(null);
        } else if ("api-service".equals(model)) {
            tc.setService(rb.getString("ServiceTemplateConfigPath"));
            tc.setServiceImpl(rb.getString("ServiceImplTemplateConfigPath"));
            tc.setController(null);
            tc.setEntity(null);
            tc.setMapper(null);
            tc.setXml(null);
        } else if ("api-commons".equals(model)) {
            tc.setController(null);
            tc.setService(null);
            tc.setServiceImpl(null);
            tc.setEntity(null);
            tc.setMapper(null);
            tc.setXml(null);
        }
        mpg.setTemplate(tc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(new String[]{rb.getString("TableName")});
        mpg.setStrategy(strategy);
        mpg.execute();

    }

}