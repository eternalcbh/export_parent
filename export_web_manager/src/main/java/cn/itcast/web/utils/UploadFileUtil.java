package cn.itcast.web.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.utils
 * @ClassName:UploadFile
 * @Description:
 * @date 2020-12-31 21:56
 */
@Component
@PropertySource("classpath:propertis/qiniu.properties")
public class UploadFileUtil {
	@Value("${qiniu.accessKey}")
	private String accessKey;

	@Value("${qiniu.secretKey}")
	private String secretKey;

	@Value("${qiniu.bucket}")
	private String bucket;

	@Value("${qiniu.rtValue}")
	private String rtValue;

	public String upload(MultipartFile multipartFile) {

		String img = "";
		try {
			//1.取出原始文件名
			String fileName = multipartFile.getOriginalFilename();

			//2.随机化文件名
			String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
			fileName = uuid + "_" + fileName;

			//构建一个带指定Zone对象的配置类
			//指定文件上传服务器
			Configuration configuration = new Configuration(Region.region2());

			//上传管理器
			UploadManager uploadManager = new UploadManager(configuration);

			//身份认证
			Auth auth = Auth.create(accessKey, secretKey);

			//指定覆盖上传
			String uploadToken = auth.uploadToken(bucket, fileName);

			//上传
			Response response = uploadManager.put(multipartFile.getBytes(), fileName, uploadToken);

			//解析上传成功的结果
			DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

			img = rtValue + "/" + fileName;
		} catch (QiniuException ex) {
			System.err.println(ex.getMessage());
			Response r = ex.response;
			System.err.println(r.toString());
			try {
				System.err.println(r.bodyString());
			} catch (QiniuException ex2) {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
