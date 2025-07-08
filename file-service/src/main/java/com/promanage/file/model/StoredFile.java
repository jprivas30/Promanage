package com.promanage.files.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class StoredFile {
    private String fileName;
    private String fileUrl;
}