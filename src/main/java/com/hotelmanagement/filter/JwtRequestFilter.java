package com.hotelmanagement.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hotelmanagement.dto.StaffDTO;
import com.hotelmanagement.service.management.IStaffService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	private IStaffService staffService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		StaffDTO staffDto = null;
		
		if (request.getHeader("Authorization") != null) {
			String authorizationHeader = request.getHeader("Authorization");
			if (!authorizationHeader.equals("") && authorizationHeader.startsWith("Token")) {
				String token = authorizationHeader.substring(6);
				staffDto = staffService.findOneByTokenCode(token);
			}
		}
		
		if (staffDto != null) {
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(staffDto, null, staffDto.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
		
		filterChain.doFilter(request, response);
	}

}
