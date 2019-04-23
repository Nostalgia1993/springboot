package com.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author nostalgia
 * @since 2019-04-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {
    @Override
    public String getId() {
        return super.getId();
    }


    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotBlank(message = "性别不能为空")
    private String sex;

}
