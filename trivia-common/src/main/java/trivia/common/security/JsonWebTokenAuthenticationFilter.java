package trivia.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * 
 * @author yanhaixun
 * @date 2017年3月16日 下午4:55:53 现在有了这个工具类，我就可以在每个微服务中设置Spring Security。
 *       现在我们需要一个定制授权过滤器，将能读取请求头部信息，在Spring中已经有一个这样的授权Filter称为：RequestHeaderAuthenticationFilter，我们只要扩展继承即可
 */
@Component
public class JsonWebTokenAuthenticationFilter extends RequestHeaderAuthenticationFilter {

	public JsonWebTokenAuthenticationFilter() {
		// Don't throw exceptions if the header is missing
		this.setExceptionIfHeaderMissing(false);

		// This is the request header it will look for
		this.setPrincipalRequestHeader("Authorization");
	}

	@Override
	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}
}
