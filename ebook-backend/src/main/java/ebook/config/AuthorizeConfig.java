package ebook.config;

import ebook.model.UserEntity;
import ebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AuthorizeConfig implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }

        if (user.state == -1) {
            throw new UsernameNotFoundException("User Is Banned");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(username));

        return new User(
                user.username,
                user.password,
                getGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(UserEntity user) {

        Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();

        String username = user.username;

        if (user.is_manager) {
            grantedAuthority.add(new SimpleGrantedAuthority("ADMIN"));
            grantedAuthority.add(new SimpleGrantedAuthority("USER"));
        }
        else if (!user.is_manager) {
            grantedAuthority.add(new SimpleGrantedAuthority("USER"));
        }
        return grantedAuthority;
    }
}
