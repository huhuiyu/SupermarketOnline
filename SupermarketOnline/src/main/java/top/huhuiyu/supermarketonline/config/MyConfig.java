package top.huhuiyu.supermarketonline.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * application.properties自定义配置属性
 *
 * @author DarkKnight
 *
 */
@Configuration
public class MyConfig {
  /**
   * app.name应用程序名称
   */
  @Value("${app.name}")
  public String appName;

}
