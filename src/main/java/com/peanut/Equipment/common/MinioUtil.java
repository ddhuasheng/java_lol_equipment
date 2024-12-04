package com.peanut.Equipment.common;


import cn.hutool.extra.spring.SpringUtil;
import com.peanut.Equipment.exception.BizException;
import io.minio.*;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.Optional;

@Slf4j
@Component
@EnableConfigurationProperties({MinioProperties.class})
public class MinioUtil {
	@Resource
	private MinioProperties minioProperties;

	/**
	 * 文件上传 MultipartFile方式
	 *
	 * @param file        上传的文件
	 * @param filename    文件唯一名称
	 * @param contentType 文件类型
	 */
	public void upload(MultipartFile file, String filename, String contentType) {
		try(InputStream inputStream = file.getInputStream()) {
			MinioClient client = getClient();
			client.putObject(
					PutObjectArgs
							.builder()
							.object(filename)
							.contentType(contentType)
							.bucket(minioProperties.getBucketName().trim())
							.stream(inputStream, file.getSize(), -1)
							.build()
			);
		} catch (Exception e) {
			log.error("minio MultipartFile 上传文件失败: {}", e.getMessage());
			throw BizException.of("minio MultipartFile 上传文件失败");
		}
	}

	/**
	 * 上传文件 inputStream 方式
	 *
	 * @param inputStream 文件流
	 * @param size        文件大小
	 * @param filename    文件唯一名称
	 * @param contentType 文件类型
	 */
	public void uploadFile(InputStream inputStream, long size, String filename, String contentType) {
		MinioClient client = getClient();
		try {
			PutObjectArgs putObjectArgs = PutObjectArgs
					.builder()
					.bucket(minioProperties.getBucketName().trim())
					.contentType(contentType)
					.object(filename)
					.stream(inputStream, size, -1)
					.build();
			client.putObject(putObjectArgs);
		} catch (Exception e) {
			log.error("minio file 上传文件失败: {}", e.getMessage());
			throw BizException.of("minio file 上传文件失败");
		}
	}

	/**
	 * 文件预览
	 *
	 * @param filename 文件唯一名称
	 * @return String 文件预览路径
	 */
	public String getPreviewPath(String filename) {
		MinioClient client = getClient();
		try {
			return client.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().bucket(minioProperties.getBucketName().trim()).object(filename).build());
		} catch (Exception e) {
			log.error("minio 获取文件预览路径失败: {}", e.getMessage());
			throw BizException.of("minio 获取文件预览路径失败");
		}
	}

	/**
	 * 文件下载
	 *
	 * @param filename 文件唯一名称
	 * @return InputStream 文件输入流
	 */
	public InputStream download(String filename) {
		MinioClient client = getClient();
		try {
			return client.getObject(GetObjectArgs.builder().bucket(minioProperties.getBucketName().trim()).object(filename).build());
		} catch (Exception e) {
			log.error("minio 下载文件失败: {}", e.getMessage());
			throw BizException.of("minio 下载文件失败");
		}
	}

	/**
	 * 文件删除
	 * @param filename 文件唯一名称
	 * */
	public void remove(String filename) {
		MinioClient client = getClient();
		try {
			client.removeObject(RemoveObjectArgs.builder().object(filename).build());
		} catch (Exception e) {
			log.error("minio 文件删除失败: {}", e.getMessage());
			throw BizException.of("minio 文件删除失败");
		}
	}

	/**
	 * 获取minio连接客户端
	 *
	 * @return MinioClient minio连接客户端
	 */
	private MinioClient getClient() {
		String bucketName = minioProperties.getBucketName().trim();
		MinioClient minioClient = MinioClient.builder().endpoint(minioProperties.getEndpoint()).credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey()).build();

		try {
			boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
			if (!bucketExists) {
				minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
				minioClient.setBucketPolicy(SetBucketPolicyArgs.builder()
						.bucket(bucketName)
						.config(createBucketPolicyConfig(bucketName))
						.build());
			}
		} catch (Exception e) {
			log.error("初始化minio配置异常: 【%s】".formatted(e.fillInStackTrace()));
			throw BizException.of(e.getMessage());
		}

		return minioClient;
	}

	/*
	 * 设置桶权限
	 * */
	private String createBucketPolicyConfig(String bucketName) {
		return """
				{
				  "Statement" : [ {
				    "Action" : "s3:GetObject",
				    "Effect" : "Allow",
				    "Principal" : "*",
				    "Resource" : "arn:aws:s3:::%s/*"
				  } ],
				  "Version" : "2012-10-17"
				}
				""".formatted(bucketName);
	}
}
