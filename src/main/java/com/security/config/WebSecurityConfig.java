package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 1.提供用户信息,查询用户信息。
     */
//    @Bean
//    public UserDetailsService getUserDetailsService(){
//        /**
//         * 不连接数据库，把用户信息定义到内存中。
//         */
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("admin").password("123456").authorities("s1").build());
//        manager.createUser(User.withUsername("cgb").password("123456").authorities("s2").build());
//        return manager;
//    }
    /**
     * 2.定义密码加密
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        /**
         * 加密算法
         */
        return new BCryptPasswordEncoder();
    }

    /**
     * 3.定义拦截机制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 拦截/security_user/下的所有请求
         */
        //是否开启防止csrf攻击
        http.csrf().disable()//页面不用隐藏域这个注释就要开启，否则配置的地址将都不生效
                .authorizeRequests()
                .antMatchers("/user/add").hasAuthority("s1")
                .antMatchers("/user/**").authenticated()
                .antMatchers("/login.html").permitAll()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successForwardUrl("/login_success")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout_success")
                .permitAll()
                /**
                 * 开启session
                 */
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }

}
