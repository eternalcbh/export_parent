package cn.itcast.web;

import cn.itcast.domain.company.Company;
import cn.itcast.service.company.CompanyService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cbh
 * @PackageName:cn.itcast.web
 * @ClassName:ApplyController
 * @Description:
 * @date 2020-12-27 18:48
 */
@RestController
public class ApplyController {
	@Reference
	private CompanyService companyService;

	@PostMapping("/apply")
	public String apply(Company company){
		try{
			companyService.save(company);
			return "1";
		}catch (Exception e){
			e.printStackTrace();
			return "0";
		}
	}
}
