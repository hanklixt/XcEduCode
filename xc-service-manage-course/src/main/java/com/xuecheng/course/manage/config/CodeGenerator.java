//package com.xuecheng.course.manage.config;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * @Title: CodeGenerator
// * @Package: com.ycy.mybatis.plus.mybatisplus
// * @Description: 代码生成器
// * @Author: ycy
// * @Date: 2019-01-10 20:11
// * @Version: V1.0
// */
//public class CodeGenerator {
//
//
//    /**
//     * <p>
//     * 读取控制台内容
//     * </p>
//     */
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotEmpty(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//    /**
//     * RUN THIS
//     */
//    public static void main(String[] args) {
//
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        System.err.println("user.dir : " + projectPath);
//        //设置输出目录
//        gc.setOutputDir("F:/code/XcEduCode/" + "xc-service-manage-course" + "/src/main/java");
//        //创建作者
//        gc.setAuthor("lxt");
//        //文件覆盖
//        gc.setFileOverride(true);
//        gc.setOpen(false);
//        ///主键策略
//        gc.setIdType(IdType.INPUT);
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://192.168.5.169:3306/xc_course?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false");
//        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("root");
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        //pc.setModuleName(scanner("模块名"));
//        //父级包名
//        pc.setParent("com.xuecheng.course.manage");
//        //实体目录
//        pc.setEntity("entity");
//        //service目录
//        pc.setService("service");
//        //impl目录
//        pc.setServiceImpl("service.impl");
//        //Mapper目录
//        pc.setMapper("mapper");
//        //controller目录
//        pc.setController("controller");
//        mpg.setPackageInfo(pc);
//
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//        // 如果模板引擎是 freemarker
//        //String templatePath = "/templates/mapper.xml.ftl";
//        // 如果模板引擎是 velocity
////        String templatePath = "/templates/mapper.xml.vm";
//        String templatePath = "/templates/mapper.xml.ftl";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名
//                return "F:/code/XcEduCode/" + "xc-service-manage-course" + "/src/main/resources/mapper/"
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        // templateConfig.setEntity();
//        // templateConfig.setService();
//        // templateConfig.setController();
//
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        // strategy.setSuperControllerClass("com.cdp.product.logistics.customer.common.core.util.BaseController");
//        strategy.setInclude(scanner("表名"));
//        strategy.setControllerMappingHyphenStyle(true);
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        System.err.println(LocalDateTime.now());
//        mpg.execute();
//    }
//}
//
