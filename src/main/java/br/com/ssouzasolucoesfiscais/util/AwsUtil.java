package br.com.ssouzasolucoesfiscais.util;


import java.io.File;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

public class AwsUtil {

	private static AWSCredentials credentials = null;
	private static TransferManager tf;
	
	public void S3Upload(File arquivo, String bucketName, String Profile) {
		
		try {
            credentials = new ProfileCredentialsProvider(Profile).getCredentials();
        } catch (Exception e) {
            System.out.println(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (/Users/fernandosouza/.aws/credentials), and is in valid format." + e.toString());
        }
		
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("sa-east-1").withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
		tf = TransferManagerBuilder.standard().withS3Client(s3).build();
		
		try {
            if (tf.getAmazonS3Client().doesBucketExistV2(bucketName) == false) {
            	   tf.getAmazonS3Client().createBucket(bucketName);
            }
        } catch (AmazonClientException ace) {
            System.out.println("Unable to create a new Amazon S3 bucket: " + ace.getMessage());	
        }
		
		File fileToUpload = arquivo;
        PutObjectRequest request = new PutObjectRequest(bucketName, fileToUpload.getName(), fileToUpload);
        tf.upload(request);
        
	}
	
	
}
