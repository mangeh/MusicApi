package musicapi.hernegren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by Magnus on 2016-11-11.
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
public class AppConfig {

    private static final String EHCACHE_CONFIG = "config/ehcache.xml";

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

    @Bean
    public CacheManager getEhCacheManager() {
        return new EhCacheCacheManager(getEhCacheFactory().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean getEhCacheFactory() {

        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
        factoryBean.setConfigLocation(new ClassPathResource(EHCACHE_CONFIG));
        factoryBean.setShared(true);
        return factoryBean;
    }
    @Bean
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("RestApiCaller-");
        executor.initialize();
        return executor;
    }
}
