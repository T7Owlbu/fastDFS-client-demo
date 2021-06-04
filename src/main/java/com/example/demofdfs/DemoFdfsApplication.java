package com.example.demofdfs;

import com.example.demofdfs.config.ComponetImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(ComponetImport.class)
@SpringBootApplication
public class DemoFdfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFdfsApplication.class, args);
    }

}
