package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCollect {
    private Integer id;
    private String name;
    private String url;
    private Integer collect_id;
}
