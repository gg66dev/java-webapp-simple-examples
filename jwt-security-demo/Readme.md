Reference
==========

* Original entry :  https://www.javainuse.com/spring/boot-jwt-mysql

 
 
Requests
==========

* Register: POST --  `http://localhost:8080/register`
    * header
        * `Content-Type: application/json`

    * body
```
{
	"username" : "ggp",
	"password" : "ggp1234"
}
```
    
   * response

```
{
	"username" : "ggp",
}
```     


* Authentification: POST -- `http://localhost:8080/authenticate`
    * header
        * `Content-Type: application/json`
    
    * body
```
{
	"username" : "ggp",
	"password" : "ggp1234"
}
```
   * response

```
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZ3AiLCJleHAiOjE1Njk5NjE4NDcsImlhdCI6MTU2OTk0Mzg0N30.7HGfu9ja8_YVlYhQA5Wh2uHWoeUIE3CDtMuFb4osQ-TztbYSYq1EE1M3u_h1y_efWXGJcRrBT166kuOluWl0sQ"
}
```

* Private URL: GET -- `http://localhost:8080/hello`
    * header
        * `Content-Type: application/json`
        * `Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZ3AiLCJleHAiOjE1Njk5NjE4NDcsImlhdCI6MTU2OTk0Mzg0N30.7HGfu9ja8_YVlYhQA5Wh2uHWoeUIE3CDtMuFb4osQ-TztbYSYq1EE1M3u_h1y_efWXGJcRrBT166kuOluWl0sQ`
        
    * response 

```
Hello World
```        
        
    
Notes
=========

* Use of the class DAOUser for database operations

```
@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	
    @Column
	@JsonIgnore
	private String password;

    ...
```

* Use the class UserDTO for getting values from user and pass to DAO layer

```
public class UserDTO {
	private String username;
	private String password;
```

* UserDAO is implementend using CrudRepository class from Spring Data.

* In class WebSecurityConfig
    * define authentification Manager
    
```
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}
```

* Configure HttpSecurity
    * disable CSRF
    * disable request authentication from '/register' and '/authenticate'
    * add authentication to any other request
    * define session policy
    * set authentication entry point
    * add filter to validate token
```
    @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers("/authenticate", "/register").permitAll().
				// all other requests need to be authenticated
				anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
```

* The class JwtAuthenticationEntryPoint, extends from AuthenticationEntryPoint. and send an Unauthorized response for any
request with no authorization.

```
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}
```

* In the class JwtRequestFilter is defined a filter that:
    * is executed every request.
    * check if the token is valid 
    * if had a valid token sets the authentication in the context, to specify that the current user is authenticated.  
   

``` 
    @Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}

		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

			// if token is valid configure Spring Security to manually set
			// authentication
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}
```


* Use of class JwtUserDetailsService, to get the UserDetails object and also save a new user.

```
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }

}
```

* In class authentication controller (JwtAuthenticationController)
    * authenticate (generate token)
    * register a new user
    
```
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
```




    