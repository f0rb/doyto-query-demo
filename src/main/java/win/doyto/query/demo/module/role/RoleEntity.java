package win.doyto.query.demo.module.role;

import lombok.Getter;
import lombok.Setter;
import win.doyto.query.entity.IntegerId;
import win.doyto.query.validation.CreateGroup;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "t_role")
@Getter
@Setter
public class RoleEntity extends IntegerId {

    @NotNull(groups = CreateGroup.class)
    private String roleName;

    @NotNull(groups = CreateGroup.class)
    private String roleCode;

    private Boolean valid;
}
