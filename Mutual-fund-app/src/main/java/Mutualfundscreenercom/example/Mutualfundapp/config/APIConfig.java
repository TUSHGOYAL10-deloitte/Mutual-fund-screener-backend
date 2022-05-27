//package Mutualfundscreenercom.example.Mutualfundapp.config;
//
//
//import org.ehcache.config.CacheConfiguration;
//import org.ehcache.config.EvictionAdvisor;
//import org.ehcache.config.ResourcePools;
//import org.ehcache.expiry.Expiry;
//import org.ehcache.spi.service.ServiceConfiguration;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Collection;
//
//@Configuration
//@EnableCaching
//public class APIConfig  extends CachingConfigurerSupport {
//
////    @Bean
////    public APIFilter apiFilter(){
////
////
////    }
//
//    @Bean
//    public net.sf.ehache.CacheManager ehCacheManager(){
//        CacheConfiguration config=new CacheConfiguration() {
//            @Override
//            public Collection<ServiceConfiguration<?>> getServiceConfigurations() {
//                return null;
//            }
//
//            @Override
//            public Class getKeyType() {
//                return null;
//            }
//
//            @Override
//            public Class getValueType() {
//                return null;
//            }
//
//            @Override
//            public EvictionAdvisor getEvictionAdvisor() {
//                return null;
//            }
//
//            @Override
//            public ClassLoader getClassLoader() {
//                return null;
//            }
//
//            @Override
//            public Expiry getExpiry() {
//                return null;
//            }
//
//            @Override
//            public ResourcePools getResourcePools() {
//                return null;
//            }
//        };
//
//
//    }
//}
