package com.promanage.files.service.impl;

import com.promanage.files.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadFile(MultipartFile file) {
        return "URL_fake_del_archivo_subido/" + file.getOriginalFilename();
    }
}