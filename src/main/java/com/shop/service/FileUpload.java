package com.shop.service;

import com.shop.model.FileImage;

//文件上传工具类接口
public interface FileUpload {

//实现文件上传的功能，返回上传后新的文件名称
public abstract String uploadFile(FileImage fileImage);

}