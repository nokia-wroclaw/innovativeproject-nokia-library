package com.nokia.library.nokiainnovativeproject.controllers;

import com.nokia.library.nokiainnovativeproject.services.PictureService;
import com.nokia.library.nokiainnovativeproject.utils.Mappings;
import com.nokia.library.nokiainnovativeproject.utils.MessageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static com.nokia.library.nokiainnovativeproject.utils.Constants.MessageTypes.*;
import static com.nokia.library.nokiainnovativeproject.utils.Constants.Messages;

@RestController
@RequiredArgsConstructor
@RequestMapping(Mappings.API_VERSION + Mappings.PICTURES)
public class PictureUploadController {

    private final PictureService pictureService;

    @PostMapping(value = Mappings.UPLOAD)
    public ResponseEntity uploadPicture(MultipartFile picture) throws IOException {
        Map uploadResult = pictureService.uploadPicture(picture);
        return  MessageInfo.success(uploadResult.get("secure_url"), Arrays.asList("Picture" + Messages.get(UPLOADED)));
    }
}