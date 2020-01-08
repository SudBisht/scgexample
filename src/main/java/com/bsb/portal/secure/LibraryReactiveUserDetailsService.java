package com.bsb.portal.secure;

import com.bsb.portal.data.LibraryUser;
import com.bsb.portal.data.Role;
import com.bsb.portal.data.User;
import org.springframework.security.core.userdetails.ReactiveUserDetailsPasswordService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

/**
 * User: Sudarshan Bisht
 * Date: 2020-01-08:22:36
 */

@Service
public class LibraryReactiveUserDetailsService implements ReactiveUserDetailsService, ReactiveUserDetailsPasswordService {

	@Override
	public Mono<UserDetails> findByUsername(String username) {
		User user = new User("bruce.wayne@example.com", "{bcrypt}$2a$10$mYD/DAZgbIusEJPC.oF7hOFH6QiR4tDVOExSVEkJ39mHtUYP.btAK",
			new ArrayList<Role>() {{
				add(Role.ADMIN);
			}});
		return Mono.just(new LibraryUser(user));
	}

	@Override
	public Mono<UserDetails> updatePassword(UserDetails user, String newPassword) {
		return Mono.empty();
	}
}
