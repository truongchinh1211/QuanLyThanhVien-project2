/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Bum
 */
public class HibernateConfig {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        try{
            Configuration configuration = new Configuration();
                
                // Hibernate setting equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/school");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.POOL_SIZE,"4");
                
                // Auto create missing tables and fields. Database must be created first!
                // https://gpcoder.com/6371-tao-database-table-tu-dong-tu-hibernate-entity/ in section 2
                settings.put(Environment.HBM2DDL_AUTO, "update");
                
                configuration.setProperties(settings);
                
                
                
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                                      .applySettings(configuration.getProperties())
                                                      .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
