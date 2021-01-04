package cn.itcast.web.controller.stat;

import cn.itcast.service.stat.StatService;
import cn.itcast.web.controller.BaseController;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.controller.stat
 * @ClassName:StatController
 * @Description:
 * @date 2021-01-04 9:19
 */
@Controller
@RequestMapping("/stat")
public class StatController extends BaseController {

	@Reference
	private StatService statService;

	/**
	 * 进入页面
	 * @param chartsType
	 * @return
	 */
	@RequestMapping("/toCharts")
	public String toCharts(String chartsType){
		return "stat/stat-" +chartsType;
	}

	@RequestMapping("/factoryCharts")
	@ResponseBody
	public List<Map<String, Object>> factoryCharts(){
		return statService.getFactoryData(getLoginCompanyId());
	}
}
