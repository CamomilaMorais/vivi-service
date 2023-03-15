package ifce.viviservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/auths/**").permitAll()
            .antMatchers("/administradores/**", "/campi/**", "/cursos/**", "/dominios/**").hasRole("ADMIN")
            .antMatchers("/alunos/**", "/curriculos/**", "/experiencias/**").hasAnyRole("ADMIN", "ALUNO")
            .antMatchers("/empresas/**").hasAnyRole("ADMIN", "EMPRESA")
            /*
            .antMatchers("/campi/**", "/dominios/**").authenticated()
            .anyRequest().denyAll();
            */
            .antMatchers().authenticated();
    }

}